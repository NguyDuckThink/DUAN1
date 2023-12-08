USE master
GO
CREATE DATABASE [DuAn1]
GO
USE [DuAn1]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChitietSP]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChitietSP](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nvarchar](10) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[IdNsx] [int] NULL,
	[IdMauSac] [int] NULL,
	[IdDMuc] [int] NULL,
	[IdKC] [int] NULL,
	[IdCL] [int] NULL,
	[IdTH] [int] NULL,
	[IdKM] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[SoLuongTon] [int] NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
	[QrCode] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSP]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSP](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdKH] [int] NULL,
	[IdNV] [int] NULL,
	[Ma] [varchar](20) NULL,
	[NgayTao] [datetime] NULL,
	[NgayThanhToan] [date] NULL,
	[TinhTrang] [bit] NULL,
	[Ghichu] [varchar](255) NULL,
	[TongTien] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IdHD] [int] NOT NULL,
	[IdCTSP] [int] NOT NULL,
	[Soluong] [int] NOT NULL,
	[Dongia] [decimal](18, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHD] ASC,
	[IdCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[Gioitinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[Email] [varchar](max) NOT NULL,
	[Sdt] [varchar](30) NULL,
	[Diemthuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Ngaybatdau] [date] NOT NULL,
	[Ngayketthuc] [date] NOT NULL,
	[HinhthucKM] [nvarchar](50) NOT NULL,
	[Giatrigiam] [decimal](18, 0) NULL,
	[Trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichCo]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichCo](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/10/2023 10:02:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[NgaySinh] [date] NULL,
	[Gioitinh] [bit] NULL,
	[Sdt] [varchar](30) NULL,
	[IdCV] [int] NULL,
	[TaiKhoan] [varchar](max) NULL,
	[MatKhau] [varchar](max) NULL,
	[Email] [varchar](max) NOT NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 

INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (1, N'Da Bò')
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (2, N'Da cao cấp')
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (3, N'Da nhựa dẻo')
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (4, N'Da ép')
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[ChitietSP] ON 

INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [QrCode]) VALUES (1, N'SP01', N'Nike Air Zoom Pegasus', 1, 1, 1, 1, 1, 1, 1, N'giày hot 2022', 17, CAST(199000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), N'678526354211')
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [QrCode]) VALUES (2, N'SP02', N'Giày thể thao nhẹ', 4, 2, 1, 9, 4, 3, 1, N'không có', 37, CAST(350000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), N'799488870335')
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan], [QrCode]) VALUES (3, N'SP03', N'Giày gym hot ', 9, 8, 2, 12, 3, 7, 1, N'không có', 85, CAST(450000 AS Decimal(20, 0)), CAST(600000 AS Decimal(20, 0)), N'550098290613')
SET IDENTITY_INSERT [dbo].[ChitietSP] OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([Id], [Ten]) VALUES (1, N'quản lý')
INSERT [dbo].[ChucVu] ([Id], [Ten]) VALUES (2, N'nhân viên')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[DanhMucSP] ON 

INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (1, N'Giày chạy bộ ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (2, N'Giày tập gym ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (4, N'Giày đá banh ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (5, N'Giày đi bộ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (6, N'Giày leo núi ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (8, N'Giày thể thao đa năng ')
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (9, N'Giày golf ')
SET IDENTITY_INSERT [dbo].[DanhMucSP] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (4, 4, 1, N'HD-379816004', CAST(N'2023-04-10T21:49:08.637' AS DateTime), CAST(N'2023-04-10' AS Date), 1, N'', CAST(2280000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (5, 2, 1, N'HD750615929', CAST(N'2023-04-10T21:58:39.967' AS DateTime), CAST(N'2023-04-10' AS Date), 1, N'', CAST(1740000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (6, 1, 1, N'HD-240915134', CAST(N'2023-04-10T21:58:43.613' AS DateTime), CAST(N'2023-04-10' AS Date), 1, N'', CAST(860000 AS Decimal(18, 0)))
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (4, 1, 2, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (4, 2, 3, CAST(400000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (4, 3, 1, CAST(600000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (5, 3, 3, CAST(600000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (6, 1, 1, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (6, 3, 1, CAST(600000 AS Decimal(18, 0)))
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (1, N'Thể', N'Văn', N'Nguyễn', 0, CAST(N'2001-09-08' AS Date), N'hevnhhahaa@gmail.com', N'09786664432', 0)
INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (2, N'Đức', N'Văn', N'Nguyễn', 0, CAST(N'2000-09-08' AS Date), N'thenvhahaha09022@gmail.com', N'0967233115', 0)
INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (4, N'Huy', N'Văn', N'Nguyễn', 0, CAST(N'2005-09-08' AS Date), N'hungndph889977@gmail.com', N'0967233115', 0)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 

INSERT [dbo].[KhuyenMai] ([Id], [Ten], [Ngaybatdau], [Ngayketthuc], [HinhthucKM], [Giatrigiam], [Trangthai]) VALUES (1, N'Black Friday', CAST(N'2023-04-10' AS Date), CAST(N'2023-04-11' AS Date), N'VND', CAST(20000 AS Decimal(18, 0)), 0)
INSERT [dbo].[KhuyenMai] ([Id], [Ten], [Ngaybatdau], [Ngayketthuc], [HinhthucKM], [Giatrigiam], [Trangthai]) VALUES (2, N'Valentine Lễ Tình Nhân', CAST(N'2023-02-14' AS Date), CAST(N'2023-02-15' AS Date), N'%', CAST(0 AS Decimal(18, 0)), 1)
INSERT [dbo].[KhuyenMai] ([Id], [Ten], [Ngaybatdau], [Ngayketthuc], [HinhthucKM], [Giatrigiam], [Trangthai]) VALUES (3, N'Giỗ Tổ Hùng Vương', CAST(N'2023-03-10' AS Date), CAST(N'2023-03-11' AS Date), N'VND', CAST(0 AS Decimal(18, 0)), 1)
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[KichCo] ON 

INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (1, N'34-35')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (2, N'35')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (3, N'35-36')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (4, N'36')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (5, N'36-37')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (6, N'37')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (7, N'37-38')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (8, N'38')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (9, N'38-39')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (10, N'39')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (11, N'39-40')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (12, N'40')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (13, N'40-41')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (14, N'41')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (15, N'41-42')
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (16, N'42-43')
SET IDENTITY_INSERT [dbo].[KichCo] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (1, N'Ánh kim')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (2, N'Đen nhám')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (3, N'Xanh')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (4, N'Vàng nhạt')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (5, N'Ánh kim')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (6, N'Dằn di')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (7, N'Đỏ nhạt')
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (8, N'Tím mộng mơ')
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NSX] ON 

INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (1, N'Nike')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (2, N'Inc')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (4, N'Puma SE')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (5, N'New Balance Athletics')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (9, N'Vans')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (10, N'Converse ')
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (18, N'Merrell')
SET IDENTITY_INSERT [dbo].[NSX] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (1, N'Nike')
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (2, N'Adidas')
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (3, N'Puma')
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (6, N'ASICS')
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (7, N'Vans')
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (8, N'Converse')
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (1, N'Nam', N'Đức', N'Nguyễn', CAST(N'2003-06-08' AS Date), 0, N'0967493115', 1, N'1', N'1', N'namndph22694@fpt.edu.vn', 1)
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (2, N'Hùng', N'Đức', N'Nguyễn', CAST(N'2003-06-07' AS Date), 0, N'0967493115', 2, N'2', N'2', N'hungndph889977@fpt.edu.vn', 1)
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (3, N'Huy', N'Duy', N'Nguyễn', CAST(N'2002-06-04' AS Date), 0, N'0967493135', 2, N'3', N'3', N'huydnph27822782@fpt.edu.vn', 1)
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (4, N'Thể', N'Văn', N'Nguyễn', CAST(N'2009-06-02' AS Date), 0, N'0967233115', 2, N'4', N'4', N'thenvhahaha09022@fpt.edu.vn', 0)
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (5, N'Hiếu', N'Văn', N'Nguyễn', CAST(N'2003-01-08' AS Date), 0, N'0945983115', 2, N'5', N'5', N'hieuhahahha09223@fpt.edu.vn', 0)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__3214CC9E34FD9661]    Script Date: 4/10/2023 10:02:06 PM ******/
ALTER TABLE [dbo].[HoaDon] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT (NULL) FOR [MoTa]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT ((0)) FOR [GiaNhap]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT (NULL) FOR [QrCode]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TinhTrang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Diemthuong]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [Giatrigiam]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [Trangthai]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [TaiKhoan]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdCL])
REFERENCES [dbo].[ChatLieu] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdDMuc])
REFERENCES [dbo].[DanhMucSP] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdKC])
REFERENCES [dbo].[KichCo] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdKM])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdNsx])
REFERENCES [dbo].[NSX] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdTH])
REFERENCES [dbo].[ThuongHieu] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdNV])
REFERENCES [dbo].[Users] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChitietSP] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdHD])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([IdCV])
REFERENCES [dbo].[ChucVu] ([Id])
GO
