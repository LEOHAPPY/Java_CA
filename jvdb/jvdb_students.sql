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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pw` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('S0001','Dex Tan','dex.tan@gmail.com','abcd1234!','Dex'),('S0002','Dinar Rahimita','d.rahimita@gmail.com','abcd1234!','Dinar'),('S0003','Edward Yang','yjdayuer@gmail.com','abcd1234!','Edward'),('S0004','Gillian Kang','gillykang@gmail.com','abcd1234!','Gillian'),('S0005','Hanni Zaw','hannizaw93@gmail.com','abcd1234!','Hanni'),('S0006','Sowndarya','sowndarya.prs@gmail.com','abcd1234!','Sownd'),('S0007','Leo Liu Chao','leochao.happy@gmail.com','abcd1234!','Leo'),('S0008','Ye Kyaw Paing','wiz.ash.1331@gmail.com','abcd1234!','Paing'),('S0009','Aung Ye Kaung','aungyekaung@gmail.com','abcd1234!','Aung'),('S0010','Cao Wei','caowei@gmail.com','abcd1234!','Caowei'),('S0011','Chan Wing Fook','wingfook@gmail.com','abcd1234!','Wingfook'),('S0012','Chen Ying','chenying@gmail.com','abcd1234!','Chenying'),('S0013','Chiam Sixuan','sixuan@gmail.com','abcd1234!','Sixuan'),('S0014','Amos Chow','amoschow@gmail.com','abcd1234!','Amos'),('S0015','Ei Ei Maw','eiei@gmail.com','abcd1234!','Eiei'),('S0016','David Fan','davidfan@gmail.com','abcd1234!','David'),('S0017','Gogul','gogul@gmail.com','abcd1234!','Gogul'),('S0018','Huang Ji','huangji@gmail.com','abcd1234!','Huangji'),('S0019','Krithiga','krithiga@gmail.com','abcd1234!','Krithiga'),('S0020','Angeline Lee','angelinelee@gmail.com','abcd1234!','Angeline'),('S0021','Lim Zhi Yang','zhiyang@gmail.com','abcd1234!','Zhiyang'),('S0022','Billy Lv','billy@gmail.com','abcd1234!','Billy'),('S0023','Matthew Soh','matthewsoh@gmail.com','abcd1234!','Matthew'),('S0024','Nwe Thazin','thazin@gmail.com','abcd1234!','Thazin'),('S0025','Pan Pan','panpan@gmail.com','abcd1234!','Panpan'),('S0026','Quek Wee Kiat','weekiat@gmail.com','abcd1234!','Weekiat'),('S0027','Raaj','raaj@gmail.com','abcd1234!','Raaj'),('S0028','Sidi Hu','sidi@gmail.com','abcd1234!','Sidi'),('S0029','Sooyoun Lee','sooyoun@gmail.com','abcd1234!','Sooyoun'),('S0030','Su Mon Mon','monmon@gmail.com','abcd1234!','Monmon');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-06  9:12:35
