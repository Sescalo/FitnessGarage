-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fitnessgarage
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitnessgarage` ;

-- -----------------------------------------------------
-- Schema fitnessgarage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnessgarage` DEFAULT CHARACTER SET utf8 ;
USE `fitnessgarage` ;

-- -----------------------------------------------------
-- Table `fitnessgarage`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessgarage`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `diasVencimiento` INT(11) NULL DEFAULT NULL,
  `nombreCliente` VARCHAR(45) NULL DEFAULT NULL,
  `primerApellido` VARCHAR(45) NULL DEFAULT NULL,
  `segundoApellido` VARCHAR(45) NULL DEFAULT NULL,
  `cedula` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(150) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `fechaIngreso` VARCHAR(45) NULL DEFAULT NULL,
  `fechaPago` VARCHAR(45) NULL DEFAULT NULL,
  `fechaSigPago` VARCHAR(45) NULL DEFAULT NULL,
  `morosidades` VARCHAR(200) NULL DEFAULT NULL,
  `comentarios` VARCHAR(300) NULL DEFAULT NULL,
  `tratoEspecial` TINYINT(4) NULL DEFAULT NULL,
  `eliminado` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 2012
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnessgarage`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessgarage`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `primerApellido` VARCHAR(45) NULL DEFAULT NULL,
  `segundoApellido` VARCHAR(45) NULL DEFAULT NULL,
  `eliminado` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnessgarage`.`Historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessgarage`.`Historial` (
  `idHistorial` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idHistorial`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;