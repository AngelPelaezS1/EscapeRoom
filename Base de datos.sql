-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema escaperoom
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema escaperoom
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `escaperoom` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `escaperoom` ;

-- -----------------------------------------------------
-- Table `escaperoom`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `difficulty` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = ascii;


-- -----------------------------------------------------
-- Table `escaperoom`.`track`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`track` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `topics` VARCHAR(45) NOT NULL,
  `track_details` VARCHAR(155) NOT NULL,
  `rooms_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tracks_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_tracks_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `escaperoom`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escaperoom`.`object`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`object` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `material` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  `rooms_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_objects_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_objects_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `escaperoom`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escaperoom`.`session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`session` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `played_time` DATETIME NOT NULL,
  `finished` TINYINT NOT NULL,
  `rooms_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_session_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_session_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `escaperoom`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escaperoom`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(60) NOT NULL,
  `notification` TINYINT NOT NULL,
  `session_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_players_session1_idx` (`session_id` ASC) VISIBLE,
  CONSTRAINT `fk_players_session1`
    FOREIGN KEY (`session_id`)
    REFERENCES `escaperoom`.`session` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escaperoom`.`certificate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`certificate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `achievement` VARCHAR(45) NOT NULL,
  `gift` VARCHAR(45) NOT NULL,
  `players_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_certificates_players1_idx` (`players_id` ASC) VISIBLE,
  CONSTRAINT `fk_certificates_players1`
    FOREIGN KEY (`players_id`)
    REFERENCES `escaperoom`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escaperoom`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escaperoom`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` FLOAT NOT NULL,
  `players_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_players1_idx` (`players_id` ASC) VISIBLE,
  CONSTRAINT `fk_tickets_players1`
    FOREIGN KEY (`players_id`)
    REFERENCES `escaperoom`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
