create table phong (
    id_phong int auto_increment primary key ,
    ten_phong varchar(20),
    gia_phong decimal(10,2),
    trang_thai varchar(20)
);
ALTER TABLE phong
ADD CONSTRAINT unique_ten_phong UNIQUE (ten_phong);
create table nguoi_thue (
    id_nguoi int auto_increment primary key ,
    ten_nguoi varchar(20),
    so_dien_thoai varchar(15),
    cccd varchar(20),
    id_phong int,
    FOREIGN KEY (id_phong) REFERENCES phong(id_phong)
);
ALTER TABLE nguoi_thue
ADD CONSTRAINT unique_cccd UNIQUE (cccd);
create table dien_nuoc (
    id int auto_increment primary key ,
    id_phong int,
    thang int,
    nam int,
    so_dien int,
    so_nuoc int,
    FOREIGN KEY (id_phong) REFERENCES phong(id_phong)
);
ALTER TABLE dien_nuoc
ADD CONSTRAINT unique_dien_nuoc UNIQUE (id_phong, thang, nam);
create table hoa_don (
    id_hoa_don int auto_increment primary key ,
    id_phong int,
    thang int,
    nam int,
    tien_phong decimal(10,2),
    tien_dien decimal(10,2),
    tien_nuoc decimal(10,2),
    tong_tien decimal(10,2),
    FOREIGN KEY (id_phong) REFERENCES phong(id_phong)
);
ALTER TABLE hoa_don
ADD CONSTRAINT unique_hoa_don UNIQUE (id_phong, thang, nam);
