-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.7.24 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for reserva
CREATE DATABASE IF NOT EXISTS `reserva` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `reserva`;

-- Dumping structure for table reserva.tblplatillos
CREATE TABLE IF NOT EXISTS `tblplatillos` (
  `IdPlatillos` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Costo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdPlatillos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table reserva.tblplatillos: ~0 rows (approximately)
DELETE FROM `tblplatillos`;
/*!40000 ALTER TABLE `tblplatillos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblplatillos` ENABLE KEYS */;

-- Dumping structure for table reserva.tblreserva
CREATE TABLE IF NOT EXISTS `tblreserva` (
  `IdReserva` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `MesaPara` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Estado` varchar(45) NOT NULL DEFAULT 'Reservado',
  PRIMARY KEY (`IdReserva`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table reserva.tblreserva: ~5 rows (approximately)
DELETE FROM `tblreserva`;
/*!40000 ALTER TABLE `tblreserva` DISABLE KEYS */;
INSERT INTO `tblreserva` (`IdReserva`, `Nombre`, `Fecha`, `Hora`, `Telefono`, `MesaPara`, `Usuario`, `Estado`) VALUES
	(1, 'Camilo', '2010-12-22', '11:39 AM', '567853', '5 personas', 'admin', 'Cancelado'),
	(2, 'andres', '3922-12-10', '13:00 PM', '5555', '4 personas', 'cami', 'Cancelado'),
	(6, 'Benja', '5822-12-09', '11:00 PM', '6575', '2 PERSONAS', 'cami', 'Cancelado'),
	(8, 'andres', '5822-12-10', '13:00 PM', '5555', '4 ', 'cami', 'Reservado'),
	(9, 'andres', '5822-12-10', '13:00 PM', '5555', '4 personas', 'cami', 'Reservado');
/*!40000 ALTER TABLE `tblreserva` ENABLE KEYS */;

-- Dumping structure for table reserva.tblusuarios
CREATE TABLE IF NOT EXISTS `tblusuarios` (
  `IdUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apaterno` varchar(45) NOT NULL,
  `Amaterno` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `Perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`IdUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Dumping data for table reserva.tblusuarios: ~3 rows (approximately)
DELETE FROM `tblusuarios`;
/*!40000 ALTER TABLE `tblusuarios` DISABLE KEYS */;
INSERT INTO `tblusuarios` (`IdUsuarios`, `Nombre`, `Apaterno`, `Amaterno`, `Usuario`, `Clave`, `Perfil`) VALUES
	(2, 'andres', 'poblete', 'manriquez', 'usu', 'admin', 'admin'),
	(5, 'cami', 'cami', 'cami', 'cami', 'cami', 'Empleado'),
	(30, 'a', 'b', 'c', 'u', 'u', 'Administrador');
/*!40000 ALTER TABLE `tblusuarios` ENABLE KEYS */;

-- Dumping structure for table reserva.tblventa
CREATE TABLE IF NOT EXISTS `tblventa` (
  `IdVenta` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Fecha` date NOT NULL,
  `MesaP` varchar(45) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Platillo` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Costo` decimal(10,2) NOT NULL,
  `Total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table reserva.tblventa: ~0 rows (approximately)
DELETE FROM `tblventa`;
/*!40000 ALTER TABLE `tblventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblventa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
