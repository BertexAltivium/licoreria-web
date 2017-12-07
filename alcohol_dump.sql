-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: alcohol
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Current Database: `alcohol`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `alcohol` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `alcohol`;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `colonia` varchar(45) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cart_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_cart_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_has_producto`
--

DROP TABLE IF EXISTS `cart_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_has_producto` (
  `cart_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`,`producto_id`),
  KEY `fk_cart_has_producto_producto1_idx` (`producto_id`),
  KEY `fk_cart_has_producto_cart1_idx` (`cart_id`),
  CONSTRAINT `fk_cart_has_producto_cart1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_has_producto_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_has_producto`
--

LOCK TABLES `cart_has_producto` WRITE;
/*!40000 ALTER TABLE `cart_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidor`
--

DROP TABLE IF EXISTS `distribuidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distribuidor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_distribuidor_address1_idx` (`address_id`),
  CONSTRAINT `fk_distribuidor_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuidor`
--

LOCK TABLES `distribuidor` WRITE;
/*!40000 ALTER TABLE `distribuidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `distribuidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `vendedor` varchar(45) DEFAULT NULL,
  `comprador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licor`
--

DROP TABLE IF EXISTS `licor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `subtipo` varchar(45) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `denominacion` varchar(45) DEFAULT NULL,
  `contenido_neto` varchar(45) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `image` varchar(2083) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licor`
--

LOCK TABLES `licor` WRITE;
/*!40000 ALTER TABLE `licor` DISABLE KEYS */;
INSERT INTO `licor` VALUES (1,'Tequila','Glenlivet','Escoses',12,2012,NULL,'750ml','Uno de los whiskies escoceses más reconocidos del mundo, Glenlivet es un whisky elegante de complejidad gratificante y sutil. El humo, el trébol, la miel y el brezo lo harán regresar una y otra vez.','2017-12-07 11:43:25','/home/bertex/image/f2ccf9b9-67b9-4b96-a7c2-e6c08a324d8eglenlivet.jpg','Whisky Glenlivet 700ml');
/*!40000 ALTER TABLE `licor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licorType`
--

DROP TABLE IF EXISTS `licorType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licorType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `licorType` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licorType`
--

LOCK TABLES `licorType` WRITE;
/*!40000 ALTER TABLE `licorType` DISABLE KEYS */;
INSERT INTO `licorType` VALUES (1,'Brandy'),(2,'Coñac'),(3,'Ginebra'),(4,'Mezcal'),(5,'Otro'),(6,'Tequila'),(7,'Vodka'),(8,'Whisky');
/*!40000 ALTER TABLE `licorType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licor_has_producto`
--

DROP TABLE IF EXISTS `licor_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licor_has_producto` (
  `licor_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  PRIMARY KEY (`licor_id`,`producto_id`),
  KEY `fk_licor_has_producto_producto1_idx` (`producto_id`),
  KEY `fk_licor_has_producto_licor1_idx` (`licor_id`),
  CONSTRAINT `fk_licor_has_producto_licor1` FOREIGN KEY (`licor_id`) REFERENCES `licor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_licor_has_producto_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licor_has_producto`
--

LOCK TABLES `licor_has_producto` WRITE;
/*!40000 ALTER TABLE `licor_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `licor_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(45) NOT NULL,
  `presentacion` varchar(45) NOT NULL,
  `id_distribuidor` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `factura_id` int(11) DEFAULT NULL,
  `sucursal_id` int(11) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `distribuidor_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_producto_factura1_idx` (`factura_id`),
  KEY `fk_producto_sucursal1_idx` (`sucursal_id`),
  KEY `fk_producto_distribuidor1_idx` (`distribuidor_id`),
  CONSTRAINT `fk_producto_distribuidor1` FOREIGN KEY (`distribuidor_id`) REFERENCES `distribuidor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_factura1` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_sucursal1` FOREIGN KEY (`sucursal_id`) REFERENCES `sucursal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sucursal_address1_idx` (`address_id`),
  CONSTRAINT `fk_sucursal_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `ap_paterno` varchar(45) NOT NULL,
  `ap_materno` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `admin` tinyint(1) DEFAULT '0',
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_usuario_address1_idx` (`address_id`),
  CONSTRAINT `fk_usuario_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'juan','juan','juan','bertex.altivium@gmail.com','juan1','2017-11-27 23:07:36',1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-07 13:48:18
