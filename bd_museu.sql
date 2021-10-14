CREATE DATABASE  IF NOT EXISTS `bd_museu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_museu`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_museu
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `tb_admmarketing`
--

DROP TABLE IF EXISTS `tb_admmarketing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_admmarketing` (
  `cod_adm` int NOT NULL AUTO_INCREMENT,
  `at_nome` varchar(40) NOT NULL,
  `at_email` varchar(40) NOT NULL,
  `at_senha` char(8) NOT NULL,
  PRIMARY KEY (`cod_adm`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admmarketing`
--

LOCK TABLES `tb_admmarketing` WRITE;
/*!40000 ALTER TABLE `tb_admmarketing` DISABLE KEYS */;
INSERT INTO `tb_admmarketing` VALUES (1,'Daniel Machado','danielmachado3fs@gmail.com','29736987');
/*!40000 ALTER TABLE `tb_admmarketing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_visitante`
--

DROP TABLE IF EXISTS `tb_visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_visitante` (
  `cod_visitante` int NOT NULL AUTO_INCREMENT,
  `at_nome` varchar(40) NOT NULL,
  `at_email` varchar(40) NOT NULL,
  `at_senha` char(64) NOT NULL,
  `at_localizacao` varchar(50) NOT NULL,
  `at_status` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_visitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_visitante`
--

LOCK TABLES `tb_visitante` WRITE;
/*!40000 ALTER TABLE `tb_visitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_visitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_museu'
--

--
-- Dumping routines for database 'bd_museu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-13 21:25:41
