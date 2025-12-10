-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: reservas_db
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Current Database: `reservas_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `reservas_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `reservas_db`;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_atualizacao` datetime(6) NOT NULL,
  `data_check_in` varchar(255) NOT NULL,
  `data_check_out` varchar(255) NOT NULL,
  `data_criacao` datetime(6) NOT NULL,
  `hotel_id` bigint NOT NULL,
  `status` enum('CANCELADA','CONFIRMADA','PENDENTE') NOT NULL,
  `usuario_id` bigint NOT NULL,
  `voo_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,'2025-10-01 10:00:00.000000','2025-12-20','2025-12-25','2025-10-01 10:00:00.000000',2,'CONFIRMADA',101,1),(2,'2025-10-02 11:30:00.000000','2025-12-23','2025-12-30','2025-10-02 11:30:00.000000',3,'PENDENTE',102,3),(3,'2025-10-03 09:15:00.000000','2025-12-26','2025-12-28','2025-10-03 09:15:00.000000',4,'CONFIRMADA',103,5),(4,'2025-10-05 08:00:00.000000','2025-12-24','2025-12-29','2025-10-04 14:00:00.000000',9,'CANCELADA',104,4),(5,'2025-10-01 15:45:00.000000','2025-12-20','2025-12-27','2025-10-01 15:45:00.000000',6,'CONFIRMADA',105,1);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `hoteis_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hoteis_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `hoteis_db`;

--
-- Table structure for table `hoteis`
--

DROP TABLE IF EXISTS `hoteis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoteis` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cidade` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `estrelas` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteis`
--

LOCK TABLES `hoteis` WRITE;
/*!40000 ALTER TABLE `hoteis` DISABLE KEYS */;
INSERT INTO `hoteis` VALUES (1,'São Paulo','Rua das Flores, 123',5,'Hotel Paraíso'),(2,'Rio de Janeiro','Av. Beira Mar, 456',4,'Pousada Tranquilidade'),(3,'Salvador','Praia do Sol, 789',5,'Resort Tropical'),(4,'São Paulo','Av. Paulista, 1000',4,'Hotel Executivo'),(5,'Campos do Jordão','Estrada da Serra, 500',3,'Pousada Serra Verde'),(6,'Rio de Janeiro','Av. Atlântica, 1702',5,'Hotel Copacabana Palace'),(7,'Salvador','Rodovia BA-099, km 76',5,'Resort Costa do Sauípe'),(8,'Belo Horizonte','Zona Rural, s/n',4,'Hotel Fazenda Boa Vista'),(9,'Gramado','Rua das Acácias, 88',4,'Pousada do Arvoredo'),(10,'Curitiba','Rua XV de Novembro, 300',3,'Hotel Urbano Center');
/*!40000 ALTER TABLE `hoteis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartos`
--

DROP TABLE IF EXISTS `quartos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quartos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacidade` int NOT NULL,
  `disponivel` bit(1) NOT NULL,
  `numero` int NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `valor_reserva` decimal(10,2) NOT NULL,
  `hotel_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcctexby9rs8gqqctcowl3d5jt` (`numero`),
  KEY `FKl58c8wy7e9gh2spj3drkmm535` (`hotel_id`),
  CONSTRAINT `FKl58c8wy7e9gh2spj3drkmm535` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartos`
--

