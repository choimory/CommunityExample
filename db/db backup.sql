-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: communityexample
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
-- Table structure for table `board_category`
--

DROP TABLE IF EXISTS `board_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_category` (
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_CATEGORY` varchar(45) NOT NULL,
  KEY `FK_board_category_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_board_category_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_category`
--

LOCK TABLES `board_category` WRITE;
/*!40000 ALTER TABLE `board_category` DISABLE KEYS */;
INSERT INTO `board_category` VALUES ('humor','감동'),('lol','롤챔스'),('humor','유머'),('overwatch','잡담'),('lol','잡담'),('pubg','잡담'),('baseball','잡담'),('tft','정보'),('girlgroup','프로미스나인'),('girlgroup','아이즈원'),('boygroup','BTS'),('boygroup','EXO'),('girlgroup','EXID');
/*!40000 ALTER TABLE `board_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_type`
--

DROP TABLE IF EXISTS `board_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_type` (
  `BOARD_TYPE` varchar(100) NOT NULL,
  `BOARD_ID` varchar(45) NOT NULL,
  `BOARD_TYPE_KOR` varchar(100) NOT NULL,
  `BOARD_ID_KOR` varchar(45) NOT NULL,
  `BOARD_INTRODUCE` varchar(255) DEFAULT NULL,
  UNIQUE KEY `BOARD_ID_UNIQUE` (`BOARD_ID`),
  UNIQUE KEY `BOARD_ID_KOR_UNIQUE` (`BOARD_ID_KOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_type`
--

LOCK TABLES `board_type` WRITE;
/*!40000 ALTER TABLE `board_type` DISABLE KEYS */;
INSERT INTO `board_type` VALUES ('sports','baseball','스포츠','야구','야구 게시판입니다'),('sports','basketball','스포츠','농구','농구와 관련된 글을 올려주세요'),('best','best','BEST','BEST','BEST 게시판입니다'),('entertainment','boygroup','연예','보이그룹','남자아이돌 게시판입니다'),('sports','football','스포츠','축구','축구와 관련된 글을 올려주세요'),('entertainment','girlgroup','연예','걸그룹','걸그룹 게시판입니다'),('game','hearthstone','게임','하스스톤','하스스톤 게시판입니다'),('game','heroes','게임','히어로즈 오브 스톰','고오급 분식집입니다'),('humor','humor','유머','유머','유머 게시판입니다'),('humor','issue','유머','이슈','최근 이슈들을 올려주세요'),('game','lol','게임','리그 오브 레전드','리그 오브 레전드에 관련된 글을 올려주세요'),('entertainment','man_actor','연예','남자배우','남자배우와 관련된 글을 올려주세요'),('game','overwatch','게임','오버워치','오버워치 게시판입니다'),('game','pubg','게임','배틀그라운드','배틀그라운드 게시판입니다'),('entertainment','streaming','연예','인터넷방송','인터넷방송 게시판입니다'),('game','tft','게임','전략적 팀 전투','전략적 팀 전투(롤토체스) 게시판입니다'),('entertainment','woman_actor','연예','여자배우','여자배우 게시판입니다');
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
  `BOARD_INDEX` int(11) NOT NULL,
  PRIMARY KEY (`BOOKMARK_INDEX`),
  KEY `FK_bookmark_article_BOARD_ID_idx` (`BOARD_ID`),
  KEY `FK_bookmark_article_ID_idx` (`ID`),
  CONSTRAINT `FK_bookmark_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmark_article`
--

LOCK TABLES `bookmark_article` WRITE;
/*!40000 ALTER TABLE `bookmark_article` DISABLE KEYS */;
INSERT INTO `bookmark_article` VALUES (1,'choimory','game','overwatch',20),(3,'choimory','game','overwatch',7),(4,'morychoi','game','lol',25),(5,'choimory','game','overwatch',5),(6,'choimory','game','lol',25),(7,'choimory','game','lol',26),(9,'choimory','game','lol',11),(13,'choimory','game','lol',27),(14,'choimory','humor','humor',1),(16,'choimory','game','lol',32);
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
  `BOARD_TYPE_KOR` varchar(100) NOT NULL,
  `BOARD_ID_KOR` varchar(45) NOT NULL,
  KEY `FK_bookmark_board_BOARD_ID_idx` (`BOARD_ID`),
  KEY `FK_bookmark_board_ID_idx` (`ID`),
  KEY `FK_bookmark_board_BOARD_ID_KOR_idx` (`BOARD_ID_KOR`),
  CONSTRAINT `FK_bookmark_board_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_board_BOARD_ID_KOR` FOREIGN KEY (`BOARD_ID_KOR`) REFERENCES `board_type` (`BOARD_ID_KOR`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bookmark_board_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmark_board`
--

LOCK TABLES `bookmark_board` WRITE;
/*!40000 ALTER TABLE `bookmark_board` DISABLE KEYS */;
INSERT INTO `bookmark_board` VALUES ('choimory','game','lol','게임','리그 오브 레전드'),('choimory','sports','baseball','스포츠','야구'),('choimory','entertainment','streaming','연예','인터넷방송'),('choimory','entertainment','girlgroup','연예','걸그룹'),('choimory','humor','humor','유머','유머'),('choimory','game','tft','게임','전략적 팀 전투'),('choimory','sports','football','스포츠','축구');
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
  KEY `FK_cart_ID_idx` (`ID`),
  KEY `FK_cart_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_cart_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_cart_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE
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
-- Table structure for table `dm`
--

DROP TABLE IF EXISTS `dm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm` (
  `DM_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `DM_SENDER_ID` varchar(45) NOT NULL,
  `DM_SENDER_NICKNAME` varchar(45) NOT NULL,
  `DM_SENDDATE` datetime NOT NULL,
  `DM_RECEIVER_ID` varchar(45) NOT NULL,
  `DM_RECEIVER_NICKNAME` varchar(45) NOT NULL,
  `DM_RECEIVEDATE` datetime NOT NULL,
  `DM_TITLE` varchar(255) NOT NULL,
  `DM_CONTENT` text NOT NULL,
  PRIMARY KEY (`DM_INDEX`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm`
--

LOCK TABLES `dm` WRITE;
/*!40000 ALTER TABLE `dm` DISABLE KEYS */;
INSERT INTO `dm` VALUES (1,'morychoi','모리최','2020-01-23 12:05:17','choimory','최모리','2020-01-23 13:00:09','쪽지 보내봅니다','ㅎㅎ;'),(2,'morychoi','모리최','2020-01-23 12:09:40','choimory','최모리','2020-01-23 13:02:53','쪽지 드렸읍니다','이응'),(3,'morychoi','모리최','2020-01-23 12:14:35','choimory','최모리','2020-01-23 12:47:51','쪽지 드렸읍니다2','2'),(4,'choimory','최모리','2020-01-23 13:05:08','morychoi','모리최','2020-01-23 13:05:57','쪽지 드렸읍니다','예'),(5,'morychoi','모리최','2020-01-25 14:42:59','choimory','최모리','2020-01-25 14:46:34','쪽지 파일첨부 테스트','예');
/*!40000 ALTER TABLE `dm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dm_file`
--

DROP TABLE IF EXISTS `dm_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm_file` (
  `FILE_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `DM_INDEX` int(11) NOT NULL,
  `FILE_ORIGINAL_NAME` varchar(255) NOT NULL,
  `FILE_STORED_NAME` varchar(255) NOT NULL,
  `FILE_SIZE` int(11) NOT NULL,
  PRIMARY KEY (`FILE_INDEX`),
  KEY `FK_dm_file_DM_INDEX_idx` (`DM_INDEX`),
  CONSTRAINT `FK_dm_file_DM_INDEX` FOREIGN KEY (`DM_INDEX`) REFERENCES `dm` (`DM_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_file`
--

LOCK TABLES `dm_file` WRITE;
/*!40000 ALTER TABLE `dm_file` DISABLE KEYS */;
INSERT INTO `dm_file` VALUES (1,5,'unnamed.jpg','5_unnamed.jpg',286201);
/*!40000 ALTER TABLE `dm_file` ENABLE KEYS */;
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
  PRIMARY KEY (`BOARD_INDEX`),
  KEY `FK_entertainment_ID_idx` (`ID`),
  KEY `FK_entertainment_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_entertainment_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_entertainment_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_entertainment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_entertainment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `COMMENT_GROUP` int(10) unsigned NOT NULL,
  `COMMENT_STEP` int(10) unsigned NOT NULL,
  `COMMENT_INDENT` int(10) unsigned NOT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_entertainment_comment_BOARD_ID_idx` (`BOARD_INDEX`),
  KEY `FK_entertainment_comment_ID_idx` (`ID`),
  KEY `FK_entertainment_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_entertainment_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `entertainment` (`BOARD_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_entertainment_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_entertainment_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `COMMENT_UPVOTE` int(10) unsigned NOT NULL,
  `COMMENT_DOWNVOTE` int(10) unsigned NOT NULL,
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL,
  `COMMENT_BLIND` tinyint(1) NOT NULL,
  `COMMENT_NOTICE` tinyint(1) NOT NULL,
  `COMMENT_BEST` tinyint(1) NOT NULL,
  KEY `FK_entertainment_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_entertainment_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `entertainment_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment_comment_info`
--

LOCK TABLES `entertainment_comment_info` WRITE;
/*!40000 ALTER TABLE `entertainment_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment_file`
--

DROP TABLE IF EXISTS `entertainment_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment_file` (
  `FILE_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `FILE_ORIGINAL_NAME` varchar(255) NOT NULL,
  `FILE_STORED_NAME` varchar(255) NOT NULL,
  `FILE_SIZE` int(11) NOT NULL,
  PRIMARY KEY (`FILE_INDEX`),
  KEY `FK_entertainment_file_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_entertainment_file_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `entertainment` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entertainment_file`
--

LOCK TABLES `entertainment_file` WRITE;
/*!40000 ALTER TABLE `entertainment_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `entertainment_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entertainment_info`
--

DROP TABLE IF EXISTS `entertainment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entertainment_info` (
  `BOARD_INDEX` int(11) NOT NULL,
  `BOARD_HIT` int(10) unsigned NOT NULL,
  `BOARD_UPVOTE` int(10) unsigned NOT NULL,
  `BOARD_DOWNVOTE` int(10) unsigned NOT NULL,
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL,
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL,
  `BOARD_BLIND` tinyint(1) NOT NULL,
  `BOARD_NOTICE` tinyint(1) NOT NULL,
  `BOARD_BEST` tinyint(1) NOT NULL,
  KEY `FK_entertainment_info_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_entertainment_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `entertainment` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`BOARD_INDEX`),
  KEY `FK_game_ID_idx` (`ID`),
  KEY `FK_game_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_game_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_game_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_game_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_game_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (5,'overwatch','잡담','tititle','concontent','choimory','최모리','2020-01-16 19:43:40'),(7,'overwatch','잡담','제목이 길면 어떻게될ㄲ아아ㅏㅏㅏㅏㅏㅏㅏㅏ아아아아','내용없음~','choimory','최모리','2020-01-28 19:16:31'),(11,'lol','롤챔스','글제목','글내용','choimory','최모리','2020-01-19 09:43:47'),(14,'overwatch','잡담','ㄱㄴㄷ','ㄱㄴㄷ','choimory','최모리','2020-01-24 15:58:30'),(20,'overwatch','잡담','다중업로드 테스트','넹','choimory','최모리','2020-01-25 13:19:25'),(22,'overwatch','잡담','aa','aa','choimory','최모리','2020-01-29 10:30:09'),(23,'overwatch','잡담','bb','bb','choimory','최모리','2020-01-29 10:30:36'),(24,'overwatch','잡담','cc','cc','choimory','최모리','2020-01-29 10:30:50'),(25,'lol','롤챔스','abc','abc','morychoi','모리최','2020-01-29 16:18:52'),(26,'lol','롤챔스','a','a','choimory','최모리','2020-01-29 20:16:42'),(27,'lol','롤챔스','b','b','choimory','최모리','2020-01-29 20:17:04'),(28,'lol','롤챔스','d','e','choimory','최모리','2020-01-30 12:23:29'),(29,'pubg','잡담','zz','zz','choimory','최모리','2020-01-30 16:05:42'),(31,'lol','롤챔스','tttttteeeeeeesssssstttttt','test','choimory','최모리','2020-02-02 11:41:47'),(32,'lol','롤챔스','ㅌㅅㅌ','ㅌㅅㅌ','choimory','최모리','2020-02-02 11:57:23');
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
  `COMMENT_GROUP` int(10) unsigned NOT NULL,
  `COMMENT_STEP` int(10) unsigned NOT NULL,
  `COMMENT_INDENT` int(10) unsigned NOT NULL,
  PRIMARY KEY (`COMMENT_INDEX`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_comment`
--

LOCK TABLES `game_comment` WRITE;
/*!40000 ALTER TABLE `game_comment` DISABLE KEYS */;
INSERT INTO `game_comment` VALUES (1,8,'abc','abc','[1st] test','2020-01-20 00:00:00',1,0,0),(2,8,'ㄱㄴㄷ','ㄱㄴㄷ','[2nd] abc에게 대댓글1','2020-01-20 00:00:01',1,1,1),(3,8,'zz','zz','[3rd] zz','2020-01-20 00:00:02',3,0,0),(4,8,'ㅋㅋ','ㅋㅋ','[4th] abc에게 대댓글2','2020-01-20 00:00:03',1,2,1),(5,8,'hmm','hmm','[5th] ㄱㄴㄷ에게 대댓글1','2020-01-20 00:00:04',1,1,2),(9,8,'choimory','최모리','write comment','2020-01-20 13:02:01',9,0,0),(10,8,'choimory','최모리','write comment2','2020-01-20 13:10:33',10,0,0),(11,8,'choimory','최모리','aaa','2020-01-22 17:48:58',11,0,0),(12,12,'choimory','최모리','','2020-01-24 16:01:45',12,0,0),(13,14,'choimory','최모리','댓글','2020-01-25 17:27:51',13,0,0),(14,14,'choimory','최모리','댓글2','2020-01-25 17:44:23',14,0,0),(15,14,'choimory','최모리','abc','2020-01-29 15:27:12',15,0,0),(16,7,'choimory','최모리','1','2020-01-29 15:41:47',16,0,0),(17,7,'choimory','최모리','2','2020-01-29 15:41:49',17,0,0),(18,7,'choimory','최모리','3','2020-01-29 15:41:52',18,0,0),(19,22,'choimory','최모리','a','2020-01-29 15:43:41',19,0,0),(20,22,'choimory','최모리','b','2020-01-29 15:43:44',20,0,0),(21,22,'choimory','최모리','c','2020-01-29 15:43:46',21,0,0),(22,22,'choimory','최모리','d','2020-01-29 15:44:46',22,0,0),(23,22,'choimory','최모리','d','2020-01-29 15:45:55',23,0,0),(24,22,'choimory','최모리','e','2020-01-29 15:46:00',24,0,0),(25,22,'choimory','최모리','asfdasdf','2020-01-29 15:47:55',25,0,0),(26,22,'choimory','최모리','w','2020-01-29 15:49:37',26,0,0),(27,24,'choimory','최모리','a','2020-01-29 15:52:15',27,0,0),(28,24,'choimory','최모리','erg','2020-01-29 15:52:24',28,0,0),(29,23,'choimory','최모리','zz','2020-01-29 15:52:55',29,0,0),(30,11,'choimory','최모리','abc','2020-01-29 15:53:39',30,0,0),(31,11,'choimory','최모리','abc','2020-01-29 15:53:57',31,0,0),(32,11,'choimory','최모리','abc','2020-01-29 15:54:03',32,0,0),(33,11,'choimory','최모리','abc','2020-01-29 15:54:18',33,0,0),(34,24,'choimory','최모리','abc','2020-01-29 15:54:32',34,0,0),(35,24,'choimory','최모리','asdf','2020-01-29 15:54:35',35,0,0),(36,11,'morychoi','모리최','a','2020-01-29 16:02:33',36,0,0),(37,11,'choimory','최모리','a','2020-01-29 16:03:00',37,0,0),(38,11,'choimory','최모리','abc','2020-01-29 16:06:15',38,0,0),(39,11,'choimory','최모리','aa','2020-01-29 16:09:40',39,0,0),(40,11,'choimory','최모리','aa','2020-01-29 16:09:43',40,0,0),(41,11,'choimory','최모리','1','2020-01-29 16:10:02',41,0,0),(42,11,'choimory','최모리','2','2020-01-29 16:10:05',42,0,0),(43,11,'choimory','최모리','3','2020-01-29 16:10:07',43,0,0),(44,25,'morychoi','모리최','a','2020-01-29 16:18:55',44,0,0),(45,25,'morychoi','모리최','b','2020-01-29 16:18:58',45,0,0),(46,25,'morychoi','모리최','c','2020-01-29 16:19:00',46,0,0),(47,25,'morychoi','모리최','d','2020-01-29 16:23:32',47,0,0),(48,11,'choimory','최모리','a','2020-02-02 16:42:12',48,0,0);
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
  `COMMENT_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_game_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_game_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `game_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_comment_info`
--

LOCK TABLES `game_comment_info` WRITE;
/*!40000 ALTER TABLE `game_comment_info` DISABLE KEYS */;
INSERT INTO `game_comment_info` VALUES (1,0,0,0,0,0,0),(2,0,0,0,0,0,0),(3,0,0,0,0,0,0),(4,0,0,0,0,0,0),(5,0,0,0,0,0,0),(9,0,0,0,0,0,0),(10,0,0,0,0,0,0),(11,0,0,0,0,0,0),(12,0,0,0,0,0,0),(13,1,0,0,0,0,0),(14,1,0,0,0,0,0),(15,0,0,0,0,0,0),(16,1,0,0,0,0,0),(17,1,0,0,0,0,0),(18,1,0,0,0,0,0),(19,1,0,0,0,0,0),(20,1,0,0,0,0,0),(21,1,0,0,0,0,0),(22,1,0,0,0,0,0),(24,1,0,0,0,0,0),(25,1,0,0,0,0,0),(26,1,0,0,0,0,0),(28,1,0,0,0,0,0),(29,1,0,0,0,0,0),(35,1,0,0,0,0,0),(36,1,0,0,0,0,0),(39,1,0,0,0,0,0),(40,1,0,0,0,0,0),(41,1,0,0,0,0,0),(42,1,0,0,0,0,0),(43,2,0,0,0,0,0),(44,2,0,0,0,0,0),(45,2,0,0,0,0,0),(46,0,2,0,0,0,0),(47,0,2,0,0,0,0),(48,0,1,0,0,0,0);
/*!40000 ALTER TABLE `game_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_file`
--

DROP TABLE IF EXISTS `game_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_file` (
  `FILE_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `FILE_ORIGINAL_NAME` varchar(255) NOT NULL,
  `FILE_STORED_NAME` varchar(255) NOT NULL,
  `FILE_SIZE` int(11) NOT NULL,
  PRIMARY KEY (`FILE_INDEX`),
  KEY `FK_game_file_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_game_file_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `game` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_file`
--

LOCK TABLES `game_file` WRITE;
/*!40000 ALTER TABLE `game_file` DISABLE KEYS */;
INSERT INTO `game_file` VALUES (2,20,'85813815779492550.gif','20_85813815779492550.gif',1526581),(3,20,'85813815779492555.gif','20_85813815779492555.gif',6463875),(13,31,'unnamed.jpg','31_unnamed.jpg',286201),(14,32,'unnamed.webp','32_unnamed.webp',352242),(15,32,'unnamed.jpg','32_unnamed.jpg',286201);
/*!40000 ALTER TABLE `game_file` ENABLE KEYS */;
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
  `BOARD_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_game_info_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_game_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `game` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_info`
--

LOCK TABLES `game_info` WRITE;
/*!40000 ALTER TABLE `game_info` DISABLE KEYS */;
INSERT INTO `game_info` VALUES (5,37,2,1,0,0,0,0,0),(7,40,0,1,3,0,0,0,0),(11,57,1,1,7,2,0,0,1),(14,110,1,0,3,0,0,0,0),(20,82,7,0,0,0,0,0,1),(22,21,0,1,7,1,0,0,0),(23,8,0,1,1,2,0,0,0),(24,27,0,1,2,2,0,0,1),(25,61,0,0,5,1,0,0,0),(26,4,0,0,0,0,0,0,0),(27,18,0,0,0,0,0,0,0),(28,18,0,0,0,0,0,0,0),(29,5,0,0,0,0,0,0,0),(31,11,0,0,0,0,0,0,0),(32,40,50,0,0,1,0,0,1);
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
  KEY `FK_humor_ID_idx` (`ID`),
  KEY `FK_humor_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_humor_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_humor_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_humor_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_humor_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor`
--

LOCK TABLES `humor` WRITE;
/*!40000 ALTER TABLE `humor` DISABLE KEYS */;
INSERT INTO `humor` VALUES (1,'humor','감동','ㅁ','ㅠ','choimory','최모리','2020-01-30 16:03:19');
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
  `COMMENT_GROUP` int(10) unsigned NOT NULL,
  `COMMENT_STEP` int(10) unsigned NOT NULL,
  `COMMENT_INDENT` int(10) unsigned NOT NULL,
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_humor_comment_BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_humor_comment_ID_idx` (`ID`),
  KEY `FK_humor_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_humor_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `humor` (`BOARD_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_humor_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_humor_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `COMMENT_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_humor_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_humor_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `humor_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_comment_info`
--

LOCK TABLES `humor_comment_info` WRITE;
/*!40000 ALTER TABLE `humor_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humor_file`
--

DROP TABLE IF EXISTS `humor_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humor_file` (
  `FILE_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `FILE_ORIGINAL_NAME` varchar(255) NOT NULL,
  `FILE_STORED_NAME` varchar(255) NOT NULL,
  `FILE_SIZE` int(11) NOT NULL,
  PRIMARY KEY (`FILE_INDEX`),
  KEY `FK_humor_file_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_humor_file_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `humor` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_file`
--

LOCK TABLES `humor_file` WRITE;
/*!40000 ALTER TABLE `humor_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `humor_file` ENABLE KEYS */;
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
  `BOARD_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_humor_info_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_humor_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `humor` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humor_info`
--

LOCK TABLES `humor_info` WRITE;
/*!40000 ALTER TABLE `humor_info` DISABLE KEYS */;
INSERT INTO `humor_info` VALUES (1,38,0,0,0,0,0,0,1);
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
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `NICKNAME_UNIQUE` (`NICKNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('choimory','$2a$10$s032Ie8UkYvWMhp2g23VO.piFSqAzEbt6wQYNLUggK4eXmNjZoXsG','최모리','choimory@naver.com'),('morychoi','$2a$10$MU3bPMXvmihUcRqqJmvnjeZd5nPZp8JhW3WafwvOaC7Dpp1sz7AB6','모리최','morychoi@naver.com'),('test1','$2a$10$rl07y5EPikCyg5yg8e.ZVutLFf86SE.tOPTV4oGu6lQvB3yDxzxXq','test1','test1@test1.test1'),('test2','$2a$10$nGb47BqCvqTttUwFyYXMAuO8DykBpFp3Em05XHWJ6taMPIjbgZUyq','test2','test2@test2.test2'),('test3','$2a$10$Vje6VIjP6php71WrhCfTLehuc6cj9o2cX8Ui3wJQjlZsMMHbh.mwm','test3','test3@test3.test3'),('test4','$2a$10$8DO./tBKN98ssSZ08Lwq0eInRLp/DWd4sgWRMRuKz2rx0twXsYJU6','test4','test4@test4.test4'),('test5','$2a$10$jJY7PlrJRysfo6VmxL5yLOpPZcZc0ePHHXlb/83abswT6sFn9Brh2','test5','test5@test5.test5');
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
  `BAN` tinyint(1) NOT NULL DEFAULT '1',
  `REASON` varchar(255) DEFAULT NULL,
  `ENDTOBAN` datetime DEFAULT NULL,
  KEY `FK_member_ban_ID_idx` (`ID`),
  CONSTRAINT `FK_member_ban_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  KEY `FK_member_info_ID_idx` (`ID`),
  CONSTRAINT `FK_member_info_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES ('choimory',1,1,0,'2020-01-16 15:57:28','2020-02-05 20:43:38','admin'),('morychoi',1,1,0,'2020-01-23 11:35:31','2020-01-29 17:18:13',NULL),('test1',1,1,0,'2020-01-29 08:27:44','2020-01-29 09:28:41',NULL),('test2',1,1,0,'2020-01-29 08:29:17','2020-01-29 08:29:17',NULL),('test3',1,1,0,'2020-01-29 08:31:00','2020-01-29 08:31:00',NULL),('test4',1,1,0,'2020-01-29 09:18:31','2020-01-29 09:18:31',NULL),('test5',1,1,0,'2020-01-29 09:21:58','2020-01-29 09:21:58',NULL);
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
  CONSTRAINT `FK_member_item_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_member_item_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  KEY `FK_report_article_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_report_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_report_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_article`
--

LOCK TABLES `report_article` WRITE;
/*!40000 ALTER TABLE `report_article` DISABLE KEYS */;
INSERT INTO `report_article` VALUES ('choimory','game','lol',25),('choimory','game','lol',11),('choimory','game','overwatch',24),('choimory','game','overwatch',23),('morychoi','game','lol',25),('morychoi','game','lol',11),('morychoi','game','overwatch',24),('morychoi','game','overwatch',23),('morychoi','game','overwatch',22),('choimory','game','lol',32);
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
  `SHOP_REGDATE` datetime NOT NULL,
  PRIMARY KEY (`SHOP_INDEX`),
  KEY `FK_shop_ID_idx` (`ID`),
  KEY `FK_shop_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_shop_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `S_COMMENT_REGDATE` datetime NOT NULL,
  `S_COMMENT_GROUP` int(10) unsigned NOT NULL,
  `S_COMMENT_STEP` int(10) unsigned NOT NULL,
  `S_COMMENT_INDENT` int(10) unsigned NOT NULL,
  PRIMARY KEY (`S_COMMENT_INDEX`),
  KEY `FK_shop_comment_SHOP_INDEX_idx` (`SHOP_INDEX`),
  KEY `FK_shop_comment_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_shop_comment_ID_idx` (`ID`),
  CONSTRAINT `FK_shop_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_shop_comment_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `S_COMMENT_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `S_COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `S_COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `S_COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `S_COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_shop_comment_info_S_COMMENT_INDEX_idx` (`S_COMMENT_INDEX`),
  CONSTRAINT `FK_shop_comment_info_S_COMMENT_INDEX` FOREIGN KEY (`S_COMMENT_INDEX`) REFERENCES `shop_comment` (`S_COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `SHOP_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `SHOP_PERMISSION` tinyint(1) NOT NULL DEFAULT '0',
  `SHOP_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_shop_info_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_shop_info_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  CONSTRAINT `FK_shop_report_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_report_article_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  CONSTRAINT `FK_shop_vote_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_vote_article_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  CONSTRAINT `FK_shop_vote_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_vote_comment_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_vote_comment_S_COMMENT_INDEX` FOREIGN KEY (`S_COMMENT_INDEX`) REFERENCES `shop_comment` (`S_COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`BOARD_INDEX`),
  KEY `FK_sports_ID_idx` (`ID`),
  KEY `FK_sports_NICKNAME_idx` (`NICKNAME`),
  KEY `FK_sports_BOARD_ID_idx` (`BOARD_ID`),
  CONSTRAINT `FK_sports_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_sports_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_sports_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports`
--

LOCK TABLES `sports` WRITE;
/*!40000 ALTER TABLE `sports` DISABLE KEYS */;
INSERT INTO `sports` VALUES (1,'baseball','잡담','테스트1','테스트1','choimory','최모리','2020-02-02 10:12:51'),(2,'baseball','잡담','테스트2','테스트2','choimory','최모리','2020-02-02 10:13:14'),(3,'baseball','잡담','테3','테3','choimory','최모리','2020-02-02 10:16:45'),(4,'baseball','잡담','테4','테4','choimory','최모리','2020-02-02 10:17:19'),(5,'baseball','잡담','테5','ㅌ5','choimory','최모리','2020-02-02 10:19:07'),(6,'baseball','잡담','ㅌ1','ㅌ1','choimory','최모리','2020-02-02 10:22:52'),(7,'baseball','잡담','ㅌ2','ㅌ2','choimory','최모리','2020-02-02 10:23:10'),(8,'baseball','잡담','ㅌ1','ㅌ1','choimory','최모리','2020-02-02 10:25:25'),(9,'baseball','잡담','ㅁ','ㅁ','choimory','최모리','2020-02-02 10:26:38'),(10,'baseball','잡담','ㅌ','ㅌ','choimory','최모리','2020-02-02 10:28:47'),(11,'baseball','잡담','ㅁㄴㅇㄹ','ㅁㄴㅇㄹ','choimory','최모리','2020-02-02 10:31:57'),(12,'baseball','잡담','ㄴㅇㅍㄴㅇ','','choimory','최모리','2020-02-02 10:32:11');
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
  `COMMENT_GROUP` int(10) NOT NULL DEFAULT '0',
  `COMMENT_STEP` int(10) NOT NULL DEFAULT '0',
  `COMMENT_INDENT` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`COMMENT_INDEX`),
  KEY `FK_sports_comment_BOARD_INDEX_idx` (`BOARD_INDEX`),
  KEY `FK_sports_comment_ID_idx` (`ID`),
  KEY `FK_sports_comment_NICKNAME_idx` (`NICKNAME`),
  CONSTRAINT `FK_sports_comment_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `sports` (`BOARD_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_sports_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_sports_comment_NICKNAME` FOREIGN KEY (`NICKNAME`) REFERENCES `member` (`NICKNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `COMMENT_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `COMMENT_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `COMMENT_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_sports_comment_info_COMMENT_INDEX_idx` (`COMMENT_INDEX`),
  CONSTRAINT `FK_sports_comment_info_COMMENT_INDEX` FOREIGN KEY (`COMMENT_INDEX`) REFERENCES `sports_comment` (`COMMENT_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_comment_info`
--

LOCK TABLES `sports_comment_info` WRITE;
/*!40000 ALTER TABLE `sports_comment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `sports_comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports_file`
--

DROP TABLE IF EXISTS `sports_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports_file` (
  `FILE_INDEX` int(11) NOT NULL AUTO_INCREMENT,
  `BOARD_INDEX` int(11) NOT NULL,
  `FILE_ORIGINAL_NAME` varchar(255) NOT NULL,
  `FILE_STORED_NAME` varchar(255) NOT NULL,
  `FILE_SIZE` int(11) NOT NULL,
  PRIMARY KEY (`FILE_INDEX`),
  KEY `FK_sports_file_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_sports_file_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `sports` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_file`
--

LOCK TABLES `sports_file` WRITE;
/*!40000 ALTER TABLE `sports_file` DISABLE KEYS */;
INSERT INTO `sports_file` VALUES (2,2,'unnamed.jpg','2_unnamed.jpg',286201),(7,7,'unnamed.jpg','7_unnamed.jpg',286201),(10,12,'unnamed.jpg','12_unnamed.jpg',286201);
/*!40000 ALTER TABLE `sports_file` ENABLE KEYS */;
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
  `BOARD_DOWNVOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_COMMENTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_REPORTNUM` int(10) unsigned NOT NULL DEFAULT '0',
  `BOARD_BLIND` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_NOTICE` tinyint(1) NOT NULL DEFAULT '0',
  `BOARD_BEST` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FK_sports_info_BOARD_INDEX_idx` (`BOARD_INDEX`),
  CONSTRAINT `FK_sports_info_BOARD_INDEX` FOREIGN KEY (`BOARD_INDEX`) REFERENCES `sports` (`BOARD_INDEX`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports_info`
--

LOCK TABLES `sports_info` WRITE;
/*!40000 ALTER TABLE `sports_info` DISABLE KEYS */;
INSERT INTO `sports_info` VALUES (1,1,0,0,0,0,0,0,0),(2,1,0,0,0,0,0,0,0),(3,1,0,0,0,0,0,0,0),(4,3,0,0,0,0,0,0,0),(5,1,0,0,0,0,0,0,0),(6,1,0,0,0,0,0,0,0),(7,1,0,0,0,0,0,0,0),(8,1,0,0,0,0,0,0,0),(9,1,0,0,0,0,0,0,0),(10,1,0,0,0,0,0,0,0),(11,1,0,0,0,0,0,0,0),(12,3,0,0,0,0,0,0,0);
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
  KEY `FK_vote_article_BOARD_ID_idx` (`BOARD_ID`),
  KEY `FK_vote_article_ID_idx` (`ID`),
  CONSTRAINT `FK_vote_article_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_article_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_article`
--

LOCK TABLES `vote_article` WRITE;
/*!40000 ALTER TABLE `vote_article` DISABLE KEYS */;
INSERT INTO `vote_article` VALUES ('choimory','game','overwatch',20,1),('morychoi','game','overwatch',20,1),('test1','game','overwatch',20,1),('test2','game','overwatch',20,1),('test3','game','overwatch',20,1),('test4','game','overwatch',20,1),('test5','game','lol',11,1),('test5','game','overwatch',20,1),('test5','game','overwatch',14,1),('test5','game','overwatch',5,1),('test1','game','overwatch',5,1),('choimory','game','overwatch',7,-1),('choimory','game','overwatch',5,-1),('choimory','game','lol',11,-1),('choimory','game','overwatch',21,-1),('choimory','game','overwatch',22,-1),('choimory','game','overwatch',23,-1),('choimory','game','overwatch',24,-1),('choimory','game','lol',32,1);
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
  KEY `FK_vote_comment_BOARD_ID_idx` (`BOARD_ID`),
  KEY `FK_vote_comment_ID_idx` (`ID`),
  CONSTRAINT `FK_vote_comment_BOARD_ID` FOREIGN KEY (`BOARD_ID`) REFERENCES `board_type` (`BOARD_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vote_comment_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_comment`
--

LOCK TABLES `vote_comment` WRITE;
/*!40000 ALTER TABLE `vote_comment` DISABLE KEYS */;
INSERT INTO `vote_comment` VALUES ('choimory','game','overwatch',17,1),('choimory','game','overwatch',18,1),('choimory','game','overwatch',16,1),('choimory','game','overwatch',20,1),('choimory','game','overwatch',19,1),('choimory','game','overwatch',21,1),('choimory','game','overwatch',22,1),('choimory','game','overwatch',24,1),('choimory','game','overwatch',25,1),('choimory','game','overwatch',26,1),('choimory','game','overwatch',28,1),('choimory','game','overwatch',29,1),('choimory','game','overwatch',35,1),('choimory','game','lol',40,1),('choimory','game','lol',39,1),('choimory','game','lol',36,1),('choimory','game','lol',42,1),('choimory','game','lol',41,1),('choimory','game','lol',43,1),('morychoi','game','lol',43,1),('morychoi','game','lol',45,1),('morychoi','game','lol',44,1),('morychoi','game','lol',46,-1),('morychoi','game','lol',47,-1),('choimory','game','lol',44,1),('choimory','game','lol',45,1),('choimory','game','lol',46,-1),('choimory','game','lol',47,-1),('choimory','game','lol',48,-1);
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
  KEY `FK_wishlist_ID_idx` (`ID`),
  KEY `FK_wishlist_SHOP_INDEX_idx` (`SHOP_INDEX`),
  CONSTRAINT `FK_wishlist_ID` FOREIGN KEY (`ID`) REFERENCES `member` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_wishlist_SHOP_INDEX` FOREIGN KEY (`SHOP_INDEX`) REFERENCES `shop` (`SHOP_INDEX`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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

-- Dump completed on 2020-02-05 21:33:26
