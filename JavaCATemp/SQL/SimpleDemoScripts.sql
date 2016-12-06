create database sample;

use sample;
DROP TABLE IF EXISTS `sample`.`heros`;
CREATE TABLE  `sample`.`heros` (
  `name` varchar(50) NOT NULL,
  `description` varchar(255) default NULL,
  `play` varchar(255) default NULL,
   PRIMARY KEY  (`name`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `sample`.`employee`;
create table employee(
    employeeid varchar(16) not null primary key,
    name varchar(64),
    managerid varchar(16)
    );



 insert into heros values("Mother Theresa","Peace Maker","RealLife");
 insert into heros values("Ghandhi","Freedom Fighter","RealLife");
 insert into heros values("Givera","Free Thinker","RealLife");
 insert into heros values("Jackie Chan","Stunt Guy","Drunken Monk");
 

 insert into employee values("emp-1","Dilbert","emp-3");
 insert into employee values("emp-2","Wally","emp-3");
 insert into employee values("emp-3","Pointy Hair Manager","emp-4");
 insert into employee values("emp-4","Dogbert","");
 insert into employee values("emp-5","Alice","emp-3");
 insert into employee values("emp-6","Catbert","emp-4");
 
 
