CREATE DATABASE IF NOT EXISTS `Student_Management`;
USE `Student_Management`;

SELECT * from `Major`;
select * from `Lecturer`;
select * from `account`;
-- Thêm role vào bảng account để phân quyền cho menu

ALTER TABLE `Account` ADD COLUMN `role` VARCHAR(20) NOT NULL DEFAULT 'Student';

---- set mặc định
UPDATE `account`
SET `role` = 'ADMIN'
WHERE `email` = 'admin@vti.edu.vn';
--- set mặc định
UPDATE `account`
SET `role` = 'LECTURER'
WHERE `email` = 'vana@vti.edu.vn';

-- 1. Bảng Major (Chuyên ngành)
CREATE TABLE IF NOT EXISTS `Major` (
    `major_id`   INT AUTO_INCREMENT PRIMARY KEY,
    `major_name` VARCHAR(100) NOT NULL UNIQUE
);

-- 2. Bảng Lecturer (Giảng viên)
CREATE TABLE IF NOT EXISTS `Lecturer` (
    `lecturer_id` INT AUTO_INCREMENT PRIMARY KEY,
    `full_name`   VARCHAR(100) NOT NULL,
    `email`       VARCHAR(100) NOT NULL UNIQUE,
    `department`  VARCHAR(100) -- Tên khoa
);

-- 3. Bảng Student (Sinh viên)
CREATE TABLE IF NOT EXISTS `Student` (
    `student_id`    INT AUTO_INCREMENT PRIMARY KEY,
    `full_name`     VARCHAR(100) NOT NULL,
    `email`         VARCHAR(100) NOT NULL UNIQUE,
    `date_of_birth` DATE,
    `major_id`      INT,
    FOREIGN KEY (`major_id`) REFERENCES `Major` (`major_id`)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- 4. Bảng Account (Tài khoản)
CREATE TABLE IF NOT EXISTS `Account` (
    `account_id` INT AUTO_INCREMENT PRIMARY KEY,
    `email`      VARCHAR(100) NOT NULL UNIQUE,
    `password`   VARCHAR(255) NOT NULL,
    `full_name`  VARCHAR(100) NOT NULL
);


INSERT INTO `Major` (`major_name`) VALUES
('Công nghệ thông tin'),
('Quản trị kinh doanh'),
('Ngôn ngữ Anh'),
('Cơ khí');

INSERT INTO `Lecturer` (`full_name`, `email`, `department`) VALUES
('Nguyễn Văn A', 'vana@vti.edu.vn', 'Khoa CNTT'),
('Trần Thị B', 'thib@vti.edu.vn', 'Khoa Kinh tế'),
('Lê Văn C', 'vanl@vti.edu.vn', 'Khoa Ngoại ngữ');

INSERT INTO `Student` (`full_name`, `email`, `date_of_birth`, `major_id`) VALUES
('Phạm Nhật Vượng', 'vuong.pn@vti.edu.vn', '1990-05-15', 1),
('Đặng Lê Nguyên Vũ', 'vu.dln@vti.edu.vn', '1992-11-20', 2),
('Nguyễn Thị Phương Thảo', 'thao.ntp@vti.edu.vn', '1991-03-10', 1),
('Trần Đình Long', 'long.td@vti.edu.vn', '1993-07-25', 3);

INSERT INTO `Account` (`email`, `password`, `full_name`) VALUES
('admin@vti.edu.vn', '$2P9eTa8', 'Admin Quản Trị'),
('vana@vti.edu.vn', '$2P9eTa8', 'Nguyễn Văn A'),
('vuong.pn@vti.edu.vn', '$2P9eTa8', 'Phạm Nhật Vượng');