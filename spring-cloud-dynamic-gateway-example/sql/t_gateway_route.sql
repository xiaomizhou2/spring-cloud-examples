SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_gateway_route
-- ----------------------------
DROP TABLE IF EXISTS `t_gateway_route`;
CREATE TABLE `t_gateway_route` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '代码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路由uri',
  `predicates` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '断言，json格式',
  `filters` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '过滤器，json格式',
  `metadata` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '元数据，json格式',
  `disabled` bit(1) DEFAULT b'0' COMMENT '禁用标识',
  `order_no` int DEFAULT NULL COMMENT '排序',
  `created_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='接口表';

-- ----------------------------
-- Records of t_gateway_route
-- ----------------------------
BEGIN;
INSERT INTO `t_gateway_route` (`id`, `code`, `name`, `uri`, `predicates`, `filters`, `metadata`, `disabled`, `order_no`, `created_time`, `last_modified_time`) VALUES ('nacos-discovery-example', 'nacos-discovery-example', 'nacos注册示例服务', 'lb://nacos-discovery-example', '[\n    {\n        \"args\": {\n            \"pattern\": \"/examples/**\"\n        },\n        \"name\": \"Path\"\n    }\n]', '[]', '{\n    \"name\":\"nacos注册示例服务\"\n}', b'0', 0, '2022-10-06 04:19:20', '2022-10-06 04:19:20');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
