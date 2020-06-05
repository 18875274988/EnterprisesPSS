/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : enterprisespurchasesellsave

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 05/06/2020 20:25:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category_info
-- ----------------------------
DROP TABLE IF EXISTS `category_info`;
CREATE TABLE `category_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category_info
-- ----------------------------
INSERT INTO `category_info` VALUES (1, '蔬菜瓜果');
INSERT INTO `category_info` VALUES (2, '服装');
INSERT INTO `category_info` VALUES (6, '建材');
INSERT INTO `category_info` VALUES (7, '手机数码');
INSERT INTO `category_info` VALUES (8, '箱包手袋');
INSERT INTO `category_info` VALUES (9, '酒水饮料');
INSERT INTO `category_info` VALUES (10, '酒水饮料');
INSERT INTO `category_info` VALUES (11, '图书娱乐');
INSERT INTO `category_info` VALUES (12, '工业品');

-- ----------------------------
-- Table structure for eps_product_info
-- ----------------------------
DROP TABLE IF EXISTS `eps_product_info`;
CREATE TABLE `eps_product_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_count` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` double(10, 2) NULL DEFAULT NULL,
  `product_createtime` datetime(0) NULL DEFAULT NULL,
  `product_from` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `prewarning_value` double(10, 2) NULL DEFAULT NULL COMMENT '预警值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eps_product_info
-- ----------------------------
INSERT INTO `eps_product_info` VALUES (5, '床上四件套', '195.0套', 84.00, '2020-04-27 23:01:21', '张三15215276030', '服装', '0', 65.00, 100.00);
INSERT INTO `eps_product_info` VALUES (6, '毛巾', '0.0套', 8.50, '2020-04-27 23:03:15', '张三18875274988', '服装', '1', 9.00, 100.00);
INSERT INTO `eps_product_info` VALUES (7, 'IT科技', '989.0本', 35.00, '2020-04-27 23:04:40', 'Name:张三Tel:18875492966No:500101199704059312', '图书娱乐', NULL, 30.00, NULL);
INSERT INTO `eps_product_info` VALUES (8, '苏打水（中袄350ml）', '998.0箱', 10.00, '2020-04-27 23:06:07', 'Name:张三Tel:18875492966No:500101199704059312', '酒水饮料', NULL, 2.60, NULL);

-- ----------------------------
-- Table structure for eps_sell_order
-- ----------------------------
DROP TABLE IF EXISTS `eps_sell_order`;
CREATE TABLE `eps_sell_order`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_createtime` datetime(0) NULL DEFAULT NULL,
  `order_state` smallint(6) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eps_sell_order
-- ----------------------------
INSERT INTO `eps_sell_order` VALUES (55, 'EPSS20200518150559160', '合计：90元', 'puyin0', '2020-05-18 15:05:59', 1);
INSERT INTO `eps_sell_order` VALUES (56, 'EPSS20200518150733250', '合计：129.5元', 'puyin0', '2020-05-18 15:07:33', 1);
INSERT INTO `eps_sell_order` VALUES (57, 'EPSS20200518151436698', '合计：17元', 'puyin0', '2020-05-18 15:14:36', 1);
INSERT INTO `eps_sell_order` VALUES (58, 'EPSS20200518151656003', '合计：25.5元', 'puyin0', '2020-05-18 15:16:56', 1);
INSERT INTO `eps_sell_order` VALUES (59, 'EPSS20200523004118454', '合计：1270元', 'puyin0', '2020-05-23 00:41:18', 1);
INSERT INTO `eps_sell_order` VALUES (60, 'EPSS20200523082329769', '合计：1025元', 'puyin0', '2020-05-23 08:23:30', 0);

-- ----------------------------
-- Table structure for eps_user
-- ----------------------------
DROP TABLE IF EXISTS `eps_user`;
CREATE TABLE `eps_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eps_user
-- ----------------------------
INSERT INTO `eps_user` VALUES (1, 'puyin0', '123', 0);
INSERT INTO `eps_user` VALUES (22, 'puyin1', '321', 1);
INSERT INTO `eps_user` VALUES (23, 'puyin2', '321', 2);
INSERT INTO `eps_user` VALUES (24, 'puyin3', '321', 3);
INSERT INTO `eps_user` VALUES (25, 'puyin4', '321', 4);

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '来源单id',
  `amount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '金额小计',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商/客户名',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商/客户电话',
  `no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商/客户名身份证号',
  `classify` smallint(6) NULL DEFAULT NULL,
  `state` smallint(6) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES (144, 55, '合计：90元', '张三', '18875274988', '500101199706059313', 1, 1, '2020-05-18 15:05:59', NULL);
