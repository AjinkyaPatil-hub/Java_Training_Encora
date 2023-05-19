CREATE TABLE `employee_info` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(500) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `pf` tinyint(1) NOT NULL,
  `graduity` tinyint(1) NOT NULL,
  `meal_card` tinyint(1) NOT NULL,
  `office_location` varchar(100) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT;


CREATE TABLE `employee_info` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(500) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `pf` tinyint(1) NOT NULL,
  `graduity` tinyint(1) NOT NULL,
  `meal_card` tinyint(1) NOT NULL,
  `office_location` varchar(100) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;