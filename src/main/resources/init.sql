CREATE DATABASE  IF NOT EXISTS `regionsdb`;

USE `regionsdb`;

--DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NULL,
  `shortname` varchar(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



