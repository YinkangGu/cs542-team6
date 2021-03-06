-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: database6
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_manager`
--

DROP TABLE IF EXISTS `tb_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_manager` (
  `ManagerNum` char(10) NOT NULL,
  `ManagerName` varchar(20) NOT NULL,
  `ManagerSex` char(10) NOT NULL,
  `ManagerPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`ManagerNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_manager`
--

LOCK TABLES `tb_manager` WRITE;
/*!40000 ALTER TABLE `tb_manager` DISABLE KEYS */;
INSERT INTO `tb_manager` VALUES ('111','ben','M','b12345'),('29457862','Kane Black','F','adminSun010101'),('29457863','Coy Garica ','F','adminMoon0990'),('29457864','Cox Brown','M','adminJh76902'),('29457865','Yang Wang','M','adminLo09932'),('29457866','Helen Labbon','F','adminBh8765'),('29457867','Dan Jones','F','adminDan09'),('29457868','Pter Rodriguez','M','adminPet0518'),('29457869','Lily Wilson','F','adminLily0920'),('29457870','Zack Lee','M','adminZack2203'),('29457871','Kata Johnson','F','adminKa040910');
/*!40000 ALTER TABLE `tb_manager` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14 14:13:05
