USE [master]
GO
/****** Object:  Database [CongTyDuLich]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[DiaDiem]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[PhuongTien]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 5/3/2023 10:26:33 PM ******/
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
/****** Object:  Table [dbo].[ThanhVien]    Script Date: 5/3/2023 10:26:33 PM ******/
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
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL010', N'Quy Nhơn')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL011', N'Cà Mau')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL012', N'Cần Thơ')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL013', N'Bến Tre')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL014', N'Buôn Mê')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL015', N'Nha Trang')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL016', N'Huế')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL017', N'Hà Nội')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL018', N'Đồng Hới')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL019', N'Mũi Né')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH001', N'TP Hồ Chí Minh')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH002', N'Hà Nội')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH003', N'Gia Lai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH004', N'Đà Nẵng')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH005', N'Cần Thơ')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH006', N'Hậu Giang')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH007', N'Nghệ An')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH008', N'Đà Lạt')
GO
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD001', N'KH001', N'T001', CAST(N'2023-03-14T00:00:00.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD002', N'KH001', N'T001', CAST(N'2023-03-27T13:00:05.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD003', N'KH001', N'T002', CAST(N'2023-04-12T13:01:06.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD004', N'KH011', N'T010', CAST(N'2023-04-14T15:38:50.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD005', N'KH001', N'T010', CAST(N'2023-04-15T16:06:40.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD006', N'KH001', N'T010', CAST(N'2023-04-18T16:22:16.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD007', N'KH001', N'T001', CAST(N'2023-04-21T22:44:33.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD008', N'KH001', N'T007', CAST(N'2023-04-23T22:48:24.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD009', N'KH001', N'T003', CAST(N'2023-04-24T22:50:54.000' AS DateTime), N'NV001')
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
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD023', N'KH001', N'T003', CAST(N'2022-01-02T01:59:56.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD024', N'KH014', N'T014', CAST(N'2022-01-07T17:22:54.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD025', N'KH015', N'T014', CAST(N'2022-01-04T17:24:37.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD026', N'KH012', N'T014', CAST(N'2022-01-05T17:26:47.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD027', N'KH010', N'T013', CAST(N'2022-01-09T17:28:32.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD028', N'KH016', N'T015', CAST(N'2022-02-01T17:30:22.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD029', N'KH017', N'T015', CAST(N'2022-02-02T17:32:35.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD030', N'KH018', N'T015', CAST(N'2022-02-06T17:34:08.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD031', N'KH019', N'T016', CAST(N'2022-02-10T17:37:16.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD032', N'KH020', N'T016', CAST(N'2022-02-11T17:38:55.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD033', N'KH021', N'T017', CAST(N'2022-03-11T17:41:52.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD034', N'KH022', N'T017', CAST(N'2022-03-14T17:43:03.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD035', N'KH023', N'T017', CAST(N'2022-03-20T17:45:48.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD036', N'KH024', N'T018', CAST(N'2022-04-01T17:48:42.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD037', N'KH025', N'T018', CAST(N'2022-04-03T17:50:14.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD038', N'KH026', N'T018', CAST(N'2022-04-12T17:51:21.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD039', N'KH027', N'T019', CAST(N'2022-05-05T18:18:44.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD040', N'KH028', N'T019', CAST(N'2022-05-08T18:19:54.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD041', N'KH029', N'T019', CAST(N'2022-05-12T18:24:54.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD042', N'KH030', N'T020', CAST(N'2022-06-06T18:27:40.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD043', N'KH031', N'T020', CAST(N'2022-06-10T18:29:12.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD044', N'KH032', N'T020', CAST(N'2022-06-14T18:30:29.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD045', N'KH021', N'T021', CAST(N'2022-07-01T18:33:18.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD046', N'KH033', N'T021', CAST(N'2022-07-04T18:34:19.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD047', N'KH034', N'T021', CAST(N'2022-07-08T18:35:20.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD048', N'KH035', N'T022', CAST(N'2022-08-01T18:38:03.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD049', N'KH036', N'T022', CAST(N'2022-08-03T18:40:12.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD050', N'KH037', N'T022', CAST(N'2022-08-06T18:41:00.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD051', N'KH038', N'T023', CAST(N'2022-09-01T18:43:06.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD052', N'KH039', N'T023', CAST(N'2022-09-04T18:44:14.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD053', N'KH040', N'T023', CAST(N'2022-09-08T18:45:48.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD054', N'KH041', N'T024', CAST(N'2022-10-02T18:48:48.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD055', N'KH042', N'T024', CAST(N'2022-10-05T18:50:16.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD056', N'KH043', N'T026', CAST(N'2022-12-02T18:52:21.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD057', N'KH044', N'T026', CAST(N'2022-12-02T18:54:26.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD058', N'KH045', N'T025', CAST(N'2022-11-02T18:57:19.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD059', N'KH046', N'T025', CAST(N'2022-11-06T18:58:24.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD060', N'KH047', N'T025', CAST(N'2022-11-09T19:00:07.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD061', N'KH048', N'T027', CAST(N'2023-01-02T19:02:48.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD062', N'KH049', N'T027', CAST(N'2023-01-03T19:04:16.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD063', N'KH050', N'T027', CAST(N'2023-01-04T19:04:54.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD064', N'KH051', N'T027', CAST(N'2023-01-04T19:05:58.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD065', N'KH052', N'T027', CAST(N'2023-01-05T19:06:59.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD066', N'KH053', N'T029', CAST(N'2023-01-10T19:09:35.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD067', N'KH054', N'T029', CAST(N'2023-01-12T19:10:46.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD068', N'KH055', N'T029', CAST(N'2023-01-15T19:11:47.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD069', N'KH056', N'T030', CAST(N'2023-02-01T19:52:59.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD070', N'KH057', N'T030', CAST(N'2023-02-01T19:55:49.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD071', N'KH058', N'T031', CAST(N'2023-02-10T19:57:36.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD072', N'KH059', N'T031', CAST(N'2023-02-12T19:58:56.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD073', N'KH060', N'T031', CAST(N'2023-02-13T20:01:29.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD074', N'KH061', N'T032', CAST(N'2023-03-03T00:06:46.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD075', N'KH062', N'T032', CAST(N'2023-03-04T00:09:04.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD076', N'KH063', N'T032', CAST(N'2023-03-06T00:10:32.000' AS DateTime), N'NV004')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD077', N'KH064', N'T032', CAST(N'2023-03-10T00:13:07.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD078', N'KH065', N'T033', CAST(N'2023-03-11T00:14:18.000' AS DateTime), N'NV002')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD079', N'KH066', N'T033', CAST(N'2023-03-12T00:15:29.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD080', N'KH067', N'T033', CAST(N'2023-03-13T00:17:40.000' AS DateTime), N'NV003')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD081', N'KH068', N'T002', CAST(N'2023-05-03T00:27:01.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD082', N'KH069', N'T002', CAST(N'2023-05-03T00:31:11.000' AS DateTime), N'NV001')
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD083', N'KH023', N'T002', CAST(N'2023-05-03T15:35:12.000' AS DateTime), N'NV001')
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
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH014', N'0945314677', N'Trương Trọng Quân', N'trongquan@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH015', N'0975641231', N'Vũ Thị Phương', N'phuongvu0405@gmail.com', N'Hải Dương')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH016', N'0937651211', N'Nguyễn Đức Thông', N'ducthong11@gmail.com', N'Kon Tum')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH017', N'0954377734', N'Phạm Thị Thanh Thuý', N'phamthuy97@gmail.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH018', N'0977653134', N'Lê Nguyễn Thúy An', N'anthuynguen95@gmai.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH019', N'0953113576', N'Phạm Thị Như Duyên', N'phamduyen098@gmail.com', N'Hà Nam')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH020', N'09125752254', N'Nguyễn Thái Bình', N'thaibinh0410@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH021', N'0956463335', N'Đoàn Thị Thanh Dung', N'dungthanh1123@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH022', N'09843346785', N'Huỳnh Minh Đức', N'ducdeptrai111@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH023', N'0935673325', N'Nguyễn Trường Giang', N'giangnguyen1996@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH024', N'0986425767', N'Nguyễn Chí Hiếu', N'hieuchi123@gmail.com', N'Hậu Giang')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH025', N'09876623431', N'Nguyễn Trần Nhật Linh', N'nhatllinh2000@gmail.com', N'Kiên Giang')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH026', N'0936464421', N'Trương Nhựt Phương', N'truongphuongpro@gmail.com', N'Hậu Giang')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH027', N'0975446542', N'Phạm Minh Quân', N'minhquanpro@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH028', N'0945726456', N'Tăng Yến Anh', N'yenanh321@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH029', N'0962635453', N'Đặng Quốc Quân', N'quandang@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH030', N'0924731344', N'Mai Kim Tiên', N'kimtien@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH031', N'0946781837', N'Nguyễn Công Vũ', N'vucong@gmaill.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH032', N'0967544567', N'Nguyễn Thị Liên', N'lliennguyenthi123@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH033', N'0965341253', N'Đặng Ngọc Quyên', N'quyenngoc@gmail.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH034', N'09364672532', N'Trần Vũ Tấn Tài', N'tantai12345@gmail.com', N'Gia Lai')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH035', N'0936435334', N'Phạm Minh Quy', N'minhquy@gmail.com', N'Đà Lạt')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH036', N'0912462258', N'Đoàn Thị Thanh Thảo', N'thaothanh@gmail.com', N'Đà Lạt')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH037', N'0966533454', N'Lê Nguyễn Thịnh', N'lethinh98@gmail.com', N'Đà Lạt')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH038', N'0977763543', N'Trần Nguyễn Bảo Trung', N'baotrung@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH039', N'0987223563', N'Phạm Bao Hoàng Dũng', N'hoangdungsss@gmail.com', N'Hà Nam')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH040', N'0912654338', N'Khương Minh Đại', N'khuongdaii@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH041', N'0935447722', N'Lê Trung Tính', N'trungtinh@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH042', N'0935534343', N'Đỗ Thị Ngọc Hà', N'doha@gmail.com', N'Quảng Nam')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH043', N'0937365453', N'Đinh Thị Thùy', N'dinhtuy@gmail.com', N'Quảng Ngãi')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH044', N'0912462824', N'Nguyễn Đăng Khoa', N'dangkhoa@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH045', N'0935642773', N'Lê Quang Nguyên', N'quangnguyen@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH046', N'0936654314', N'Bùi Thế Hiển', N'buihien@gmail.com', N'Long An')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH047', N'0936477255', N'Nguyễn Thanh Phong', N'phongthanh@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH048', N'0943732745', N'Lê Huỳnh Thương', N'huynhthuong@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH049', N'0984636474', N'Trần Hữu Đức', N'huuduc@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH050', N'0936545334', N'Hồ Văn Nhã', N'hovanha@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH051', N'0936461254', N'Nguyễn Thiện Khiêm', N'khiemthien@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH052', N'0936443636', N'Võ Thị Thuý Kiều', N'kieuthuy@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH053', N'0984552624', N'Nguyễn Tài Lộc', N'nguyenloc@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH054', N'0936543454', N'Nguyễn Ngọc Nam', N'ngocnam@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH055', N'0946632774', N'Cao Đoan Hồng Ngọc', N'hongngoc@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH056', N'09363453553', N'Thượng Đảo Hoàng', N'thuonghoang@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH057', N'0946637454', N'Cao Mạnh Lanh', N'caolanh@gmail.com', N'Hà Nam')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH058', N'0946632745', N'Nguyễn Tân Quí Long', N'Nguyenlong@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH059', N'0946722745', N'Trần Hoài Phương', N'tranphuong@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH060', N'0936464737', N'Nguyễn Thị Lan Phương', N'lanphuong@gmail.com', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH061', N'0935546727', N'Nguyễn Thành Nhân', N'thanhnhan@gmail.com', N'TP HCM')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH062', N'0946362745', N'Đậu Thị Kim Oanh', N'kimoanh222@gmail.com', N'Bình Dương')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH063', N'0933547547', N'Huỳnh Nguyễn Quốc Bửu', N'quocbuu123@gmail.com', N'Gò Vấp')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH064', N'0974676643', N'Lê Thị Kim Chung', N'kimchung789@gmail.com', N'Bình Dương')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH065', N'0936433445', N'Thái Nguyễn Minh Giang', N'minhgiang123@gmail.com', N'Cần Thơ')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH066', N'0926236354', N'Nguyễn Thị Ngọc', N'ngocxinhdep@gmail.com', N'Tân Bình')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH067', N'0936346547', N'Trần Thị Hạnh', N'hanh321@gmail.com', N'Tân Phú')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH068', N'0936437374', N'Mai Thị Kiều Oanh', N'kieuoanhkera@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH069', N'0936456434', N'Nguyễn Thuận Phát', N'thuanphattien@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH070', N'0326635356', N'Phạm Hữu Thuận', N'huuthuan1405@gmail.com', N'Gò Vấp')
GO
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV001', N'0326635356', N'12345', N'Phạm Hữu Thuận', CAST(N'2003-05-14' AS Date), 1, N'064123123321', CAST(N'2023-03-15' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV002', N'0987654321', N'12345', N'Nguyễn Thị Như Quỳnh', CAST(N'2000-01-01' AS Date), 0, N'123456789123', CAST(N'2022-01-01' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV003', N'0122333444', N'54321', N'Nguyễn Thị Hằng', CAST(N'2001-10-28' AS Date), 0, N'064987123654', CAST(N'2020-05-01' AS Date))
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV004', N'0952123476', N'123456789', N'Trần Văn Hiếu', CAST(N'1995-03-04' AS Date), 1, NULL, CAST(N'2021-09-10' AS Date))
GO
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT01', N'Máy bay')
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT02', N'Xe khách')
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT03', N'Tàu')
INSERT [dbo].[PhuongTien] ([MaPhuongTien], [PhuongTien]) VALUES (N'PT04', N'Xe bus')
GO
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T001', N'Tour Du Lịch Khám Phá Phú Quốc', N'Không phải tự nhiên mà Phú Quốc được mệnh danh là “đảo ngọc” của Việt Nam. Nơi đây sở hữu những bãi biển quyến rũ nhất thế giới, có cả thiên nhiên đa dạng và những điểm dừng chân đậm chất văn hóa địa phương.', 25, N'PT01', CAST(N'2023-04-30' AS Date), CAST(N'2023-05-02' AS Date), N'DKH001', N'DDL002', N'Khách sạn 4 sao', CAST(3500000.00 AS Decimal(18, 2)), N'Img\T001\phuquoc1.jpg;Img\T001\phuquoc2.jpg;Img\T001\phuquoc3.jpg;Img\T001\phuquoc4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T002', N'Sa Pa Điểm Du Lịch Nổi Tiếng Tây Bắc', N'Sapa nổi tiếng với phong cảnh thiên nhiên hữu tình, là nơi đất trời hội tụ với nhiều điểm du lịch hấp dẫn. Ngắm nhìn thiên nhiên hùng vĩ, tìm hiểu văn hóa, con người Sapa sẽ mang đến cho du khách chuyến đi với nhiều trải nghiệm thú vị.', 30, N'PT01', CAST(N'2023-05-14' AS Date), CAST(N'2023-05-20' AS Date), N'DKH002', N'DDL003', N'Khách sạn 5 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T002\sapa1.jpg;Img\T002\sapa2.jpg;Img\T002\sapa3.jpg;Img\T002\sapa4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T003', N'Đà Lạt Thiên Đường Du Lịch', N'Một xứ sở của các loài hoa thi nhau đua sắc thắm.  Ở Đà Lạt tập trung rất nhiều các loài hoa quý từ các nước khác nhập về. Tạo thêm cho Đà Lạt một vẽ đẹp huyền bí và mơ mộng tới tột cùng. Màng không có một thành phố nào tại nước Việt Nam ta sánh kịp với Đà Lạt.', 40, N'PT02', CAST(N'2023-06-01' AS Date), CAST(N'2023-06-03' AS Date), N'DKH003', N'DDL006', N'Khách sạn 3 sao', CAST(3000000.00 AS Decimal(18, 2)), N'Img\T003\dalat1.jpg;Img\T003\dalat2.jpg;Img\T003\dalat3.jpg;Img\T003\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T006', N'Phố Núi Gia Lai', N'Gia Lai còn được biết đến là vùng đất cổ xưa, di chỉ khảo cổ Biển Hồ là minh chứng cho quá trình hình thành, định cư lâu dài của người bản địa trên vùng đất cao nguyên hùng vĩ. Trải qua bao thăng trầm của lịch sử, vùng đất Gia Lai vẫn giữ cho mình nền văn hóa truyền thống đặc trưng, đa dạng thể hiện qua tôn giáo đa thần (Tô Tem), chế độ mẫu hệ của người bản địa.', 30, N'PT01', CAST(N'2023-07-06' AS Date), CAST(N'2023-07-10' AS Date), N'DKH002', N'DDL005', N'Khách sạn 4 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T006\gialai1.jpg;Img\T006\gialai.jpg;Img\T006\gialai3.jpg;Img\T006\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T007', N'Hạ Long - Kĩ Quan Thiên Nhiên Hùng Vĩ', N'Cảnh đẹp của Vịnh Hạ Long còn đến từ sự đa dạng của các hệ sinh thái. Được ví như một bức tranh thủy mặc khổng lồ, Vịnh Hạ Long là một kỳ quan sống động với hàng nghìn đảo đá nhô lên từ mặt nước trong xanh cùng hệ thống hang động phong phú và kỳ bí. Nơi đây có sắc xanh biếc sâu thẳm của biển, sắc xanh thiên thanh phớt nhẹ của bầu trời, và sắc xanh lá cây tươi mát của vô số loài thực vật hiện hữu trên núi đá vôi...', 20, N'PT03', CAST(N'2023-05-22' AS Date), CAST(N'2023-05-26' AS Date), N'DKH004', N'DDL008', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T007\halong1.jpg;Img\T007\halong2.jpg;Img\T007\halong3.jpg;Img\T007\halong4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T008', N'Lễ hội hoa dã quỳ tại Gia Lai', N'Lễ hội hoa dã quỳ tổ chức tại núi lửa Chư Đăng Ya - Gia Lai', 20, N'PT01', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL005', N'Khách sạn 3 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T008\gialai1.jpg;Img\T008\gialai2.jpg;Img\T008\gialai3.jpg;Img\T008\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T009', N'Vũng Tàu  - Thành Phố Biển', N'Đến với Vũng Tàu bạn sẽ được trải nghiệm những trò chơi thú vị, bãi tắm đẹp cùng những con người thân thiện nơi đây.''', 30, N'PT02', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL004', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T009\vungtau1.jpeg;Img\T009\vungtau2.jpg;Img\T009\vungtau3.jpg;Img\T009\vungtau4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T010', N'Đà Nẵng Thành Phố Đáng Sống', N'Toạ lạc ở vùng duyên hải Nam Trung Bộ, Đà Nẵng được đông đảo bạn bè quốc tế biết đến với hình ảnh đô thị năng động và rực rỡ sắc màu. Hơn cả Cầu Vàng ẩn hiện sau màn sương sớm hay tượng Cá Chép Hoá Rồng lập loè dưới ánh sáng pháo hoa, Đà Nẵng còn là trung tâm văn hoá, giáo dục, y tế, chính trị, kinh tế, xã hội... quan trọng. Không hoa lệ như Sài Thành hay chỉn chu chất Hà Nội, đi  tự túc, bạn sẽ nhận ra sự giao thoa giữa các yếu tố ''xưa'' và ''nay'' trong kiến trúc lẫn nhịp sống thường nhật của người dân bản địa.', 25, N'PT02', CAST(N'2023-05-18' AS Date), CAST(N'2023-05-20' AS Date), N'DKH003', N'DDL007', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T010\danang1.jpg;Img\T010\danang2.jpg;Img\T010\danang3.png;Img\T010\danang4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T011', N'Lâm Đồng - Thành Phố Sương Mù', N'Lâm Đồng là một tỉnh thuộc Tây Nguyên, Việt Nam. Được biết đến với rất nhiều danh lam thắng cảnh. Từ thơ mộng đến hùng vĩ, từ trên núi xuống thung lũng. Lâm Đồng, vùng đất nuôi dưỡng biết bao thế hệ người dân Việt Nam. Và cũng là nơi luôn đem lại sự yên bình xanh biếc.', 40, N'PT01', CAST(N'2023-04-29' AS Date), CAST(N'2023-05-03' AS Date), N'DKH001', N'DDL006', N'Khách sạn 4 sao', CAST(6500000.00 AS Decimal(18, 2)), N'Img\T011\dalat1.jpg;Img\T011\dalat2.jpg;Img\T011\dalat3.jpg;Img\T011\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T012', N'Thành phố biển Quy Nhơn - thiên đường du lịch hấp dẫn', N'Nếu như du khách đã quá quen thuộc với các tour du lịch Vũng Tàu, Nha Trang, Bình Thuận 
thì Quy Nhơn sẽ là điểm đến hấp dẫn cho những người yêu thích biển và sự bình yên.', 35, N'PT01', CAST(N'2023-06-22' AS Date), CAST(N'2023-06-26' AS Date), N'DKH003', N'DDL010', N'Khách sạn 4 sao', CAST(3500000.00 AS Decimal(18, 2)), N'Img\T012\quynhon1.jpg;Img\T012\quynhon2.jpg;Img\T012\quynhon3.jpg;Img\T012\quynhon4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T013', N'Bến Tre - miền quê bình yên rợp bóng dừa xanh', N'Bến Tre, miền quê bình yên rợp bóng dừa xanh là một trong những địa điểm lý tưởng cho những ai muốn cảm nhận sự thư thái, rời xa phồn hoa đô thị về với vùng đất miệt vườn. Cùng khám phá những điểm tham quan nổi tiếng nhất mà đã đến Bến Tre là phải đi cho bằng được dưới đây nhé!', 45, N'PT04', CAST(N'2022-01-20' AS Date), CAST(N'2022-01-22' AS Date), N'DKH001', N'DDL013', N'Khách sạn 3 sao', CAST(4500000.00 AS Decimal(18, 2)), N'Img\T013\bentre1.jpg;Img\T013\bentre2.jpg;Img\T013\bentre3.jpg;Img\T013\bentre4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T014', N'Du lịch Buôn Mê Thuột', N'Buôn Mê Thuột là thành phố trực thuộc tỉnh Đắk Lắk, có lịch sử hơn 4.000 năm tuổi, là nơi tập trung sinh sống của các dân tộc vùng núi Tây Nguyên. Nếu bạn yêu thích màu hoa pơ lang nở đỏ rực núi đồi, những rẫy cà phê xanh bạt ngàn, tham gia các lễ hội truyền thống độc đáo cùng những ché rượu cần ngất ngây và tiếng cồng chiêng rộn rã, khám phá những thác nước hùng vĩ… thì tất cả những điều ấy đều có trong chuyến đi du lịch buôn ma thuột vô cùng hấp dẫn.', 35, N'PT01', CAST(N'2022-01-14' AS Date), CAST(N'2022-01-17' AS Date), N'DKH002', N'DDL014', N'Khách sạn 4 sao', CAST(6500000.00 AS Decimal(18, 2)), N'Img\T014\buonme1.jpg;Img\T014\buonme2.jpg;Img\T014\buonme3.jpg;Img\T014\buonme4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T015', N'Mảnh đất cực Nam Tổ Quốc – Cà Mau sông nước', N'Những trải nghiệm bạn nên thử khi đi chợ nổi Cà Mau như lênh đênh trên sông nước nghe câu hò điệu lý của người dân và hòa mình vào cuộc sống bận rộn, tập lập của họ hay thưởng thức trái cây miệt vườn cùng các đặc sản khác như hủ tiếu…', 55, N'PT01', CAST(N'2022-02-10' AS Date), CAST(N'2022-02-11' AS Date), N'DKH003', N'DDL011', N'Khách sạn 4 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T015\camau1.jpg;Img\T015\camau2.jpg;Img\T015\camau3.jpg;Img\T015\camau4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T016', N'Cần Thơ - vùng quê sông nước, cảnh sắc hữu tình', N'Cần Thơ là thủ phủ của vùng Đồng bằng sông Cửu Long, có mạng lưới kênh rạch chằng chịt kết hợp sự nhộn nhịp của chợ nổi Cái Răng vào sáng sớm, vườn trái cây trĩu quả và kiến trúc độc đáo của nhà cổ, tất cả tạo nên vẻ đẹp sông nước đặc biệt không lẫn vào đâu, dưới đây là những điểm du lịch nổi tiếng Cần Thơ bạn không nên bỏ lỡ khi tới đây.', 20, N'PT01', CAST(N'2022-02-24' AS Date), CAST(N'2022-02-26' AS Date), N'DKH002', N'DDL012', N'Khách sạn 5 sao', CAST(7500000.00 AS Decimal(18, 2)), N'Img\T016\cantho1.jpg;Img\T016\cantho2.jpg;Img\T016\cantho3.jpg;Img\T016\cantho4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T017', N'Du lịch về thành phố Đồng Hới', N'Về du lịch, lượng khách trong nước và quốc tế đến tỉnh này ngày càng tăng cao. Quảng Bình là vùng đất giàu tiềm năng phát triển du lịch vì vừa có rừng, vừa có biển với nhiều di tích văn hóa - lịch sử và cảnh quan thiên nhiên tươi đẹp như cửa biển Nhật Lệ, Quang Phú, Đèo Ngang, đèo Lý Hòa, bãi Đá Nhảy, thành phố Đồng Hới năng động mến khách ... đặc biệt là Di sản thiên nhiên thế giới Vườn Quốc Gia Phong Nha - Kẻ Bàng. Động Phong Nha - một trong những hang động đẹp nhất thế giới đã được nhiều kỷ lục Guinness về hang động.', 25, N'PT02', CAST(N'2022-03-24' AS Date), CAST(N'2022-03-29' AS Date), N'DKH004', N'DDL018', N'Khách sạn 4 sao', CAST(8500000.00 AS Decimal(18, 2)), N'Img\T017\donghoi1.jpg;Img\T017\donghoi2.jpg;Img\T017\donghoi3.jpg;Img\T017\donghoi4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T018', N'DU LỊCH SÀI GÒN', N'Sài Gòn - TP.HCM cũng là một trung tâm du lịch lớn, với các di tích lịch sử và bảo tàng ghi lại dấu ấn thời chiến tranh chống Pháp và Mỹ. Tiêu biểu là hệ thống 11 bảo tàng trong đó nổi tiếng nhất là Bảo tàng chứng tích chiến tranh. Bên cạnh đó, các công trình kiến trúc thời thuộc địa cũng làm mãn nhãn du khách khi du lịch Sài Gòn, như Trụ sở Ủy Ban Nhân Dân Thành phố, Nhà hát lớn, Bưu điện trung tâm, Bến Nhà Rồng, Chợ Bến Thành và Dinh Độc Lập.', 60, N'PT02', CAST(N'2022-04-22' AS Date), CAST(N'2022-04-25' AS Date), N'DKH006', N'DDL009', N'Khách sạn 5 sao', CAST(6000000.00 AS Decimal(18, 2)), N'Img\T018\hcm1.jpg;Img\T018\hcm2.jpg;Img\T018\hcm3.jpg;Img\T018\hcm4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T019', N'Du lịch Hà Nội hấp dẫn nhất không thể bỏ qua', N'Những công trình từ thời Pháp thuộc, hàng quán vỉa hè bày bán đặc sản địa phương, xe máy luồn lách trên đường đông đúc... là những ấn tượng đầu tiên của du khách về Hà Nội. Với nhiều người, Hà Nội có tất cả những thứ thú vị để khám phá nơi đây theo cách riêng của mình.', 30, N'PT01', CAST(N'2022-05-18' AS Date), CAST(N'2022-05-24' AS Date), N'DKH004', N'DDL017', N'Khách sạn 5 sao', CAST(13000000.00 AS Decimal(18, 2)), N'Img\T019\hanoi1.jpg;Img\T019\hanoi2.jpg;Img\T019\hanoi3.jpg;Img\T019\hanoi4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T020', N'Huế là thành phố di sản văn hóa thế giới', N'Nằm trên dải đất miền Trung, Huế là thành phố di sản văn hóa thế giới. Cố đô vốn có lịch sử và truyền thống lâu đời với những giá trị và bản sắc độc đáo.', 40, N'PT02', CAST(N'2022-06-20' AS Date), CAST(N'2022-06-22' AS Date), N'DKH004', N'DDL016', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T020\hue1.jpg;Img\T020\hue2.jpg;Img\T020\hue3.jpg;Img\T020\hue4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T021', N'Nha Trang - điểm du lịch hút khách nhất Việt Nam', N'Nha Trang, thành phố biển nằm tại vị trí trung tâm tỉnh Khánh Hòa, từ lâu đã là một trong những điểm du lịch hút khách nhất Việt Nam. Được thiên nhiên ban tặng những bãi biển, vùng vịnh đẹp cùng nhiều đảo lớn nhỏ, thành phố còn sở hữu nhiều danh lam thắng cảnh, điểm tham quan, vui chơi và cơ sở nghỉ dưỡng.', 35, N'PT02', CAST(N'2022-07-14' AS Date), CAST(N'2022-07-18' AS Date), N'DKH003', N'DDL015', N'Khách sạn 4 sao', CAST(9000000.00 AS Decimal(18, 2)), N'Img\T021\nhatrang1.jpg;Img\T021\nhatrang2.jpg;Img\T021\nhatrang3.jpg;Img\T021\nhatrang4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T022', N'Mũi Né là một mũi biển ở thành phố Phan Thiết', N'Mũi Né là một mũi biển ở thành phố Phan Thiết, một trung tâm du lịch nổi tiếng của tỉnh Bình Thuận. Tên gọi Mũi Né xuất phát từ ngư dân đánh cá. "Mũi" là cái mũi đất đưa ra biển lớn; "Né" có nghĩa là nơi tránh giông bão. Năm 2018, Mũi Né được công nhận là khu du lịch quốc gia. Nơi đây nổi tiếng với bãi biển xanh trải dài và những đồi cát đẹp.', 30, N'PT01', CAST(N'2022-08-27' AS Date), CAST(N'2022-08-31' AS Date), N'DKH008', N'DDL019', N'Khách sạn 5 sao', CAST(8500000.00 AS Decimal(18, 2)), N'Img\T022\muine1.jpg;Img\T022\muine2.jpg;Img\T022\muine3.jpg;Img\T022\muine4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T023', N'Tour Du Lịch Khám Phá Phú Quốc', N'Không phải tự nhiên mà Phú Quốc được mệnh danh là “đảo ngọc” của Việt Nam. Nơi đây sở hữu những bãi biển quyến rũ nhất thế giới, có cả thiên nhiên đa dạng và những điểm dừng chân đậm chất văn hóa địa phương.', 40, N'PT01', CAST(N'2022-09-23' AS Date), CAST(N'2022-09-24' AS Date), N'DKH002', N'DDL002', N'Khách sạn 5 sao', CAST(6500000.00 AS Decimal(18, 2)), N'Img\T023\phuquoc1.jpg;Img\T023\phuquoc2.jpg;Img\T023\phuquoc3.jpg;Img\T023\phuquoc4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T024', N'Sa Pa Điểm Du Lịch Nổi Tiếng Tây Bắc', N'Sapa nổi tiếng với phong cảnh thiên nhiên hữu tình, là nơi đất trời hội tụ với nhiều điểm du lịch hấp dẫn. Ngắm nhìn thiên nhiên hùng vĩ, tìm hiểu văn hóa, con người Sapa sẽ mang đến cho du khách chuyến đi với nhiều trải nghiệm thú vị.', 45, N'PT01', CAST(N'2022-10-18' AS Date), CAST(N'2022-10-22' AS Date), N'DKH004', N'DDL003', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T024\sapa1.jpg;Img\T024\sapa2.jpg;Img\T024\sapa3.jpg;Img\T024\sapa4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T025', N'Đà Lạt Thiên Đường Du Lịch', N'Một xứ sở của các loài hoa thi nhau đua sắc thắm.  Ở Đà Lạt tập trung rất nhiều các loài hoa quý từ các nước khác nhập về. Tạo thêm cho Đà Lạt một vẽ đẹp huyền bí và mơ mộng tới tột cùng. Màng không có một thành phố nào tại nước Việt Nam ta sánh kịp với Đà Lạt.', 30, N'PT01', CAST(N'2022-11-28' AS Date), CAST(N'2022-11-30' AS Date), N'DKH001', N'DDL006', N'Khách sạn 5 sao', CAST(8000000.00 AS Decimal(18, 2)), N'Img\T025\dalat1.jpg;Img\T025\dalat2.jpg;Img\T025\dalat3.jpg;Img\T025\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T026', N'Phố Núi Gia Lai', N'Gia Lai còn được biết đến là vùng đất cổ xưa, di chỉ khảo cổ Biển Hồ là minh chứng cho quá trình hình thành, định cư lâu dài của người bản địa trên vùng đất cao nguyên hùng vĩ. Trải qua bao thăng trầm của lịch sử, vùng đất Gia Lai vẫn giữ cho mình nền văn hóa truyền thống đặc trưng, đa dạng thể hiện qua tôn giáo đa thần (Tô Tem), chế độ mẫu hệ của người bản địa.', 50, N'PT02', CAST(N'2022-12-18' AS Date), CAST(N'2022-12-22' AS Date), N'DKH004', N'DDL005', N'Khách sạn 5 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T026\gialai1.jpg;Img\T026\gialai.jpg;Img\T026\gialai3.jpg;Img\T026\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T027', N'Hạ Long - Kĩ Quan Thiên Nhiên Hùng Vĩ', N'Cảnh đẹp của Vịnh Hạ Long còn đến từ sự đa dạng của các hệ sinh thái. Được ví như một bức tranh thủy mặc khổng lồ, Vịnh Hạ Long là một kỳ quan sống động với hàng nghìn đảo đá nhô lên từ mặt nước trong xanh cùng hệ thống hang động phong phú và kỳ bí. Nơi đây có sắc xanh biếc sâu thẳm của biển, sắc xanh thiên thanh phớt nhẹ của bầu trời, và sắc xanh lá cây tươi mát của vô số loài thực vật hiện hữu trên núi đá vôi...', 20, N'PT03', CAST(N'2023-01-11' AS Date), CAST(N'2023-01-13' AS Date), N'DKH004', N'DDL008', N'Khách sạn 5 sao', CAST(6000000.00 AS Decimal(18, 2)), N'Img\T027\halong1.jpg;Img\T027\halong2.jpg;Img\T027\halong3.jpg;Img\T027\halong4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T028', N'Lễ hội hoa dã quỳ tại Gia Lai', N'Lễ hội hoa dã quỳ tổ chức tại núi lửa Chư Đăng Ya - Gia Lai', 20, N'PT01', CAST(N'2023-01-18' AS Date), CAST(N'2023-01-19' AS Date), N'DKH002', N'DDL005', N'Khách sạn 3 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T028\gialai1.jpg;Img\T028\gialai2.jpg;Img\T028\gialai3.jpg;Img\T028\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T029', N'Vũng Tàu  - Thành Phố Biển', N'Đến với Vũng Tàu bạn sẽ được trải nghiệm những trò chơi thú vị, bãi tắm đẹp cùng những con người thân thiện nơi đây.''', 30, N'PT02', CAST(N'2023-01-24' AS Date), CAST(N'2023-01-28' AS Date), N'DKH001', N'DDL004', N'Khách sạn 5 sao', CAST(6000000.00 AS Decimal(18, 2)), N'Img\T029\vungtau1.jpeg;Img\T029\vungtau2.jpg;Img\T029\vungtau3.jpg;Img\T029\vungtau4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T030', N'Đà Nẵng Thành Phố Đáng Sống', N'Toạ lạc ở vùng duyên hải Nam Trung Bộ, Đà Nẵng được đông đảo bạn bè quốc tế biết đến với hình ảnh đô thị năng động và rực rỡ sắc màu. Hơn cả Cầu Vàng ẩn hiện sau màn sương sớm hay tượng Cá Chép Hoá Rồng lập loè dưới ánh sáng pháo hoa, Đà Nẵng còn là trung tâm văn hoá, giáo dục, y tế, chính trị, kinh tế, xã hội... quan trọng. Không hoa lệ như Sài Thành hay chỉn chu chất Hà Nội, đi  tự túc, bạn sẽ nhận ra sự giao thoa giữa các yếu tố ''xưa'' và ''nay'' trong kiến trúc lẫn nhịp sống thường nhật của người dân bản địa.', 25, N'PT01', CAST(N'2023-02-02' AS Date), CAST(N'2023-02-04' AS Date), N'DKH002', N'DDL007', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T030\danang1.jpg;Img\T030\danang2.jpg;Img\T030\danang3.png;Img\T030\danang4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T031', N'Lâm Đồng - Thành Phố Sương Mù', N'Lâm Đồng là một tỉnh thuộc Tây Nguyên, Việt Nam. Được biết đến với rất nhiều danh lam thắng cảnh. Từ thơ mộng đến hùng vĩ, từ trên núi xuống thung lũng. Lâm Đồng, vùng đất nuôi dưỡng biết bao thế hệ người dân Việt Nam. Và cũng là nơi luôn đem lại sự yên bình xanh biếc.', 40, N'PT01', CAST(N'2023-02-16' AS Date), CAST(N'2023-02-20' AS Date), N'DKH004', N'DDL006', N'Khách sạn 5 sao', CAST(8000000.00 AS Decimal(18, 2)), N'Img\T031\dalat1.jpg;Img\T031\dalat2.jpg;Img\T031\dalat3.jpg;Img\T031\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T032', N'Thành phố biển Quy Nhơn - thiên đường du lịch hấp dẫn', N'Nếu như du khách đã quá quen thuộc với các tour du lịch Vũng Tàu, Nha Trang, Bình Thuận 
thì Quy Nhơn sẽ là điểm đến hấp dẫn cho những người yêu thích biển và sự bình yên.', 25, N'PT01', CAST(N'2023-03-10' AS Date), CAST(N'2023-03-13' AS Date), N'DKH001', N'DDL010', N'Khách sạn 4 sao', CAST(6000000.00 AS Decimal(18, 2)), N'Img\T032\quynhon1.jpg;Img\T032\quynhon2.jpg;Img\T032\quynhon3.jpg;Img\T032\quynhon4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T033', N'Hoàng thành Huế - Di sản văn hóa thế giới', N'Nằm trên dải đất miền Trung, Huế là thành phố di sản văn hóa thế giới. Cố đô vốn có lịch sử và truyền thống lâu đời với những giá trị và bản sắc độc đáo.', 40, N'PT01', CAST(N'2023-03-16' AS Date), CAST(N'2023-03-18' AS Date), N'DKH002', N'DDL016', N'Khách sạn 5 sao', CAST(8500000.00 AS Decimal(18, 2)), N'Img\T033\hue1.jpg;Img\T033\hue2.jpg;Img\T033\hue3.jpg;Img\T033\hue4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T034', N'Đà Nẵng Nơi giao thoa giữa cổ kính và hiện đại', N'Toạ lạc ở vùng duyên hải Nam Trung Bộ, Đà Nẵng được đông đảo bạn bè quốc tế biết đến với hình ảnh đô thị năng động và rực rỡ sắc màu. Hơn cả Cầu Vàng ẩn hiện sau màn sương sớm hay tượng Cá Chép Hoá Rồng lập loè dưới ánh sáng pháo hoa, Đà Nẵng còn là trung tâm văn hoá, giáo dục, y tế, chính trị, kinh tế, xã hội... quan trọng. Không hoa lệ như Sài Thành hay chỉn chu chất Hà Nội, đi  tự túc, bạn sẽ nhận ra sự giao thoa giữa các yếu tố ''xưa'' và ''nay'' trong kiến trúc lẫn nhịp sống thường nhật của người dân bản địa.', 35, N'PT01', CAST(N'2023-07-20' AS Date), CAST(N'2023-07-21' AS Date), N'DKH001', N'DDL007', N'Khách sạn 5 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T034\danang1.jpg;Img\T034\danang2.jpg;Img\T034\danang3.png;Img\T034\danang4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T035', N'Khám phá vẻ đẹp tuyệt vời của Sapa', N'Sapa nổi tiếng với phong cảnh thiên nhiên hữu tình, là nơi đất trời hội tụ với nhiều điểm du lịch hấp dẫn. Ngắm nhìn thiên nhiên hùng vĩ, tìm hiểu văn hóa, con người Sapa sẽ mang đến cho du khách chuyến đi với nhiều trải nghiệm thú vị.', 45, N'PT01', CAST(N'2023-05-26' AS Date), CAST(N'2023-05-30' AS Date), N'DKH003', N'DDL003', N'Khách sạn 5 sao', CAST(9990000.00 AS Decimal(18, 2)), N'Img\T035\sapa1.jpg;Img\T035\sapa2.jpg;Img\T035\sapa3.jpg;Img\T035\sapa4.jpg;')
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
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV035', N'HD023', N'Nguyễn Văn Phong', 1, CAST(N'2003-03-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV036', N'HD024', N'Trương Trọng Quân', 1, CAST(N'1995-02-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV037', N'HD024', N'Nguyễn Vũ Ngọc Quyên', 0, CAST(N'2000-09-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV038', N'HD025', N'Vũ Thị Phương', 0, CAST(N'1999-03-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV039', N'HD025', N'Võ Tiến Sĩ', 1, CAST(N'2008-11-20' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV040', N'HD025', N'Đặng Văn Thắng', 1, CAST(N'1991-01-11' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV041', N'HD026', N'Nguyễn Quốc Đại', 1, CAST(N'1995-05-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV042', N'HD027', N'Hoang Thi Huong', 0, CAST(N'1985-06-07' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV043', N'HD027', N'Đàm Văn Thiện', 1, CAST(N'1980-07-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV044', N'HD028', N'Nguyễn Đức Thông', 1, CAST(N'1991-06-01' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV045', N'HD028', N'Nguyễn Bỉnh Khiêm', 1, CAST(N'2010-06-11' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV046', N'HD028', N'Huỳnh Thị Kim Sinh', 0, CAST(N'1995-02-21' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV047', N'HD029', N'Phạm Thị Thanh Thuý', 0, CAST(N'2000-10-06' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV048', N'HD029', N'Phan Khánh Thuận', 1, CAST(N'1997-11-25' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV049', N'HD030', N'Lê Nguyễn Thúy An', 0, CAST(N'1995-04-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV050', N'HD030', N'Nguyễn Ngọc Hợp', 1, CAST(N'1991-07-25' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV051', N'HD030', N'Nguyễn Khắc Bảo Anh', 1, CAST(N'2005-07-15' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV052', N'HD030', N'Nguyễn Ngọc Lan Anh', 0, CAST(N'2011-03-13' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV053', N'HD031', N'Phạm Thị Như Duyên', 0, CAST(N'2002-10-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV054', N'HD031', N'Nguyễn Phương Anh', 0, CAST(N'2002-08-21' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV055', N'HD031', N'Dương Thị Hồng Ánh', 0, CAST(N'2002-01-22' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV056', N'HD032', N'Nguyễn Thái Bình', 1, CAST(N'2003-05-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV057', N'HD032', N'Đinh Hồng Châu', 1, CAST(N'2003-07-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV058', N'HD032', N'Hà Thị Thùy Chi', 0, CAST(N'2003-02-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV059', N'HD032', N'Nguyễn Linh Chi', 0, CAST(N'2003-01-13' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV060', N'HD032', N'Trần Huy Cường', 1, CAST(N'2003-06-25' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV061', N'HD033', N'Đoàn Thị Thanh Dung', 0, CAST(N'1991-04-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV062', N'HD033', N'Đỗ Quang Đạt', 1, CAST(N'1981-04-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV063', N'HD034', N'Huỳnh Minh Đức', 1, CAST(N'1994-08-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV064', N'HD034', N'Nguyễn Tiến Dũng', 1, CAST(N'1995-09-28' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV065', N'HD034', N'Võ Thanh Tòng', 1, CAST(N'1995-07-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV066', N'HD035', N'Nguyễn Trường Giang', 1, CAST(N'1996-02-12' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV067', N'HD035', N'Nguyễn Thị Hồng Hạnh', 0, CAST(N'1999-04-10' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV068', N'HD035', N'Nguyễn Ngọc Minh', 1, CAST(N'2008-07-21' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV069', N'HD036', N'Nguyễn Chí Hiếu', 1, CAST(N'1996-05-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV070', N'HD036', N'Đoàn Bá Hùng', 1, CAST(N'1996-08-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV071', N'HD036', N'Phan Ngọc Duy', 1, CAST(N'1996-03-12' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV072', N'HD036', N'Trịnh Hoàng Giang', 1, CAST(N'1995-12-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV073', N'HD036', N'Trần Thanh Hải', 1, CAST(N'1995-10-09' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV074', N'HD037', N'Nguyễn Trần Nhật Linh', 1, CAST(N'2000-05-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV075', N'HD037', N'Nguyễn Thị Kim Nhi', 0, CAST(N'2002-07-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV076', N'HD038', N'Trương Nhựt Phương', 0, CAST(N'1996-06-01' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV077', N'HD038', N'Nguyễn Sơn Thủy', 1, CAST(N'1984-06-07' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV078', N'HD038', N'Nguyễn Anh Thư', 0, CAST(N'2010-02-07' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV079', N'HD039', N'Phạm Minh Quân', 1, CAST(N'1998-08-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV080', N'HD039', N'Nguyễn Minh Phương', 0, CAST(N'2000-10-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV081', N'HD040', N'Tăng Yến Anh', 0, CAST(N'1985-05-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV082', N'HD040', N'Lê Thùy Linh', 0, CAST(N'2008-02-01' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV083', N'HD040', N'Dương Hoàng Long', 1, CAST(N'1977-01-30' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV084', N'HD041', N'Đặng Quốc Quân', 1, CAST(N'2001-07-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV085', N'HD041', N'Nguyễn Phương Thanh', 0, CAST(N'2001-09-28' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV086', N'HD042', N'Mai Kim Tiên', 0, CAST(N'2002-06-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV087', N'HD042', N'Nguyễn Thanh Tuấn', 1, CAST(N'1999-11-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV088', N'HD042', N'Nguyễn Thị Thu Tuyền', 0, CAST(N'2015-12-28' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV089', N'HD043', N'Nguyễn Công Vũ', 1, CAST(N'1987-04-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV090', N'HD043', N'Phan Trần Như Ngọc', 0, CAST(N'1992-05-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV091', N'HD044', N'Nguyễn Thị Liên', 0, CAST(N'1998-08-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV092', N'HD044', N'Âu Thị Lan', 0, CAST(N'1998-10-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV093', N'HD044', N'Võ Thị Ánh Nhi', 0, CAST(N'1998-04-05' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV094', N'HD044', N'Hồ Nguyễn Huỳnh Phương', 0, CAST(N'1998-09-01' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV095', N'HD045', N'Đoàn Thị Thanh Dung', 0, CAST(N'1995-05-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV096', N'HD045', N'Phó Thiên Phước', 1, CAST(N'1989-03-12' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV097', N'HD045', N'Ngô Thị Quỳnh Phương', 0, CAST(N'2004-03-10' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV098', N'HD046', N'Đặng Ngọc Quyên', 0, CAST(N'2002-07-31' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV099', N'HD046', N'Nguyễn Vương Quyền', 1, CAST(N'1999-09-05' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV100', N'HD047', N'Trần Vũ Tấn Tài', 1, CAST(N'1995-03-22' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV101', N'HD047', N'Ngô Thị Hồng Sen', 0, CAST(N'1999-07-05' AS Date), 1)
GO
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV102', N'HD047', N'Trần Ngọc Tân', 1, CAST(N'2017-07-17' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV103', N'HD048', N'Phạm Minh Quy', 1, CAST(N'1993-05-10' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV104', N'HD048', N'Thái Thanh Tâm', 0, CAST(N'1998-02-01' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV105', N'HD048', N'Phạm Thanh Sang', 1, CAST(N'2014-03-18' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV106', N'HD048', N'Phạm Thị Thanh Thảo', 0, CAST(N'2017-06-10' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV107', N'HD049', N'Đoàn Thị Thanh Thảo', 0, CAST(N'2000-11-29' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV108', N'HD050', N'Lê Nguyễn Thịnh', 1, CAST(N'1985-04-21' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV109', N'HD050', N'Hoàng Xuân Thiên', 1, CAST(N'1985-08-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV110', N'HD051', N'Trần Nguyễn Bảo Trung', 1, CAST(N'1999-01-06' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV111', N'HD051', N'Trần Nguyễn Anh Tú', 1, CAST(N'2019-04-14' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV112', N'HD052', N'Phạm Bao Hoàng Dũng', 1, CAST(N'1983-02-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV113', N'HD052', N'Phạm Quốc Cường', 1, CAST(N'2002-05-04' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV114', N'HD052', N'Phạm Ánh Dương', 0, CAST(N'1984-07-07' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV115', N'HD053', N'Khương Minh Đại', 1, CAST(N'1976-06-11' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV116', N'HD054', N'Lê Trung Tính', 1, CAST(N'2000-07-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV117', N'HD054', N'Võ Hoàng Thái', 1, CAST(N'2000-09-03' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV118', N'HD054', N'Nguyễn Hữu Hà', 1, CAST(N'2000-03-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV119', N'HD054', N'Hoàng Hải Bằng', 1, CAST(N'1999-12-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV120', N'HD055', N'Đỗ Thị Ngọc Hà', 0, CAST(N'2002-05-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV121', N'HD055', N'Phan Thị Thu Hương', 0, CAST(N'2002-10-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV122', N'HD055', N'Vũ Thị Bích Thủy', 0, CAST(N'2003-01-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV123', N'HD056', N'Đinh Thị Thùy', 0, CAST(N'1976-07-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV124', N'HD056', N'Phạm Văn Chính', 1, CAST(N'1968-10-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV125', N'HD056', N'Phạm Đức Duy', 1, CAST(N'1996-09-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV126', N'HD057', N'Nguyễn Đăng Khoa', 1, CAST(N'2003-06-28' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV127', N'HD057', N'Cao Văn Sơn', 1, CAST(N'2003-04-27' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV128', N'HD057', N'Đỗ Ngọc Tuyên', 0, CAST(N'2003-08-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV129', N'HD057', N'Vũ Đình Dũng', 1, CAST(N'2003-05-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV130', N'HD057', N'Dương Hồng Hà', 0, CAST(N'2003-09-03' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV131', N'HD057', N'Dương Thị Thu Hiển', 0, CAST(N'2003-06-13' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV132', N'HD058', N'Lê Quang Nguyên', 1, CAST(N'1999-04-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV133', N'HD058', N'Phan Thị Ngọc Thy', 0, CAST(N'2001-06-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV134', N'HD059', N'Bùi Thế Hiển', 1, CAST(N'1990-04-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV135', N'HD059', N'Nguyễn Thị Ngọc Ân', 0, CAST(N'1993-02-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV136', N'HD059', N'Nguyễn Thanh Ngoan', 0, CAST(N'2017-10-06' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV137', N'HD059', N'Nguyễn Văn Nam', 1, CAST(N'2016-05-31' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV138', N'HD060', N'Nguyễn Thanh Phong', 1, CAST(N'1981-01-11' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV139', N'HD060', N'Nguyễn Thị Hồng Phước', 0, CAST(N'1984-04-21' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV140', N'HD060', N'Nguyễn Hoàng Thảo', 0, CAST(N'2005-05-02' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV141', N'HD061', N'Lê Huỳnh Thương', 0, CAST(N'1994-06-13' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV142', N'HD061', N'Lê Hải Yến', 0, CAST(N'1994-09-04' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV143', N'HD061', N'Đặng Xuân Vũ', 0, CAST(N'1994-01-09' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV144', N'HD061', N'Lê Thị Mỹ Lộc', 0, CAST(N'1994-07-29' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV145', N'HD062', N'Trần Hữu Đức', 1, CAST(N'1990-05-06' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV146', N'HD063', N'Hồ Văn Nhã', 1, CAST(N'2001-06-25' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV147', N'HD063', N'Bùi Trung Tín', 1, CAST(N'2000-08-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV148', N'HD064', N'Nguyễn Thiện Khiêm', 1, CAST(N'1996-06-09' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV149', N'HD064', N'Nguyễn Quốc Kiện', 1, CAST(N'2013-08-10' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV150', N'HD065', N'Võ Thị Thuý Kiều', 0, CAST(N'2003-07-27' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV151', N'HD065', N'Hoàng Xuân Lâm', 1, CAST(N'2003-05-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV152', N'HD065', N'Bùi Thanh Liêm', 1, CAST(N'2002-10-29' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV153', N'HD065', N'Lưu Nguyễn Hoàng Lê', 1, CAST(N'2003-01-05' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV154', N'HD066', N'Nguyễn Tài Lộc', 1, CAST(N'1995-06-25' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV155', N'HD066', N'Lương Tiểu Long', 1, CAST(N'1995-10-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV156', N'HD066', N'Ngô Hoàng Nam', 1, CAST(N'1996-01-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV157', N'HD067', N'Nguyễn Ngọc Nam', 1, CAST(N'2004-04-11' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV158', N'HD067', N'Nguyễn Văn Thể Mỹ', 1, CAST(N'2004-07-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV159', N'HD067', N'Đỗ Thị Thanh Ngân', 0, CAST(N'2004-03-14' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV160', N'HD068', N'Cao Đoan Hồng Ngọc', 0, CAST(N'1999-05-23' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV161', N'HD068', N'Nguyễn Minh Nghĩa', 1, CAST(N'1992-03-09' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV162', N'HD069', N'Thượng Đảo Hoàng', 1, CAST(N'1997-04-20' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV163', N'HD069', N'Nguyễn Thị Lành', 0, CAST(N'1998-08-03' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV164', N'HD070', N'Cao Mạnh Lanh', 1, CAST(N'1991-08-05' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV165', N'HD070', N'Nguyễn Khánh Liền', 1, CAST(N'1997-09-16' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV166', N'HD070', N'Mạc Minh Lợi', 1, CAST(N'1990-07-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV167', N'HD071', N'Nguyễn Tân Quí Long', 1, CAST(N'1994-05-10' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV168', N'HD071', N'Phạm Thùy Nhi', 0, CAST(N'1996-09-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV169', N'HD072', N'Trần Hoài Phương', 0, CAST(N'1996-08-19' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV170', N'HD072', N'Lê Hoài Tâm', 0, CAST(N'1997-09-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV171', N'HD072', N'Trương Mai Thảo', 0, CAST(N'1996-12-07' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV172', N'HD073', N'Nguyễn Thị Lan Phương', 0, CAST(N'2003-06-08' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV173', N'HD073', N'Trương Thị Thảo Uyên', 0, CAST(N'2003-08-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV174', N'HD073', N'Cao Thị Tuyết Trinh', 0, CAST(N'2003-02-17' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV175', N'HD074', N'Nguyễn Thành Nhân', 1, CAST(N'1992-06-13' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV176', N'HD074', N'Ngô Thị Tuyết Nhung', 0, CAST(N'1996-09-18' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV177', N'HD075', N'Đậu Thị Kim Oanh', 0, CAST(N'1992-03-05' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV178', N'HD075', N'Tưởng Ngọc Quốc Bình', 1, CAST(N'1982-06-12' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV179', N'HD075', N'Tưởng Ngọc Quốc Thắng', 1, CAST(N'2005-05-02' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV180', N'HD076', N'Huỳnh Nguyễn Quốc Bửu', 1, CAST(N'1993-08-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV181', N'HD076', N'Phạm Đỗ Kim Chi', 0, CAST(N'1997-10-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV182', N'HD077', N'Lê Thị Kim Chung', 0, CAST(N'1994-08-22' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV183', N'HD077', N'Lý Trung Cương', 1, CAST(N'1992-05-24' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV184', N'HD078', N'Thái Nguyễn Minh Giang', 0, CAST(N'2002-04-15' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV185', N'HD078', N'Nguyễn Vũ Phong Hải', 1, CAST(N'2017-03-13' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV186', N'HD079', N'Nguyễn Thị Ngọc', 0, CAST(N'2001-08-26' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV187', N'HD080', N'Trần Thị Hạnh', 0, CAST(N'1992-08-30' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV188', N'HD080', N'Dương Kỳ Trí', 1, CAST(N'1987-10-03' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV189', N'HD080', N'Dương Ngọc Phúc', 1, CAST(N'2007-07-08' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV190', N'HD080', N'Dương Thị ái Nhi', 0, CAST(N'2012-11-11' AS Date), 0)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV191', N'HD081', N'Mai Thị Kiều Oanh', 0, CAST(N'1998-06-22' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV192', N'HD082', N'Nguyễn Thuận Phát', 1, CAST(N'1994-06-27' AS Date), 1)
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV193', N'HD083', N'Nguyễn Trường Giang', 1, CAST(N'1996-06-25' AS Date), 1)
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
