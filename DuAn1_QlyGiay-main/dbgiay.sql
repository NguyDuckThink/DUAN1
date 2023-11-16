CREATE DATABASE DBDUAN1
GO
IF OBJECT_ID('LoaiSP') IS NOT NULL
DROP TABLE LoaiSP
GO
CREATE TABLE LoaiSP(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('ChatLieu') IS NOT NULL
DROP TABLE ChatLieu
GO
CREATE TABLE ChatLieu(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('ThuongHieu') IS NOT NULL
DROP TABLE ThuongHieu
GO
CREATE TABLE ThuongHieu(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('MauSac') IS NOT NULL
DROP TABLE MauSac
GO
CREATE TABLE MauSac(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('Size') IS NOT NULL
DROP TABLE Size
GO
CREATE TABLE Size(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('SanPham') IS NOT NULL
DROP TABLE SanPham
GO
CREATE TABLE SanPham(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(100),
)
IF OBJECT_ID('SanPhamCT') IS NOT NULL
DROP TABLE SanPhamCT
GO
CREATE TABLE SanPhamCT(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
SanPham_Id INT,
MauSac_Id INT,
ThuongHieu_Id INT,
Size_Id INT,
LoaiSP_Id INT,
ChatLieu_Id INT,
KhuyenMai_Id Int,
SoLuong INT,
GiaBan FLOAT,
GiaNhap FLOAT,
TrongLuong NVARCHAR(50),
TrangThai bit default 0,
MoTa NVARCHAR(250),
)
IF OBJECT_ID('KhuyenMai') IS NOT NULL
DROP TABLE KhuyenMai
GO
CREATE TABLE KhuyenMai(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(50),
NgayBatDau DATE,
NgayKetThuc DATE,
GiamGia INT,
TrangThai INT,
)
IF OBJECT_ID('KhachHang') IS NOT NULL
DROP TABLE KhachHang
GO
CREATE TABLE KhachHang(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(50) ,
SDT VARCHAR(15) NULL,
DiaChi NVARCHAR(100) NULL,
)
IF OBJECT_ID('NhanVien') IS NOT NULL
DROP TABLE NhanVien
GO
CREATE TABLE NhanVien(
Id INT IDENTITY(1001,1) PRIMARY KEY ,
Ten NVARCHAR(50),
GioiTinh BIT,
NgaySinh DATE,
SDT VARCHAR(15),
DiaChi NVARCHAR(100),
Email VARCHAR(50),
MatKhau VARCHAR(40),
VaiTro INT,
TrangThai bit,
)
IF OBJECT_ID('HoaDon') IS NOT NULL
DROP TABLE HoaDon
GO
CREATE TABLE HoaDon(
Id INT IDENTITY(100991,1) PRIMARY KEY ,
NhanVien_Id INT,
KhachHang_Id INT,
NgayTao DATE,
TrangThai INT,
TongTien FLOAT,
GhiChu NVARCHAR(100),
)
IF OBJECT_ID('HoaDonCT') IS NOT NULL
DROP TABLE HoaDonCT
GO
CREATE TABLE HoaDonCT(
Id INT IDENTITY(100991,1) PRIMARY KEY ,
HoaDon_Id INT,
SanPhamCT_Id INT,
KhuyenMai_Id INT,
SoLuong INT,
Gia FlOAT,
ThanhTien FLOAT,
)
--TẠO QUAN HỆ GIỮA CÁC BẢNG
-- ChiTietSP - SanPham
ALTER TABLE SanPhamCT ADD FOREIGN KEY(SanPham_Id) REFERENCES SanPham(Id)
-- ChiTietSP - MauSac
ALTER TABLE SanPhamCT ADD FOREIGN KEY(MauSac_Id) REFERENCES MauSac(Id)
-- ChiTietSP - LoaiSP
ALTER TABLE SanPhamCT ADD FOREIGN KEY(LoaiSP_Id) REFERENCES LoaiSP(Id)
-- ChiTietSP - Size
ALTER TABLE SanPhamCT ADD FOREIGN KEY(Size_Id) REFERENCES Size(Id)
-- ChiTietSP - ThuongHieu
ALTER TABLE SanPhamCT ADD FOREIGN KEY(ThuongHieu_Id) REFERENCES ThuongHieu(Id)
-- ChiTietSP - ChatLieu
ALTER TABLE SanPhamCT ADD FOREIGN KEY(ChatLieu_Id) REFERENCES ChatLieu(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY(NhanVien_Id) REFERENCES NhanVien(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY(KhachHang_Id) REFERENCES KhachHang(Id)
-- HoaDonCT - HoaDon
ALTER TABLE HoaDonCT ADD FOREIGN KEY(HoaDon_Id) REFERENCES HoaDon(Id)
-- HoaDonCT - SanPhamCT
ALTER TABLE HoaDonCT ADD FOREIGN KEY(SanPhamCT_Id) REFERENCES SanPhamCT(Id)
-- KhuyenMai - SanPhamCT
ALTER TABLE KhuyenMai ADD FOREIGN KEY(SanPhamCT_Id) REFERENCES SanPhamCT(Id)
-- ChiTietSP - KhuyenMai
ALTER TABLE SanPhamCT ADD FOREIGN KEY(KhuyenMai_Id) REFERENCES KhuyenMai(Id)
/*ALTER TABLE KhuyenMai ADD FOREIGN KEY(SanPham_Id) REFERENCES SanPham(Id)*/

SELECT * FROM MauSac
SELECT * FROM LoaiSP
SELECT * FROM ChatLieu
SELECT * FROM ThuongHieu
SELECT * FROM SanPham
SELECT * FROM Size
SELECT * FROM SanPhamCT
select * from HoaDonCT
select * from hoadon
select * from KhuyenMai
delete from KhuyenMai where id='1001'
Insert into HoaDonCT(hoadon_id,SanPhamCT_id,KhuyenMai_id,Soluong,gia,thanhtien)
values('100993','1001','1001',20,2000,10000);
Insert into HoaDonCT(hoadon_id,SanPhamCT_id,KhuyenMai_id,Soluong,gia,thanhtien)
values('100992','1001','1002',288,5000,167886);
Insert into KhuyenMai (SanPhamCT_Id,Ten,NgayBatDau,NgayKetThuc,GiamGia,TrangThai)
values('1001','Giam Gia Giay The Thao','2023-09-11','2024-09-24',40,1)
Insert into KhuyenMai (SanPham_Id,Ten,NgayBatDau,NgayKetThuc,GiamGia,TrangThai)
values('1002','Giam Gia Giay Chay Bo','2023-09-11','2024-09-24',88847474,1)
SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,GiaBan,SoLuong FROM SanPhamCT Join SanPham on SanPhamCT.SanPham_Id = SanPham.Id
			JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id
            JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id
            JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id
            JOIN Size ON SanPhamCT.Size_id = Size.id Where SanPhamCT.TrangThai LIKE '0';

INSERT INTO SanPhamCT(SanPham_id,MauSac_Id,Size_Id,ThuongHieu_Id,ChatLieu_Id,LoaiSP_Id,GiaBan,SoLuong)VALUES (
'1001','1001','1001','1001','1001','1001',2000,10);

UPDATE SanPhamCT SET SanPham_Id='1002',MauSac_Id ='1002',Size_Id='1002',ThuongHieu_Id='1002',ChatLieu_Id='1002',LoaiSP_Id='1002',GiaBan=400000,SoLuong=14 WHERE id = '1001'
SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,GiaBan,SoLuong FROM SanPhamCT Join SanPham on SanPhamCT.SanPham_Id = SanPham.Id
			JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id
            JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id
            JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id
            JOIN Size ON SanPhamCT.Size_id = Size.id Where SanPham.Ten like 'Giay Cao Got';


SELECT SanPhamCT.Id,SanPham.Ten,GiaBan,SoLuong FROM SanPhamCT join SanPham on SanPhamCT.SanPham_Id = SanPham.Id  WHERE SanPhamCT.Id LIKE '1001'
SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,GiaBan,SoLuong FROM SanPhamCT Join SanPham on SanPhamCT.SanPham_Id = SanPham.Id
			JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id
            JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id
            JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id
            JOIN Size ON SanPhamCT.Size_id = Size.id Where LoaiSP.Ten LIKE 'GiayCongSo';


Insert into NhanVien(ten,gioitinh,ngaysinh,sdt,diachi,email,matkhau,vaitro,trangthai)values('Le Anh Dung',0,'2003-08-13','0867550591','Ha Noi','Dungdaubet@gmail.com','123456',0,1);
Insert into NhanVien(ten,gioitinh,ngaysinh,sdt,diachi,email,matkhau,vaitro,trangthai)values('Le Anh Dung2344',1,'2003-09-14','9999999999','Ha Noi 2323','Dungdaubet@gmail.com','1234564444',0,1);
Insert into KhachHang(ten,sdt,diachi)values('Pham Quang Thinh','12347878834','ha Noi');
Insert into KhachHang(ten,sdt,diachi)values('Pham Quang Thinh222222','8888888888','Nghe An');
select * from NhanVien
select * from KhachHang
insert into hoaDon(NhanVien_id,KhachHang_id,ngaytao,trangthai,tongtien,ghichu) 
values('1001','1001','2023-04-12',0,12000,'totdddd');
insert into hoaDon(NhanVien_id,KhachHang_id,ngaytao,trangthai,tongtien,ghichu) 
values('1002','1002','2023-05-15',0,12000,'totdddd');
select * from HoaDon
SELECT HoaDon.Id,NhanVien.Ten,KhachHang.Ten,KhachHang.DiaChi,KhachHang.SDT,NgayTao,TongTien,HoaDon.TrangThai,GhiChu 
FROM HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang 
ON HoaDon.KhachHang_Id = KhachHang.Id where HoaDon.id like'100991'
SELECT NhanVien.Ten,KhachHang.Ten,KhachHang.DiaChi,KhachHang.SDT,NgayTao,TongTien,HoaDon.TrangThai,GhiChu 
FROM HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang 
ON HoaDon.KhachHang_Id = KhachHang.Id 


SELECT HoaDon.Id,NhanVien.Ten,KhachHang.Ten,NgayTao,HoaDon.TrangThai
    FROM  HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang
       ON HoaDon.KhachHang_Id = KhachHang.Id WHERE NgayTao LIKE '2023-05-15' OR HoaDon.Id LIKE '100992'

SELECT COUNT(*) FROM HoaDon WHERE id LIKE '100992'
SELECT id,NhanVien_id,KhachHang_id,NgayTao,TongTien,TrangThai,GhiChu FROM HoaDon WHERE id = '100992'
select * from HoaDonCT
SELECT SanPhamCT.SanPham_id,SanPham.Ten,HoaDonCT.Gia,HoaDonCT.SoLuong,KhuyenMai.GiamGia,HoaDonCT.ThanhTien FROM HoaDonCT JOIN SanPhamCT 
	ON HoaDonCT.SanPhamCT_Id = SanPhamCT.id join SanPham
	On SanPhamCT.SanPham_id = SanPham.id join KhuyenMai
	On SanPham.id = KhuyenMai.SanPham_id join HoaDon
	On HoaDonCT.HoaDon_id = HoaDon.id



SELECT HoaDon.id,SanPhamCT.SanPham_id,SanPham.Ten,HoaDonCT.Gia,HoaDonCT.SoLuong,KhuyenMai.GiamGia,HoaDonCT.ThanhTien FROM HoaDonCT JOIN SanPhamCT 
	ON HoaDonCT.SanPhamCT_Id = SanPhamCT.id join SanPham
	On SanPhamCT.SanPham_id = SanPham.id join KhuyenMai
	On SanPhamCT.id = KhuyenMai.SanPhamCT_Id join HoaDon
	On HoaDonCT.HoaDon_id = HoaDon.id
	WHERE hoadon.id LIKE '100993';
/*SELECT SanPham.MaSanPham,SanPham.TenSanPham,ChiTietHoaDon.SoLuong,ChiTietHoaDon.DonGia,KhuyenMai.GiamGia,ChiTietHoaDon.ThanhTien

      FROM ChiTietHoaDon JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham JOIN KhuyenMai ON SanPham.MaSanPham = KhuyenMai.MaSanPham WHERE SanPham.MaSanPham LIKE ?"
*/
SELECT KhuyenMai.id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.Ten
FROM KhuyenMai JOIN SanPham ON KhuyenMai.id = SanPham.Id

INSERT INTO KhuyenMai(Ten,NgayBatDau,NgayKetThuc,GiamGia,TrangThai,SanPham_id) 
VALUES(?,?,?,?,?,?)

UPDATE KhuyenMai SET Ten= 'Giam Gia Giay 22222',NgayBatDau ='2023-04-23',NgayKetThuc='2023-04-23',GiamGia=1234444,TrangThai = 1,SanPham_id='1002' WHERE id = '1004'
select * from KhuyenMai


SELECT KhuyenMai.id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.Ten FROM KhuyenMai JOIN SanPham ON KhuyenMai.SanPham_Id = SanPham.id 
WHERE KhuyenMai.Ten LIKE 'Giam Gia Giay 22222' OR SanPham.Ten LIKE 'giay chay bo'


SELECT KhuyenMai.id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai from KhuyenMai

SELECT id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai FROM KhuyenMai WHERE KhuyenMai.Ten LIKE 'giam23'

SELECT id,SanPham_Id,GiaBan,SoLuong FROM SanPhamCT where id like '1001'


/*
select hoa don
insert khuyen mai
*/