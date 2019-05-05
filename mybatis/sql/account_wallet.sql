# 测试Mysql乐观锁

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_wallet
-- ----------------------------
DROP TABLE IF EXISTS `account_wallet`;
CREATE TABLE `account_wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户钱包主键',
  `user_open_id` varchar(64) DEFAULT NULL COMMENT '用户中心的用户唯一编号',
  `user_amount` decimal(10,5) DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '基于mysql乐观锁，解决并发访问',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_wallet
-- ----------------------------
INSERT INTO `account_wallet` VALUES ('1', '123', '100.00000', '1');
