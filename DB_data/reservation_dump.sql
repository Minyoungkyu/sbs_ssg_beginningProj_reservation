CREATE DATABASE  IF NOT EXISTS `reservation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reservation`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (x86_64)
--
-- Host: localhost    Database: reservation
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `stadium` varchar(45) NOT NULL,
  `dateAndTime` datetime NOT NULL,
  `premium` int DEFAULT '264',
  `table` int DEFAULT '502',
  `blue` int DEFAULT '2373',
  `red` int DEFAULT '6399',
  `navy` int DEFAULT '10112',
  `green` int DEFAULT '5813',
  `opponent_club_num` int DEFAULT NULL,
  `home_club_num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (10,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-01 18:30:00',264,502,2373,6399,10112,5813,9,10),(11,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-02 18:30:00',264,502,2373,6399,10112,5813,9,10),(12,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-03 18:30:00',264,502,2373,6399,10112,5813,9,10),(13,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-04 18:30:00',264,502,2373,6399,10112,5813,10,5),(14,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-05 18:00:00',264,502,2373,6399,10112,5813,10,5),(15,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-06 17:00:00',264,502,2373,6399,10112,5813,10,5),(16,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-08 18:30:00',264,502,2373,6399,10112,5813,10,4),(17,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-09 18:30:00',264,502,2373,6399,10112,5813,10,4),(18,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-10 18:30:00',264,502,2373,6399,10112,5813,10,4),(19,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-11 18:30:00',264,502,2373,6399,10112,5813,9,10),(20,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-12 18:00:00',264,502,2373,6399,10112,5813,9,10),(21,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-13 17:00:00',264,502,2373,6399,10112,5813,9,10),(22,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-15 17:00:00',264,502,2373,6399,10112,5813,10,6),(23,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-16 18:30:00',264,502,2373,6399,10112,5813,10,6),(24,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-17 18:30:00',264,502,2373,6399,10112,5813,10,6),(25,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-18 18:30:00',264,502,2373,6399,10112,5813,4,10),(26,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-19 18:00:00',264,502,2373,6399,10112,5813,4,10),(27,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-20 17:00:00',264,502,2373,6399,10112,5813,4,10),(28,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-22 18:30:00',264,502,2373,6399,10112,5813,7,10),(29,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-23 18:30:00',264,502,2373,6399,10112,5813,7,10),(30,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-24 18:30:00',264,502,2373,6399,10112,5813,7,10),(31,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-25 18:30:00',264,502,2373,6399,10112,5813,10,5),(32,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-26 18:00:00',264,502,2373,6399,10112,5813,10,5),(33,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-27 17:00:00',264,502,2373,6399,10112,5813,10,5),(34,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-29 18:30:00',264,502,2373,6399,10112,5813,8,10),(35,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-30 18:30:00',264,502,2373,6399,10112,5813,8,10),(36,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-31 18:30:00',264,502,2373,6399,10112,5813,8,10);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `park_info`
--

DROP TABLE IF EXISTS `park_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `park_info` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` tinytext NOT NULL,
  `food` longtext NOT NULL,
  `traffic_busstop` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `traffic_bus` longtext,
  `traffic_sub` longtext,
  `traffic_parking` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `park_info`
--

LOCK TABLES `park_info` WRITE;
/*!40000 ALTER TABLE `park_info` DISABLE KEYS */;
INSERT INTO `park_info` VALUES (1,'한화생명 이글스파크','대전 중구 대종로 373 (지번) 대사동84-4','빅찹핫도그,\r\n친절한스낵바,\r\n세븐일레븐,\r\n멕시카나치킨,\r\n스트릿츄러스,\r\n허니빈스,\r\n농심가락,\r\n이글스 브루어리,\r\n세븐일레븐,\r\n이글스 브루어리,\r\n스테프핫도그,\r\n스테이인터뷰,\r\n세븐일레븐,\r\n멕시카나치킨,\r\n오수리,\r\n신전떡볶이,\r\n이글스 브루어리,\r\n멕시카나치킨,\r\n세븐일레븐,\r\n장충동왕족발,\r\n푸드공감,\r\n멕시카나치킨,\r\n수리마카롱','한화생명이글스파크(23300), \r\n한화생명이글스파크(21050), \r\n한밭종합운동장(21090)','(일반)809,\r\n(일반)119,\r\n(일반)802,\r\n(일반)513,\r\n(일반)604,\r\n(급행)2,\r\n(외곽)52','',''),(2,'광주 - 기아 챔피언스 필드','광주 북구 서림로 10','CU,\r\n교촌치킨,\r\nXOXO핫도그, \r\n비스트로펍,\r\n마성떡볶이,\r\n스테이크펍,\r\n광주제일햄버고,\r\n빅토리펍','광주 -기아 챔피언스 필드 정류소','풍암16,\r\n일곡38,\r\n운림51,\r\n금남58,\r\n임곡89,\r\n첨단95,\r\n송정98,\r\n지원151','광주 - 기아 챔피언스 필드 정류소','');
/*!40000 ALTER TABLE `park_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservationID` int NOT NULL AUTO_INCREMENT,
  `gameID` int NOT NULL,
  `seatType` char(7) DEFAULT NULL,
  `seatBlock` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`reservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (2,1,'blue',220,34),(4,1,'green',401,1),(6,1,'premium',0,344),(7,1,'red',219,2),(9,1,'blue',216,304),(10,1,'navy',320,453),(11,1,'table',213,233),(12,1,'navy',304,24),(13,1,'navy',302,3),(14,1,'red',220,1),(16,1,'green',401,1),(17,1,'table',110,2),(18,1,'blue',107,1),(19,1,'blue',107,1),(20,1,'premium',0,1),(21,5,'table',112,2),(23,2,'premium',0,1),(24,2,'table',100,1),(26,3,'red',101,1),(27,2,'navy',334,1),(28,3,'red',101,1),(29,5,'table',110,6),(31,1,'red',101,1),(32,4,'blue',107,1),(33,1,'green',401,1);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `seatType` char(10) NOT NULL,
  `seatBlockScope` varchar(100) DEFAULT NULL,
  `weekdayPrice` int NOT NULL,
  `weekendPrice` int NOT NULL,
  PRIMARY KEY (`seatType`),
  UNIQUE KEY `seatBlockScope_UNIQUE` (`seatBlockScope`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES ('blue','107~109, 114~116, 209~211, 216~218',15000,17000),('green','401~422',7000,8000),('navy','301 ~ 334',10000,12000),('premium',NULL,70000,70000),('red','101~106, 117~122, 201~208, 219~226',12000,14000),('table','110~112, 212~215',40000,45000);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL,
  `preferredClubNum` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,10),(2,1),(3,2),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
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

-- Dump completed on 2023-07-18 13:36:34
