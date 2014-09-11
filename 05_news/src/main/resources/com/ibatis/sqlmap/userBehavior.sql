CREATE DATABASE IF NOT EXISTS bigdata;
USE bigdata;

DROP TABLE IF EXISTS `user_news_behavior`;
CREATE TABLE `user_news_behavior` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `news_id` bigint(20) unsigned DEFAULT NULL,
  `scan_time` datetime  DEFAULT '0000-00-00 00:00:00',
  title VARCHAR(100) default null,
  content LONGTEXT character set utf8mb4,
  `publish_time`datetime  DEFAULT '0000-00-00 00:00:00' ,
  PRIMARY KEY (`id`),
  KEY `Index_2` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



