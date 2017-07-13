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
  `diasVencimiento` INT(11) NULL,
  `nombreCliente` VARCHAR(45) NULL,
  `primerApellido` VARCHAR(45) NULL,
  `segundoApellido` VARCHAR(45) NULL,
  `cedula` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(150) NULL,
  `email` VARCHAR(45) NULL,
  `fechaIngreso` VARCHAR(45) NULL,
  `fechaPago` VARCHAR(45) NULL,
  `fechaSigPago` VARCHAR(45) NULL,
  `morosidades` VARCHAR(200) NULL,
  `comentarios` VARCHAR(300) NULL,
  `tratoEspecial` TINYINT NULL,
  `eliminado` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnessgarage`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessgarage`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `primerApellido` VARCHAR(45) NULL,
  `segundoApellido` VARCHAR(45) NULL,
  `eliminado` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
