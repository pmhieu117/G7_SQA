-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: bhyt
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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address_gks` varchar(255) DEFAULT NULL,
  `cccd` varchar(12) DEFAULT NULL,
  `cccd_sau` varchar(255) DEFAULT NULL,
  `cccd_truoc` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gioi_tinh` varchar(20) DEFAULT NULL,
  `ho_ten` varchar(100) DEFAULT NULL,
  `img_chan_dung` varchar(255) DEFAULT NULL,
  `img_gks` varchar(255) DEFAULT NULL,
  `muc_huong` varchar(1) DEFAULT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phuong_xa` varchar(50) DEFAULT NULL,
  `quan_he_chu_ho` varchar(255) DEFAULT NULL,
  `quan_huyen` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(11) DEFAULT NULL,
  `tinh_thanh_pho` varchar(50) DEFAULT NULL,
  `bhxh` varchar(10) DEFAULT NULL,
  `code_ct_co_quan_bhxh` varchar(255) DEFAULT NULL,
  `code_doi_tuong_bhyt` varchar(255) DEFAULT NULL,
  `ho_gia_dinh` varchar(255) DEFAULT NULL,
  `bhyt` varchar(15) DEFAULT NULL,
  `code_tinhtp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86jrlku6v0wjxyl3cvyhi355n` (`code_ct_co_quan_bhxh`),
  KEY `FKjvgnt7p0k7pptscj8u7h3j3a0` (`code_doi_tuong_bhyt`),
  KEY `FKflwfwx9aemx2pa7lajqg5bjbc` (`ho_gia_dinh`),
  KEY `FK5gjedv6ktnqsv3n9sux3xfl8b` (`code_tinhtp`),
  CONSTRAINT `FK5gjedv6ktnqsv3n9sux3xfl8b` FOREIGN KEY (`code_tinhtp`) REFERENCES `co_quan_bhxh` (`code`),
  CONSTRAINT `FK86jrlku6v0wjxyl3cvyhi355n` FOREIGN KEY (`code_ct_co_quan_bhxh`) REFERENCES `chi_tiet_co_quan_bhxh` (`code`),
  CONSTRAINT `FKflwfwx9aemx2pa7lajqg5bjbc` FOREIGN KEY (`ho_gia_dinh`) REFERENCES `ho_gia_dinh` (`code`),
  CONSTRAINT `FKjvgnt7p0k7pptscj8u7h3j3a0` FOREIGN KEY (`code_doi_tuong_bhyt`) REFERENCES `doi_tuong_bhyt` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Bệnh viện phụ sản Hải Phòng','111111111111','link_img','link_img','Quán Toan, Hồng Bàng, Hải Phòng','pmh@gmail.com','Nam','Phạm Minh Hiếu','link_img',NULL,'3','11/07/2001','$2a$10$qwd9N12c13Cq4WOvMZWRSej121iXfdmUsNksRgQK.Rsh8P8teu1De','Phường Quán Toan','Con','Quận Hồng Bàng','123456789','TP Hải Phòng','1234567890','03108',NULL,'3198926674','TE1311234567890','031'),(2,'Bệnh viện phụ sản Hải Phòng','222222222222','link_img','link_img','Trực Thuận, Trực Ninh, Nam Định','phm@gmail.com','Nữ','Phạm Hùng Minh','link_img',NULL,'3','25/11/2006','$2a$10$tYscnUiqfdMU/N02z04MwuHDbHms4vwN9MqLpKvV8YoXaH5XfKfBa','Xã Trực Thuận','Con','Huyện Trực Ninh','012345678','Tỉnh Nam Định','0123456789','03108',NULL,'3198926674','GD4310123456789','031'),(3,'Bệnh viện phụ sản Hải Phòng','333333333333','link_img','link_img','Nam Sơn, An Dương, Hải Phòng','pva@gmail.com','Nam','Phạm Văn A','link_img',NULL,'4','02/03/1971','$2a$10$DlwQP3kP4wwZ9aRnwevvjOCq1d.qE9.Rtb9pWnsnIvVtYmiJI4RFy','Xã Nam Sơn','Chủ hộ','Huyện An Dương','0012345678','Thành phố Hải Phòng','1234567899','03108',NULL,'3198926674','GD4311234567899','031'),(4,'Bệnh viện phụ sản Hải Phòng','444444444444','http://res.cloudinary.com/hieupm117/image/upload/4444444444_cccd_sau','http://res.cloudinary.com/hieupm117/image/upload/4444444444_cccd_truoc','Phan Thiết, Tuyên Quang','nvb@gmail.com','Nam','Nguyễn Văn B','http://res.cloudinary.com/hieupm117/image/upload/4444444444_avt',NULL,NULL,'05/03/1999','$2a$10$SOZ/grBnDsJ6woOPRv1VxO01QuQYpAxFX2eSla2oolOhHss6h3B8S','Phường Phan Thiết','Vợ','Thành phố Tuyên Quang','4444444444','Tỉnh Tuyên Quang','4444444444',NULL,NULL,NULL,NULL,NULL),(5,'Bệnh viện phụ sản Hải Phòng','555555555555','http://res.cloudinary.com/hieupm117/image/upload/5555555555_cccd_sau','http://res.cloudinary.com/hieupm117/image/upload/5555555555_cccd_truoc','hh','ntc@gmail.com','Nữ','Nguyễn Thị C','http://res.cloudinary.com/hieupm117/image/upload/5555555555_avt',NULL,'','09/07/1998','$2a$10$ClOflpoUJmKiHh6X7jpm9ex8vnsYAp0gldLfvn8Wbm7brBeGDhZU6','Phường Hạp Lĩnh','Con','Thành phố Bắc Ninh','5555555555','Tỉnh Bắc Ninh','5555555555',NULL,NULL,NULL,NULL,NULL),(6,'Bệnh viện phụ sản Hải Phòng','666666666666','http://res.cloudinary.com/hieupm117/image/upload/6666666666_cccd_sau','http://res.cloudinary.com/hieupm117/image/upload/6666666666_cccd_truoc','Cô Tô Quảng Ninh','ntd@gmail.com','Nữ','Nguyễn Thị D','http://res.cloudinary.com/hieupm117/image/upload/6666666666_avt',NULL,NULL,'11/01/2005','$2a$10$Qw7wWN36CnQOTbAU4naj2eakODgImEmDyf/bp94EDW0wLgJUCyEMi','Thị trấn Cô Tô',NULL,'Huyện Cô Tô','6666666666','Tỉnh Quảng Ninh','6666666666',NULL,NULL,NULL,NULL,NULL),(7,'Bệnh viện phụ sản Hải Phòng','777777777777',NULL,NULL,NULL,NULL,'Nam','Phạm Văn E',NULL,NULL,NULL,'25/11/2006',NULL,NULL,'Chủ hộ',NULL,NULL,NULL,'7777777777',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-05 22:14:00
