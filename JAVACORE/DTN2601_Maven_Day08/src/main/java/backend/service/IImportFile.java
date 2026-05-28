package backend.service;

import dto.ImportError;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IImportFile<T, E, K>  {
    List<T> readFile(String path);// trả ra 1 list csv
    void validation(T t, E context, List<ImportError> importErrors, List<K> entities);// E là context, đưa vao map, list de check validation
    void saveAll(List<K> entities) throws SQLException;
    void exportFileError(List<ImportError> importErrors, String pathError);

    //path: đường dẫn:
    default String importFile(String path, E context, String pathError) throws SQLException {
        File file = new File(path);
        if (!file.exists()) {
            return "File này ko ko tồn tại";
        }
        if (!path.endsWith(".csv")) {
            return "File này ko đúng định";
        }
        List<T> csvs = readFile(path);// ds csv lấy ra từ file csv
        List<ImportError> importErrors = new ArrayList<>();// list bắt lỗi
        List<K> entities = new ArrayList<>();// list lưu vao DB
        for (T t : csvs) {
            validation(t, context, importErrors, entities);
        }
        // luu ds ko loi vào DB
        saveAll(entities);

        // xuat ra file loi
        exportFileError(importErrors, pathError);
        String message = "Đã import thành công " + entities.size() + ", thất bại " + importErrors.size();
        return message;
    }
}
