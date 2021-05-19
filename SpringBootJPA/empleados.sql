
DROP TABLE IF EXISTS `cargos`;

CREATE TABLE `cargos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;





DROP TABLE IF EXISTS `datos_laborales`;

CREATE TABLE `datos_laborales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salario` int(11) NOT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `cargos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)) ;




DROP TABLE IF EXISTS `hijos`;

CREATE TABLE `hijos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chicos` int(11) NOT NULL DEFAULT '0',
  `chicas` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ;
 

DROP TABLE IF EXISTS `datos_personales`;

CREATE TABLE `datos_personales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado_civil` varchar(45) NOT NULL,
  `hijos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`));




DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `datos_personales_id` int(11) NOT NULL,
  `dtos_laborales_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
  ) ;









