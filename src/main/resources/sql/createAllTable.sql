CREATE TABLE IF NOT EXISTS `user`(
    `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `user_name` VARCHAR(100) DEFAULT NULL COMMENT '用户名字',
    `user_age` INT NOT NULL COMMENT '用户年龄',
    `user_gender` ENUM('男','女','保密') DEFAULT '保密' COMMENT '用户性别',
    PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `department`(
    `department_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '科室id' ,
    `department_name` VARCHAR(100) DEFAULT NULL COMMENT '科室名字',
    `department_addr` VARCHAR(100) DEFAULT NULL COMMENT '科室地址',
    `hospital_id` BIGINT(20) NOT NULL COMMENT '医院id',
    `hospital_name` VARCHAR(100) DEFAULT NULL COMMENT '医院名字',
    `department_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '挂号费',
    PRIMARY KEY ( `department_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `doctor`(
    `doctor_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '医生id',
    `doctor_name` VARCHAR(100) DEFAULT NULL COMMENT '医生名字' ,
    `department_id` BIGINT(20) NOT NULL COMMENT '科室id' ,
    PRIMARY KEY ( `doctor_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `guahao`(
    `guahao_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '挂号id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
    `department_id` BIGINT(20) NOT NULL COMMENT '科室id' ,
    `department_name` VARCHAR(100) DEFAULT NULL COMMENT '科室名字',
	`doctor_id` BIGINT(20) NOT NULL COMMENT '医生id' ,
    `create_date` DATETIME DEFAULT NULL COMMENT '挂号的时间' ,
    PRIMARY KEY ( `guahao_id` ),
	UNIQUE KEY `user_department` (`user_id`,`department_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `jiancha`(
    `jiancha_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '检查项目id' ,
    `jiancha_name` VARCHAR(100) DEFAULT NULL COMMENT '检查项目名字' ,
    `jiancha_addr` VARCHAR(100) DEFAULT NULL COMMENT '检查项目地址',
	`jiancha_time` INT DEFAULT 30 COMMENT '检查项目拿到报告所需时间（分钟）',
    `jiancha_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '检查项目费用',
    PRIMARY KEY ( `jiancha_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `jianchaOrder`(
    `jianchaOrder_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '检查项目流水id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
	`jiuzhen_id` BIGINT(20) NOT NULL COMMENT '就诊id' ,
    `jiancha_id` BIGINT(20) NOT NULL COMMENT '检查项目id' ,
    `report_id` BIGINT(20) COMMENT '报告id' ,
    `create_date` DATETIME DEFAULT NULL COMMENT '创建时间' ,
	`start_date` DATETIME DEFAULT NULL COMMENT '检查开始时间' ,
    PRIMARY KEY ( `jianchaOrder_id` ),
	UNIQUE KEY `user_jiancha` (`user_id`,`jiancha_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `report`(
    `report_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '报告id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
    `jianchaOrder_id` BIGINT(20) NOT NULL COMMENT '检查项目流水id' ,
    `report_content` longtext DEFAULT NULL COMMENT '报告内容' ,
    `create_date` DATETIME DEFAULT NULL COMMENT '创建时间' ,
    PRIMARY KEY ( `report_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `jiuzhen`(
    `jiuzhen_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '就诊id' ,
    `doctor_id` BIGINT(20) NOT NULL COMMENT '医生id' ,
    `doctor_name` VARCHAR(100) DEFAULT NULL COMMENT '医生名字' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
    `jiuzhen_content_first` longtext DEFAULT NULL COMMENT '初步诊断内容' ,
    `jiuzhen_content_finally` longtext DEFAULT NULL COMMENT '最终诊断内容' ,
	`create_date` DATETIME DEFAULT NULL COMMENT '诊断时间' ,
    PRIMARY KEY ( `jiuzhen_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;