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
  `premium` int DEFAULT NULL,
  `table` int DEFAULT NULL,
  `blue` int DEFAULT NULL,
  `red` int DEFAULT NULL,
  `navy` int DEFAULT NULL,
  `green` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'LG트윈스 vs 한화이글스','잠실야구장','2023-07-29 14:25:00',261,502,2370,6398,10112,5812),(2,'SSG 랜더스 vs 두산베어스','인천 SSG 랜더스 필드','2023-07-24 15:45:00',3,203,349,2034,6002,3466),(3,'KIA 타이거즈 vs 삼성 라이온즈','KIA 챔피언스필드','2023-07-22 14:00:00',34,273,2100,5323,2323,3432),(4,'KIA 타이거즈 vs 두산베어스','KIA 챔피언스필드','2023-07-25 16:30:00',234,402,343,3432,3534,2235),(5,'kt wiz vs 롯데 자이언츠','수원 케이티 위즈 파크','2023-07-15 14:20:00',115,233,453,823,4234,5434);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (2,1,'blue',220,34),(4,1,'green',401,1),(6,1,'premium',0,344),(7,1,'red',219,2),(9,1,'blue',216,304),(10,1,'navy',320,453),(11,1,'table',213,233),(12,1,'navy',304,24),(13,1,'navy',302,3),(14,1,'red',220,1),(16,1,'green',401,1),(17,1,'table',110,2),(18,1,'blue',107,1),(19,1,'blue',107,1),(20,1,'premium',0,1),(21,5,'table',112,2),(23,2,'premium',0,1),(24,2,'table',100,1),(26,3,'red',101,1),(27,2,'navy',334,1),(28,3,'red',101,1),(29,5,'table',110,6),(31,1,'red',101,1);
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
INSERT INTO `user` VALUES (1,5),(2,1),(3,2),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
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

-- Dump completed on 2023-07-17  9:11:52
