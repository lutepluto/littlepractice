-- MySQL dump 10.13  Distrib 5.1.71, for Win32 (ia32)
--
-- Host: localhost    Database: jiecao
-- ------------------------------------------------------
-- Server version	5.1.71-community

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
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_pid` int(11) NOT NULL,
  `image_url` varchar(500) NOT NULL,
  `image_name` varchar(100) NOT NULL,
  `image_timestamp` bigint(20) NOT NULL,
  `image_status` int(11) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK_image_program_idx` (`image_pid`),
  CONSTRAINT `FK_image_program` FOREIGN KEY (`image_pid`) REFERENCES `program` (`program_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (4,1,'/program/','直播图3.png',1377677753408,1),(5,1,'/program/','预告图3.png',1377677753408,0),(6,2,'/program/','精选图1.png',1377677743408,2),(7,1,'/program/','精选图2.png',1377677723408,2);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify_img`
--

DROP TABLE IF EXISTS `notify_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notify_img` (
  `notify_img_id` int(11) NOT NULL AUTO_INCREMENT,
  `notify_img_url` varchar(500) NOT NULL,
  `notify_img_name` varchar(100) NOT NULL,
  `notify_img_timestamp` bigint(20) NOT NULL,
  PRIMARY KEY (`notify_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify_img`
--

LOCK TABLES `notify_img` WRITE;
/*!40000 ALTER TABLE `notify_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `notify_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `program_id` int(11) NOT NULL AUTO_INCREMENT,
  `program_name` varchar(100) NOT NULL,
  `program_description` varchar(500) NOT NULL,
  `program_stime` time NOT NULL,
  `program_etime` time NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'有缘千里来交配','来交配来交配来交配来交配','19:05:00','20:00:00'),(2,'姐是老中医','老中医老中医老中医老中医','21:00:00','22:00:00');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_img`
--

DROP TABLE IF EXISTS `sale_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_img` (
  `sale_img_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_img_url` varchar(500) NOT NULL,
  `sale_img_name` varchar(100) NOT NULL,
  `sale_img_timestamp` bigint(20) NOT NULL,
  `sale_img_type` int(11) NOT NULL,
  PRIMARY KEY (`sale_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_img`
--

LOCK TABLES `sale_img` WRITE;
/*!40000 ALTER TABLE `sale_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(200) NOT NULL,
  `sns_id` bigint(20) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `profile_image_url` varchar(100) CHARACTER SET ucs2 DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `user_type` int(11) NOT NULL DEFAULT '0',
  `sns_type` varchar(10) NOT NULL,
  `caobi_count` bigint(20) NOT NULL DEFAULT '0',
  `redegg_count` int(11) NOT NULL DEFAULT '0',
  `blueegg_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'20130819',2000477001,'Luteeee',NULL,NULL,'m',1,'sina',0,0,0),(5,'20130800',2000477002,'zhubo',NULL,NULL,'m',0,'sina',0,0,0),(6,'20130710',2000477012,'test123',NULL,NULL,'m',1,'sina',0,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-28 17:24:59