LOCK TABLES `quartos` WRITE;
/*!40000 ALTER TABLE `quartos` DISABLE KEYS */;
INSERT INTO `quartos` VALUES (1,2,_binary '',501,'Suite Luxo',450.00,1),(2,2,_binary '',302,'Standard',250.00,1),(3,4,_binary '',405,'Família',380.00,1),(4,3,_binary '',601,'Suite Presidencial',850.00,1),(5,2,_binary '\0',203,'Executivo',320.00,1),(6,2,_binary '',301,'Suite Master',350.00,2),(7,1,_binary '',105,'Simples',180.00,2),(8,2,_binary '',208,'Duplo',220.00,2),(9,2,_binary '\0',402,'Suite Vista Jardim',280.00,2),(10,3,_binary '',101,'Premium',650.00,3),(11,2,_binary '',205,'Suite Vista Mar',550.00,3),(12,2,_binary '',310,'Standard',380.00,3),(13,6,_binary '',3501,'Villa Privativa',1200.00,3),(14,2,_binary '',401,'Executivo',420.00,4),(15,2,_binary '',305,'Standard',280.00,4),(16,1,_binary '',210,'Single',200.00,4),(17,2,_binary '',102,'Confort',320.00,5),(18,4,_binary '',5205,'Família',480.00,5),(19,2,_binary '\0',308,'Standard',250.00,5),(20,2,_binary '',801,'Suite Imperial',980.00,6),(21,2,_binary '',705,'Suite Deluxe',720.00,6),(22,2,_binary '',610,'Superior',580.00,6),(23,4,_binary '',201,'Premium',890.00,7),(24,2,_binary '',7305,'Suite Premium',680.00,7),(25,2,_binary '',410,'Standard',450.00,7),(26,3,_binary '',8105,'Confort',380.00,8),(27,2,_binary '',8208,'Standard',280.00,8),(28,2,_binary '\0',8301,'Suite Panorâmica',420.00,8),(29,2,_binary '',9201,'Suite Romântica',450.00,9),(30,2,_binary '',9305,'Standard',320.00,9),(31,4,_binary '',9410,'Família',520.00,9),(32,2,_binary '',10105,'Econômico',180.00,10),(33,2,_binary '',10210,'Standard',240.00,10),(34,2,_binary '\0',315,'Executivo',350.00,10);
/*!40000 ALTER TABLE `quartos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `voos_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `voos_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `voos_db`;

--
-- Table structure for table `assentos`
--

DROP TABLE IF EXISTS `assentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assentos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `disponivel` bit(1) NOT NULL,
  `nome_passageiro` varchar(255) DEFAULT NULL,
  `numero_assento` varchar(255) NOT NULL,
  `voo_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfxk8ga2b8wxqysqou3074jkw7` (`voo_id`),
  CONSTRAINT `FKfxk8ga2b8wxqysqou3074jkw7` FOREIGN KEY (`voo_id`) REFERENCES `voos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assentos`
--

LOCK TABLES `assentos` WRITE;
/*!40000 ALTER TABLE `assentos` DISABLE KEYS */;
INSERT INTO `assentos` VALUES (1,_binary '',NULL,'1A',1),(2,_binary '\0','Carlos Silva','1B',1),(3,_binary '',NULL,'1C',1),(4,_binary '\0','Ana Pereira','2A',1),(5,_binary '',NULL,'10A',2),(6,_binary '',NULL,'10B',2),(7,_binary '\0','Roberto Costa','10C',2),(8,_binary '',NULL,'1F',3),(9,_binary '',NULL,'2F',3),(10,_binary '\0','Fernanda Lima','3F',3),(11,_binary '',NULL,'5A',4),(12,_binary '',NULL,'5B',4),(13,_binary '',NULL,'12C',5),(14,_binary '\0','Lucas Martins','12D',5);
/*!40000 ALTER TABLE `assentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voos`
--

DROP TABLE IF EXISTS `voos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacidade_total` int NOT NULL,
  `companhia_aerea` varchar(255) NOT NULL,
  `data_hora_chegada` varchar(255) NOT NULL,
  `data_hora_partida` varchar(255) NOT NULL,
  `destino` varchar(255) NOT NULL,
  `numero_voo` varchar(255) NOT NULL,
  `origem` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK59yfcwhx7lg3pt3gsn7jcbdrt` (`numero_voo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voos`
--

LOCK TABLES `voos` WRITE;
/*!40000 ALTER TABLE `voos` DISABLE KEYS */;
INSERT INTO `voos` VALUES (1,150,'Latam','2025-12-20 09:00:00','2025-12-20 08:00:00','Rio de Janeiro','LA3001','São Paulo'),(2,150,'Latam','2025-12-22 19:00:00','2025-12-22 18:00:00','São Paulo','LA3002','Rio de Janeiro'),(3,180,'Gol','2025-12-23 12:30:00','2025-12-23 10:00:00','Salvador','GL1550','São Paulo'),(4,120,'Azul','2025-12-24 16:30:00','2025-12-24 14:00:00','Gramado','AZ4004','Belo Horizonte'),(5,150,'Gol','2025-12-26 08:00:00','2025-12-26 07:00:00','São Paulo','GL1600','Curitiba');
/*!40000 ALTER TABLE `voos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-10  0:21:57
