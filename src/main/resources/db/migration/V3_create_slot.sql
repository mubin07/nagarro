CREATE TABLE `vaccnow`.`slot` (
  `slot_id` VARCHAR(3) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  PRIMARY KEY (`slot_id`));