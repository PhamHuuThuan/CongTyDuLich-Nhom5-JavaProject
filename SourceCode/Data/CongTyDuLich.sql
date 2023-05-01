USE [master]
GO
/****** Object:  Database [CongTyDuLich]    Script Date: 5/1/2023 5:21:45 PM ******/
CREATE DATABASE [CongTyDuLich]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CongTyDuLich', FILENAME = N'D:\CongTyDuLich.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CongTyDuLich_log', FILENAME = N'D:\CongTyDuLich_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CongTyDuLich] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CongTyDuLich].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CongTyDuLich] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CongTyDuLich] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CongTyDuLich] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CongTyDuLich] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CongTyDuLich] SET ARITHABORT OFF 
GO
ALTER DATABASE [CongTyDuLich] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CongTyDuLich] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CongTyDuLich] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CongTyDuLich] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CongTyDuLich] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CongTyDuLich] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CongTyDuLich] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CongTyDuLich] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CongTyDuLich] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CongTyDuLich] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CongTyDuLich] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CongTyDuLich] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CongTyDuLich] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CongTyDuLich] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CongTyDuLich] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CongTyDuLich] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CongTyDuLich] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CongTyDuLich] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CongTyDuLich] SET  MULTI_USER 
GO
ALTER DATABASE [CongTyDuLich] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CongTyDuLich] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CongTyDuLich] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CongTyDuLich] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CongTyDuLich] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CongTyDuLich] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [CongTyDuLich] SET QUERY_STORE = OFF
GO
USE [CongTyDuLich]
GO
/****** Object:  Table [dbo].[DiaDiem]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaDiem](
	[MaDiaDiem] [nvarchar](20) NOT NULL,
	[TenDiaDiem] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_DiaDiem] PRIMARY KEY CLUSTERED 
(
	[MaDiaDiem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[SoHoaDon] [nvarchar](20) NOT NULL,
	[MaKH] [nvarchar](20) NULL,
	[MaTour] [nvarchar](20) NULL,
	[NgayLapHD] [datetime] NULL,
	[MaNV] [nvarchar](20) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[SoHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](20) NOT NULL,
	[SDT] [nvarchar](11) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](20) NOT NULL,
	[SDT] [nvarchar](11) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[CCCD] [nvarchar](12) NULL,
	[NgayVaoLam] [date] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuongTien]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuongTien](
	[MaPhuongTien] [nvarchar](50) NOT NULL,
	[PhuongTien] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhuongTien] PRIMARY KEY CLUSTERED 
(
	[MaPhuongTien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TourDuLich](
	[MaTour] [nvarchar](20) NOT NULL,
	[TenTour] [nvarchar](100) NOT NULL,
	[MoTa] [nvarchar](1000) NULL,
	[SoCho] [int] NOT NULL,
	[PhuongTien] [nvarchar](50) NULL,
	[NgayDi] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
	[DiemKH] [nvarchar](20) NOT NULL,
	[DiemKT] [nvarchar](20) NOT NULL,
	[KhachSan] [nvarchar](50) NULL,
	[Gia] [decimal](18, 2) NULL,
	[Anh] [nvarchar](200) NULL,
 CONSTRAINT [PK_TourDuLich] PRIMARY KEY CLUSTERED 
(
	[MaTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhVien]    Script Date: 5/1/2023 5:21:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhVien](
	[MaTV] [nvarchar](20) NOT NULL,
	[MaHD] [nvarchar](20) NOT NULL,
	[TenTV] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[LuaTuoi] [bit] NULL,
 CONSTRAINT [PK_ThanhVien] PRIMARY KEY CLUSTERED 
(
	[MaTV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'', N'TP HCM')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL001', N'Hội An')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL002', N'Phú Quốc')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL003', N'Lào Cai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL004', N'Vũng Tàu')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL005', N'Gia Lai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL006', N'Đà Lạt')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL007', N'Đà Nẵng')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL008', N'Hạ Long')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL009', N'TP HCM')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH001', N'TP Hồ Chí Minh')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH002', N'Hà Nội')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH003', N'Gia Lai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH004', N'Đà Nẵng')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH005', N'Cần Thơ')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH006', N'Hậu Giang')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH007', N'Hà Nội')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH008', N'Đà Lạt')
GO
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD001', N'KH001', N'T001', CAST(N'2023-04-14T00:00:00.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD002', N'KH001', N'T001', CAST(N'2023-04-27T13:00:05.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD003', N'KH001', N'T002', CAST(N'2023-04-27T13:01:06.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD004', N'KH011', N'T010', CAST(N'2023-04-27T15:38:50.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD005', N'KH001', N'T010', CAST(N'2023-04-28T16:06:40.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD006', N'KH001', N'T010', CAST(N'2023-04-28T16:22:16.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD007', N'KH001', N'T001', CAST(N'2023-04-28T22:44:33.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD008', N'KH001', N'T007', CAST(N'2023-04-28T22:48:24.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD009', N'KH001', N'T003', CAST(N'2023-04-28T22:50:54.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD010', N'KH001', N'T007', CAST(N'2023-04-28T22:54:03.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD011', N'KH001', N'T007', CAST(N'2023-04-28T23:11:03.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD012', N'KH011', N'T011', CAST(N'2023-04-28T23:18:50.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD013', N'KH008', N'T010', CAST(N'2023-04-28T23:29:43.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD014', N'KH012', N'T010', CAST(N'2023-04-28T23:36:50.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD015', N'KH012', N'T011', CAST(N'2023-04-29T23:40:27.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD016', N'KH012', N'T011', CAST(N'2023-04-29T23:41:50.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD017', N'KH006', N'T010', CAST(N'2023-04-29T23:55:17.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD018', N'KH004', N'T011', CAST(N'2023-04-29T23:59:32.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD019', N'KH003', N'T006', CAST(N'2023-04-29T00:03:03.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD020', N'KH002', N'T011', CAST(N'2023-04-30T00:07:07.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD021', N'KH008', N'T006', CAST(N'2023-04-30T00:15:41.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD022', N'KH010', N'T010', CAST(N'2023-04-30T00:28:24.000' AS DateTime), N'NV002')
GO
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH001', N'0987654321', N'Nguyen Thi An', N'thian@gmail.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH002', N'0987234231', N'Lê Hoàng Quân', N'dinhbao@gmail.com', N'HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH003', N'0923123141', N'Nguyen Van Nhat', N'vannhat@gmail.com', N'Ha Noi')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH004', N'0862726121', N'Nguyễn Xuân Sang', N'dinhphat@gmail.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH005', N'0924413412', N'Hoang Huy Toi', N'hoanghuytoi03@gmail.com', N'Hau Giang')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH006', N'0928737113', N'Nguyen Van Nam', N'vannam@gmail.com', N'Hà Giang')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH007', N'0931234124', N'Hoang Nguyen Van Thach', N'hoangthach@gmail.com', N'Hà Tĩnh')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH008', N'0923712341', N'Le Thi Hong', N'lehong@gmail.com', N'Binh Phuoc')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH009', N'0983231123', N'Phạm Văn Tuân', N'vantuan@gmail.com', N'Nghệ An')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH010', N'0987123121', N'Hoang Thi Huong', N'thihuong@gmail.com', N'Thanh Hoa')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH011', N'0123123123', N'Phùng Cảnh Tuấn', N'tuan123@gmail.com', N'Gò Vấp')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH012', N'0123456123', N'Nguyễn Quốc Đại', N'quocdaii@gmail.com', N'Quận 1')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH013', N'0124123123', N'Nguyễn Thùy Vân', N'thuyvan@gmail.com', N'Long An')
GO
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV001', N'0123456789', N'12345', N'Phạm Hữu Thuận', CAST(N'2003-05-14' AS Date), 1, N'064123123123', CAST(N'2023-03-15' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV002', N'0987654321', N'12345', N'Nguyễn Thị Như Quỳnh', CAST(N'2000-01-01' AS Date), 0, N'123456789123', CAST(N'2022-01-01' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV003', N'0122333444', N'54321', N'Nguyễn Thị Hằng', CAST(N'2001-10-28' AS Date), 0, N'064987123654', CAST(N'2020-05-01' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV004', N'0952123476', N'123456789', N'Trần Văn Hiếu', CAST(N'1995-03-04' AS Date), 1, NULL, CAST(N'2021-09-10' AS Date))
GO
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT01', N'Máy bay')
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT02', N'Xe khách')
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT03', N'Tàu')
GO
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T001', N'Tour Du Lịch Khám Phá Phú Quốc', N'Không phải tự nhiên mà Phú Quốc được mệnh danh là “đảo ngọc” của Việt Nam. Nơi đây sở hữu những bãi biển quyến rũ nhất thế giới, có cả thiên nhiên đa dạng và những điểm dừng chân đậm chất văn hóa địa phương.', 25, N'PT01', CAST(N'2023-04-30' AS Date), CAST(N'2023-05-02' AS Date), N'DKH001', N'DDL002', N'Khách sạn 4 sao', CAST(3500000.00 AS Decimal(18, 2)), N'Img\T001\phuquoc1.jpg;Img\T001\phuquoc2.jpg;Img\T001\phuquoc3.jpg;Img\T001\phuquoc4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T002', N'Sa Pa Điểm Du Lịch Nổi Tiếng Tây Bắc', N'Sapa nổi tiếng với phong cảnh thiên nhiên hữu tình, là nơi đất trời hội tụ với nhiều điểm du lịch hấp dẫn. Ngắm nhìn thiên nhiên hùng vĩ, tìm hiểu văn hóa, con người Sapa sẽ mang đến cho du khách chuyến đi với nhiều trải nghiệm thú vị.', 2, N'PT01', CAST(N'2023-05-14' AS Date), CAST(N'2023-05-20' AS Date), N'DKH002', N'DDL003', N'Khách sạn 5 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T002\sapa1.jpg;Img\T002\sapa2.jpg;Img\T002\sapa3.jpg;Img\T002\sapa4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T003', N'Đà Lạt Thiên Đường Du Lịch', N'Một xứ sở của các loài hoa thi nhau đua sắc thắm.  Ở Đà Lạt tập trung rất nhiều các loài hoa quý từ các nước khác nhập về. Tạo thêm cho Đà Lạt một vẽ đẹp huyền bí và mơ mộng tới tột cùng. Màng không có một thành phố nào tại nước Việt Nam ta sánh kịp với Đà Lạt.', 40, N'PT02', CAST(N'2023-06-01' AS Date), CAST(N'2023-06-03' AS Date), N'DKH003', N'DDL006', N'Khách sạn 3 sao', CAST(3000000.00 AS Decimal(18, 2)), N'Img\T003\dalat1.jpg;Img\T003\dalat2.jpg;Img\T003\dalat3.jpg;Img\T003\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T006', N'Phố Núi Gia Lai', N'Gia Lai còn được biết đến là vùng đất cổ xưa, di chỉ khảo cổ Biển Hồ là minh chứng cho quá trình hình thành, định cư lâu dài của người bản địa trên vùng đất cao nguyên hùng vĩ. Trải qua bao thăng trầm của lịch sử, vùng đất Gia Lai vẫn giữ cho mình nền văn hóa truyền thống đặc trưng, đa dạng thể hiện qua tôn giáo đa thần (Tô Tem), chế độ mẫu hệ của người bản địa.', 30, N'PT01', CAST(N'2023-07-06' AS Date), CAST(N'2023-07-10' AS Date), N'DKH002', N'DDL005', N'Khách sạn 4 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T006\gialai1.jpg;Img\T006\gialai.jpg;Img\T006\gialai3.jpg;Img\T006\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T007', N'Hạ Long - Kĩ Quan Thiên Nhiên Hùng Vĩ', N'Cảnh đẹp của Vịnh Hạ Long còn đến từ sự đa dạng của các hệ sinh thái. Được ví như một bức tranh thủy mặc khổng lồ, Vịnh Hạ Long là một kỳ quan sống động với hàng nghìn đảo đá nhô lên từ mặt nước trong xanh cùng hệ thống hang động phong phú và kỳ bí. Nơi đây có sắc xanh biếc sâu thẳm của biển, sắc xanh thiên thanh phớt nhẹ của bầu trời, và sắc xanh lá cây tươi mát của vô số loài thực vật hiện hữu trên núi đá vôi...', 20, N'PT03', CAST(N'2023-05-22' AS Date), CAST(N'2023-05-26' AS Date), N'DKH004', N'DDL008', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T007\halong1.jpg;Img\T007\halong2.jpg;Img\T007\halong3.jpg;Img\T007\halong4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T008', N'Lễ hội hoa dã quỳ tại Gia Lai', N'Lễ hội hoa dã quỳ tổ chức tại núi lửa Chư Đăng Ya - Gia Lai', 20, N'PT01', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL005', N'Khách sạn 3 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T008\gialai1.jpg;Img\T008\gialai2.jpg;Img\T008\gialai3.jpg;Img\T008\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T009', N'Vũng Tàu  - Thành Phố Biển''', N'Đến với Vũng Tàu bạn sẽ được trải nghiệm những trò chơi thú vị, bãi tắm đẹp cùng những con người thân thiện nơi đây.''', 30, N'PT02', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL004', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T009\vungtau1.jpeg;Img\T009\vungtau2.jpg;Img\T009\vungtau3.jpg;Img\T009\vungtau4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T010', N'Đà Nẵng Thành Phố Đáng Sống', N'Đà Nẵng là một thành phố biển thuộc miền Trung', 25, N'PT02', CAST(N'2023-05-18' AS Date), CAST(N'2023-05-20' AS Date), N'DKH003', N'DDL007', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T010\danang1.jpg;Img\T010\danang2.jpg;Img\T010\danang3.png;Img\T010\danang4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T011', N'Lâm Đồng - Thành Phố Sương Mù', N'abc xyz', 40, N'PT01', CAST(N'2023-04-29' AS Date), CAST(N'2023-05-03' AS Date), N'DKH001', N'DDL006', N'Khách sạn 4 sao', CAST(6500000.00 AS Decimal(18, 2)), N'Img\T011\dalat1.jpg;Img\T011\dalat2.jpg;Img\T011\dalat3.jpg;Img\T011\dalat4.jpg;')
GO
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV001', N'HD001', N'Đỗ Hiếu Thương', 1, CAST(N'2000-01-01' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV002', N'HD002', N'Cao Khả Đạt', 1, CAST(N'2008-02-09' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV003', N'HD002', N'Lương Văn Trọng', 1, CAST(N'1986-11-28' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV004', N'HD003', N'Nguyễn Văn Thân', 1, CAST(N'2015-01-16' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV005', N'HD003', N'Nguyễn Thái Thắng', 1, CAST(N'2000-09-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV006', N'HD004', N'Bao Ly', 1, CAST(N'2002-04-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV007', N'HD005', N'Lê Phú Quý', 1, CAST(N'2008-04-18' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV008', N'HD005', N'Bùi Minh Quân', 1, CAST(N'1998-02-09' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV009', N'HD006', N'Vũ Thị Phương', 0, CAST(N'2002-02-10' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV010', N'HD006', N'Phan Đức Sơn', 1, CAST(N'2008-04-18' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV011', N'HD007', N'Lê Văn Tài', 1, CAST(N'2010-04-14' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV012', N'HD007', N'Vũ Thị Hoài', 0, CAST(N'2002-04-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV013', N'HD008', N'Trần Tất Thắng', 1, CAST(N'2011-11-11' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV014', N'HD008', N'Nguyễn Ngọc Hoài Thu', 0, CAST(N'2000-04-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV015', N'HD009', N'Phạm Thị Thanh Thuý', 0, CAST(N'1994-04-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV016', N'HD010', N'Lê Nguyễn Thúy An', 0, CAST(N'2001-04-22' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV017', N'HD011', N'Hồ Ngọc An', 0, CAST(N'2006-04-19' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV018', N'HD011', N'Phạm Thị Như Duyên', 0, CAST(N'1987-07-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV019', N'HD012', N'Lê Thanh An', 0, CAST(N'1997-04-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV021', N'HD013', N'Đỗ Ngọc Kiều Chinh', 0, CAST(N'2000-04-27' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV022', N'HD014', N'Nguyễn Quốc Đại', 1, CAST(N'1993-04-21' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV023', N'HD015', N'Lê Huy Bảo Đạt', 1, CAST(N'2002-04-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV024', N'HD016', N'Đoàn Thị Thanh Dung', 0, CAST(N'2004-04-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV025', N'HD017', N'Nguyễn Trường Giang', 1, CAST(N'2000-04-12' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV026', N'HD018', N'Bùi Tiến Dũng', 1, CAST(N'2000-04-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV027', N'HD019', N'Hoàng Nam Hải', 1, CAST(N'2000-04-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV028', N'HD019', N'Lương Chí Nguyên', 1, CAST(N'1999-08-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV029', N'HD020', N'Lê Hoàng Quân', 1, CAST(N'1995-04-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV030', N'HD020', N'Nguyễn Hữu Nhân', 1, CAST(N'1993-12-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV031', N'HD020', N'Trần Thị Thu Nhân', 0, CAST(N'1997-01-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV032', N'HD021', N'Trần Thanh Phong', 1, CAST(N'2002-04-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV033', N'HD022', N'Hoang Thi Huong', 1, CAST(N'1998-04-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV034', N'HD022', N'Trần Minh Sơn', 1, CAST(N'1996-07-11' AS Date), 1)
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaTour])
REFERENCES [dbo].[TourDuLich] ([MaTour])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD  CONSTRAINT [FK_TourDuLich_DiaDiem] FOREIGN KEY([DiemKT])
REFERENCES [dbo].[DiaDiem] ([MaDiaDiem])
GO
ALTER TABLE [dbo].[TourDuLich] CHECK CONSTRAINT [FK_TourDuLich_DiaDiem]
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD  CONSTRAINT [FK_TourDuLich_DiaDiem1] FOREIGN KEY([DiemKH])
REFERENCES [dbo].[DiaDiem] ([MaDiaDiem])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TourDuLich] CHECK CONSTRAINT [FK_TourDuLich_DiaDiem1]
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD  CONSTRAINT [FK_TourDuLich_PhuongTien] FOREIGN KEY([PhuongTien])
REFERENCES [dbo].[PhuongTien] ([MaPhuongTien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TourDuLich] CHECK CONSTRAINT [FK_TourDuLich_PhuongTien]
GO
ALTER TABLE [dbo].[ThanhVien]  WITH CHECK ADD  CONSTRAINT [FK__ThanhVien__MaHD__45F365D3] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([SoHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThanhVien] CHECK CONSTRAINT [FK__ThanhVien__MaHD__45F365D3]
GO
USE [master]
GO
ALTER DATABASE [CongTyDuLich] SET  READ_WRITE 
GO
