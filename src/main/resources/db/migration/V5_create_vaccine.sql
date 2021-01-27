CREATE TABLE `vaccnow`.`vaccine` (
  `vaccine_id` INT NOT NULL AUTO_INCREMENT,
  `patient_email` VARCHAR(45) NOT NULL,
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `booking_date` DATETIME NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  `payment_method` VARCHAR(6) NOT NULL,
  `is_applied` TINYINT(1) NOT NULL,
  PRIMARY KEY (`vaccine_id`),
  UNIQUE INDEX `patient_email_UNIQUE` (`patient_email` ASC) VISIBLE,
  INDEX `fk_branch_idx` (`branch_id` ASC) VISIBLE,
  INDEX `fk_slot_idx` (`slot_id` ASC) VISIBLE,
  CONSTRAINT `fk_branch`
    FOREIGN KEY (`branch_id`)
    REFERENCES `vaccnow`.`branch` (`branch_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_slot`
    FOREIGN KEY (`slot_id`)
    REFERENCES `vaccnow`.`slot` (`slot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
