/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : imaya_mall

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/05/2022 23:06:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_imaya_mall_user
-- ----------------------------
DROP TABLE IF EXISTS `t_imaya_mall_user`;
CREATE TABLE `t_imaya_mall_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5 加密之后的密码',
  `extra_info` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '额外的信息',
  `create_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
