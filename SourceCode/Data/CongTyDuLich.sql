USE [master]
GO
/****** Object:  Database [CongTyDuLich]    Script Date: 4/21/2023 12:10:51 AM ******/
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
/****** Object:  Table [dbo].[DiaDiem]    Script Date: 4/21/2023 12:10:51 AM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/21/2023 12:10:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[SoHoaDon] [nvarchar](20) NOT NULL,
	[MaKH] [nvarchar](20) NOT NULL,
	[MaTour] [nvarchar](20) NOT NULL,
	[NgayLapHD] [datetime] NULL,
	[MaNV] [nvarchar](20) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[SoHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/21/2023 12:10:51 AM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/21/2023 12:10:51 AM ******/
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
/****** Object:  Table [dbo].[TourDuLich]    Script Date: 4/21/2023 12:10:51 AM ******/
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
/****** Object:  Table [dbo].[ThanhVien]    Script Date: 4/21/2023 12:10:51 AM ******/
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
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL001', N'Hội An')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL002', N'Phú Quốc')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL003', N'Sa Pa')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL004', N'Vũng Tàu')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL005', N'Gia Lai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL006', N'Đà Lạt')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL007', N'Đà Nẵng')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DDL008', N'Hạ Long')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH001', N'TP Hồ Chí Minh')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH002', N'Hà Nội')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH003', N'Gia Lai')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH004', N'Đà Nẵng')
INSERT [dbo].[DiaDiem] ([MaDiaDiem], [TenDiaDiem]) VALUES (N'DKH005', N'Cần Thơ')
GO
INSERT [dbo].[HoaDon] ([SoHoaDon], [MaKH], [MaTour], [NgayLapHD], [MaNV]) VALUES (N'HD001', N'KH001', N'T001', CAST(N'2023-04-14T00:00:00.000' AS DateTime), N'NV001')
GO
INSERT [dbo].[KhachHang] ([MaKH], [SDT], [TenKH], [Email], [DiaChi]) VALUES (N'KH001', N'0987654321', N'Nguyen Thi A', N'abc@gmail.com', N'Gia Lai')
GO
INSERT [dbo].[NhanVien] ([MaNV], [SDT], [MatKhau], [TenNV], [NgaySinh], [GioiTinh], [CCCD], [NgayVaoLam]) VALUES (N'NV001', N'0123456789', N'12345', N'Phạm Hữu Thuận', CAST(N'2003-01-01' AS Date), 1, N'123456789', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T001', N'Tour Du Lịch Khám Phá Phú Quốc', N'Không phải tự nhiên mà Phú Quốc được mệnh danh là “đảo ngọc” của Việt Nam. Nơi đây sở hữu những bãi biển quyến rũ nhất thế giới, có cả thiên nhiên đa dạng và những điểm dừng chân đậm chất văn hóa địa phương.', 25, N'Máy bay', CAST(N'2023-04-30' AS Date), CAST(N'2023-05-02' AS Date), N'DKH001', N'DDL002', N'Khách sạn 4 sao', CAST(3500000.00 AS Decimal(18, 2)), N'Img\T001\phuquoc1.jpg;Img\T001\phuquoc2.jpg;Img\T001\phuquoc3.jpg;Img\T001\phuquoc4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T002', N'Sa Pa Điểm Du Lịch Nổi Tiếng Tây Bắc', N'Sapa nổi tiếng với phong cảnh thiên nhiên hữu tình, là nơi đất trời hội tụ với nhiều điểm du lịch hấp dẫn. Ngắm nhìn thiên nhiên hùng vĩ, tìm hiểu văn hóa, con người Sapa sẽ mang đến cho du khách chuyến đi với nhiều trải nghiệm thú vị.', 30, N'Máy bay', CAST(N'2023-05-14' AS Date), CAST(N'2023-05-20' AS Date), N'DKH002', N'DDL003', N'Khách sạn 5 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T002\sapa1.jpg;Img\T002\sapa2.jpg;Img\T002\sapa3.jpg;Img\T002\sapa4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T003', N'Đà Lạt Thiên Đường Du Lịch', N'Một xứ sở của các loài hoa thi nhau đua sắc thắm.  Ở Đà Lạt tập trung rất nhiều các loài hoa quý từ các nước khác nhập về. Tạo thêm cho Đà Lạt một vẽ đẹp huyền bí và mơ mộng tới tột cùng. Màng không có một thành phố nào tại nước Việt Nam ta sánh kịp với Đà Lạt.', 40, N'Xe khách', CAST(N'2023-06-01' AS Date), CAST(N'2023-06-03' AS Date), N'DKH003', N'DDL006', N'Khách sạn 3 sao', CAST(3000000.00 AS Decimal(18, 2)), N'Img\T003\dalat1.jpg;Img\T003\dalat2.jpg;Img\T003\dalat3.jpg;Img\T003\dalat4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T006', N'Phố Núi Gia Lai', N'Gia Lai còn được biết đến là vùng đất cổ xưa, di chỉ khảo cổ Biển Hồ là minh chứng cho quá trình hình thành, định cư lâu dài của người bản địa trên vùng đất cao nguyên hùng vĩ. Trải qua bao thăng trầm của lịch sử, vùng đất Gia Lai vẫn giữ cho mình nền văn hóa truyền thống đặc trưng, đa dạng thể hiện qua tôn giáo đa thần (Tô Tem), chế độ mẫu hệ của người bản địa.', 30, N'Máy bay', CAST(N'2023-07-06' AS Date), CAST(N'2023-07-10' AS Date), N'DKH002', N'DDL005', N'Khách sạn 4 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T006\gialai1.jpg;Img\T006\gialai.jpg;Img\T006\gialai3.jpg;Img\T006\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T007', N'Hạ Long - Kĩ Quan Thiên Nhiên Hùng Vĩ', N'Cảnh đẹp của Vịnh Hạ Long còn đến từ sự đa dạng của các hệ sinh thái. Được ví như một bức tranh thủy mặc khổng lồ, Vịnh Hạ Long là một kỳ quan sống động với hàng nghìn đảo đá nhô lên từ mặt nước trong xanh cùng hệ thống hang động phong phú và kỳ bí. Nơi đây có sắc xanh biếc sâu thẳm của biển, sắc xanh thiên thanh phớt nhẹ của bầu trời, và sắc xanh lá cây tươi mát của vô số loài thực vật hiện hữu trên núi đá vôi.', 20, N'Tàu', CAST(N'2023-05-22' AS Date), CAST(N'2023-05-26' AS Date), N'DKH004', N'DDL008', N'Khách sạn 5 sao', CAST(7000000.00 AS Decimal(18, 2)), N'Img\T007\halong1.jpg;Img\T007\halong2.jpg;Img\T007\halong3.jpg;Img\T007\halong4.jpg')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T008', N'Lễ hội hoa dã quỳ tại Gia Lai', N'Lễ hội hoa dã quỳ tổ chức tại núi lửa Chư Đăng Ya - Gia Lai', 20, N'Máy bay', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL005', N'Khách sạn 3 sao', CAST(5000000.00 AS Decimal(18, 2)), N'Img\T008\gialai1.jpg;Img\T008\gialai2.jpg;Img\T008\gialai3.jpg;Img\T008\gialai4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T009', N'Vũng Tàu  - Thành Phố Biển''', N'Đến với Vũng Tàu bạn sẽ được trải nghiệm những trò chơi thú vị, bãi tắm đẹp cùng những con người thân thiện nơi đây.''', 30, N'Xe khách', CAST(N'2023-04-20' AS Date), CAST(N'2023-04-25' AS Date), N'DKH001', N'DDL004', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T009\vungtau1.jpeg;Img\T009\vungtau2.jpg;Img\T009\vungtau3.jpg;Img\T009\vungtau4.jpg;')
INSERT [dbo].[TourDuLich] ([MaTour], [TenTour], [MoTa], [SoCho], [PhuongTien], [NgayDi], [NgayKetThuc], [DiemKH], [DiemKT], [KhachSan], [Gia], [Anh]) VALUES (N'T010', N'Đà Nẵng Thành Phố Đáng Sống', N'Đà Nẵng là một thành phố biển thuộc miền Trung', 25, N'Xe khách', CAST(N'2023-05-18' AS Date), CAST(N'2023-05-20' AS Date), N'DKH003', N'DDL007', N'Khách sạn 5 sao', CAST(4000000.00 AS Decimal(18, 2)), N'Img\T010\danang1.jpg;Img\T010\danang2.jpg;Img\T010\danang3.png;Img\T010\danang4.jpg;')
GO
INSERT [dbo].[ThanhVien] ([MaTV], [MaHD], [TenTV], [GioiTinh], [NgaySinh], [LuaTuoi]) VALUES (N'TV001', N'HD001', N'Nguyễn Văn A', 1, CAST(N'2000-01-01' AS Date), 1)
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaTour])
REFERENCES [dbo].[TourDuLich] ([MaTour])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD FOREIGN KEY([DiemKH])
REFERENCES [dbo].[DiaDiem] ([MaDiaDiem])
GO
ALTER TABLE [dbo].[TourDuLich]  WITH CHECK ADD FOREIGN KEY([DiemKT])
REFERENCES [dbo].[DiaDiem] ([MaDiaDiem])
GO
ALTER TABLE [dbo].[ThanhVien]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([SoHoaDon])
GO
USE [master]
GO
ALTER DATABASE [CongTyDuLich] SET  READ_WRITE 
GO
