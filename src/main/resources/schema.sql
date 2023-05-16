CREATE SCHEMA IF NOT EXISTS EstateAgency;
USE EstateAgency;
CREATE TABLE IF NOT EXISTS buyers (
  buyer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(50) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  address VARCHAR(100) NOT NULL,
  postcode VARCHAR(20) NOT NULL,
  phone VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS sellers (
  seller_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(50) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  address VARCHAR(100) NOT NULL,
  postcode VARCHAR(20) NOT NULL,
  phone VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS properties (
  property_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  address VARCHAR(150) UNIQUE,
  postcode VARCHAR(20) NOT NULL,
  type VARCHAR(30) NOT NULL,
  bedrooms INT NOT NULL,
  bathrooms INT NOT NULL,
  garden BOOLEAN NOT NULL,
  price INT NOT NULL,
  status ENUM('FOR SALE', 'SOLD', 'WITHDRAWN') DEFAULT 'FOR SALE',
  seller_id INT NOT NULL,
  FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);
