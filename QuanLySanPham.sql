-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th3 03, 2023 lúc 09:07 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `QuanLySanPham`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbnhomsanpham`
--

CREATE TABLE `tbnhomsanpham` (
  `manhom` int(11) NOT NULL,
  `tennhom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbnhomsanpham`
--

INSERT INTO `tbnhomsanpham` (`manhom`, `tennhom`) VALUES
(1, 'Hoa Đà Lạt'),
(2, 'Hoa sinh nhật'),
(3, 'Hoa cưới');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbsanpham`
--

CREATE TABLE `tbsanpham` (
  `MaSP` int(11) NOT NULL,
  `TenSP` varchar(100) NOT NULL,
  `HinhanhSP` varchar(100) NOT NULL,
  `GioithieuSP` varchar(1000) NOT NULL,
  `GiaSP` int(11) NOT NULL,
  `manhom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbsanpham`
--

INSERT INTO `tbsanpham` (`MaSP`, `TenSP`, `HinhanhSP`, `GioithieuSP`, `GiaSP`, `manhom`) VALUES
(1, 'Big love', '1.jpg', 'Loài hoa này tượng trưng cho hạnh phúc', 500000, 3),
(2, 'Bản nhạc dịu êm', '2.jpg', 'Loài hoa tượng trưng cho sự lãng mạn', 200000, 2),
(3, 'color-of-love', '3.jpg', 'Tượng trưng cho món quà có ý nghiax', 700000, 3),
(4, 'Im thinking of you', '4.jpg', 'Xuất xứ: Đà lạt màu tím của hoa lan', 300000, 1),
(5, 'Princess', '5.jpg', 'Xuất xứ: Đà lạt kết hợp hoa hồng', 400000, 1),
(6, 'Sắc màu', '6.jpg', 'Xuất xứ: Đà lạt bó hoa có nhiều màu sắc', 350000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbtaikhoan`
--

CREATE TABLE `tbtaikhoan` (
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbtaikhoan`
--

INSERT INTO `tbtaikhoan` (`user`, `password`) VALUES
('admin', '123456'),
('nhanvien', '123456');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbnhomsanpham`
--
ALTER TABLE `tbnhomsanpham`
  ADD PRIMARY KEY (`manhom`);

--
-- Chỉ mục cho bảng `tbsanpham`
--
ALTER TABLE `tbsanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `manhom` (`manhom`);

--
-- Chỉ mục cho bảng `tbtaikhoan`
--
ALTER TABLE `tbtaikhoan`
  ADD PRIMARY KEY (`user`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbsanpham`
--
ALTER TABLE `tbsanpham`
  ADD CONSTRAINT `tbsanpham_ibfk_1` FOREIGN KEY (`manhom`) REFERENCES `tbnhomsanpham` (`manhom`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