INSERT INTO `finance` VALUES (145, 56, '合计：129.5元', '张三', '18875274988', '500101199706059313', 1, 1, '2020-05-18 15:07:33', NULL);
INSERT INTO `finance` VALUES (146, 129, '合计:6.0元', '张三', '18875274988', '500101199706059313', 0, 1, '2020-05-18 15:08:53', '2020-05-18 15:12:32');
INSERT INTO `finance` VALUES (147, 57, '合计：17元', '张三', '18875274988', '500101199706059313', 1, 1, '2020-05-18 15:14:37', NULL);
INSERT INTO `finance` VALUES (148, 130, '合计:12.0元', '张三', '18875274988', '500101199706059313', 0, 1, '2020-05-18 15:14:55', '2020-05-18 15:15:57');
INSERT INTO `finance` VALUES (149, 58, '合计：25.5元', '张三', '18875274988', '500101199706059313', 1, 1, '2020-05-18 15:16:56', NULL);
INSERT INTO `finance` VALUES (150, 131, '合计:24.0元', '张三', '18875274988', '500101199706059313', 0, 1, '2020-05-18 15:17:44', '2020-05-18 19:05:48');
INSERT INTO `finance` VALUES (151, 59, '合计：1270元', '张三', '18875274988', '500101199706059313', 1, 1, '2020-05-23 00:41:18', NULL);
INSERT INTO `finance` VALUES (152, 132, '合计:30.0元', '张三', '18875274988', '500101199706059313', 0, 1, '2020-05-23 00:42:11', '2020-05-23 00:42:55');
INSERT INTO `finance` VALUES (153, 60, '合计：1025元', '张三', '18875274988', '500101199706059313', 1, 0, '2020-05-23 08:23:30', NULL);
INSERT INTO `finance` VALUES (154, 1, '合计:9.0元', '张三', '18875274988', '500101199706059313', 0, 0, '2020-05-23 08:24:18', NULL);
INSERT INTO `finance` VALUES (155, 1, '合计:9.0元', '张三', '18875274988', '500101199706059313', 0, 0, '2020-05-23 08:24:19', NULL);

