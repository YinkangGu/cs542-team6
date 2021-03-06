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
-- Table structure for table `tb_teacher`
--

DROP TABLE IF EXISTS `tb_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_teacher` (
  `TeacherNum` char(10) NOT NULL,
  `TeacherName` varchar(20) NOT NULL,
  `TeacherSex` char(10) NOT NULL,
  `TeacherPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`TeacherNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_teacher`
--

LOCK TABLES `tb_teacher` WRITE;
/*!40000 ALTER TABLE `tb_teacher` DISABLE KEYS */;
INSERT INTO `tb_teacher` VALUES ('222','andy','M','a12345'),('444','cynthia','F','c12345'),('45439967','Gabriel.J Cliton','M','Gaj07291996'),('45439968','Aaron Smith','M','Aaron05301970'),('45439969','Marry Black','F','Marry01011986'),('45439970','Paul Williams','M','Paul08011980'),('45439971','Rose Reagan','F','Rose04211979'),('45439972','Rachel Carter','M','Rachel111'),('45439973','Lucy Hall','F','Ly09141976'),('45439974','Karla Kent','F','Karla0615'),('45439975','Aalto Mill','M','Aalto0308'),('45439976','Conn Brook','M','ConnConn12'),('45439977','Daly Tang','F','Van090819'),('45439978','Eda Vueson','F','Eda042'),('45439979','Dallas Texas','M','Dallas0872'),('45439980','Halley Minny','M','Dallas0827'),('45439981','Haines Ully','F','Dallas0827'),('45439982','Lacy Tullen','F','Mkahdg55'),('45439983','Mac JP','M','JJgdsd55'),('45439984','Quick.Marrow','M','FJ835735jj'),('45439985','Eason Walen','M','Vsgu1233'),('45439986','Tm Kin','F','Shgj879');
/*!40000 ALTER TABLE `tb_teacher` ENABLE KEYS */;
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
