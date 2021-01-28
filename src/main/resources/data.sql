CREATE SCHEMA `vaccnow`;

CREATE TABLE `vaccnow`.`branch` (
  `branch_id` INT NOT NULL AUTO_INCREMENT,
  `branch_name` VARCHAR(45) NOT NULL,
  `available_vaccine` INT NULL,
  `applied_vaccine` INT NULL,
  PRIMARY KEY (`branch_id`));

CREATE TABLE `vaccnow`.`slot` (
  `slot_id` VARCHAR(3) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  PRIMARY KEY (`slot_id`));

CREATE TABLE `vaccnow`.`schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`schedule_id`));

CREATE TABLE `vaccnow`.`vaccine` (
  `vaccine_id` INT NOT NULL AUTO_INCREMENT,
  `patient_email` VARCHAR(45) NOT NULL,
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `booking_date` DATETIME NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  `payment_method` VARCHAR(6) NOT NULL,
  `is_applied` TINYINT(1) NOT NULL,
  PRIMARY KEY (`vaccine_id`)
);