-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: javacadatabase
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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `CourseID` varchar(255) NOT NULL,
  `CourseName` varchar(255) DEFAULT NULL,
  `CourseStart` datetime DEFAULT NULL,
  `CourseEnd` datetime DEFAULT NULL,
  `CourseCredit` double DEFAULT NULL,
  `CourseMaxSize` double DEFAULT NULL,
  `CourseDesc` longtext,
  `LectureID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CourseID`),
  KEY `LectureID` (`LectureID`),
  KEY `LecturesCourses` (`LectureID`),
  CONSTRAINT `LecturesCourses` FOREIGN KEY (`LectureID`) REFERENCES `lectures` (`LecturerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('C1001','Digital Marketing','2017-01-01 00:00:00','2017-03-31 00:00:00',8,15,'An overview of digital marketing essentials inclusive of the digital marketing ecosystem, current tools, opportunities, and careers. In this three-month course, students will learn to plan and execute a marketing campaign, acquire and engage users, and quantify a strategy\'s success.','L0001'),('C1002','Facebook Advertising','2017-01-01 00:00:00','2017-03-31 00:00:00',8,15,'3-month.In this class you will get insights and practical lessons from the field and you’ll learn how to make the most of Facebook advertising.','L0002'),('C1003','Google Analytics','2017-04-01 00:00:00','2017-04-30 00:00:00',4,30,'1-month.Learn how to use your Google Analytics to get real insights into your website’s visitors, their behavior and any patterns and trends.','L0003'),('C1004','Data Analysis','2017-05-05 00:00:00','2017-05-31 00:00:00',4,30,'1-month.Learn to gather, analyze, and tell stories through data with SQL, Excel, and visualization.','L0004'),('C1005','Break Into Product Management','2017-06-01 00:00:00','2017-06-30 00:00:00',4,30,'1-month.We will discuss the product management landscape, what the PM role entails, who makes a good PM, and how you can transition into the field.','L0005'),('C1006','Web Development','2017-07-01 00:00:00','2017-07-31 00:00:00',4,30,'1-month. All day, every day. Learn the skills to become an entry-level full stack web developer and get access to dedicated career services in this innovative program. ','L0006'),('C1007','User Experience Design','2017-08-01 00:00:00','2017-08-31 00:00:00',4,30,'1-month. All day. Monday through Friday. Learn the skills of a UX designer and put them to work while building a comprehensive portfolio.','L0007'),('C1008','Product Management','2017-09-01 00:00:00','2017-09-30 00:00:00',4,30,'In this 1-month, students will learn to navigate the product cycle, from evaluating users and managing a roadmap to creating an MVP and developing metrics.','L0001'),('C1009','UX Design 101','2017-10-01 00:00:00','2017-10-31 00:00:00',4,30,'1-month.This is an ideal 101 class for someone who has heard the term UX and maybe even understands the basics, but is not sure what it really means to them.','L0002'),('C1010','Data Analytics 101','2017-11-01 00:00:00','2017-11-30 00:00:00',4,30,'1-month.In this hands-on introductory workshop, you’ll learn to ask the right questions of your data, while learning basic analytic functionality & manipulating real- data sets.','L0003'),('C1011','Visual Design Fundamentals','2017-12-01 00:00:00','2017-12-31 00:00:00',3,15,'1-month.This class teaches the basics of effective design by applying principles that have been mastered throughout the ages to the core concepts used in the industry today.','L0004'),('C1012','\nJavascript 101','2017-12-01 00:00:00','2017-12-31 00:00:00',3,15,'1-month.In this introductory class, you’ll learn about the Javascript development community. You’ll also learn how to think programmatically and apply javascript programming fundamentals.','L0005');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-05 12:40:14
