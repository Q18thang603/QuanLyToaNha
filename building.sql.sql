create database management_building;
use management_building;

create table building
(
    id   int auto_increment primary key,
    name varchar(200) not null

);

create table Room(
id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    price DECIMAL(10,2),
    status ENUM('EMPTY','OCCUPIED') DEFAULT 'EMPTY',
    building_id INT,
    FOREIGN KEY (building_id) REFERENCES building(id)
);
CREATE TABLE Tenant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(15),
    cccd VARCHAR(20),
    room_id INT,
    FOREIGN KEY (room_id) REFERENCES Room(id)
);
CREATE TABLE Bill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    bill_date DATE,
    room_fee DOUBLE,
    electric_fee DOUBLE,
    water_fee DOUBLE,
    FOREIGN KEY (room_id) REFERENCES Room(id)
);
