/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : sql_test

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-08-31 22:27:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `课程号` varchar(128) NOT NULL,
  `课程名称` varchar(255) NOT NULL,
  `教师号` varchar(255) NOT NULL,
  PRIMARY KEY (`课程号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('0001', '语文', '0002');
INSERT INTO `course` VALUES ('0002', '数学', '0001');
INSERT INTO `course` VALUES ('0003', '英语', '0003');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `学号` varchar(128) NOT NULL,
  `课程号` varchar(128) NOT NULL,
  `成绩` float(3,0) NOT NULL,
  PRIMARY KEY (`学号`,`课程号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('0001', '0001', '80');
INSERT INTO `score` VALUES ('0001', '0002', '90');
INSERT INTO `score` VALUES ('0001', '0003', '99');
INSERT INTO `score` VALUES ('0002', '0002', '60');
INSERT INTO `score` VALUES ('0002', '0003', '80');
INSERT INTO `score` VALUES ('0003', '0001', '80');
INSERT INTO `score` VALUES ('0003', '0002', '80');
INSERT INTO `score` VALUES ('0003', '0003', '80');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `学号` varchar(128) NOT NULL,
  `姓名` varchar(255) NOT NULL,
  `出生日期` date NOT NULL,
  `性别` varchar(255) NOT NULL,
  PRIMARY KEY (`学号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0001', '猴子', '1989-01-01', '男');
INSERT INTO `student` VALUES ('0002', '猴子', '1990-12-21', '女');
INSERT INTO `student` VALUES ('0003', '马云', '1991-12-21', '男');
INSERT INTO `student` VALUES ('0004', '王思聪', '1990-05-20', '男');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `教师号` varchar(20) NOT NULL,
  `教师姓名` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`教师号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('0001', '孟扎扎');
INSERT INTO `teacher` VALUES ('0002', '马化腾');
INSERT INTO `teacher` VALUES ('0003', null);
INSERT INTO `teacher` VALUES ('0004', '');
