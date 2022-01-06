-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: cuahangsach
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
-- Table structure for table `chude`
--

DROP TABLE IF EXISTS `chude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chude` (
  `MaChuDe` varchar(10) NOT NULL,
  `TenChuDe` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`MaChuDe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chude`
--

LOCK TABLES `chude` WRITE;
/*!40000 ALTER TABLE `chude` DISABLE KEYS */;
INSERT INTO `chude` VALUES ('KNS','Kỹ năng sống'),('KT','Kinh tế'),('NK','Nhật ký'),('NN','Ngoại ngữ'),('TH','Tin học'),('TH1','Toán học'),('TN','Thiếu nhi'),('TT','Thể thao'),('VH','Văn hoá');
/*!40000 ALTER TABLE `chude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `userId` int NOT NULL,
  `tenDangNhap` varchar(45) DEFAULT NULL,
  `matKhau` varchar(45) DEFAULT NULL,
  `hoTen` varchar(45) DEFAULT NULL,
  `dienThoai` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL,
  `vaiTroId` int NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'tungnb','123','Nguyễn Bá Tùng',924830938,'tung@gmail.com','Hải Dương',0);
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `MaSach` varchar(10) NOT NULL,
  `TenSach` varchar(150) DEFAULT NULL,
  `MoTa` varchar(500) DEFAULT NULL,
  `AnhSach` varchar(100) DEFAULT NULL,
  `GiaSach` float DEFAULT NULL,
  `TacGia` varchar(30) DEFAULT NULL,
  `NgayTao` date DEFAULT NULL,
  `NgayCapNhat` date DEFAULT NULL,
  `NgayDuyet` date DEFAULT NULL,
  `DaDuyet` bit(1) DEFAULT b'0',
  `MaChuDe` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MaSach`),
  KEY `FK_ChuDe_Id` (`MaChuDe`),
  CONSTRAINT `FK_ChuDe_Id` FOREIGN KEY (`MaChuDe`) REFERENCES `chude` (`MaChuDe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('JV01','Lập trình Java cơ bản 1','Sách dành cho các bạn mới học lập trình java',NULL,150000,'Thompson',NULL,'2021-10-24',NULL,_binary '\0','TH'),('JV0122','Lập trình Java cơ bản 1','Sách dành cho các bạn mới học lập trình java',NULL,150000,'Thompson',NULL,NULL,NULL,_binary '\0','TH'),('JV013','Lập trình Java cơ bản 12222','Sách dành cho các bạn mới học lập trình java',NULL,150000,'Thompson',NULL,NULL,NULL,_binary '\0','TH'),('JV02','Lập trình Java nâng cao','Sách dành cho các bạn đã có kiến thức về java muốn học kiến thức nâng cao về ngôn ngữ này','java_program.jpg',250000,'Hottman','2021-10-24','2021-10-24','2021-10-24',_binary '','TH'),('MT1','tt','dfsfs','csharp2.jpg',2000,'tùng',NULL,NULL,NULL,_binary '\0','KNS'),('NT888','Acvbcc','ừaasfafaf','csharp2.jpg',454545,'Tùng',NULL,NULL,NULL,_binary '\0',NULL);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-06  9:54:06
