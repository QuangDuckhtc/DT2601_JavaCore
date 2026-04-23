import java.time.LocalDate;

public class Exercise4 {
    public static void question1() {
        int x = RandomUtil.randomInt(-1000, 1000);
        System.out.println("In ngẫu nhiên số nguyên trong khoảng [-1000, 1000]: " + x);

    }
    public static void question2() {
        System.out.println("in ngẫu nhiên ra 1 số thực: " + RandomUtil.randomDouble());
    }
    public static void question3() {
        String[] names = {"name1", "name2", "name3", "name4", "name5"};

        System.out.println("In ra học sinh ngẫu nhiên: " +
                RandomUtil.randomFromArray(names));
    }
    public static void question4() {
        LocalDate start = LocalDate.of(1995, 7, 24);
        LocalDate end = LocalDate.of(1995, 12, 20);

        System.out.println("lấy ngẫy nhiên 1 ngày : " + RandomUtil.randomDate(start, end));
    }
    public static void question5() {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusYears(1);

        System.out.println("Lấy ngẫu nhiên 1 ngày trong khoảng 1 năm trở lại:  " + RandomUtil.randomDate(start, end));
    }
    public static void question6() {
        LocalDate start = LocalDate.of(1900, 1, 1);

        System.out.println("Lấy ngẫu nhiên 1 ngày trong quá khứ:  " + RandomUtil.randomDate(start, LocalDate.now()));
    }
    public static void question7() {
        int x = RandomUtil.randomInt(100, 999);
        System.out.println("Lấy ngẫu nhiên 1 số có 3 chữ số: " + x);
    }
}
