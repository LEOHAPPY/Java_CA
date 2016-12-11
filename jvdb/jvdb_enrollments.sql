-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: jvdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollments` (
  `EnrollmentID` smallint(6) NOT NULL,
  `StudentID` varchar(255) DEFAULT NULL,
  `CourseID` varchar(255) DEFAULT NULL,
  `CourseGrade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EnrollmentID`),
  KEY `CourseID` (`CourseID`),
  KEY `CoursesEnrollments` (`CourseID`),
  KEY `StudentID` (`StudentID`),
  KEY `StudentsEnrollments` (`StudentID`),
  CONSTRAINT `CoursesEnrollments` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`CourseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `StudentsEnrollments` FOREIGN KEY (`StudentID`) REFERENCES `students` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES (2,'S0001','C1003','A'),(3,'S0001','C1004','B'),(4,'S0001','C1005','B'),(5,'S0001','C1006','C'),(6,'S0001','C1007','C'),(13,'S0007','C1004','A'),(15,'S0007','C1006','B'),(16,'S0007','C1007','C'),(18,'S0007','C1009','B'),(19,'S0007','C1010','C'),(22,'S0002','C1003','A'),(23,'S0002','C1004','C'),(27,'S0002','C1011','C'),(29,'S0003','C1011','A'),(33,'S0004','C1004','A'),(34,'S0004','C1011','A'),(37,'S0005','C1004','B'),(38,'S0005','C1011','C'),(41,'S0006','C1004','B'),(42,'S0006','C1011','A'),(45,'S0008','C1011','A'),(48,'S0009','C1011','B'),(50,'S0010','C1011','A'),(74,'S0018','C1004','C'),(83,'S0004','C1001','notset'),(84,'S0005','C1001','notset'),(85,'S0007','C1001','notset'),(86,'S0008','C1001','notset'),(87,'S0009','C1001','notset'),(88,'S0010','C1001','notset'),(89,'S0011','C1001','notset'),(90,'S0012','C1001','notset'),(91,'S0013','C1001','notset'),(92,'S0014','C1001','notset'),(93,'S0015','C1001','notset'),(94,'S0016','C1001','notset'),(95,'S0017','C1001','notset'),(96,'S0018','C1001','notset'),(97,'S0019','C1001','notset'),(98,'S0020','C1001','notset'),(99,'S0021','C1001','notset');
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12  5:19:16
