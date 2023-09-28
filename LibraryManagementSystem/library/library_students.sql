-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `books_issued` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'John Smith',0),(2,'Jane Doe',0),(3,'Bob Johnson',0),(4,'Alice Lee',0),(5,'David Kim',0),(6,'Emily Chen',0),(7,'Michael Brown',0),(8,'Olivia Davis',0),(9,'Sophia Wilson',0),(10,'William Garcia',0),(11,'Ava Rodriguez',0),(12,'Benjamin Martinez',0),(13,'Charlotte Hernandez',0),(14,'Daniel Lopez',0),(15,'Ella Gonzalez',0),(16,'Frank Perez',0),(17,'Grace Taylor',0),(18,'Henry Anderson',0),(19,'Isabella Thomas',0),(20,'Jacob Jackson',0),(21,'Kaylee White',0),(22,'Liam Harris',0),(23,'Mia Martin',0),(24,'Noah Thompson',0),(25,'Oliver Moore',0),(26,'Penelope Allen',0),(27,'Quinn Nelson',0),(28,'Ryan Carter',0),(29,'Samantha Mitchell',0),(30,'Thomas Perez',0),(31,'Uma Patel',0),(32,'Victoria Cooper',0),(33,'William Green',0),(34,'Xavier King',0),(35,'Yara Ramirez',0),(36,'Zachary Scott',0),(37,'Avery Baker',0),(38,'Brooklyn Turner',0),(39,'Caleb Parker',0),(40,'Daisy Collins',0);
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

-- Dump completed on 2023-09-29  1:30:24
