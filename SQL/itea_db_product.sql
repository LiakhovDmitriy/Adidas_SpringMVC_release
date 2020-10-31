CREATE DATABASE  IF NOT EXISTS `itea_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `itea_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: itea_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `categoryID` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shortDescription` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `photoUrlIcon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photoUrlBig1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photoUrlBig2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photoUrlBig3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photoUrlBig4` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bigDescription` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'RAPIDARUN ELITE SHOES',50,1,5,'SHOES FOR LATE-SUMMER RUNS','ShortDesc',50,'picForProd/1_1.jpg','picForProd/1_2.jpg','picForProd/1_3.jpg','picForProd/1_4.jpg','picForProd/1_5.jpg','Adapt to cool-weather running in these juniors\' adidas shoes. A mesh upper with leather and suede keeps you comfortable as summer turns to fall. Midsole cushioning and a heel clip offer a soft, stable ride. Adapt to cool-weather running in these juniors\' adidas shoes. A mesh upper with leather and suede keeps you comfortable as summer turns to fall. Midsole cushioning and a heel clip offer a soft, stable ride. Adapt to cool-weather running in these juniors\' adidas shoes. A mesh upper with leather and suede keeps you comfortable as summer turns to fall. Midsole cushioning and a heel clip offer a soft, stable ride.SPECIFICATIONS'),(2,'CONTINENTAL 80 SHOES',52,1,5,'SHOES FOR LATE-SUMMER RUNS','Adapt to cool-weather running in these juniors\' adidas shoes. A mesh upper with leather and suede keeps you comfortable as summer turns to fall. Midsole cushioning and a heel clip offer a soft, stable ride.',0,'picForProd/2_1.jpg','picForProd/2_2.jpg','picForProd/2_3.jpg','picForProd/2_4.jpg','picForProd/2_5.jpg','CONTINENTAL 80 SHOESCONTINENTAL 80 SHOESCONTINENTAL 80 SHOESCONTINENTAL 80 SHOESRetro \'80s tennis style inspires the Continental 80. These juniors\' low top shoes have a nostalgic look with a swooping two-tone stripe on the side and a logo window near the laces. A split rubber cupsole with an EVA insert provides a comfortable, flexible feelRetro \'80s tennis style inspires the Continental 80. These juniors\' low top shoes have a nostalgic look with a swooping two-tone stripe on the side and a logo window near the laces. A split rubber cupsole with an EVA insert provides a comfortable, flexible feelRetro \'80s tennis style inspires the Continental 80. These juniors\' low top shoes have a nostalgic look with a swooping two-tone stripe on the side and a logo window near the laces. A split rubber cupsole with an EVA insert provides a comfortable, flexible feel Retro \'80s tennis style inspires the Continental 80. These juniors\' low top shoes have a nostalgic look with a swooping two-tone stripe on the side and a logo window near the laces. A split rubber cupsole with an EVA insert provides a comfortable, flexible feel'),(8,'SUPERSTAR SHOES',63,1,5,'CLOUD WHITE / CLOUD WHITE / CORE BLACK','CLOUD WHITE / CLOUD WHITE / CORE BLACK',0,'picForProd/8_1.jpg','picForProd/8_2.jpg','picForProd/8_3.jpg','picForProd/8_4.jpg','picForProd/8_5.jpg','It\'s all about the details. From the iconic rubber shell toe to the contrast heel tab, the adidas Superstar shoes have been bringing the finer points of style to the world of sport since 1970. Originally designed as a basketball shoe, they now appear everywhere from cafés to concerts. Wear this juniors\' version with the 3-Stripes lace-jewels for an evening out, or slip them off for a more casual lookIt\'s all about the details. From the iconic rubber shell toe to the contrast heel tab, the adidas Superstar shoes have been bringing the finer points of style to the world of sport since 1970. Originally designed as a basketball shoe, they now appear everywhere from cafés to concerts. Wear this juniors\' version with the 3-Stripes lace-jewels for an evening out, or slip them off for a more casual lookIt\'s all about the details. From the iconic rubber shell toe to the contrast heel tab, the adidas Superstar shoes have been bringing the finer points of style to the world of sport since 1970. Originally designed as a basketball shoe, they now appear everywhere from cafés to concerts. Wear this juniors\' version with the 3-Stripes lace-jewels for an evening out, or slip them off for a more casual look It\'s all about the details. From the iconic rubber shell toe to the contrast heel tab, the adidas Superstar shoes have been bringing the finer points of style to the world of sport since 1970. Originally designed as a basketball shoe, they now appear everywhere from cafés to concerts. Wear this juniors\' version with the 3-Stripes lace-jewels for an evening out, or slip them off for a more casual look'),(9,'R.Y.V. HOODIE',70,2,5,'CLAY','CLAY',0,'picForProd/9_1.jpg','picForProd/9_2.jpg','picForProd/9_3.jpg','picForProd/9_4.jpg','picForProd/9_5.jpg','For those times when you\'re hanging with friends and break into a spontaneous dance party. The evening may have started with popcorn and movies, but you\'ve since moved into a \'90s dance throw-down. This adidas crop hoodie is a bonus for pulling off a relaxed evening or a re-enactment of your favorite music video. For those times when you\'re hanging with friends and break into a spontaneous dance party. The evening may have started with popcorn and movies, but you\'ve since moved into a \'90s dance throw-down. This adidas crop hoodie is a bonus for pulling off a relaxed evening or a re-enactment of your favorite music video.'),(10,'R.Y.V. PANTS',42,2,5,'SKY TINT','SKY TINT',0,'picForProd/10_1.jpg','picForProd/10_2.jpg','picForProd/10_3.jpg','picForProd/10_4.jpg','picForProd/10_5.jpg','Kinda retro, but kinda modern. These track pants mix fresh color with two-tone branded tape details for iconic sporty style. French terry material gives them an easy, comfortable feel. They\'re part of the adidas R.Y.V. collection, made for self-expression in the next gen of streetwear Kinda retro, but kinda modern. These track pants mix fresh color with two-tone branded tape details for iconic sporty style. French terry material gives them an easy, comfortable feel. They\'re part of the adidas R.Y.V. collection, made for self-expression in the next gen of streetwear Kinda retro, but kinda modern. These track pants mix fresh color with two-tone branded tape details for iconic sporty style. French terry material gives them an easy, comfortable feel. They\'re part of the adidas R.Y.V. collection, made for self-expression in the next gen of streetwear'),(11,'R.Y.V. SWEATSHIRT',70,2,5,'TRACE PINK / MULTICOLOR','TRACE PINK / MULTICOLOR',0,'picForProd/11_1.jpg','picForProd/11_2.jpg','picForProd/11_3.jpg','picForProd/11_4.jpg','picForProd/11_5.jpg','There\'s streetwear. Then there\'s wearing the street. You\'ll channel the energy of the city in this adidas sweatshirt. Pair it with something low-key or a statement piece. Why not push your look even further? It\'s all up to you. There\'s streetwear. Then there\'s wearing the street. You\'ll channel the energy of the city in this adidas sweatshirt. Pair it with something low-key or a statement piece. Why not push your look even further? It\'s all up to you.'),(12,'CLASSIC 3-STRIPES BACKPACK',35,3,5,'BLACK','BLACK',0,'picForProd/12_1.jpg','picForProd/12_2.jpg','picForProd/12_3.jpg','picForProd/12_4.jpg','picForProd/12_5.jpg','A backpack with plenty of room for everything your kids need to face the day: a cooler-lined front pocket for snacks, side water bottle pocket and main compartment with plenty of room for school books and supplies. Vintage adidas styling looks as cool today as when you first rocked it when you were the student. A backpack with plenty of room for everything your kids need to face the day: a cooler-lined front pocket for snacks, side water bottle pocket and main compartment with plenty of room for school books and supplies. Vintage adidas styling looks as cool today as when you first rocked it when you were the student.'),(13,'YOUNG CREATOR BACKPACK',40,3,5,'MEDIUM BLUE','MEDIUM BLUE',0,'picForProd/13_1.jpg','picForProd/13_2.jpg','picForProd/13_3.jpg','picForProd/13_4.jpg','picForProd/13_5.jpg','Because kids think of fun first, this adidas backpack pops with playful colors. But it\'s plenty practical too. It\'s roomy enough to hold a whole school day\'s worth of stuff and tough enough to stand up to daily abuse. Padded straps keep the load easy on their shoulders. Because kids think of fun first, this adidas backpack pops with playful colors. But it\'s plenty practical too. It\'s roomy enough to hold a whole school day\'s worth of stuff and tough enough to stand up to daily abuse. Padded straps keep the load easy on their shoulders. '),(14,'CLASSIC 3-STRIPES BACKPACK',35,3,5,'BRIGHT PINK','BRIGHT PINK',0,'picForProd/14_1.jpg','picForProd/14_2.jpg','picForProd/14_3.jpg','picForProd/14_4.jpg','picForProd/14_5.jpg','A backpack with plenty of room for everything your kids need to face the day: a cooler-lined front pocket for snacks, side water bottle pocket and main compartment with plenty of room for school books and supplies. Vintage adidas styling looks as cool today as when you first rocked it when you were the student. A backpack with plenty of room for everything your kids need to face the day: a cooler-lined front pocket for snacks, side water bottle pocket and main compartment with plenty of room for school books and supplies. Vintage adidas styling looks as cool today as when you first rocked it when you were the student. A backpack with plenty of room for everything your kids need to face the day: a cooler-lined front pocket for snacks, side water bottle pocket and main compartment with plenty of room for school books and supplies. Vintage adidas styling looks as cool today as when you first rocked it when you were the student.');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-10 16:02:02
