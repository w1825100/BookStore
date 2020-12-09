/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.28-log : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`,`price`,`author`,`sales`,`stock`,`img_path`) values (2,'数据结构与算法','2.00','严敏君',20,122,'static/img/default.jpg'),(3,'怎样拐跑别人的媳妇','3.00','龙伍',28,0,'static/img/bk_name/3.jpg'),(4,'木虚肉盖饭','16.00','小胖',1054,0,'static/img/bk_name/4.jpg'),(6,'蛋炒饭','9.90','周星星',43,22,'static/img/bk_name/6.jpg'),(7,'赌神','66.50','龙伍',139,521,'static/img/bk_name/7.jpg'),(8,'Java编程思想','99.50','阳哥',57,26,'static/img/bk_name/8.jpg'),(9,'JavaScript从入门到精通','9.90','婷姐',88,93,'static/img/default.jpg'),(10,'cocos2d-x游戏编程入门','49.00','国哥',63,51,'static/img/bk_name/10.jpg'),(11,'C语言程序设计','28.00','谭浩强',54,72,'static/img/bk_name/5.jpg'),(12,'Lua语言程序设计','51.50','雷丰阳',49,81,'static/img/bk_name/12.jpg'),(16,'数据结构 java版','173.15','封大神',21,81,'static/img/bk_name/5.jpg'),(17,'UNIX高级环境编程','99.15','乐天',210,810,'static/img/default.jpg'),(18,'javaScript高级编程','69.15','国哥',210,810,'static/img/bk_name/5.jpg'),(19,'大话设计模式','89.15','国哥',29,1,'static/img/default.jpg'),(20,'人月神话','88.15','刚哥',20,80,'static/img/default.jpg'),(21,'java从入门到放弃','80.00','国哥',9111,2,'static/img/default.jpg'),(22,'数据结构与算法','78.50','严敏君',6,13,'static/img/bk_name/5.jpg'),(23,'怎样拐跑别人的媳妇','68.00','龙伍',99999,52,'static/img/default.jpg'),(24,'木虚肉盖饭','16.00','小胖',1000,50,'static/img/default.jpg'),(25,'C++编程思想','45.50','刚哥',14,95,'static/img/default.jpg'),(26,'蛋炒饭','9.90','周星星',12,53,'static/img/default.jpg');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`order_id`,`create_time`,`price`,`status`,`user_id`) values ('160342447371714','2020-10-23 11:41:13','914.35',1,14),('16034494682071','2020-10-23 18:37:48','446.00',1,NULL),('16034497612541','2020-10-23 18:42:41','8.00',1,NULL),('16044551502091','2020-11-04 09:59:10','0.00',1,NULL),('16047093307481','2020-11-07 08:35:30','190.80',0,NULL);

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

/*Data for the table `t_order_item` */

insert  into `t_order_item`(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values (105,'木虚肉盖饭',7,'16.00','112.00','160342447371714'),(106,'大话设计模式',9,'89.15','802.35','160342447371714'),(107,'木虚肉盖饭',5,'16.00','80.00','16034494682071'),(108,'数据结构与算法',1,'2.00','2.00','16034494682071'),(109,'C++编程思想',8,'45.50','364.00','16034494682071'),(110,'数据结构与算法',4,'2.00','8.00','16034497612541'),(111,'数据结构与算法',0,'2.00','0.00','16044551502091'),(112,'数据结构与算法',2,'2.00','4.00','16047093307481'),(113,'java从入门到放弃',1,'1.00','1.00','16047093307481'),(114,'蛋炒饭',2,'9.90','19.80','16047093307481'),(115,'赌神',1,'66.50','66.50','16047093307481'),(116,'Java编程思想',1,'99.50','99.50','16047093307481');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`) values (1,'admin','admin','admin@atguigu.com'),(6,'admin1','123123','123123@qq.com'),(14,'风中追风','123','adadad@qq.com'),(15,'剑客暮云','123123','123@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