-- ----------------------------
-- Table structure for order_from_info
-- ----------------------------
DROP TABLE IF EXISTS `order_from_info`;
CREATE TABLE `order_from_info`  (
  `order_from_id` bigint(20) NOT NULL,
  `order_from_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_from_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_from_codeid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `order_from_id`(`order_from_id`) USING BTREE,
  CONSTRAINT `order_from_info_ibfk_1` FOREIGN KEY (`order_from_id`) REFERENCES `eps_sell_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_from_info
-- ----------------------------
INSERT INTO `order_from_info` VALUES (55, '张三', '18875274988', '55');
INSERT INTO `order_from_info` VALUES (56, '张三', '18875274988', '56');
INSERT INTO `order_from_info` VALUES (57, '张三', '18875274988', '57');
INSERT INTO `order_from_info` VALUES (58, '张三', '18875274988', '58');
INSERT INTO `order_from_info` VALUES (59, '张三', '18875274988', '59');
INSERT INTO `order_from_info` VALUES (60, '张三', '18875274988', '60');

-- ----------------------------
-- Table structure for order_product_info
-- ----------------------------
DROP TABLE IF EXISTS `order_product_info`;
CREATE TABLE `order_product_info`  (
  `order_id` bigint(20) NOT NULL,
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` double(10, 2) NULL DEFAULT NULL,
  `product_count` double(10, 2) NULL DEFAULT NULL,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `order_product_info_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `eps_sell_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_product_info
-- ----------------------------
INSERT INTO `order_product_info` VALUES (55, 'IT科技', 35.00, 2.00);
INSERT INTO `order_product_info` VALUES (55, '苏打水（中袄350ml）', 10.00, 2.00);
INSERT INTO `order_product_info` VALUES (56, '毛巾', 8.50, 7.00);
INSERT INTO `order_product_info` VALUES (56, 'IT科技', 35.00, 2.00);
INSERT INTO `order_product_info` VALUES (57, '毛巾', 8.50, 2.00);
INSERT INTO `order_product_info` VALUES (58, '毛巾', 8.50, 3.00);
INSERT INTO `order_product_info` VALUES (59, '毛巾', 8.50, 100.00);
INSERT INTO `order_product_info` VALUES (59, '床上四件套', 84.00, 5.00);
INSERT INTO `order_product_info` VALUES (60, '毛巾', 8.50, 100.00);
INSERT INTO `order_product_info` VALUES (60, 'IT科技', 35.00, 5.00);

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order`  (
  `purchase_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '采购单id',
  `purchase_order_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchase_sell_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchase_order_state` int(11) NULL DEFAULT NULL,
  `order_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`purchase_order_id`) USING BTREE,
  INDEX `purchase_order_no`(`purchase_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
INSERT INTO `purchase_order` VALUES (1, 'EPS20200523082329843', 'puyin0', 1, 'EPSS20200523082329769');

-- ----------------------------
-- Table structure for purchase_order_info
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order_info`;
CREATE TABLE `purchase_order_info`  (
  `purchase_order_id` bigint(20) NOT NULL DEFAULT 0,
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_count` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_purchase_price` double(10, 2) NULL DEFAULT NULL,
  `supplier_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `purchase_id`(`product_name`) USING BTREE,
  INDEX `purchase_order_id`(`purchase_order_id`) USING BTREE,
  CONSTRAINT `purchase_order_info_ibfk_1` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`purchase_order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of purchase_order_info
-- ----------------------------
INSERT INTO `purchase_order_info` VALUES (1, '毛巾', '1.0套', 9.00, '张三', '18875274988', '500101199706059313');

-- ----------------------------
-- Table structure for temporary_table
-- ----------------------------
DROP TABLE IF EXISTS `temporary_table`;
CREATE TABLE `temporary_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) NULL DEFAULT NULL,
  `client_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` char(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_tel` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account_name` varbinary(20) NULL DEFAULT NULL,
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_price` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of temporary_table
-- ----------------------------

-- ----------------------------
-- Table structure for warehouse_order
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_order`;
CREATE TABLE `warehouse_order`  (
  `warehouse_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `warehouse_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_type` smallint(2) NULL DEFAULT NULL,
  `warehouse_starttime` datetime(0) NULL DEFAULT NULL,
  `warehouse_state` bigint(2) NULL DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of warehouse_order
-- ----------------------------
INSERT INTO `warehouse_order` VALUES (3, 'EPSWE20200523082419322', 0, '2020-05-23 08:24:19', 0);
INSERT INTO `warehouse_order` VALUES (4, 'EPSWO20200523082419482', 1, '2020-05-23 08:24:19', 3);

-- ----------------------------
-- Table structure for warehouse_order_info
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_order_info`;
CREATE TABLE `warehouse_order_info`  (
  `warehouse_id` bigint(20) NOT NULL,
  `product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `product_count` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_info` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `warehouse_id`(`warehouse_id`) USING BTREE,
  CONSTRAINT `warehouse_order_info_ibfk_1` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse_order` (`warehouse_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of warehouse_order_info
-- ----------------------------
INSERT INTO `warehouse_order_info` VALUES (3, '毛巾', 9.00, '1.0套', 'Name:张三Tel:18875274988No:500101199706059313');
INSERT INTO `warehouse_order_info` VALUES (4, '毛巾', NULL, '1.0套', NULL);

SET FOREIGN_KEY_CHECKS = 1;
