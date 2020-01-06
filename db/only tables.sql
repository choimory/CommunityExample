-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: community_example
-- ------------------------------------------------------
-- Server version	5.5.62-log

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
-- Table structure for table `board_type`
--

DROP TABLE IF EXISTS `board_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_type` (
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_CATEGORY` varchar(100) NOT NULL,
  `BOARD_ID_KOR` varchar(45) NOT NULL,
  `BOARD_TYPE_KOR` varchar(100) NOT NULL,
  UNIQUE KEY `BOARD_ID_UNIQUE` (`BOARD_ID`),
  UNIQUE KEY `BOARD_ID_KOR_UNIQUE` (`BOARD_ID_KOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_type`
--

LOCK TABLES `board_type` WRITE;
/*!40000 ALTER TABLE `board_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookmark_article`
--

DROP TABLE IF EXISTS `bookmark_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookmark_article` (
  `BOOKMARK_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_INDEX` int(11) DEFAULT NULL,
  PRIMARY KEY (`BOOKMARK_INDEX`),
  KEY `FK_bookmark_article_ID_idx` (`ID`),
  KEY `FK_bookmark_article_BOARD_TYPE_idx` (`BOARD_TYPE`),
  KEY `FK_bookmark_article_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_bookmark_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_article_BOARD_TYPE` FOREIGN KEY (`BOARD_TYPE`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmark_article`
--

LOCK TABLES `bookmark_article` WRITE;
/*!40000 ALTER TABLE `bookmark_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmark_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookmark_board`
--

DROP TABLE IF EXISTS `bookmark_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookmark_board` (
  `ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  KEY `FK_bookmark_board_ID_idx` (`ID`),
  KEY `FK_bookmark_board_TYPE_idx` (`BOARD_TYPE`),
  KEY `FK_bookmark_board_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_bookmark_board_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_board_BOARD_TYPE` FOREIGN KEY (`BOARD_TYPE`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_board_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmark_board`
--

LOCK TABLES `bookmark_board` WRITE;
/*!40000 ALTER TABLE `bookmark_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmark_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `CART_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_INDEX` int(11) NOT NULL,
  `CART_COUNT` int(10) unsigned NOT NULL,
  `ID` varchar(45) NOT NULL,
  PRIMARY KEY (`CART_INDEX`),
  KEY `FK_cart_SHOP_INDEX_idx` (`SHOP_INDEX`),
  KEY `FK_cart_ID_idx` (`ID`),
  CONSTRAINT `FK_cart_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_cart_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dm`
--

DROP TABLE IF EXISTS `dm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm` (
  `DM_INDEX` int(11) NOT NULL,
  `DM_SENDER_ID` varchar(45) NOT NULL,
  `DM_SENDER_NICKNAME` varchar(45) NOT NULL,
  `DM_SENDDATE` datetime NOT NULL,
  `DM_RECEIVER_ID` varchar(45) NOT NULL,
  `DM_RECEIVER_NICKNAME` varchar(45) NOT NULL,
  `DM_RECEIVEDATE` datetime DEFAULT NULL,
  `DM_TITLE` varchar(255) NOT NULL,
  `DM_CONTENT` text NOT NULL,
  PRIMARY KEY (`DM_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm`
--

LOCK TABLES `dm` WRITE;
/*!40000 ALTER TABLE `dm` DISABLE KEYS */;
/*!40000 ALTER TABLE `dm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment`
--

DROP TABLE IF EXISTS `entertainment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment` (
  `BOARD_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_CATEGORY` varchar(100) NOT NULL,
  `BOARD_TITLE` varchar(255) NOT NULL,
  `BOARD_CONTENT` text NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `BOARD_REGDATE` datetime NOT NULL,
  PRIMARY KEY (`BOARD_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment`
--

LOCK TABLES `entertainment` WRITE;
/*!40000 ALTER TABLE `entertainment` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment_comment`
--

DROP TABLE IF EXISTS `entertainment_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment_comment` (
  `COMMENT_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `COMMENT_CONTENT` varchar(255) NOT NULL,
  `COMMENT_REGDATE` datetime NOT NULL,
  `COMMENT_GROUP` int(10) unsigned DEFAULT NULL,
  `COMMENT_STEP` int(10) unsigned DEFAULT NULL,
  `COMMENT_INDENT` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_entertainment_comment_BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_entertainment_comment_ID_idx` (`ID`),
  KEY `FK_entertainment_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_entertainment_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `entertainment` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_entertainment_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_entertainment_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment_comment`
--

LOCK TABLES `entertainment_comment` WRITE;
/*!40000 ALTER TABLE `entertainment_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment_comment_info`
--

DROP TABLE IF EXISTS `entertainment_comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment_comment_info` (
  `COMMENT_INDEX` int(11) NOT NULL,
  `COMMENT_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_entertainment_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_entertainment_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `entertainment_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment_comment_info`
--

LOCK TABLES `entertainment_comment_info` WRITE;
/*!40000 ALTER TABLE `entertainment_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment_info`
--

DROP TABLE IF EXISTS `entertainment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment_info` (
  `BOARD_INDEX` int(11) NOT NULL,
  `BOARD_HIT` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_entertainment_info_BOARD_INDEX` (`BOARD_INDEX`),
  CONSTRAINT `FK_entertainment_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `entertainment` (`BOARD_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment_info`
--

LOCK TABLES `entertainment_info` WRITE;
/*!40000 ALTER TABLE `entertainment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `BOARD_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_CATEGORY` varchar(100) NOT NULL,
  `BOARD_TITLE` varchar(255) NOT NULL,
  `BOARD_CONTENT` text NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `BOARD_REGDATE` datetime NOT NULL,
  PRIMARY KEY (`BOARD_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_comment`
--

DROP TABLE IF EXISTS `game_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_comment` (
  `COMMENT_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `COMMENT_CONTENT` varchar(255) NOT NULL,
  `COMMENT_REGDATE` datetime NOT NULL,
  `COMMENT_GROUP` int(10) unsigned DEFAULT NULL,
  `COMMENT_STEP` int(10) unsigned DEFAULT NULL,
  `COMMENT_INDENT` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_game_comment_BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_game_comment_ID_idx` (`ID`),
  KEY `FK_game_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_game_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `game` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_game_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_game_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_comment`
--

LOCK TABLES `game_comment` WRITE;
/*!40000 ALTER TABLE `game_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_comment_info`
--

DROP TABLE IF EXISTS `game_comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_comment_info` (
  `COMMENT_INDEX` int(11) NOT NULL,
  `COMMENT_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_game_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_game_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `game_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_comment_info`
--

LOCK TABLES `game_comment_info` WRITE;
/*!40000 ALTER TABLE `game_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_info`
--

DROP TABLE IF EXISTS `game_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_info` (
  `BOARD_INDEX` int(11) NOT NULL,
  `BOARD_HIT` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_game_info_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_game_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `game` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_info`
--

LOCK TABLES `game_info` WRITE;
/*!40000 ALTER TABLE `game_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humor`
--

DROP TABLE IF EXISTS `humor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humor` (
  `BOARD_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_CATEGORY` varchar(100) NOT NULL,
  `BOARD_TITLE` varchar(255) NOT NULL,
  `BOARD_CONTENT` text NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `BOARD_REGDATE` datetime NOT NULL,
  PRIMARY KEY (`BOARD_INDEX`),
  KEY `ID_idx` (`ID`),
  KEY `NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_humor_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_humor_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor`
--

LOCK TABLES `humor` WRITE;
/*!40000 ALTER TABLE `humor` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humor_comment`
--

DROP TABLE IF EXISTS `humor_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humor_comment` (
  `COMMENT_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `COMMENT_CONTENT` varchar(255) NOT NULL,
  `COMMENT_REGDATE` datetime NOT NULL,
  `COMMENT_GROUP` int(11) DEFAULT NULL,
  `COMMENT_STEP` int(11) DEFAULT NULL,
  `COMMENT_INDENT` int(11) DEFAULT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_humor_comment_ID_idx` (`ID`),
  KEY `FK_humor_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_humor_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `humor` (`BOARD_INDEX`) ON DELETE CASCADE,
  CONSTRAINT `FK_humor_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_humor_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_comment`
--

LOCK TABLES `humor_comment` WRITE;
/*!40000 ALTER TABLE `humor_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humor_comment_info`
--

DROP TABLE IF EXISTS `humor_comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humor_comment_info` (
  `COMMENT_INDEX` int(11) NOT NULL,
  `COMMENT_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_humor_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_humor_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `humor_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_comment_info`
--

LOCK TABLES `humor_comment_info` WRITE;
/*!40000 ALTER TABLE `humor_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humor_info`
--

DROP TABLE IF EXISTS `humor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humor_info` (
  `BOARD_INDEX` int(11) NOT NULL,
  `BOARD_HIT` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(11) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(11) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_humor_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `humor` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_info`
--

LOCK TABLES `humor_info` WRITE;
/*!40000 ALTER TABLE `humor_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `ID` varchar(45) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NICKNAME_UNIQUE` (`NICKNAME`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_ban`
--

DROP TABLE IF EXISTS `member_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_ban` (
  `ID` varchar(45) NOT NULL,
  `BAN` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `REASON` varchar(255) DEFAULT NULL,
  `ENDTOBAN` datetime DEFAULT NULL,
  KEY `FK_member_ban_ID` (`ID`),
  CONSTRAINT `FK_member_ban_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_ban`
--

LOCK TABLES `member_ban` WRITE;
/*!40000 ALTER TABLE `member_ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_info` (
  `ID` varchar(45) NOT NULL,
  `EXP` int(10) unsigned NOT NULL DEFAULT '1',
  `POINT` int(10) unsigned NOT NULL DEFAULT '1',
  `EQUIP_ITEM` int(10) unsigned NOT NULL DEFAULT '0',
  `REGDATE` datetime DEFAULT NULL,
  `LOGINDATE` datetime DEFAULT NULL,
  `ADMIN` varchar(45) DEFAULT NULL,
  KEY `FK_member_info_ID` (`ID`),
  CONSTRAINT `FK_member_info_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_item`
--

DROP TABLE IF EXISTS `member_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_item` (
  `ID` varchar(45) NOT NULL,
  `SHOP_INDEX` int(11) NOT NULL,
  KEY `FK_member_item_ID_idx` (`ID`),
  KEY `FK_member_item_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_member_item_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_member_item_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_item`
--

LOCK TABLES `member_item` WRITE;
/*!40000 ALTER TABLE `member_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_article`
--

DROP TABLE IF EXISTS `report_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_article` (
  `ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_INDEX` int(11) NOT NULL,
  KEY `FK_report_article_ID_idx` (`ID`),
  KEY `FK_report_article_BOARD_TYPE_idx` (`BOARD_TYPE`),
  KEY `FK_report_article_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_report_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_report_article_BOARD_TYPE` FOREIGN KEY (`BOARD_TYPE`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_report_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_article`
--

LOCK TABLES `report_article` WRITE;
/*!40000 ALTER TABLE `report_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `SHOP_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_TYPE` varchar(45) NOT NULL,
  `SHOP_CATEGORY` varchar(100) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `SHOP_TITLE` varchar(255) NOT NULL,
  `SHOP_CONTENT` text NOT NULL,
  `SHOP_FILENAME` varchar(255) NOT NULL,
  `SHOP_PRICE` int(10) unsigned NOT NULL,
  `SHOP_REGDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`SHOP_INDEX`),
  KEY `FK_shop_ID_idx` (`ID`),
  KEY `FK_shop_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_shop_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_comment`
--

DROP TABLE IF EXISTS `shop_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_comment` (
  `S_COMMENT_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `S_COMMENT_CONTENT` varchar(255) NOT NULL,
  `S_COMMENT_REGDATE` datetime DEFAULT NULL,
  `S_COMMENT_GROUP` int(10) unsigned DEFAULT NULL,
  `S_COMMENT_STEP` int(10) unsigned DEFAULT NULL,
  `S_COMMENT_INDENT` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`S_COMMENT_INDEX`),
  KEY `FK_shop_comment_SHOP_INDEX_idx` (`SHOP_INDEX`),
  KEY `FK_shop_comment_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_shop_comment_ID_idx` (`ID`),
  CONSTRAINT `FK_shop_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_comment_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_comment`
--

LOCK TABLES `shop_comment` WRITE;
/*!40000 ALTER TABLE `shop_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_comment_info`
--

DROP TABLE IF EXISTS `shop_comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_comment_info` (
  `S_COMMENT_INDEX` int(11) NOT NULL,
  `S_COMMENT_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `S_COMMENT_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `S_COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `S_COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `S_COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `S_COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_shop_comment_info_S_COMMENT_INDEX_idx` (`S_COMMENT_INDEX`),
  CONSTRAINT `FK_shop_comment_info_S_COMMENT_INDEX` FOREIGN KEY (`S_COMMENT_INDEX`) REFERENCES `shop_comment` (`S_COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_comment_info`
--

LOCK TABLES `shop_comment_info` WRITE;
/*!40000 ALTER TABLE `shop_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_info`
--

DROP TABLE IF EXISTS `shop_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_info` (
  `SHOP_INDEX` int(11) NOT NULL,
  `SHOP_HIT` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `SHOP_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_PERMISSION` tinyint(1) NOT NULL DEFAULT '0',
  `SHOP_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_shop_info_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_shop_info_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_info`
--

LOCK TABLES `shop_info` WRITE;
/*!40000 ALTER TABLE `shop_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_report_article`
--

DROP TABLE IF EXISTS `shop_report_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_report_article` (
  `ID` varchar(45) NOT NULL,
  `SHOP_INDEX` int(11) NOT NULL,
  KEY `FK_shop_report_article_ID_idx` (`ID`),
  KEY `FK_shop_report_article_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_shop_report_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_report_article_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_report_article`
--

LOCK TABLES `shop_report_article` WRITE;
/*!40000 ALTER TABLE `shop_report_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_report_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_vote_article`
--

DROP TABLE IF EXISTS `shop_vote_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_vote_article` (
  `ID` varchar(45) NOT NULL,
  `SHOP_INDEX` int(11) NOT NULL,
  `UPDOWN` tinyint(1) NOT NULL,
  KEY `FK_shop_vote_article_ID_idx` (`ID`),
  KEY `FK_shop_vote_article_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_shop_vote_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_vote_article_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_vote_article`
--

LOCK TABLES `shop_vote_article` WRITE;
/*!40000 ALTER TABLE `shop_vote_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_vote_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_vote_comment`
--

DROP TABLE IF EXISTS `shop_vote_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_vote_comment` (
  `ID` varchar(45) NOT NULL,
  `SHOP_INDEX` int(11) NOT NULL,
  `S_COMMENT_INDEX` int(11) NOT NULL,
  `UPDOWN` tinyint(1) NOT NULL,
  KEY `FK_shop_vote_comment_ID_idx` (`ID`),
  KEY `FK_shop_vote_comment_SHOP_INDEX_idx` (`SHOP_INDEX`),
  KEY `FK_shop_vote_comment_S_COMMENT_INDEX_idx` (`S_COMMENT_INDEX`),
  CONSTRAINT `FK_shop_vote_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_vote_comment_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_vote_comment_S_COMMENT_INDEX` FOREIGN KEY (`S_COMMENT_INDEX`) REFERENCES `shop_comment` (`S_COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_vote_comment`
--

LOCK TABLES `shop_vote_comment` WRITE;
/*!40000 ALTER TABLE `shop_vote_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_vote_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports`
--

DROP TABLE IF EXISTS `sports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports` (
  `BOARD_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_CATEGORY` varchar(100) NOT NULL,
  `BOARD_TITLE` varchar(255) NOT NULL,
  `BOARD_CONTENT` text NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `BOARD_REGDATE` datetime NOT NULL,
  PRIMARY KEY (`BOARD_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports`
--

LOCK TABLES `sports` WRITE;
/*!40000 ALTER TABLE `sports` DISABLE KEYS */;
/*!40000 ALTER TABLE `sports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports_comment`
--

DROP TABLE IF EXISTS `sports_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports_comment` (
  `COMMENT_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  `NICKNAME` varchar(45) NOT NULL,
  `COMMENT_CONTENT` varchar(255) NOT NULL,
  `COMMENT_REGDATE` datetime NOT NULL,
  `COMMENT_GROUP` int(10) unsigned DEFAULT NULL,
  `COMMENT_STEP` int(10) unsigned DEFAULT NULL,
  `COMMENT_INDENT` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_sports_comment_BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_sports_comment_ID_idx` (`ID`),
  KEY `FK_sports_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_sports_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `sports` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_sports_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_sports_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_comment`
--

LOCK TABLES `sports_comment` WRITE;
/*!40000 ALTER TABLE `sports_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `sports_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports_comment_info`
--

DROP TABLE IF EXISTS `sports_comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports_comment_info` (
  `COMMENT_INDEX` int(11) NOT NULL,
  `COMMENT_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_sports_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_sports_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `sports_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_comment_info`
--

LOCK TABLES `sports_comment_info` WRITE;
/*!40000 ALTER TABLE `sports_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `sports_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports_info`
--

DROP TABLE IF EXISTS `sports_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports_info` (
  `BOARD_INDEX` int(11) NOT NULL,
  `BOARD_HIT` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_UPVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_DOWNVOTE` int(11) NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_sports_info_BOARD_INDEX` (`BOARD_INDEX`),
  CONSTRAINT `FK_sports_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `sports` (`BOARD_INDEX`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_info`
--

LOCK TABLES `sports_info` WRITE;
/*!40000 ALTER TABLE `sports_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `sports_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_article`
--

DROP TABLE IF EXISTS `vote_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_article` (
  `ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_INDEX` int(11) NOT NULL,
  `UPDOWN` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_vote_article_BOARD_TYPE_idx` (`BOARD_TYPE`),
  KEY `FK_vote_article_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_vote_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_article_BOARD_TYPE` FOREIGN KEY (`BOARD_TYPE`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_article`
--

LOCK TABLES `vote_article` WRITE;
/*!40000 ALTER TABLE `vote_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_comment`
--

DROP TABLE IF EXISTS `vote_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_comment` (
  `ID` varchar(45) NOT NULL,
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  `COMMENT_INDEX` int(11) NOT NULL,
  `UPDOWN` int(1) NOT NULL DEFAULT '0',
  KEY `FK_vote_comment_ID_idx` (`ID`),
  KEY `FK_vote_comment_BOARD_TYPE_idx` (`BOARD_TYPE`),
  KEY `FK_vote_comment_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_vote_comment_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_comment_BOARD_TYPE` FOREIGN KEY (`BOARD_TYPE`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_comment`
--

LOCK TABLES `vote_comment` WRITE;
/*!40000 ALTER TABLE `vote_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wishlist` (
  `WISHLIST_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_INDEX` int(11) NOT NULL,
  `ID` varchar(45) NOT NULL,
  PRIMARY KEY (`WISHLIST_INDEX`),
  KEY `FK_wishlist_SHOP_INDEX_idx` (`SHOP_INDEX`),
  KEY `FK_wishlist_ID_idx` (`ID`),
  CONSTRAINT `FK_wishlist_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_wishlist_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-06 23:37:28
