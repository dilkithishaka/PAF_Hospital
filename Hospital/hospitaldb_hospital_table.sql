-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitaldb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `hospital_table`
--

DROP TABLE IF EXISTS `hospital_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_table` (
  `hospitalID` int NOT NULL AUTO_INCREMENT,
  `hospitalName` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contactNumber` varchar(20) NOT NULL,
  PRIMARY KEY (`hospitalID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_table`
--

LOCK TABLES `hospital_table` WRITE;
/*!40000 ALTER TABLE `hospital_table` DISABLE KEYS */;
INSERT INTO `hospital_table` VALUES (2,'Asiri hospital','Matara','Galle Road,Matara','asiriLk@gmail.com','0413355687'),(3,'Southern hospital','Galle','Wakwella Road,Galle','southern@gmail.com','0912255660'),(4,'Nawaloka hospital','Colombo','Galle Road,colombo2','nawaloka@gmail.com','0117744983'),(5,'Lanka hospitals','Colombo','Galle Road,Colombo','lankahos@gmail.com','0116754345'),(6,'Apollo hospital','Colombo 5','Gunadasa Mawatha,colombo 5','apollo@gmail.com','0113355754');
/*!40000 ALTER TABLE `hospital_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-05 23:42:05
