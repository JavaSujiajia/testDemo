/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : user_test

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-12-02 14:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `cname` varchar(10) DEFAULT NULL COMMENT '课程名称',
  `tid` varchar(10) DEFAULT NULL COMMENT '教师ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01', '语文', '02');
INSERT INTO `course` VALUES ('02', '数学', '01');
INSERT INTO `course` VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sid` varchar(10) DEFAULT NULL COMMENT '学生编号',
  `cid` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `score` decimal(18,1) DEFAULT NULL COMMENT '分数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('01', '01', '80.0');
INSERT INTO `sc` VALUES ('01', '02', '90.0');
INSERT INTO `sc` VALUES ('01', '03', '99.0');
INSERT INTO `sc` VALUES ('02', '01', '70.0');
INSERT INTO `sc` VALUES ('02', '02', '60.0');
INSERT INTO `sc` VALUES ('02', '03', '80.0');
INSERT INTO `sc` VALUES ('03', '01', '80.0');
INSERT INTO `sc` VALUES ('03', '02', '80.0');
INSERT INTO `sc` VALUES ('03', '03', '80.0');
INSERT INTO `sc` VALUES ('04', '01', '50.0');
INSERT INTO `sc` VALUES ('04', '02', '30.0');
INSERT INTO `sc` VALUES ('04', '03', '20.0');
INSERT INTO `sc` VALUES ('05', '01', '76.0');
INSERT INTO `sc` VALUES ('05', '02', '87.0');
INSERT INTO `sc` VALUES ('06', '01', '31.0');
INSERT INTO `sc` VALUES ('06', '03', '34.0');
INSERT INTO `sc` VALUES ('07', '02', '89.0');
INSERT INTO `sc` VALUES ('07', '03', '98.0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(10) DEFAULT NULL COMMENT 'studentID',
  `sname` varchar(10) DEFAULT NULL COMMENT '学生姓名',
  `sage` datetime DEFAULT NULL COMMENT '年龄',
  `ssex` varchar(10) DEFAULT NULL COMMENT '性别'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `student` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `student` VALUES ('03', '孙风', '1990-12-20 00:00:00', '男');
INSERT INTO `student` VALUES ('04', '李云', '1990-12-06 00:00:00', '男');
INSERT INTO `student` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `student` VALUES ('06', '吴兰', '1992-01-01 00:00:00', '女');
INSERT INTO `student` VALUES ('07', '郑竹', '1989-01-01 00:00:00', '女');
INSERT INTO `student` VALUES ('09', '张三', '2017-12-20 00:00:00', '女');
INSERT INTO `student` VALUES ('10', '李四', '2017-12-25 00:00:00', '女');
INSERT INTO `student` VALUES ('11', '李四', '2012-06-06 00:00:00', '女');
INSERT INTO `student` VALUES ('12', '赵六', '2013-06-13 00:00:00', '女');
INSERT INTO `student` VALUES ('13', '孙七', '2014-06-01 00:00:00', '女');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(10) DEFAULT NULL COMMENT '教师ID',
  `tname` varchar(10) DEFAULT NULL COMMENT '教师名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('01', '张三');
INSERT INTO `teacher` VALUES ('02', '李四');
INSERT INTO `teacher` VALUES ('03', '王五');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张柳', '1206');
