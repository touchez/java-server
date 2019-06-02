CREATE TABLE IF NOT EXISTS `user`(
    `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `user_name` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '用户名字',
    `uid` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户openid',
    `uname` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户微信名',
    `user_gender` ENUM('男','女','保密') DEFAULT '保密' COMMENT '用户性别',
    `user_age` INT NOT NULL DEFAULT 20 COMMENT '用户年龄',
    `uavatar` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像',
    `skey` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户登录态标识',
    `sessionkey` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信登录态标识',
    PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
    `end_date` DATETIME DEFAULT NULL COMMENT '自动结束的时间' ,
    `state` INT(1) DEFAULT NULL COMMENT '是否有效' ,
    PRIMARY KEY ( `guahao_id` ),
	UNIQUE KEY `user_department` (`user_id`,`department_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# CREATE TABLE IF NOT EXISTS `jiancha`(
#     `jiancha_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '检查项目id' ,
#     `jiancha_name` VARCHAR(100) DEFAULT NULL COMMENT '检查项目名字' ,
#     `jiancha_addr` VARCHAR(100) DEFAULT NULL COMMENT '检查项目地址',
# 	`jiancha_time` INT DEFAULT 30 COMMENT '检查项目拿到报告所需时间（分钟）',
#     `jiancha_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '检查项目费用',
#     PRIMARY KEY ( `jiancha_id` )
# )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `exsanguinate`(
    `exsanguinate_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '抽血id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
    `exsanguinate_time` DATETIME DEFAULT NULL COMMENT '抽血时间' ,
    `exsanguinate_addr` VARCHAR(100) DEFAULT NULL COMMENT '抽血地址' ,
    `exsanguinate_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '抽血项目费用',
    `exsanguinate_report` VARCHAR(100) DEFAULT NULL COMMENT '抽血报告',
    `report_time` DATETIME DEFAULT NULL COMMENT '报告生成时间' ,
    `exsanguinate_attr1` VARCHAR(100) DEFAULT NULL COMMENT '生化指标1' ,
    `exsanguinate_attr2` VARCHAR(100) DEFAULT NULL COMMENT '生化指标2' ,
    `exsanguinate_attr3` VARCHAR(100) DEFAULT NULL COMMENT '生化指标3' ,
    PRIMARY KEY ( `exsanguinate_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `xray`(
    `xray_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'X光id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
    `xray_time` DATETIME DEFAULT NULL COMMENT '检验时间' ,
    `xray_addr` VARCHAR(100) DEFAULT NULL COMMENT '检验地址' ,
    `xray_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '检验项目费用',
    `xray_report` VARCHAR(100) DEFAULT NULL COMMENT '检验报告',
    `report_time` DATETIME DEFAULT NULL COMMENT '报告生成时间' ,
    `xray_img` VARCHAR(100) DEFAULT NULL COMMENT '图片url' ,
    `xray_part` VARCHAR(100) DEFAULT NULL COMMENT '检验部位' ,
    PRIMARY KEY ( `xray_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ct`(
    `ct_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'X光id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
    `ct_time` DATETIME DEFAULT NULL COMMENT '检验时间' ,
    `ct_addr` VARCHAR(100) DEFAULT NULL COMMENT '检验地址' ,
    `ct_cost` DECIMAL(10,2) DEFAULT '0.00' COMMENT '检验项目费用',
    `ct_report` VARCHAR(100) DEFAULT NULL COMMENT '检验报告',
    `report_time` DATETIME DEFAULT NULL COMMENT '报告生成时间' ,
    `ct_img` VARCHAR(100) DEFAULT NULL COMMENT '图片url' ,
    `ct_part` VARCHAR(100) DEFAULT NULL COMMENT '检验部位' ,
    PRIMARY KEY ( `ct_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `examinationOrder`(
    `examinationOrder_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '检查项目流水id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
	`medicalRecord_id` BIGINT(20) NOT NULL COMMENT '病历id' ,
    `examination_id` BIGINT(20) NOT NULL COMMENT '某种检查的流水号' ,
    `examination_type` VARCHAR(100) DEFAULT NULL COMMENT '某种检查的类别' ,
    PRIMARY KEY ( `examinationOrder_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*检查从examinationOrder中查找*/
CREATE TABLE IF NOT EXISTS `medicalRecord`(
    `medicalRecord_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '病历id' ,
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
    `department_id` BIGINT(20) NOT NULL COMMENT '科室id' ,
    `doctor_id` BIGINT(20) NOT NULL COMMENT '医生id' ,
    `symptom` longtext DEFAULT NULL COMMENT '症状描述' ,
    `medicalRecord_content_first` longtext DEFAULT NULL COMMENT '初步诊断内容' ,
    `medicalRecord_content_finally` longtext DEFAULT NULL COMMENT '最终诊断内容' ,
    `treatment` longtext DEFAULT NULL COMMENT '治疗方式' ,
    `general` longtext DEFAULT NULL COMMENT '概括' ,
    `create_date` DATETIME DEFAULT NULL COMMENT '创建时间' ,
    PRIMARY KEY ( `medicalRecord_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


# CREATE TABLE IF NOT EXISTS `jiuzhen`(
#     `jiuzhen_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '就诊id' ,
#     `guahao_id` BIGINT(20) NOT NULL COMMENT '挂号id' ,
#     `doctor_id` BIGINT(20) NOT NULL COMMENT '医生id' ,
#     `doctor_name` VARCHAR(100) DEFAULT NULL COMMENT '医生名字' ,
#     `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
#     `jiuzhen_content_first` longtext DEFAULT NULL COMMENT '初步诊断内容' ,
#     `jiuzhen_content_finally` longtext DEFAULT NULL COMMENT '最终诊断内容' ,
# 	`create_date` DATETIME DEFAULT NULL COMMENT '诊断时间' ,
#     PRIMARY KEY ( `jiuzhen_id` )
# )ENGINE=InnoDB DEFAULT CHARSET=utf8;