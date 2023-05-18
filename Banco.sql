CREATE DATABASE  IF NOT EXISTS `banco_exemplo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banco_exemplo`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_exemplo
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
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `cor` varchar(35) NOT NULL,
  `valor` decimal(6,2) unsigned NOT NULL,
  `ano` int unsigned NOT NULL,
  `montadora_id` int unsigned NOT NULL,
  `marca_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `montadora_id` (`montadora_id`),
  KEY `marca_id` (`marca_id`),
  CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`montadora_id`) REFERENCES `montadora` (`id`),
  CONSTRAINT `carro_ibfk_2` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,'BMW X6','Azul',30.95,1995,1,1),(2,'Cerato','Vermelho',20.00,2010,3,2);
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `estado_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `estado_id` (`estado_id`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Belford Rocho',2),(3,'Manaus',4);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  `regiao` enum('Norte','Nordeste','Centro-Oeste','Sudeste','Sul') NOT NULL,
  `populacao` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  UNIQUE KEY `sigla` (`sigla`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Alagoas','AL','Nordeste',3.38),(2,'Rio de Janeiro','RJ','Sudeste',1.00),(4,'Amazonas','AM','Norte',1.20),(6,'asfsdas','ii','Norte',9.20);
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sede` varchar(50) NOT NULL,
  `valor` decimal(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'BMW','Alemanha',41631.00),(2,'Kia','Coreia do Sul',6612.00);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mont_resp`
--

DROP TABLE IF EXISTS `mont_resp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mont_resp` (
  `montadora_id` int unsigned NOT NULL,
  `responsavel_id` int unsigned NOT NULL,
  KEY `montadora_id` (`montadora_id`),
  KEY `responsavel_id` (`responsavel_id`),
  CONSTRAINT `mont_resp_ibfk_1` FOREIGN KEY (`montadora_id`) REFERENCES `montadora` (`id`),
  CONSTRAINT `mont_resp_ibfk_2` FOREIGN KEY (`responsavel_id`) REFERENCES `responsavel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mont_resp`
--

LOCK TABLES `mont_resp` WRITE;
/*!40000 ALTER TABLE `mont_resp` DISABLE KEYS */;
/*!40000 ALTER TABLE `mont_resp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `montadora`
--

DROP TABLE IF EXISTS `montadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `montadora` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cidade_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cidade_id` (`cidade_id`),
  CONSTRAINT `montadora_ibfk_1` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `montadora`
--

LOCK TABLES `montadora` WRITE;
/*!40000 ALTER TABLE `montadora` DISABLE KEYS */;
INSERT INTO `montadora` VALUES (1,'Less Auto',3),(3,'Fc Cars',1);
/*!40000 ALTER TABLE `montadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsavel`
--

DROP TABLE IF EXISTS `responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsavel` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `passe` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `passe` (`passe`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsavel`
--

LOCK TABLES `responsavel` WRITE;
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
INSERT INTO `responsavel` VALUES (1,'Manoel Gomez',1745),(4,'Jussara MAria',3232),(5,'Andersson Ventura',2547),(7,'Ana Maria',2317);
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 12:07:17
