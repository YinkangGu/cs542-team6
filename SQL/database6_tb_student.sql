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
-- Table structure for table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_student` (
  `StudentNum` char(10) NOT NULL,
  `MajorNum` char(10) NOT NULL,
  `StudentName` varchar(20) NOT NULL,
  `StudentSex` char(10) NOT NULL,
  `StudentPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`StudentNum`),
  KEY `MajorNum` (`MajorNum`),
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`MajorNum`) REFERENCES `tb_major` (`MajorNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_student`
--

LOCK TABLES `tb_student` WRITE;
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
INSERT INTO `tb_student` VALUES ('333','ECE','qqq','M','q12345'),('555','CS','ppp','F','p12345'),('57689324','ECE','Zihan Liu','M','Da0987651'),('57689325','CS','Jiameng Wang','F','12312o123'),('57689326','CS','Ruby Jason','M','837324h234'),('57689327','ECE','Bowen Sun','M','123uh123'),('57689328','MSE','Taolue Chen','M','9we9uw98e'),('57689329','MKT','Mary Jin','F','1892y1923'),('57689330','CHE','Hades Jordan','M','98d98ywe'),('57689331','MKT','Kim King','F','89y123123ff'),('57689332','ECE','Amy Young','M','8f8r8374'),('57689333','MSE','Jimmy Wang','F','87e8gwwf'),('57689334','MSE','Davies Athen','M','98sdf98wer'),('57689335','ECE','Edison Chen','F','8f88wewer1'),('57689336','ECE','Eric Gu','M','98sd98f78w9'),('57689337','MKT','Shihan Tian','F','syd9w98yhv'),('57689338','CHE','Dalas Hanson','M','09s88uwsd0iu'),('57689339','CHE','Alvina Lee','F','98sdf98qwe'),('57689340','CS','Alada Joe','M','09sdf90wer'),('57689341','ECE','Gory Kong','M','908sdfsdf'),('57689342','MSE','Smith Jeon','M','0s9dfu09we'),('57689343','CS','Taylor Swift','F','s0d9f0s9f'),('57689344','MKT','White Tom','M','98dsfweu89c9'),('57689345','CS','Harries Ted','M','98dyf98yf9ef'),('57689346','CHE','THomas Edison','F','sdf9u98v98we'),('57689347','CHE','Backer Ben','M','sd7f98we98'),('57689348','CS','Martin Robert','M','78y87yeg87w'),('57689349','ECE','Simmons Hill','M','s98dyf9wehu'),('57689350','MSE','Harries Perry','F','0sduf98wue'),('57689351','MSE','Perez Butler','M','78sdy8gsd8fh'),('57689352','MKT','Carter Howard','M','98dfys98ydf'),('57689353','CS','Washington DC','M','97sd9fsy');
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;
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
