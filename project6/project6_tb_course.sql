-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: project6
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
INSERT INTO `tb_course` VALUES ('CS501','Data','444','CS',3.0,'FRI: 6:00PM-9:00PM','TBA'),('CS502','qqq','444','CS',3.0,'WED: 6:00PM-9:00PM','TBA'),('ECE501','Probability','222','ECE',2.0,'WED: 1:00PM-3:00PM','TBA'),('ECE503','DSP','222','ECE',3.0,'FRI: 6:00PM-9:00PM','This course needs Matlab...');
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

-- Dump completed on 2016-12-12  0:07:27
