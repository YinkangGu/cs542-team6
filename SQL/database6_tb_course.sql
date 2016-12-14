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
-- Table structure for table `tb_course`
--

DROP TABLE IF EXISTS `tb_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_course` (
  `CourseNum` varchar(10) NOT NULL,
  `CourseName` varchar(50) NOT NULL,
  `TeacherNum` char(10) NOT NULL,
  `MajorNum` char(10) NOT NULL,
  `CourseCredit` decimal(2,1) NOT NULL,
  `CourseTime` varchar(20) NOT NULL,
  `CourseDesc` varchar(255) NOT NULL,
  PRIMARY KEY (`CourseNum`),
  UNIQUE KEY `TeacherNum` (`TeacherNum`,`CourseTime`),
  KEY `MajorNum` (`MajorNum`),
  CONSTRAINT `tb_course_ibfk_1` FOREIGN KEY (`TeacherNum`) REFERENCES `tb_teacher` (`TeacherNum`),
  CONSTRAINT `tb_course_ibfk_2` FOREIGN KEY (`MajorNum`) REFERENCES `tb_major` (`MajorNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_course`
--

LOCK TABLES `tb_course` WRITE;
/*!40000 ALTER TABLE `tb_course` DISABLE KEYS */;
INSERT INTO `tb_course` VALUES ('CHE3550','Chemical Dynamics','45439985','CHE',3.0,'THU: 6:00PM-9:00PM','TBA'),('CHE3554','Molecular Modeling','45439978','CHE',3.0,'MON: 3:00PM-5:00PM','TBA'),('CHE4120','Biochemistry ','45439976','CHE',3.0,'MON: 3:00PM-5:00PM','TBA'),('CS2223','Algorithm','45439970','CS',3.0,'TUE: 3:00PM-5:00PM','TBA'),('CS3013','Operating System','45439969','CS',3.0,'TUE: 1:00PM-3:00PM','TBA'),('CS4100','Artificial Intelligent','45439981','CS',3.0,'THU: 8:00AM-10:00AM','TBA'),('CS501','Data','444','CS',3.0,'FRI: 6:00PM-9:00PM','TBA'),('CS502','Computer ','444','CS',2.0,'THU: 3:00PM-5:00PM','TBA'),('CS509','Software Engineering','45439974','CS',4.0,'MON: 6:00PM-9:00PM','TBA'),('CS542','Database ','45439969','CS',2.0,'THU: 3:00PM-5:00PM','TBA'),('CS578','Crytography','45439973','CS',4.0,'THU: 3:00PM-5:00PM','TBA'),('ECE2010','Circuits ','45439982','ECE',3.0,'TUE: 8:00AM-10:00AM','TBA'),('ECE3311','Communication System','45439986','ECE',3.0,'THU: 3:00PM-5:00PM','TBA'),('ECE3503','Power Electrionics','45439979','ECE',3.0,'THU: 8:00AM-10:00AM','TBA'),('ECE501','Probability','222','ECE',2.0,'WED: 1:00PM-3:00PM','TBA'),('ECE503','DSP','222','ECE',3.0,'FRI: 6:00PM-9:00PM','Need matlab...'),('ECE505','Computer Architecture','45439969','ECE',3.0,'FRI: 10:00AM-12:00PM','TBA'),('ECE506','Network','45439968','ECE',3.0,'FRI: 3:00PM-5:00PM','TBA'),('ECE5311','Information Theory','45439970','ECE',3.0,'WED: 1:00PM-3:00PM','TBA'),('ECE566','VLSI Design','45439975','ECE',3.0,'TUE: 8:00AM-10:00AM','TBA'),('MKT2630','Marketing Process','45439984','MKT',2.0,'MON: 6:00PM-9:00PM','TBA'),('MKT500','Marketing Management','45439971','MKT',2.0,'WED: 1:00PM-3:00PM','TBA'),('MKT560','Consumer Behavior','45439972','MKT',4.0,'TUE: 1:00PM-3:00PM','TBA'),('MKT562','Marketing Research','45439980','MKT',3.0,'FRI: 10:00AM-12:00PM','TBA'),('MKT564','Global Marketing','45439971','MKT',4.0,'WED: 8:00AM-10:00AM','TBA'),('MSE526','Thermodynamics','45439983','MSE',3.0,'THU: 10:00AM-12:00PM','TBA'),('MSE550','Biomaterials','45439983','MSE',3.0,'WED: 6:00PM-9:00PM','TBA'),('MSE558','Plastics','45439972','MSE',2.0,'MON: 10:00AM-12:00PM','TBA'),('MSE580','Mechenical Behavior','45439977','MSE',3.0,'TUE: 6:00PM-9:00PM','TBA');
/*!40000 ALTER TABLE `tb_course` ENABLE KEYS */;
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
