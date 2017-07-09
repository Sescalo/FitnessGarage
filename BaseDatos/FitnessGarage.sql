-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema FitnessGarage
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FitnessGarage` ;

-- -----------------------------------------------------
-- Schema FitnessGarage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FitnessGarage` DEFAULT CHARACTER SET utf8 ;
USE `FitnessGarage` ;

-- -----------------------------------------------------
-- Table `FitnessGarage`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FitnessGarage`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `diasVencimiento` INT NOT NULL,
  `nombreCliente` VARCHAR(45) NOT NULL,
  `primerApellido` VARCHAR(45) NOT NULL,
  `segundoApellido` VARCHAR(45) NOT NULL,
  `cedula` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(150) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `fechaIngreso` VARCHAR(45) NOT NULL,
  `fechaPago` VARCHAR(45) NOT NULL,
  `fechaSigPago` VARCHAR(45) NOT NULL,
  `comentarios` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
