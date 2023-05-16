-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: springproject
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `job`

--

use heroku_2d3045d2dca9ac1;
DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `application_guideline` varchar(255) DEFAULT NULL,
  `category` varchar(255) NOT NULL,
  `company_email` varchar(255) NOT NULL,
  `deadline` varchar(255) NOT NULL,
  `experience` varchar(255) NOT NULL,
  `job_description` varchar(255) NOT NULL,
  `job_title` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `skill` varchar(255) NOT NULL,
  `employer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr2839ti65mk0m9ihxynack3pn` (`employer_id`),
  CONSTRAINT `FKr2839ti65mk0m9ihxynack3pn` FOREIGN KEY (`employer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'IT Position guidelines.pdf','IT','munezerowilly5@gmail.com','2023-05-18','3','Support abroad client via virtual machine','Technical Support','2','Kiyovu','0782088965','Linux',2),(2,'Business Position guidelines.pdf','Business','dedehope0@gmail.com','2023-05-27','1','Provide salaries for stakeholders','Accountant','2','nyamirambo','0782088911','Stastistics',2),(3,'Health Care Position.pdf','Healthcare','cyuzuzoisimbiritah@gmail.com','2023-06-14','2','work with doctors during night shift','Nurse','2','Kanombe','0782088900','Clinical competence',2),(4,'gvt and Public service guidelines.pdf','Gvt and Public Service','manzidakimo@gmail.com','2023-07-13','6','leads international meetings','Senator','5','Kabeza','0789334567','Leadership',4),(5,'Trade and Construction guidelines.pdf','Trades and Construction','kennyrogers330@gmail.com','2023-06-06','2','transport goods from rural to urban areas','Rural-urban trader','1','Rubavu','0782088977','driving license',4),(6,'science and engineering guidelines.pdf','Science and Engineering','munezerowilly6@gmail.com','2023-08-24','4','design new houses in Kanombe','Civil engineer','3','Kanombe','0789088960','Design and planning',4);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_JOB_SEEKER'),(2,'ROLE_EMPLOYEER'),(3,'ROLE_OPERATIONS_MANAGER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'john@gmail.com','John','Doe','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','0783445678','john'),(2,'mary@gmail.com','Mary','Public','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','0798345672','mary'),(3,'susan@gmail.com','Susan','Adams','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','0788967354','susan'),(4,'willy@gmail.com','Hirwa','Willy','$2a$10$9X9uR6jF3zIlqJkfAIdqYOJCkt/0Hu9rYSz0St/shl73x7jcnMb7O','0782088965','willy'),(5,'christel@gmail.com','Ihirwe','Christel','$2a$10$7LNHq1k6jxH/16Wm.KViH.40LhpXb3m4tpIUU9ZoSo3R/9nNQMwdS','0782088000','christel'),(6,'ange@gmail.com','Umutoni','Ange','$2a$10$klnfn1MNd7fe3sAZSl2mTeVwRBM2L6wEbqq3e3OHrhP.SwKZtHgCq','0782000965','ange');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(2,2),(3,1),(3,2),(3,3),(4,2),(5,2),(5,1),(6,2),(6,1),(6,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-16 16:14:40
