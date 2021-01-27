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

INSERT INTO `vaccnow`.`branch` (`branch_id`, `branch_name`, `available_vaccine`, `applied_vaccine`) VALUES (1, "Branch01", 10, 0);
INSERT INTO `vaccnow`.`branch` (`branch_id`, `branch_name`, `available_vaccine`, `applied_vaccine`) VALUES (2, "Branch02", 20, 0);
INSERT INTO `vaccnow`.`branch` (`branch_id`, `branch_name`, `available_vaccine`, `applied_vaccine`) VALUES (3, "Branch03", 30, 0);
INSERT INTO `vaccnow`.`branch` (`branch_id`, `branch_name`, `available_vaccine`, `applied_vaccine`) VALUES (4, "Branch04", 40, 0);
INSERT INTO `vaccnow`.`branch` (`branch_id`, `branch_name`, `available_vaccine`, `applied_vaccine`) VALUES (5, "Branch05", 50, 0);

INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M1", "09:00:00", "09:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M2", "09:15:00", "09:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M3", "09:30:00", "09:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M4", "09:45:00", "10:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M5", "10:00:00", "10:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M6", "10:15:00", "10:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M7", "10:30:00", "10:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M8", "10:45:00", "11:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M9", "11:00:00", "11:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M10", "11:00:00", "11:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M11", "11:00:00", "11:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("M12", "11:00:00", "12:00:00");

INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A1", "12:00:00", "12:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A2", "12:15:00", "12:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A3", "12:30:00", "12:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A4", "12:45:00", "13:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A5", "13:00:00", "13:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A6", "13:15:00", "13:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A7", "13:30:00", "13:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A8", "13:45:00", "14:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A9", "14:00:00", "14:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A10", "14:00:00", "14:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A11", "14:00:00", "14:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("A12", "14:00:00", "15:00:00");

INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E1", "15:00:00", "15:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E2", "15:15:00", "15:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E3", "15:30:00", "15:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E4", "15:45:00", "16:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E5", "16:00:00", "16:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E6", "16:15:00", "16:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E7", "16:30:00", "16:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E8", "16:45:00", "17:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E9", "17:00:00", "17:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E10", "17:00:00", "17:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E11", "17:00:00", "17:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("E12", "17:00:00", "18:00:00");

INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N1", "18:00:00", "18:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N2", "18:15:00", "18:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N3", "18:30:00", "18:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N4", "18:45:00", "19:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N5", "19:00:00", "19:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N6", "19:15:00", "19:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N7", "19:30:00", "19:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N8", "19:45:00", "20:00:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N9", "20:00:00", "20:15:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N10", "20:00:00", "20:30:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N11", "20:00:00", "20:45:00");
INSERT INTO `vaccnow`.`slot` (`slot_id`, `start_time`, `end_time`) VALUES ("N12", "20:00:00", "21:00:00");

INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (1, "2021-01-27", "M1");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (2, "2021-01-27", "M1");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (3, "2021-01-27", "M1");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (4, "2021-01-27", "M1");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (5, "2021-01-27", "M1");

INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (1, "2021-01-27", "M2");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (2, "2021-01-27", "M2");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (3, "2021-01-27", "M2");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (4, "2021-01-27", "M2");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (5, "2021-01-27", "M2");

INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (1, "2021-01-27", "M3");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (2, "2021-01-27", "M3");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (3, "2021-01-27", "M3");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (4, "2021-01-27", "M3");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (5, "2021-01-27", "M3");

INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (1, "2021-01-27", "M4");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (2, "2021-01-27", "M4");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (3, "2021-01-27", "M4");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (4, "2021-01-27", "M4");
INSERT INTO `vaccnow`.`schedule`(`branch_id`, `appointment_date`, `slot_id`) VALUES (5, "2021-01-27", "M4");

INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("a1@gmail.com", 1, "2021-01-27", "2021-01-27", "M1", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("a2@gmail.com", 2, "2021-01-27", "2021-01-27", "M1", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("a3@gmail.com", 3, "2021-01-27", "2021-01-27", "M1", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("a4@gmail.com", 4, "2021-01-27", "2021-01-27", "M1", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("a5@gmail.com", 5, "2021-01-27", "2021-01-27", "M1", "CASH", 0);

INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("b1@gmail.com", 1, "2021-01-27", "2021-01-27", "M2", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("b2@gmail.com", 2, "2021-01-27", "2021-01-27", "M2", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("b3@gmail.com", 3, "2021-01-27", "2021-01-27", "M2", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("b4@gmail.com", 4, "2021-01-27", "2021-01-27", "M2", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("b5@gmail.com", 5, "2021-01-27", "2021-01-27", "M2", "CASH", 0);

INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("c1@gmail.com", 1, "2021-01-27", "2021-01-27", "M3", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("c2@gmail.com", 2, "2021-01-27", "2021-01-27", "M3", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("c3@gmail.com", 3, "2021-01-27", "2021-01-27", "M3", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("c4@gmail.com", 4, "2021-01-27", "2021-01-27", "M3", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("c5@gmail.com", 5, "2021-01-27", "2021-01-27", "M3", "CASH", 0);

INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("d1@gmail.com", 1, "2021-01-27", "2021-01-27", "M4", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("d2@gmail.com", 2, "2021-01-27", "2021-01-27", "M4", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("d3@gmail.com", 3, "2021-01-27", "2021-01-27", "M4", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("d4@gmail.com", 4, "2021-01-27", "2021-01-27", "M4", "CASH", 0);
INSERT INTO `vaccnow`.`vaccine` (`patient_email`, `branch_id`, `appointment_date`, `booking_date`, `slot_id`, `payment_method`, `is_applied`) VALUES
("d5@gmail.com", 5, "2021-01-27", "2021-01-27", "M4", "CASH", 0);
