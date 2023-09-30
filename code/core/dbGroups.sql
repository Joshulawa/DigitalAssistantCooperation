-- MySQL Script generated by MySQL Workbench
-- Tue Jan 31 13:33:54 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  `idUsers` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsers`),
  UNIQUE INDEX `idUsers_UNIQUE` (`idUsers` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Messaging Service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Messaging Service` (
  `id User` INT NOT NULL,
  `Auth Token Stuff` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id User`),
  UNIQUE INDEX `id User_UNIQUE` (`id User` ASC),
  CONSTRAINT `id User`
    FOREIGN KEY (`id User`)
    REFERENCES `mydb`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Groups` (
  `id` INT NOT NULL,
  `groupName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`broker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`broker` (
  `id` INT NOT NULL,
  `idUsers` INT NULL,
  `idGroup` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUsers_idx` (`idUsers` ASC),
  INDEX `idGroup_idx` (`idGroup` ASC),
  CONSTRAINT `idUsers`
    FOREIGN KEY (`idUsers`)
    REFERENCES `mydb`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idGroup`
    FOREIGN KEY (`idGroup`)
    REFERENCES `mydb`.`Groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;