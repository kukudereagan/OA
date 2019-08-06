/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-22 17:23:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_offline
-- ----------------------------
DROP TABLE IF EXISTS `course_offline`;
CREATE TABLE `course_offline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_service_network_id` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `image_path` varchar(200) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `length` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `show_homepage` int(11) DEFAULT NULL,
  `teachers` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_offline
-- ----------------------------
INSERT INTO `course_offline` VALUES ('1', '1', '线下1', '5909', '内容1123123', 'abc', '2018-06-06 08:00:00', '', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('2', '1', '线下2', '5909', '内容1123123', 'abc', '2018-06-06 08:00:00', '', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('3', '1', '线下3', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '3天', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('4', '1', '线下4', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '2天', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('5', '1', '线下5', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '1周', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('6', '1', '线下6', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '1周', '人民路100号', '1', '4,5,6');
INSERT INTO `course_offline` VALUES ('7', '1', '线下7', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '3天', '人民路100号', '1', '4,5');
INSERT INTO `course_offline` VALUES ('8', '1', '线下8', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '2天', '人民路100号', '1', null);
INSERT INTO `course_offline` VALUES ('9', '1', '线下9', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '1周', '人民路100号', null, null);
INSERT INTO `course_offline` VALUES ('10', '1', '线下10', '5909', '内容1', 'abc', '2018-06-06 00:00:00', '1周', '人民路100号', null, null);
INSERT INTO `course_offline` VALUES ('11', '1', '5909', '5909', 'asdasd', 'asd', '2018-03-16 16:09:36', '1周', '人民路100号', '1', '4');
INSERT INTO `course_offline` VALUES ('12', null, '123', '123', '123123', '', '2018-03-19 08:00:00', '123', '123', null, null);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `available` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '菜单', 'url', null, null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('5', '线下课程', 'url', 'ops/courseoffline/index', 'ops:course_offline', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('6', '教师管理', 'url', 'ops/teacher/index', 'ops:teacher', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('7', '线上课程', 'url', 'ops/courseonline/index', 'ops:course_online', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('8', '交通安全法律法规', 'url', 'ops/trafficlaw/index', 'ops:trafficlaw', '1', '', '1');
INSERT INTO `sys_permission` VALUES ('9', '驾考相关政策规定', 'url', 'ops/drivingpolicy/index', 'ops:drivingpolicy', '1', '', '1');
INSERT INTO `sys_permission` VALUES ('10', '平台网点', 'url', 'ops/platformservicenetwork/index', 'ops:platformservicenetwork', '1', '', '1');
INSERT INTO `sys_permission` VALUES ('11', '驾校信息', 'url', 'ops/school/index', 'ops:school', '1', '', '1');
INSERT INTO `sys_permission` VALUES ('12', '学员信息', 'url', 'ops/student/index', 'ops:student', '1', '', '1');
INSERT INTO `sys_permission` VALUES ('13', '平台公告', 'url', 'ops/platnotice/index', 'ops:platnotice', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('21', '驾校管理', 'url', '', '', null, '', '1');
INSERT INTO `sys_permission` VALUES ('22', '学员信息管理', 'url', 'sch/student/index', 'sch:student', '21', '', '1');
INSERT INTO `sys_permission` VALUES ('23', '开班信息管理', 'url', 'sch/schoolclass/index', 'sch:schoolclass', '21', '', '1');
INSERT INTO `sys_permission` VALUES ('24', '数据管理', 'url', null, null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('25', '数据1', 'url', 'sch/student/index', 'sch:student', '24', null, '1');
INSERT INTO `sys_permission` VALUES ('26', '数据2', 'url', 'sch/student/index', 'sch:student', '24', null, '1');
INSERT INTO `sys_permission` VALUES ('27', '系统管理', 'url', null, null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('28', '用户管理', 'url', 'system/user/index', 'system:user', '27', null, '1');
INSERT INTO `sys_permission` VALUES ('29', '角色管理', 'url', 'system/role/index', 'system:role', '27', null, '1');
INSERT INTO `sys_permission` VALUES ('30', '权限管理', 'url', 'system/permission/index', 'system:permission', '27', null, '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `available` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', 'true');
INSERT INTO `sys_role` VALUES ('2', 'dba', '数据库管理员', 'true');
INSERT INTO `sys_role` VALUES ('3', 'manager', '运营', 'true');
INSERT INTO `sys_role` VALUES ('11', 'test', '测试', 'true');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('4', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1', '5');
INSERT INTO `sys_role_permission` VALUES ('6', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '1', '7');
INSERT INTO `sys_role_permission` VALUES ('8', '1', '8');
INSERT INTO `sys_role_permission` VALUES ('9', '1', '9');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '1', '11');
INSERT INTO `sys_role_permission` VALUES ('12', '1', '12');
INSERT INTO `sys_role_permission` VALUES ('22', '4', '21');
INSERT INTO `sys_role_permission` VALUES ('23', '4', '22');
INSERT INTO `sys_role_permission` VALUES ('24', '4', '23');
INSERT INTO `sys_role_permission` VALUES ('25', '1', '13');
INSERT INTO `sys_role_permission` VALUES ('26', '2', '24');
INSERT INTO `sys_role_permission` VALUES ('27', '2', '25');
INSERT INTO `sys_role_permission` VALUES ('28', '2', '26');
INSERT INTO `sys_role_permission` VALUES ('30', '1', '28');
INSERT INTO `sys_role_permission` VALUES ('31', '1', '29');
INSERT INTO `sys_role_permission` VALUES ('32', '1', '30');
INSERT INTO `sys_role_permission` VALUES ('33', '1', '27');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT ' 0-离职 1-公出  2-出差 3-事假  4-病假 5-其他假  10-在职',
  `expiretime` date DEFAULT NULL COMMENT '用户过期时间',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'qqqqqq', '李根', '123', '1', '5', '2020-12-30', '2011-06-26 00:00:00');
INSERT INTO `sys_user` VALUES ('2', 'jiaxiao1', '123', '文博', '123', '1', '10', '2020-12-31', null);
INSERT INTO `sys_user` VALUES ('3', 'dba', 'qqqqqq', '数据库管理员', '123', '1', '10', '2020-12-31', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '1', '2');
INSERT INTO `sys_user_role` VALUES ('3', '2', '3');
INSERT INTO `sys_user_role` VALUES ('4', '3', '2');
INSERT INTO `sys_user_role` VALUES ('6', '1', '3');
