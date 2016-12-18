
#Database creation script
CREATE DATABASE `project_1` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `products` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `id_category` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `email_user` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `admin` int(11) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#End table creation




