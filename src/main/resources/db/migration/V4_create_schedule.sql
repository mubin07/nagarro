CREATE TABLE `vaccnow`.`schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`schedule_id`));