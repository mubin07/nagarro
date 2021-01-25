CREATE TABLE `vaccnow`.`schedule` (
  `branch_id` INT NOT NULL,
  `appointment_date` DATE NOT NULL,
  `slot_id` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`branch_id`, `appointment_date`, `slot_id`),
  INDEX `branch` (`branch_id` ASC) INVISIBLE,
  INDEX `appointment_date` (`appointment_date` ASC) INVISIBLE,
  INDEX `slot` (`slot_id` ASC) VISIBLE);
