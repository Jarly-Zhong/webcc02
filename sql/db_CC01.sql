-- MySQL dump 10.15  Distrib 10.0.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db_CC01
-- ------------------------------------------------------
-- Server version	10.0.23-MariaDB-0ubuntu0.15.10.1

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
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aName` varchar(20) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'zhong','admin'),(2,'liang','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_course`
--

DROP TABLE IF EXISTS `tb_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_course` (
  `course_id` bigint(20) unsigned NOT NULL,
  `course_name` varchar(40) DEFAULT NULL,
  `course_time` varchar(40) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `current_size` int(11) DEFAULT NULL,
  `max_size` int(11) DEFAULT NULL,
  `exam_time` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_course`
--

LOCK TABLES `tb_course` WRITE;
/*!40000 ALTER TABLE `tb_course` DISABLE KEYS */;
INSERT INTO `tb_course` VALUES (1,'Java核心编程','1-10周周五12节',1,1,91,100,''),(2,'SQL必知必会','11-20周周三12节',1,4,60,60,NULL),(3,'Jsp和Servlet','1-10周周三12节',2,1,78,80,NULL),(5,'Spring 实战','1-10周周五12节',3,1,60,70,NULL),(6,'Mybatis 实例','11-20周周一12节',3,2,100,100,NULL),(7,'测试课程','1-10周周二12节',1,2,100,100,'测试-测试'),(8,'测试课程2','1-10周周三12节',1,4,100,100,NULL),(9,'测试结课1','1-10周周四12节',2,3,100,100,'5月12日 五教'),(10,'测试结课2','1-10周周三34节',3,3,100,100,'5月13日 三教'),(11,'自动控制理论','1-10周周五34节',2,1,21,100,NULL),(12,'反馈控制理论','1-10周周五56节',2,1,30,100,NULL),(13,'线性代数','1-10周周五78节',3,1,40,100,NULL),(14,'高等数学','1-10周周五56节',4,1,49,100,NULL),(19,'测试结课1','1-10周 ',1,3,100,100,'测试考试时间-考试地点'),(20,'test20','123',0,1,0,0,NULL),(21,'test1','123',0,1,0,0,'');
/*!40000 ALTER TABLE `tb_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stucourse`
--

DROP TABLE IF EXISTS `tb_stucourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stucourse` (
  `stuID` int(10) unsigned DEFAULT NULL,
  `courseID` int(10) unsigned DEFAULT NULL,
  `id` bigint(20) unsigned NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stucourse`
--

LOCK TABLES `tb_stucourse` WRITE;
/*!40000 ALTER TABLE `tb_stucourse` DISABLE KEYS */;
INSERT INTO `tb_stucourse` VALUES (6,1,3,100),(11,1,4,1),(10,1,5,2),(12,1,6,3),(12,2,7,70),(5,2,9,70),(1,2,10,70),(5,9,39,100),(5,10,40,0),(5,19,41,99),(4,19,42,99),(3,20,43,88),(5,20,44,99),(5,1,45,NULL);
/*!40000 ALTER TABLE `tb_stucourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stuuser`
--

DROP TABLE IF EXISTS `tb_stuuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stuuser` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stuName` varchar(20) DEFAULT NULL,
  `stuNo` varchar(15) DEFAULT NULL,
  `stuSex` int(11) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stuuser`
--

LOCK TABLES `tb_stuuser` WRITE;
/*!40000 ALTER TABLE `tb_stuuser` DISABLE KEYS */;
INSERT INTO `tb_stuuser` VALUES (1,'方方','133333',1,'1993-01-01','13900000009','123'),(2,'静静静','122222',1,'1999-9-9','12345678999','123'),(3,'红红','233333',1,'1993-01-01','0431-84972266','123'),(4,'小军','123123',1,'1993-01-01','zhong','123'),(5,'良研','123456',1,'1993-08-19','13900000009','202cb962ac59075b964b07152d234b70'),(6,'建军','2342',1,NULL,NULL,'123'),(7,'志明','2343',1,NULL,NULL,'123'),(8,'春娇','454654',0,NULL,NULL,'123'),(9,'石头','23432',1,NULL,NULL,'123'),(10,'怪兽','3453',1,NULL,NULL,'123'),(11,'阿信','3432',1,NULL,NULL,'123'),(12,'明明','007',0,'1993-08-01','0431-84972266','123'),(13,'刘亭','234567',0,'1993-01-01','0987654','123'),(18,'测试学生',NULL,NULL,NULL,NULL,NULL),(19,'测试学生2',NULL,NULL,NULL,NULL,NULL),(21,'测试学生3','123',1,'44433','1234466','123'),(22,'zhong','123',1,'1993','1234567890','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `tb_stuuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_teauser`
--

DROP TABLE IF EXISTS `tb_teauser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_teauser` (
  `id` bigint(20) unsigned NOT NULL,
  `teaName` varchar(20) DEFAULT NULL,
  `teaNo` varchar(15) DEFAULT NULL,
  `teaSex` int(11) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_teauser`
--

LOCK TABLES `tb_teauser` WRITE;
/*!40000 ALTER TABLE `tb_teauser` DISABLE KEYS */;
INSERT INTO `tb_teauser` VALUES (1,'李梅','123456',0,'1980-01-01','zhong','202cb962ac59075b964b07152d234b70'),(2,'张凤','333333',0,'1988-01-01','13800000003','123456'),(3,'刘亭','222222',0,'1993-01-01','13800000002','123456'),(4,'吴飞','444444',1,'1993-01-01','13800000002','123456'),(5,'测试教师','test',1,'test','teste',''),(8,'测试教师2',NULL,NULL,NULL,NULL,NULL),(9,'测试教师3',NULL,NULL,NULL,NULL,NULL),(10,'测试教师4',NULL,NULL,NULL,NULL,NULL),(11,'测试添加','123',1,NULL,NULL,'123'),(12,'测试添加老师','123',1,NULL,NULL,'123'),(13,'测试老师','123',1,NULL,NULL,'123'),(14,'测试老师','123',1,NULL,NULL,'123'),(15,'测试添加','123',1,'123','123123123','123');
/*!40000 ALTER TABLE `tb_teauser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-18 11:21:37
