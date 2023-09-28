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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `is_available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Catcher in the Rye','J.D. Salinger',0),(2,'To Kill a Mockingbird','Harper Lee',1),(3,'1984','George Orwell',1),(4,'The Great Gatsby','F. Scott Fitzgerald',1),(5,'Pride and Prejudice','Jane Austen',1),(6,'The Hobbit','J.R.R. Tolkien',1),(7,'Harry Potter and the Sorcerer\'s Stone','J.K. Rowling',1),(8,'The Lord of the Rings','J.R.R. Tolkien',0),(9,'The Hunger Games','Suzanne Collins',1),(10,'Brave New World','Aldous Huxley',1),(11,'The Da Vinci Code','Dan Brown',0),(12,'The Shining','Stephen King',1),(13,'Gone Girl','Gillian Flynn',1),(14,'The Alchemist','Paulo Coelho',1),(15,'The Girl with the Dragon Tattoo','Stieg Larsson',1),(16,'Divergent','Veronica Roth',0),(17,'The Road','Cormac McCarthy',1),(18,'The Fault in Our Stars','John Green',1),(19,'The Martian','Andy Weir',1),(20,'The Chronicles of Narnia','C.S. Lewis',1),(21,'The Maze Runner','James Dashner',1),(22,'The Kite Runner','Khaled Hosseini',1),(23,'The Girl on the Train','Paula Hawkins',1),(24,'The Help','Kathryn Stockett',0),(25,'The Giver','Lois Lowry',1),(26,'The Road Less Traveled','M. Scott Peck',1),(27,'The Old Man and the Sea','Ernest Hemingway',1),(28,'A Song of Ice and Fire','George R.R. Martin',1),(29,'The Count of Monte Cristo','Alexandre Dumas',1),(30,'War and Peace','Leo Tolstoy',1),(31,'The Art of War','Sun Tzu',1),(32,'The Power of Habit','Charles Duhigg',1),(33,'The Girl with Seven Names','Hyeonseo Lee',1),(34,'The Nightingale','Kristin Hannah',1),(35,'The Secret Garden','Frances Hodgson Burnett',1),(36,'The Adventures of Sherlock Holmes','Arthur Conan Doyle',1),(37,'The Color Purple','Alice Walker',1),(38,'The Book Thief','Markus Zusak',1),(39,'The Joy Luck Club','Amy Tan',1),(40,'The Stranger','Albert Camus',1),(41,'The Road to Character','David Brooks',1),(42,'The Wind in the Willows','Kenneth Grahame',1),(43,'The Hound of the Baskervilles','Arthur Conan Doyle',1),(44,'The Glass Castle','Jeannette Walls',1),(45,'The Picture of Dorian Gray','Oscar Wilde',1),(46,'The Odyssey','Homer',1),(47,'The Scarlet Letter','Nathaniel Hawthorne',1),(48,'The Brothers Karamazov','Fyodor Dostoevsky',1),(49,'The Three Musketeers','Alexandre Dumas',1),(50,'The Metamorphosis','Franz Kafka',1),(51,'The Girl Who Played with Fire','Stieg Larsson',1),(52,'The Subtle Art of Not Giving a F*ck','Mark Manson',1),(53,'The Lovely Bones','Alice Sebold',1),(54,'The Sun Also Rises','Ernest Hemingway',1),(55,'The Night Circus','Erin Morgenstern',1),(56,'The Goldfinch','Donna Tartt',1),(57,'The Immortal Life of Henrietta Lacks','Rebecca Skloot',1),(58,'The Underground Railroad','Colson Whitehead',1),(59,'The Devil in the White City','Erik Larson',1),(60,'The Name of the Wind','Patrick Rothfuss',1),(61,'The Help','Kathryn Stockett',1),(62,'The Giver','Lois Lowry',1),(63,'The Road Less Traveled','M. Scott Peck',1),(64,'The Old Man and the Sea','Ernest Hemingway',1),(65,'A Song of Ice and Fire','George R.R. Martin',1),(66,'The Count of Monte Cristo','Alexandre Dumas',1),(67,'War and Peace','Leo Tolstoy',1),(68,'The Art of War','Sun Tzu',1),(69,'The Power of Habit','Charles Duhigg',1),(70,'The Girl with Seven Names','Hyeonseo Lee',1),(71,'The Nightingale','Kristin Hannah',1),(72,'The Secret Garden','Frances Hodgson Burnett',1),(73,'The Adventures of Sherlock Holmes','Arthur Conan Doyle',1),(74,'The Color Purple','Alice Walker',1),(75,'The Book Thief','Markus Zusak',1),(76,'The Joy Luck Club','Amy Tan',1),(77,'The Stranger','Albert Camus',1),(78,'The Road to Character','David Brooks',1),(79,'The Wind in the Willows','Kenneth Grahame',1),(80,'The Hound of the Baskervilles','Arthur Conan Doyle',1),(81,'The Glass Castle','Jeannette Walls',1),(82,'The Picture of Dorian Gray','Oscar Wilde',1),(83,'The Odyssey','Homer',1),(84,'The Scarlet Letter','Nathaniel Hawthorne',1),(85,'The Brothers Karamazov','Fyodor Dostoevsky',1),(86,'The Three Musketeers','Alexandre Dumas',1),(87,'The Metamorphosis','Franz Kafka',1),(88,'The Girl Who Played with Fire','Stieg Larsson',1),(89,'The Subtle Art of Not Giving a F*ck','Mark Manson',1),(90,'The Lovely Bones','Alice Sebold',1),(91,'The Sun Also Rises','Ernest Hemingway',1),(92,'The Night Circus','Erin Morgenstern',1),(93,'The Goldfinch','Donna Tartt',1),(94,'The Immortal Life of Henrietta Lacks','Rebecca Skloot',1),(95,'The Underground Railroad','Colson Whitehead',1),(96,'The Devil in the White City','Erik Larson',1),(97,'The Name of the Wind','Patrick Rothfuss',1),(98,'The Help','Kathryn Stockett',1),(99,'The Giver','Lois Lowry',1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
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
