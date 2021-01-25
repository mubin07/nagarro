CREATE TABLE `vaccnow`.`branch` (
  `branch_id` INT NOT NULL AUTO_INCREMENT,
  `branch_name` VARCHAR(45) NOT NULL,
  `available_vaccine` INT NULL,
  `applied_vaccine` INT NULL,
  PRIMARY KEY (`branch_id`));

