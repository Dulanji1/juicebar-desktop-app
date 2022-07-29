-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.11 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5151
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for juice_bar
DROP DATABASE IF EXISTS `juice_bar`;
CREATE DATABASE IF NOT EXISTS `juice_bar` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `juice_bar`;

-- Dumping structure for table juice_bar.cus_ordes
DROP TABLE IF EXISTS `cus_ordes`;
CREATE TABLE IF NOT EXISTS `cus_ordes` (
  `cus_id` varchar(50) NOT NULL,
  `cus_o_id` varchar(50) DEFAULT NULL,
  `cus_o_name` varchar(50) DEFAULT NULL,
  `cus_quantity` varchar(50) DEFAULT NULL,
  `cus_price` varchar(50) DEFAULT NULL,
  `cus_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.cus_ordes: ~5 rows (approximately)
DELETE FROM `cus_ordes`;
/*!40000 ALTER TABLE `cus_ordes` DISABLE KEYS */;
INSERT INTO `cus_ordes` (`cus_id`, `cus_o_id`, `cus_o_name`, `cus_quantity`, `cus_price`, `cus_date`) VALUES
	('Cid001', 'O0001', 'Apple juice', '4', '400', '12-3-2020'),
	('Cid002', 'O0001', 'Apple Juice', '2', '200', '23-3-2020'),
	('Cid003', 'O0002', 'Orange Juice', '1', '80', '22-3-2020'),
	('Cid004', 'O0003', 'Pina Apple Juice', '2', '120', '24-3-2020'),
	('Cid005', 'O0004', 'Lemon Juice', '3', '300', '25-3-2020');
/*!40000 ALTER TABLE `cus_ordes` ENABLE KEYS */;

-- Dumping structure for table juice_bar.finance
DROP TABLE IF EXISTS `finance`;
CREATE TABLE IF NOT EXISTS `finance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cDate` varchar(30) DEFAULT NULL,
  `elecBill` double(9,2) DEFAULT NULL,
  `waterBill` double(9,2) DEFAULT NULL,
  `rent` double(9,2) DEFAULT NULL,
  `phoneBill` double(9,2) DEFAULT NULL,
  `transport` double(9,2) DEFAULT NULL,
  `equipment` double(9,2) DEFAULT NULL,
  `other` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cDate` (`cDate`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.finance: ~9 rows (approximately)
DELETE FROM `finance`;
/*!40000 ALTER TABLE `finance` DISABLE KEYS */;
INSERT INTO `finance` (`id`, `cDate`, `elecBill`, `waterBill`, `rent`, `phoneBill`, `transport`, `equipment`, `other`) VALUES
	(1, '2020-05-10', 3300.00, 1400.00, 1200.00, 950.00, 450.00, 100.00, 180.00),
	(2, '2020-05-09', 0.00, 0.00, 1200.00, 100.00, 2500.00, 0.00, 800.00),
	(4, '2020-05-04', 0.00, 900.00, 1200.00, 120.00, 250.00, 0.00, 400.00),
	(5, '2020-05-05', 2100.00, 0.00, 1200.00, 200.00, 450.00, 0.00, 300.00),
	(6, '2020-05-06', 0.00, 0.00, 1200.00, 100.00, 550.00, 0.00, 400.00),
	(7, '2020-05-07', 600.00, 400.00, 1200.00, 100.00, 150.00, 280.00, 300.00),
	(8, '2020-05-08', 600.00, 400.00, 1200.00, 100.00, 50.00, 280.00, 300.00),
	(9, '2020-05-01', 600.00, 400.00, 1200.00, 100.00, 50.00, 880.00, 300.00),
	(10, '2020-05-02', 600.00, 600.00, 1200.00, 100.00, 150.00, 1880.00, 300.00);
/*!40000 ALTER TABLE `finance` ENABLE KEYS */;

-- Dumping structure for table juice_bar.inquary
DROP TABLE IF EXISTS `inquary`;
CREATE TABLE IF NOT EXISTS `inquary` (
  `Inquary_no` varchar(50) DEFAULT NULL,
  `Inquary_name` varchar(50) DEFAULT NULL,
  `Compleaninant` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Inquary` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.inquary: ~11 rows (approximately)
DELETE FROM `inquary`;
/*!40000 ALTER TABLE `inquary` DISABLE KEYS */;
INSERT INTO `inquary` (`Inquary_no`, `Inquary_name`, `Compleaninant`, `Section`, `Inquary`) VALUES
	('In001', 'Insufficent Stock', 'Dulanji', 'Supplier MAnagement', 'Insufficent Suger Stock'),
	('In002', 'Wastage', 'Anesha', 'Wastage Management', 'Get action for reduse food wastage '),
	('In003', 'Wastage', 'Aloka', 'Wastage Management', 'Wataer leak so wate wastage'),
	('In004', 'Insufficent Apple', 'Dulanji', 'Supplier MAnagement', 'Insufficent Apple Stock'),
	('In005', 'About Supplier Record', 'Dulanji', 'Supplier MAnagement', 'S001 supplier contact no does not work.Update it.'),
	('In006', 'About Items', 'Dulanji', 'Supplier MAnagement', 'Get new fruits'),
	('In007', 'Financial Issue', 'Anesha', 'Financial MAnagement', 'Profit issue'),
	('In008', 'Financial Issue', 'Nimsara', 'Financial MAnagement', 'loan payment issue'),
	('In009', 'Inventory Issue', 'Nimsara', 'Inventory MAnagement', 'Insufficent fruit stock'),
	('In010', 'Inventory Issue', 'Shakith', 'Inventory MAnagement', 'wastage fruit stock'),
	('In012', 'Order Issue ', 'Aloka', 'Order MAnagement', 'Delay regarding O005');
/*!40000 ALTER TABLE `inquary` ENABLE KEYS */;

-- Dumping structure for table juice_bar.inventory
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `Item_No` varchar(50) NOT NULL,
  `Item_Name` varchar(50) DEFAULT NULL,
  `Quantity` varchar(50) DEFAULT NULL,
  `Bring_Date` varchar(50) DEFAULT NULL,
  `Current_Quantity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Item_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.inventory: ~16 rows (approximately)
DELETE FROM `inventory`;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`Item_No`, `Item_Name`, `Quantity`, `Bring_Date`, `Current_Quantity`) VALUES
	('F001', 'Apple', '6kg', '22-3-20020', '3kg'),
	('F002', 'Orange', '4kg', '22-3-2020', '2kg'),
	('F003', 'Melan', '5kg', '24-3-2020', '2kg'),
	('F004', 'Pina Apple', '10kg', '25-3-2020', '2kg'),
	('F005', 'Banana', '5kg', '25-3-2020', '2kg'),
	('F006', 'Kivi', '7kg', '15-5-2020', '3kg'),
	('F007', 'Papaya', '6kg', '16-05-2020', '3kg'),
	('F008', 'Mango', '6kg', '16-05-2020', '2kg'),
	('F009', 'Lemon', '5kg', '16-05-2020', '3kg'),
	('F010', 'Sweet Lemon', '7kg', '16-05-2020', '4kg'),
	('I001', 'Suger', '20kg', '11-5-2020', '4kg'),
	('I002', 'Milk', '15kg', '15-5-2020', '4kg'),
	('I003', 'Chokalate Powder', '4kg', '16-5-2020', '2kg'),
	('I004', 'Salt', '4kg', '16-5-2020', '1kg'),
	('I005', 'Milk', '5 Bottels', '16-5-2020', '3 Bottels'),
	('I007', 'Chokolate', '4', '12-2-2020', '2');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;

-- Dumping structure for table juice_bar.item
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `Item_No` varchar(10) NOT NULL,
  `Item_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Item_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.item: ~7 rows (approximately)
DELETE FROM `item`;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`Item_No`, `Item_Name`) VALUES
	('I001', 'Apple'),
	('I002', 'Orange'),
	('I003', 'Melan'),
	('I004', 'Pina Apple'),
	('I005', 'Banana'),
	('I006', 'Assanse'),
	('I007', 'Suger');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table juice_bar.login
DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.login: ~6 rows (approximately)
DELETE FROM `login`;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`, `password`) VALUES
	('sumudu', 'sumudu1'),
	('aloka', 'aloka1'),
	('dilika', 'dilika1'),
	('shakith', 'shakith1'),
	('login', 'login1'),
	('A', 'A');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table juice_bar.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `o_id` varchar(50) DEFAULT NULL,
  `o_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.orders: ~6 rows (approximately)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`o_id`, `o_name`) VALUES
	('O0001', 'Apple Juice'),
	('O0002', 'Orange Juice'),
	('O0003', 'Pina Apple Juice'),
	('O0004', 'Lemon Juice'),
	('O0005', 'Chockalate Milk Shake'),
	('O0006', 'Mix Fruite');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table juice_bar.solditem
DROP TABLE IF EXISTS `solditem`;
CREATE TABLE IF NOT EXISTS `solditem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dates` varchar(20) DEFAULT NULL,
  `itemName` varchar(35) DEFAULT NULL,
  `soldQuantity` int(11) DEFAULT NULL,
  `priceofOneItem` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.solditem: ~45 rows (approximately)
DELETE FROM `solditem`;
/*!40000 ALTER TABLE `solditem` DISABLE KEYS */;
INSERT INTO `solditem` (`id`, `dates`, `itemName`, `soldQuantity`, `priceofOneItem`) VALUES
	(1, '2020-05-01', 'mixfruit', 14, 150.00),
	(2, '2020-05-01', 'avocardo', 12, 130.00),
	(3, '2020-05-01', 'mango', 16, 110.00),
	(4, '2020-05-01', 'woodapple', 15, 120.00),
	(5, '2020-05-01', 'watermelon', 10, 100.00),
	(11, '2020-05-02', 'mixfruit', 24, 150.00),
	(12, '2020-05-02', 'avocardo', 22, 130.00),
	(13, '2020-05-02', 'mango', 16, 110.00),
	(14, '2020-05-02', 'woodapple', 19, 120.00),
	(15, '2020-05-02', 'watermelon', 9, 100.00),
	(16, '2020-05-03', 'mixfruit', 14, 150.00),
	(17, '2020-05-03', 'avocardo', 32, 130.00),
	(18, '2020-05-03', 'mango', 21, 110.00),
	(19, '2020-05-03', 'woodapple', 15, 120.00),
	(20, '2020-05-03', 'watermelon', 18, 100.00),
	(21, '2020-05-04', 'mixfruit', 34, 150.00),
	(22, '2020-05-04', 'avocardo', 12, 130.00),
	(23, '2020-05-04', 'mango', 19, 110.00),
	(24, '2020-05-04', 'woodapple', 17, 120.00),
	(25, '2020-05-04', 'watermelon', 21, 100.00),
	(26, '2020-05-05', 'mixfruit', 9, 150.00),
	(27, '2020-05-05', 'avocardo', 27, 130.00),
	(28, '2020-05-05', 'mango', 20, 110.00),
	(29, '2020-05-05', 'woodapple', 21, 120.00),
	(30, '2020-05-05', 'watermelon', 20, 100.00),
	(31, '2020-05-06', 'mixfruit', 13, 150.00),
	(32, '2020-05-06', 'avocardo', 29, 130.00),
	(33, '2020-05-06', 'mango', 25, 110.00),
	(34, '2020-05-06', 'woodapple', 40, 120.00),
	(35, '2020-05-06', 'watermelon', 4, 100.00),
	(36, '2020-05-07', 'mixfruit', 24, 150.00),
	(37, '2020-05-07', 'avocardo', 22, 130.00),
	(38, '2020-05-07', 'mango', 26, 110.00),
	(39, '2020-05-07', 'woodapple', 25, 120.00),
	(40, '2020-05-07', 'watermelon', 5, 100.00),
	(41, '2020-05-08', 'mixfruit', 34, 150.00),
	(42, '2020-05-08', 'avocardo', 11, 130.00),
	(43, '2020-05-08', 'mango', 19, 110.00),
	(44, '2020-05-08', 'woodapple', 21, 120.00),
	(45, '2020-05-08', 'watermelon', 17, 100.00),
	(46, '2020-05-09', 'mixfruit', 14, 150.00),
	(47, '2020-05-09', 'avocardo', 22, 130.00),
	(48, '2020-05-09', 'mango', 46, 110.00),
	(49, '2020-05-09', 'woodapple', 9, 120.00),
	(50, '2020-05-09', 'watermelon', 4, 100.00);
/*!40000 ALTER TABLE `solditem` ENABLE KEYS */;

-- Dumping structure for table juice_bar.stock
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `used` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.stock: ~10 rows (approximately)
DELETE FROM `stock`;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` (`id`, `name`, `qty`, `used`) VALUES
	(1, 'Mango', 280, 100),
	(2, 'Banana', 900, 400),
	(3, 'Apple', 670, 210),
	(4, 'Pears', 500, 200),
	(5, 'Grapes', 500, 256),
	(6, 'Strawberry', 250, 100),
	(7, 'Pawpow', 500, 200),
	(8, 'Passion fruit', 700, 350),
	(9, 'Avacado', 500, 450),
	(10, 'Lemon', 300, 100);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;

-- Dumping structure for table juice_bar.supplier_details
DROP TABLE IF EXISTS `supplier_details`;
CREATE TABLE IF NOT EXISTS `supplier_details` (
  `Supplier_No` varchar(20) NOT NULL,
  `Supplier_Name` varchar(45) DEFAULT NULL,
  `Supplier_Address` varchar(45) DEFAULT NULL,
  `Supplier_Phone_No` varchar(45) DEFAULT NULL,
  `Supplier_Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Supplier_No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.supplier_details: ~15 rows (approximately)
DELETE FROM `supplier_details`;
/*!40000 ALTER TABLE `supplier_details` DISABLE KEYS */;
INSERT INTO `supplier_details` (`Supplier_No`, `Supplier_Name`, `Supplier_Address`, `Supplier_Phone_No`, `Supplier_Email`) VALUES
	('S001', 'Sunil Gunawardana', 'Wihara Road,Mlabe', '0774565765', 'sunilperera@gmail.com'),
	('S002', 'Anuradi Yamasinhage', 'Waliwita Road,Malamulla', '0779976038', 'anu12@gmali.com'),
	('S003', 'Gamini Samarawera', 'A12/77,Moratumulla,Moratuwa', '0754456434', 'gamini@gmai.com'),
	('S004', 'Manel werakon', 'Sagabomawatha,Panadura', '0774560932', 'manel.@gmail.com'),
	('S005', 'Kasun Dewaka', 'No44,Temple Road,Moratuwa', '0774561236', 'kasun12l.@gmail.com'),
	('S006', 'Padmasiri cooray', 'No27,Walana,Panadura', '0779356785', 'padmasiri.@gmail.com'),
	('S007', 'Bimsara Silva', '22,Kalani Road,Moratuwa', '0711112667', 'bim@gmai.com'),
	('S008', 'Sanduni Perera', '88,Miriyawatta,Panadura', '0771778093', 'sadu@gmai.com'),
	('S009', 'Ajana Subani', '3 kanuwa,Malabe', '0772345689', 'amil@gmail.com'),
	('S010', 'Amasha Siriwardana', 'Aluvila Jonction,Malamulla.', '0771535678', 'amsha.@gmail.com'),
	('S011', 'Anesha Jayasekara', 'No177,Hena Road,Rathmalana', '0774567345', 'anesha11.@gmail.com'),
	('S012', 'Nadish Fenandu', 'No7,Miriyawatta Road,Wadduwa', '0777976433', 'nadish.@gmail.com'),
	('S013', 'Sarath Thisera', 'No7,Sumangala Road,Panadura', '0774466432', 'sarath.@gmail.com'),
	('S014', 'Gamini Thennakon', 'No65,Thunmulla,Walana', '0775456700', 'gamini22.@gmail.com'),
	('S015', 'Nimali Perea', 'No26,Kiriwella Road,Moratuwa', '0776543456', 'nimali.@gmail.com');
/*!40000 ALTER TABLE `supplier_details` ENABLE KEYS */;

-- Dumping structure for table juice_bar.supplier_items_details
DROP TABLE IF EXISTS `supplier_items_details`;
CREATE TABLE IF NOT EXISTS `supplier_items_details` (
  `No` varchar(50) NOT NULL,
  `Supplier_No` varchar(50) DEFAULT NULL,
  `Item_No` varchar(50) DEFAULT NULL,
  `Item_Name` varchar(50) DEFAULT NULL,
  `Item_Quantity` varchar(50) DEFAULT NULL,
  `Item_Price` varchar(50) DEFAULT NULL,
  `Item_Bring_Date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`No`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.supplier_items_details: ~20 rows (approximately)
DELETE FROM `supplier_items_details`;
/*!40000 ALTER TABLE `supplier_items_details` DISABLE KEYS */;
INSERT INTO `supplier_items_details` (`No`, `Supplier_No`, `Item_No`, `Item_Name`, `Item_Quantity`, `Item_Price`, `Item_Bring_Date`) VALUES
	('ID001', 'S001', 'F001', 'Apple', '5', '1200', '19-10-2020'),
	('ID002', 'S001', 'F002', 'Orange', '6', '1000', '12-04-2020'),
	('ID003', 'S001', 'F003', 'Melan', '7', '1700', '12-04-2020'),
	('ID004', 'S001', 'F004', 'Pina Apple', '8', '1400', '12-04-2020'),
	('ID005', 'S001', 'F008', 'Mango', '8', '1300', '12-04-2020'),
	('ID006', 'S002', 'F008', 'Mango', '8', '1300', '25-05-2020'),
	('ID007', 'S002', 'F001', 'Apple', '4', '650', '25-05-2020'),
	('ID008', 'S002', 'F009', 'Lemon', '6', '750', '25-05-2020'),
	('ID009', 'S002', 'F010', 'Sweet Lemon', '4', '450', '25-05-2020'),
	('ID010', 'S002', 'F007', 'Papaya', '4', '350', '25-05-2020'),
	('ID011', 'S003', 'F007', 'Papaya', '5', '550', '25-05-2020'),
	('ID012', 'S003', 'F004', 'Pina Apple', '5', '1000', '27-05-2020'),
	('ID013', 'S003', 'F003', 'Melan', '5', '780', '25-05-2020'),
	('ID014', 'S004', 'F003', 'Melan', '5', '670', '27-05-2020'),
	('ID015', 'S004', 'F008', 'Mango', '6', '500', '27-05-2020'),
	('ID016', 'S005', 'I001', 'Suger', '15', '2700', '28-05-2020'),
	('ID017', 'S005', 'I002', 'Milk', '10', '1800', '28-05-2020'),
	('ID018', 'S005', 'I004', 'Salt', '4', '950', '28-05-2020'),
	('ID019', 'S006', 'I004', 'Salt', '6', '1300', '28-05-2020'),
	('ID020', 'S006', 'I001', 'Suger', '10', '2100', '10-11-2020');
/*!40000 ALTER TABLE `supplier_items_details` ENABLE KEYS */;

-- Dumping structure for table juice_bar.supplier_items_details_2
DROP TABLE IF EXISTS `supplier_items_details_2`;
CREATE TABLE IF NOT EXISTS `supplier_items_details_2` (
  `Supplier_No` varchar(50) NOT NULL,
  `Item_No` varchar(45) NOT NULL,
  `Item_Name` varchar(45) DEFAULT NULL,
  `Item_Quantity` varchar(45) DEFAULT NULL,
  `Item_Price` varchar(45) DEFAULT NULL,
  `Item_Bring_Date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Supplier_No`,`Item_No`),
  KEY `FK_supplier_items_details_item` (`Item_No`,`Supplier_No`),
  CONSTRAINT `FK_supplier_items_details_item` FOREIGN KEY (`Item_No`) REFERENCES `item` (`item_no`),
  CONSTRAINT `FK_supplier_items_details_supplier_details` FOREIGN KEY (`Supplier_No`) REFERENCES `supplier_details` (`supplier_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.supplier_items_details_2: ~0 rows (approximately)
DELETE FROM `supplier_items_details_2`;
/*!40000 ALTER TABLE `supplier_items_details_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_items_details_2` ENABLE KEYS */;

-- Dumping structure for table juice_bar.totalincome
DROP TABLE IF EXISTS `totalincome`;
CREATE TABLE IF NOT EXISTS `totalincome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dates` varchar(30) DEFAULT NULL,
  `income` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dates` (`dates`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.totalincome: ~10 rows (approximately)
DELETE FROM `totalincome`;
/*!40000 ALTER TABLE `totalincome` DISABLE KEYS */;
INSERT INTO `totalincome` (`id`, `dates`, `income`) VALUES
	(1, '2020-05-01', 8350.00),
	(2, '2020-05-10', 7220.00),
	(3, '2020-05-02', 11070.00),
	(4, '2020-05-03', 12100.00),
	(5, '2020-05-04', 12560.00),
	(6, '2020-05-05', 11780.00),
	(7, '2020-05-06', 14100.00),
	(8, '2020-05-07', 12950.00),
	(9, '2020-05-08', 12570.00),
	(10, '2020-05-09', 12570.00);
/*!40000 ALTER TABLE `totalincome` ENABLE KEYS */;

-- Dumping structure for table juice_bar.wastage
DROP TABLE IF EXISTS `wastage`;
CREATE TABLE IF NOT EXISTS `wastage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodid` int(11) NOT NULL,
  `used_qty` int(11) NOT NULL,
  `total_qty` int(11) NOT NULL,
  `wastage` int(11) NOT NULL,
  `date` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table juice_bar.wastage: ~12 rows (approximately)
DELETE FROM `wastage`;
/*!40000 ALTER TABLE `wastage` DISABLE KEYS */;
INSERT INTO `wastage` (`id`, `goodid`, `used_qty`, `total_qty`, `wastage`, `date`) VALUES
	(12, 1, 100, 280, 180, '02/04/2020 23:11:09'),
	(13, 2, 400, 900, 500, '02/04/2020 23:11:32'),
	(14, 3, 210, 670, 460, '02/04/2020 23:11:32'),
	(15, 4, 200, 500, 300, '02/04/2020 23:11:32'),
	(16, 5, 256, 500, 244, '02/04/2020 23:11:32'),
	(17, 6, 100, 250, 150, '02/04/2020 23:11:32'),
	(18, 7, 200, 500, 300, '02/04/2020 23:11:32'),
	(19, 8, 350, 700, 350, '02/04/2020 23:11:32'),
	(20, 9, 450, 900, 450, '02/04/2020 23:11:32'),
	(21, 10, 100, 300, 200, '02/04/2020 23:11:32'),
	(22, 1, 100, 280, 180, '19/05/2020 19:40:16'),
	(23, 1, 100, 280, 180, '19/05/2020 20:02:14');
/*!40000 ALTER TABLE `wastage` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
