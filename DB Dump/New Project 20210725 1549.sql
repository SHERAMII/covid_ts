-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.32-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema covid_ts
--

CREATE DATABASE IF NOT EXISTS covid_ts;
USE covid_ts;

--
-- Definition of table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(10,6) DEFAULT NULL,
  `longitude` decimal(10,6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `map`
--

/*!40000 ALTER TABLE `map` DISABLE KEYS */;
INSERT INTO `map` (`id`,`latitude`,`longitude`) VALUES 
 (1,'77.095596','34.789501'),
 (4,'7.095600','20.093399'),
 (5,'7.095600','20.093399');
/*!40000 ALTER TABLE `map` ENABLE KEYS */;


--
-- Definition of table `officers`
--

DROP TABLE IF EXISTS `officers`;
CREATE TABLE `officers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(450) DEFAULT NULL,
  `address` varchar(450) DEFAULT NULL,
  `centre` varchar(250) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `officers`
--

/*!40000 ALTER TABLE `officers` DISABLE KEYS */;
INSERT INTO `officers` (`id`,`username`,`address`,`centre`,`mobile`,`email`,`password`) VALUES 
 (5,'wer',' re','wr','34','re','32');
/*!40000 ALTER TABLE `officers` ENABLE KEYS */;


--
-- Definition of table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL,
  `fullname` varchar(250) DEFAULT NULL,
  `address` varchar(450) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `photo` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` (`id`,`fullname`,`address`,`age`,`mobile`,`photo`) VALUES 
 (1,'marvin garvis',' 93A rediie street, chicago','98','+473456786',''),
 (2,'selena wesl',' 34A arthure street, miami','79','+78675456','');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;


--
-- Definition of table `user_location_history`
--

DROP TABLE IF EXISTS `user_location_history`;
CREATE TABLE `user_location_history` (
  `id` int(10) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `longitude` decimal(10,6) NOT NULL,
  `latitude` decimal(10,6) NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  `detail` varchar(450) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_location_history`
--

/*!40000 ALTER TABLE `user_location_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_location_history` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
