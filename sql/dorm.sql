#学生表
drop table `tb_student`;
create table `tb_student`(
`id` BIGINT(20) not null auto_increment  comment '主键',
`student_num`  varchar(20)  not null comment '学号',
`student_name`  varchar(20)  not null comment '学生名',
`department` varchar(15) comment '院系',
`clazz` varchar(15)  comment '班级',
`sex` TINYINT DEFAULT '0' comment '性别：1男2女',
`birthdate` datetime DEFAULT null comment '出生日期',
`phone` varchar(15) comment '手机',
`bed_id` BIGINT(20) comment '床位id',
`dormitory_id` BIGINT(20) comment '宿舍id',
`status` TINYINT(2) default '0' comment'0未入住，1已入住，2退宿',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
 primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '学生表';

#用户表
create table `tb_user`(
`id` BIGINT(20) not null auto_increment  comment '主键',
`username` varchar(20) not null comment '用户名',
`password` varchar(32) not null comment '密码',
`user_type` TINYINT DEFAULT '0' comment '用户类型：0管理员1普通用户',
`user_status` TINYINT DEFAULT '0' comment '用户状态：0正常',
`phone` varchar(15) comment '手机',
`student_id` BIGINT(20) null  comment '学生id',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
 primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '用户表';

-- 超级管理员
INSERT INTO `tb_user` (`id`,`username`,`password`,`user_type`) VALUES (-1,'admin','123456',0);

#床位表
create table `tb_bed`(
`id` BIGINT(20) not null auto_increment,
`bed_num` varchar(10) not null comment '床位号',
`studen_id` BIGINT(20) not null comment '学生id',
`dormitory_id` BIGINT(20) not null comment '宿舍id',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '床位表';

ALTER TABLE `tb_bed` ADD `status` TINYINT(2) default '0' comment '床位状态 0未占用，1已占用';
ALTER TABLE `tb_bed` MODIFY COLUMN `studen_id` BIGINT(20) null comment '学生id';

#宿舍表
drop table `tb_dormitory`;
create table `tb_dormitory`(
`id` BIGINT(20) not null auto_increment,
`dormitory_num` varchar(10) not null comment '宿舍房号',
`apartment_id` BIGINT(20) not null comment '公寓id',
`building` varchar(10) not null comment '第几栋',
`note` varchar(255) default null comment '宿舍描述',
`floor_number` TINYINT not null comment '楼层',
`bad_num` TINYINT not null comment'床位数',
`status` TINYINT(2) default '0' comment'0未满，1已满',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '宿舍表';

ALTER TABLE `tb_dormitory` change `bad_num` bed_quantity TINYINT not null default '0' comment'床位数';
ALTER TABLE `tb_dormitory` MODIFY `building` varchar(10) null comment '第几栋';

#公寓表
drop table `tb_apartment`;
create table `tb_apartment`(
`id` BIGINT(20) not null auto_increment,
`apartment_name` varchar(30) not null comment '公寓名',
`note` varchar(255) default null comment '公寓描述',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '公寓表';


#签到表
create table `tb_sign_in`(
`id` BIGINT(20) not null auto_increment,
`student_id` BIGINT(20) not null,
`dormitory_id` BIGINT(20) not null,
`sign_in_type` TINYINT(2) default '0' comment'0机器签到，1手动签到',
`success` TINYINT(2) default '1' comment'1代表已经签到',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '签到表';


#退宿记录表
create table `tb_retirement_record`(
`id` BIGINT(20) not null auto_increment,
`reason` varchar(255) not null comment '退宿原因',
`retirement_date` datetime  null comment '退宿日期',
`bed_id` BIGINT(20) comment '床位id',
`dormitory_id` BIGINT(20) not null comment '宿舍id',
`student_id` BIGINT(20) not null comment '学生id',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '退宿记录表';


#寒暑假留校表
create table `tb_stay_school`(
`id` BIGINT(20) not null auto_increment,
`reason` varchar(255) not null comment '留宿原因',
`begin_time` datetime  null comment '开始日期',
`end_time` datetime  null comment '结束日期',
`status` TINYINT(2) default '0' comment'0未审核，-1不通过，1通过',
`audit_reason` varchar(255) null comment '审核理由',
`audit_user_id` varchar(255) null comment '审核人',
`student_id` BIGINT(20) not null comment '学生id',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '寒暑假留校表';

ALTER TABLE `tb_stay_school` MODIFY `audit_user_id` BIGINT(20) null comment '审核人';

#违规表
create table `tb_bad_record`(
`id` int(10) not null auto_increment,
`event_content` varchar(255) not null comment '违规事件',
`reason` varchar(255) null comment '原因',
`dormitory_id` BIGINT(20) not null comment '宿舍id',
`student_id` BIGINT(20) not null comment '学生id',
`record_user_id` BIGINT(20) not null comment '记录人id',
`handle_user_id` BIGINT(20) null comment '处理人id',
`handle_status` TINYINT(2) DEFAULT '0' comment '0未处理，1警告，2处分，3撤销',
`handle` varchar(255) null comment '处理内容',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '违规表';


#外访人员表
create table `tb_people`(
`id` BIGINT(20) not null auto_increment,
`people_name` varchar(10) not null comment '姓名',
`people_phone`   varchar(20) not null comment '电话号码',
`student_id` BIGINT(20) not null comment '被访学生',
`relationship` varchar(50) null comment '与被访者关系',
`reason` varchar(50) null comment '原因',
`note` varchar(200) null comment '备注',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '外访人员表';


#大件物品种类表
create table `tb_good_category`(
`id` BIGINT(20) not null auto_increment,
`good_category_name`  varchar(20) not null comment '种类名',
`good_category_type`  varchar(10) not null comment '种类类型值',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '大件物品种类表';


#大件物品表
create table `tb_good`(
`id` BIGINT(20) not null auto_increment,
`good_name`  varchar(20) not null comment '物品名',
`apartment_id` BIGINT(20) not null comment '公寓id',
`student_id` BIGINT(20) not null comment '学生id',
`dormitory_id` BIGINT(20) not null comment '宿舍id',
`in_time` datetime default null comment '入库时间',
`out_time` datetime default null comment '出库时间',
`note`  varchar(200) not null comment '备注',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '大件物品表';

ALTER TABLE `tb_good` ADD `good_category_id` BIGINT(20) not null comment '大件物品种类表';
ALTER TABLE `tb_good` ADD `status` TINYINT(2) default '0' comment '状态 0存在，1已出库';

#报修表
create table `tb_repairs`(
`id` BIGINT(20) not null auto_increment,
`sponsor_id` BIGINT(20) null comment '发起人id',
`sponsor_name` varchar(20) not null comment '发起人名',
`sponsor_type` TINYINT DEFAULT '0' comment '发起人类型：0学生1管理员2其他',
`sponsor_phone`   varchar(20) null comment '电话号码',
`content`  varchar(255) not null comment '报修内容',
`handle_user_id` BIGINT(20) not null comment '处理人id',
`status`  TINYINT(2) default'0' comment'0未处理，1已处理',
`repairs_name` varchar(20) null comment '修理人',
`repairs_phone` varchar(20) null comment '修理人电话',
`repairs_date` datetime DEFAULT null comment '修理日期',
`note`  varchar(200) null comment '备注',
`dormitory_id` BIGINT(20) null comment '宿舍id',
`create_date` timestamp DEFAULT CURRENT_TIMESTAMP comment '创建日期',
`update_date` timestamp NULL DEFAULT NULL comment '更新日期',
primary key(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8 comment '报修表';

ALTER TABLE `tb_repairs` MODIFY `handle_user_id` BIGINT(20) null comment '处理人id';