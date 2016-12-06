CREATE SCHEMA sample;
USE sample;

CREATE TABLE `sample`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(12) NULL,
  `role` VARCHAR(45) NULL,
  `mgrid` INT,
  PRIMARY KEY (`userid`));
ALTER TABLE `sample`.`user` 
ADD INDEX `mgrid_idx` (`mgrid` ASC);
ALTER TABLE `sample`.`user` 
ADD CONSTRAINT `mgrid`
  FOREIGN KEY (`mgrid`)
  REFERENCES `sample`.`user` (`userid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("dogbert", "dogbert", "manager", null);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("pointy", "pointy", "manager", 1);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("alice", "alice", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("dilbert", "dilbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("catbert", "catbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("ashok", "ashok", "intern", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("ratbert", "ratbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("wally", "wally", "employee", 2);
  