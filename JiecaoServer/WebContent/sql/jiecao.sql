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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_iid` int(11) NOT NULL,
  `comment_uid` int(11) NOT NULL,
  `comment_content` varchar(70) NOT NULL,
  `comment_timeline` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK_comment_item_idx` (`comment_iid`),
  KEY `FK_comment_user_idx` (`comment_uid`),
  CONSTRAINT `FK_comment_item` FOREIGN KEY (`comment_iid`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_comment_user` FOREIGN KEY (`comment_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host` (
  `host_id` int(11) NOT NULL AUTO_INCREMENT,
  `host_uid` int(11) NOT NULL,
  `host_pid` int(11) NOT NULL,
  `host_password` varchar(45) NOT NULL,
  `host_name` varchar(45) NOT NULL,
  `host_description` varchar(300) NOT NULL,
  `host_head_url` varchar(300) NOT NULL,
  PRIMARY KEY (`host_id`),
  KEY `FK_host_program_idx` (`host_pid`),
  KEY `FK_host_user_idx` (`host_uid`),
  CONSTRAINT `FK_host_program` FOREIGN KEY (`host_pid`) REFERENCES `program` (`program_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_host_user` FOREIGN KEY (`host_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,6,2,'123','test123','我是test123','/head/1.png'),(2,4,1,'123','Luteeee','我是Luteeee','/head/2.png');
/*!40000 ALTER TABLE `host` ENABLE KEYS */;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_iid` int(11) NOT NULL,
  `image_url` varchar(500) NOT NULL,
  `image_name` varchar(100) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK_image_item_idx` (`image_iid`),
  CONSTRAINT `FK_image_item` FOREIGN KEY (`image_iid`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--


/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,1,'/resources/item/','live3.png'),(2,2,'/resources/item/','live2.jpg'),(3,3,'/resources/item/','live1.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;


--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_pid` int(11) NOT NULL,
  `item_hid` int(11) NOT NULL,
  `item_listener_count` int(11) NOT NULL DEFAULT '0',
  `item_red_count` int(11) NOT NULL DEFAULT '0',
  `item_blue_count` int(11) NOT NULL DEFAULT '0',
  `item_date` date NOT NULL,
  `item_collection` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`),
  KEY `FK_item_program_idx` (`item_pid`),
  KEY `FK_item_host_idx` (`item_hid`),
  CONSTRAINT `FK_item_host` FOREIGN KEY (`item_hid`) REFERENCES `host` (`host_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_item_program` FOREIGN KEY (`item_pid`) REFERENCES `program` (`program_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--


/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,2,1,0,0,0,'2013-09-08',0),(2,2,1,0,0,0,'2013-09-07',0),(3,1,2,0,0,0,'2013-09-08',0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Table structure for table `listener`
--

DROP TABLE IF EXISTS `listener`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listener` (
  `listener_id` int(11) NOT NULL AUTO_INCREMENT,
  `listener_uid` int(11) NOT NULL,
  `listener_iid` int(11) NOT NULL,
  `listener_limit` int(11) NOT NULL,
  PRIMARY KEY (`listener_id`),
  KEY `FK_listener_user_idx` (`listener_uid`),
  KEY `FK_listener_item_idx` (`listener_iid`),
  CONSTRAINT `FK_listener_item` FOREIGN KEY (`listener_iid`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_listener_user` FOREIGN KEY (`listener_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listener`
--


/*!40000 ALTER TABLE `listener` DISABLE KEYS */;
/*!40000 ALTER TABLE `listener` ENABLE KEYS */;


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


/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'有缘千里来交配','来交配来交配来交配来交配','19:05:00','20:00:00'),(2,'姐是老中医','老中医老中医老中医老中医','21:00:00','22:00:00');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;


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
  `caobi_count` bigint(20) NOT NULL DEFAULT '100',
  `red_count` int(11) NOT NULL DEFAULT '5',
  `blue_count` int(11) NOT NULL DEFAULT '3',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'20130819',2000477001,'abcde',NULL,NULL,'m',1,'sina',100,2,2),(5,'20130800',2000477002,'zhubo',NULL,NULL,'m',0,'sina',100,5,3),(6,'20130710',2000477012,'test123',NULL,NULL,'m',1,'sina',100,5,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-08 16:54:53
