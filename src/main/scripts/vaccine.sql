CREATE TABLE `vaccnow`.`vaccine` (
  `vaccine_id` INT NOT NULL AUTO_INCREMENT,
  `patient_email` VARCHAR(45) NOT NULL,
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `booking_date` DATETIME NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  `payment_method` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`vaccine_id`)
);
