/*
 Navicat Premium Data Transfer

 Source Server         : 74pqsql12
 Source Server Type    : PostgreSQL
 Source Server Version : 120012
 Source Host           : 192.168.8.74:5432
 Source Catalog        : htht-server
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120012
 File Encoding         : 65001

 Date: 25/08/2023 14:33:07
*/


-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_table";
CREATE TABLE "public"."gen_table" (
  "table_id" int8 NOT NULL,
  "table_name" varchar(200) COLLATE "pg_catalog"."default",
  "table_comment" varchar(500) COLLATE "pg_catalog"."default",
  "sub_table_name" varchar(64) COLLATE "pg_catalog"."default",
  "sub_table_fk_name" varchar(64) COLLATE "pg_catalog"."default",
  "class_name" varchar(100) COLLATE "pg_catalog"."default",
  "tpl_category" varchar(200) COLLATE "pg_catalog"."default",
  "package_name" varchar(100) COLLATE "pg_catalog"."default",
  "module_name" varchar(30) COLLATE "pg_catalog"."default",
  "business_name" varchar(30) COLLATE "pg_catalog"."default",
  "function_name" varchar(50) COLLATE "pg_catalog"."default",
  "function_author" varchar(50) COLLATE "pg_catalog"."default",
  "gen_type" char(1) COLLATE "pg_catalog"."default",
  "gen_path" varchar(200) COLLATE "pg_catalog"."default",
  "options" varchar(1000) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."gen_table"."table_id" IS '编号';
COMMENT ON COLUMN "public"."gen_table"."table_name" IS '表名称';
COMMENT ON COLUMN "public"."gen_table"."table_comment" IS '表描述';
COMMENT ON COLUMN "public"."gen_table"."sub_table_name" IS '关联子表的表名';
COMMENT ON COLUMN "public"."gen_table"."sub_table_fk_name" IS '子表关联的外键名';
COMMENT ON COLUMN "public"."gen_table"."class_name" IS '实体类名称';
COMMENT ON COLUMN "public"."gen_table"."tpl_category" IS '使用的模板（crud单表操作 tree树表操作）';
COMMENT ON COLUMN "public"."gen_table"."package_name" IS '生成包路径';
COMMENT ON COLUMN "public"."gen_table"."module_name" IS '生成模块名';
COMMENT ON COLUMN "public"."gen_table"."business_name" IS '生成业务名';
COMMENT ON COLUMN "public"."gen_table"."function_name" IS '生成功能名';
COMMENT ON COLUMN "public"."gen_table"."function_author" IS '生成功能作者';
COMMENT ON COLUMN "public"."gen_table"."gen_type" IS '生成代码方式（0zip压缩包 1自定义路径）';
COMMENT ON COLUMN "public"."gen_table"."gen_path" IS '生成路径（不填默认项目路径）';
COMMENT ON COLUMN "public"."gen_table"."options" IS '其它生成选项';
COMMENT ON COLUMN "public"."gen_table"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."gen_table"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."gen_table"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."gen_table"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."gen_table"."remark" IS '备注';
COMMENT ON TABLE "public"."gen_table" IS '代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS "public"."gen_table_column";
CREATE TABLE "public"."gen_table_column" (
  "column_id" int8 NOT NULL,
  "table_id" int8,
  "column_name" varchar(200) COLLATE "pg_catalog"."default",
  "column_comment" varchar(500) COLLATE "pg_catalog"."default",
  "column_type" varchar(100) COLLATE "pg_catalog"."default",
  "java_type" varchar(500) COLLATE "pg_catalog"."default",
  "java_field" varchar(200) COLLATE "pg_catalog"."default",
  "is_pk" char(1) COLLATE "pg_catalog"."default",
  "is_increment" char(1) COLLATE "pg_catalog"."default",
  "is_required" char(1) COLLATE "pg_catalog"."default",
  "is_insert" char(1) COLLATE "pg_catalog"."default",
  "is_edit" char(1) COLLATE "pg_catalog"."default",
  "is_list" char(1) COLLATE "pg_catalog"."default",
  "is_query" char(1) COLLATE "pg_catalog"."default",
  "query_type" varchar(200) COLLATE "pg_catalog"."default",
  "html_type" varchar(200) COLLATE "pg_catalog"."default",
  "dict_type" varchar(200) COLLATE "pg_catalog"."default",
  "sort" int4,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."gen_table_column"."column_id" IS '编号';
COMMENT ON COLUMN "public"."gen_table_column"."table_id" IS '归属表编号';
COMMENT ON COLUMN "public"."gen_table_column"."column_name" IS '列名称';
COMMENT ON COLUMN "public"."gen_table_column"."column_comment" IS '列描述';
COMMENT ON COLUMN "public"."gen_table_column"."column_type" IS '列类型';
COMMENT ON COLUMN "public"."gen_table_column"."java_type" IS 'JAVA类型';
COMMENT ON COLUMN "public"."gen_table_column"."java_field" IS 'JAVA字段名';
COMMENT ON COLUMN "public"."gen_table_column"."is_pk" IS '是否主键（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_increment" IS '是否自增（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_required" IS '是否必填（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_insert" IS '是否为插入字段（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_edit" IS '是否编辑字段（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_list" IS '是否列表字段（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."is_query" IS '是否查询字段（1是）';
COMMENT ON COLUMN "public"."gen_table_column"."query_type" IS '查询方式（等于、不等于、大于、小于、范围）';
COMMENT ON COLUMN "public"."gen_table_column"."html_type" IS '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）';
COMMENT ON COLUMN "public"."gen_table_column"."dict_type" IS '字典类型';
COMMENT ON COLUMN "public"."gen_table_column"."sort" IS '排序';
COMMENT ON COLUMN "public"."gen_table_column"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."gen_table_column"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."gen_table_column"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."gen_table_column"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."gen_table_column" IS '代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_config";
CREATE TABLE "public"."sys_config" (
  "config_id" int8 NOT NULL,
  "config_name" varchar(100) COLLATE "pg_catalog"."default",
  "config_key" varchar(100) COLLATE "pg_catalog"."default",
  "config_value" varchar(500) COLLATE "pg_catalog"."default",
  "config_type" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_config"."config_id" IS '参数主键';
COMMENT ON COLUMN "public"."sys_config"."config_name" IS '参数名称';
COMMENT ON COLUMN "public"."sys_config"."config_key" IS '参数键名';
COMMENT ON COLUMN "public"."sys_config"."config_value" IS '参数键值';
COMMENT ON COLUMN "public"."sys_config"."config_type" IS '系统内置（Y是 N否）';
COMMENT ON COLUMN "public"."sys_config"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_config"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_config"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_config"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_config"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_config" IS '参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO "public"."sys_config" VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO "public"."sys_config" VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, '初始化密码 123456');
INSERT INTO "public"."sys_config" VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO "public"."sys_config" VALUES (4, '账号自助-验证码开关', 'sys.account.captchaEnabled', 'true', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO "public"."sys_config" VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO "public"."sys_config" VALUES (11, 'OSS预览列表资源开关', 'sys.oss.previewListResource', 'true', 'Y', 'admin', '2023-03-15 14:06:16', '', NULL, 'true:开启, false:关闭');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dept";
CREATE TABLE "public"."sys_dept" (
  "dept_id" int8 NOT NULL,
  "parent_id" int8,
  "ancestors" varchar(500) COLLATE "pg_catalog"."default",
  "dept_name" varchar(30) COLLATE "pg_catalog"."default",
  "order_num" int4,
  "leader" varchar(20) COLLATE "pg_catalog"."default",
  "phone" varchar(11) COLLATE "pg_catalog"."default",
  "email" varchar(50) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "del_flag" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_dept"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."sys_dept"."parent_id" IS '父部门id';
COMMENT ON COLUMN "public"."sys_dept"."ancestors" IS '祖级列表';
COMMENT ON COLUMN "public"."sys_dept"."dept_name" IS '部门名称';
COMMENT ON COLUMN "public"."sys_dept"."order_num" IS '显示顺序';
COMMENT ON COLUMN "public"."sys_dept"."leader" IS '负责人';
COMMENT ON COLUMN "public"."sys_dept"."phone" IS '联系电话';
COMMENT ON COLUMN "public"."sys_dept"."email" IS '邮箱';
COMMENT ON COLUMN "public"."sys_dept"."status" IS '部门状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_dept"."del_flag" IS '删除标志（0代表存在 2代表删除）';
COMMENT ON COLUMN "public"."sys_dept"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_dept"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dept"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_dept"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."sys_dept" IS '部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO "public"."sys_dept" VALUES (100, 0, '0', '广东HTHT', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-06-06 14:08:07');
INSERT INTO "public"."sys_dept" VALUES (101, 100, '0,100', '广东公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (102, 100, '0,100', '深圳公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:29');
INSERT INTO "public"."sys_dept" VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_dept" VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:29');
INSERT INTO "public"."sys_dept" VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:03:29');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict_data";
CREATE TABLE "public"."sys_dict_data" (
  "dict_code" int8 NOT NULL,
  "dict_sort" int4,
  "dict_label" varchar(100) COLLATE "pg_catalog"."default",
  "dict_value" varchar(100) COLLATE "pg_catalog"."default",
  "dict_type" varchar(100) COLLATE "pg_catalog"."default",
  "css_class" varchar(100) COLLATE "pg_catalog"."default",
  "list_class" varchar(100) COLLATE "pg_catalog"."default",
  "is_default" char(1) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_dict_data"."dict_code" IS '字典编码';
COMMENT ON COLUMN "public"."sys_dict_data"."dict_sort" IS '字典排序';
COMMENT ON COLUMN "public"."sys_dict_data"."dict_label" IS '字典标签';
COMMENT ON COLUMN "public"."sys_dict_data"."dict_value" IS '字典键值';
COMMENT ON COLUMN "public"."sys_dict_data"."dict_type" IS '字典类型';
COMMENT ON COLUMN "public"."sys_dict_data"."css_class" IS '样式属性（其他样式扩展）';
COMMENT ON COLUMN "public"."sys_dict_data"."list_class" IS '表格回显样式';
COMMENT ON COLUMN "public"."sys_dict_data"."is_default" IS '是否默认（Y是 N否）';
COMMENT ON COLUMN "public"."sys_dict_data"."status" IS '状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_dict_data"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_dict_data"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dict_data"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_dict_data"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_dict_data"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_dict_data" IS '字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO "public"."sys_dict_data" VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '性别男');
INSERT INTO "public"."sys_dict_data" VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '性别女');
INSERT INTO "public"."sys_dict_data" VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '性别未知');
INSERT INTO "public"."sys_dict_data" VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '显示菜单');
INSERT INTO "public"."sys_dict_data" VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '隐藏菜单');
INSERT INTO "public"."sys_dict_data" VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '正常状态');
INSERT INTO "public"."sys_dict_data" VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '停用状态');
INSERT INTO "public"."sys_dict_data" VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '系统默认是');
INSERT INTO "public"."sys_dict_data" VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '系统默认否');
INSERT INTO "public"."sys_dict_data" VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '通知');
INSERT INTO "public"."sys_dict_data" VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '公告');
INSERT INTO "public"."sys_dict_data" VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '正常状态');
INSERT INTO "public"."sys_dict_data" VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '关闭状态');
INSERT INTO "public"."sys_dict_data" VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '新增操作');
INSERT INTO "public"."sys_dict_data" VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '修改操作');
INSERT INTO "public"."sys_dict_data" VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '删除操作');
INSERT INTO "public"."sys_dict_data" VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '授权操作');
INSERT INTO "public"."sys_dict_data" VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '导出操作');
INSERT INTO "public"."sys_dict_data" VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '导入操作');
INSERT INTO "public"."sys_dict_data" VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '强退操作');
INSERT INTO "public"."sys_dict_data" VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '生成操作');
INSERT INTO "public"."sys_dict_data" VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '清空操作');
INSERT INTO "public"."sys_dict_data" VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '正常状态');
INSERT INTO "public"."sys_dict_data" VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '停用状态');
INSERT INTO "public"."sys_dict_data" VALUES (29, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '其他操作');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict_type";
CREATE TABLE "public"."sys_dict_type" (
  "dict_id" int8 NOT NULL,
  "dict_name" varchar(100) COLLATE "pg_catalog"."default",
  "dict_type" varchar(100) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_dict_type"."dict_id" IS '字典主键';
COMMENT ON COLUMN "public"."sys_dict_type"."dict_name" IS '字典名称';
COMMENT ON COLUMN "public"."sys_dict_type"."dict_type" IS '字典类型';
COMMENT ON COLUMN "public"."sys_dict_type"."status" IS '状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_dict_type"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_dict_type"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dict_type"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_dict_type"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_dict_type"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_dict_type" IS '字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO "public"."sys_dict_type" VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '用户性别列表');
INSERT INTO "public"."sys_dict_type" VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '菜单状态列表');
INSERT INTO "public"."sys_dict_type" VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-06 14:32:13', '系统开关列表');
INSERT INTO "public"."sys_dict_type" VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '系统是否列表');
INSERT INTO "public"."sys_dict_type" VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '通知类型列表');
INSERT INTO "public"."sys_dict_type" VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '通知状态列表');
INSERT INTO "public"."sys_dict_type" VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '操作类型列表');
INSERT INTO "public"."sys_dict_type" VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-30 14:17:50', '登录状态列表');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_file";
CREATE TABLE "public"."sys_file" (
  "id" int8 NOT NULL,
  "file_name" varchar(100) COLLATE "pg_catalog"."default",
  "extension" varchar(20) COLLATE "pg_catalog"."default",
  "total_size" int8,
  "file_path" varchar(100) COLLATE "pg_catalog"."default",
  "is_static" varchar(1) COLLATE "pg_catalog"."default",
  "static_path" varchar(100) COLLATE "pg_catalog"."default",
  "create_by" varchar(40) COLLATE "pg_catalog"."default",
  "update_by" varchar(40) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_file"."id" IS '主键ID';
COMMENT ON COLUMN "public"."sys_file"."file_name" IS '文件名';
COMMENT ON COLUMN "public"."sys_file"."extension" IS '扩展名';
COMMENT ON COLUMN "public"."sys_file"."total_size" IS '文件大小';
COMMENT ON COLUMN "public"."sys_file"."file_path" IS '文件路径';
COMMENT ON COLUMN "public"."sys_file"."is_static" IS '是否是静态文件（0：否，1：是）';
COMMENT ON COLUMN "public"."sys_file"."static_path" IS '静态文件相对路径';
COMMENT ON COLUMN "public"."sys_file"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_file"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_file"."create_time" IS '创建日期';
COMMENT ON COLUMN "public"."sys_file"."update_time" IS '更新时间';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_logininfor";
CREATE TABLE "public"."sys_logininfor" (
  "info_id" int8 NOT NULL,
  "user_name" varchar(50) COLLATE "pg_catalog"."default",
  "ipaddr" varchar(128) COLLATE "pg_catalog"."default",
  "login_location" varchar(255) COLLATE "pg_catalog"."default",
  "browser" varchar(50) COLLATE "pg_catalog"."default",
  "os" varchar(50) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "msg" varchar(255) COLLATE "pg_catalog"."default",
  "login_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_logininfor"."info_id" IS '访问ID';
COMMENT ON COLUMN "public"."sys_logininfor"."user_name" IS '用户账号';
COMMENT ON COLUMN "public"."sys_logininfor"."ipaddr" IS '登录IP地址';
COMMENT ON COLUMN "public"."sys_logininfor"."login_location" IS '登录地点';
COMMENT ON COLUMN "public"."sys_logininfor"."browser" IS '浏览器类型';
COMMENT ON COLUMN "public"."sys_logininfor"."os" IS '操作系统';
COMMENT ON COLUMN "public"."sys_logininfor"."status" IS '登录状态（0成功 1失败）';
COMMENT ON COLUMN "public"."sys_logininfor"."msg" IS '提示消息';
COMMENT ON COLUMN "public"."sys_logininfor"."login_time" IS '访问时间';
COMMENT ON TABLE "public"."sys_logininfor" IS '系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
  "menu_id" int8 NOT NULL,
  "menu_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" int8,
  "order_num" int4,
  "path" varchar(200) COLLATE "pg_catalog"."default",
  "component" varchar(255) COLLATE "pg_catalog"."default",
  "query_param" varchar(255) COLLATE "pg_catalog"."default",
  "is_frame" char(1) COLLATE "pg_catalog"."default",
  "is_cache" char(1) COLLATE "pg_catalog"."default",
  "menu_type" char(1) COLLATE "pg_catalog"."default",
  "visible" char(1) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "perms" varchar(100) COLLATE "pg_catalog"."default",
  "icon" varchar(100) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default",
  "show_parent" char(8) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_menu"."menu_id" IS '菜单ID';
COMMENT ON COLUMN "public"."sys_menu"."menu_name" IS '菜单名称';
COMMENT ON COLUMN "public"."sys_menu"."parent_id" IS '父菜单ID';
COMMENT ON COLUMN "public"."sys_menu"."order_num" IS '显示顺序';
COMMENT ON COLUMN "public"."sys_menu"."path" IS '路由地址';
COMMENT ON COLUMN "public"."sys_menu"."component" IS '组件路径';
COMMENT ON COLUMN "public"."sys_menu"."query_param" IS '路由参数';
COMMENT ON COLUMN "public"."sys_menu"."is_frame" IS '是否为外链（0是 1否）';
COMMENT ON COLUMN "public"."sys_menu"."is_cache" IS '是否缓存（0缓存 1不缓存）';
COMMENT ON COLUMN "public"."sys_menu"."menu_type" IS '菜单类型（M目录 C菜单 F按钮）';
COMMENT ON COLUMN "public"."sys_menu"."visible" IS '显示状态（0显示 1隐藏）';
COMMENT ON COLUMN "public"."sys_menu"."status" IS '菜单状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_menu"."perms" IS '权限标识';
COMMENT ON COLUMN "public"."sys_menu"."icon" IS '菜单图标';
COMMENT ON COLUMN "public"."sys_menu"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_menu"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_menu"."remark" IS '备注';
COMMENT ON COLUMN "public"."sys_menu"."show_parent" IS '是否显示父级';
COMMENT ON TABLE "public"."sys_menu" IS '菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "public"."sys_menu" VALUES (1, '系统管理', 0, 1, 'system', NULL, '', '1', '0', 'M', '0', '0', '', 'setting', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 17:17:14', '系统管理目录', '1       ');
INSERT INTO "public"."sys_menu" VALUES (101, '角色管理', 1, 2, '/system/role', '/system/role/index', '', '1', '1', 'C', '0', '0', 'system:role:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:13', '角色管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (102, '菜单管理', 1, 3, '/system/menu', '/system/menu/index', '', '1', '1', 'C', '0', '0', 'system:menu:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:18', '菜单管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (103, '部门管理', 1, 4, '/system/dept', '/system/dept/index', '', '1', '1', 'C', '0', '0', 'system:dept:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:23', '部门管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (104, '岗位管理', 1, 5, '/system/post', '/system/post/index', '', '1', '1', 'C', '0', '0', 'system:post:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:26', '岗位管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (105, '字典管理', 1, 6, '/system/dict', '/system/dict/index', '', '1', '1', 'C', '0', '0', 'system:dict:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:29', '字典管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (106, '参数设置', 1, 7, '/system/config', '/system/config/index', '', '1', '1', 'C', '0', '1', 'system:config:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:31', '参数设置菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (107, '通知公告', 1, 8, '/system/notice', '/system/notice/index', '', '1', '1', 'C', '0', '1', 'system:notice:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:34', '通知公告菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (108, '日志管理', 1, 9, 'log', '', '', '1', '0', 'M', '0', '0', '', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:37', '日志管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (118, '文件管理', 1, 10, '/system/oss', '/system/oss/index', '', '1', '1', 'C', '0', '1', 'system:oss:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 16:54:39', '文件管理菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (500, '操作日志', 108, 1, '/monitor/operlog', '/monitor/operlog/index', '', '1', '1', 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-31 10:15:50', '操作日志菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (501, '登录日志', 108, 2, '/monitor/logininfor', '/monitor/logininfor/index', '', '1', '1', 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-31 10:16:01', '登录日志菜单', '1       ');
INSERT INTO "public"."sys_menu" VALUES (1001, '用户查询', 100, 1, '', '', '', '1', '0', 'F', '0', '0', 'system:user:query', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1002, '用户新增', 100, 2, '', '', '', '1', '0', 'F', '0', '0', 'system:user:add', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1003, '用户修改', 100, 3, '', '', '', '1', '0', 'F', '0', '0', 'system:user:edit', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1004, '用户删除', 100, 4, '', '', '', '1', '0', 'F', '0', '0', 'system:user:remove', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1005, '用户导出', 100, 5, '', '', '', '1', '0', 'F', '0', '0', 'system:user:export', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1006, '用户导入', 100, 6, '', '', '', '1', '0', 'F', '0', '0', 'system:user:import', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1007, '重置密码', 100, 7, '', '', '', '1', '0', 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1008, '角色查询', 101, 1, '', '', '', '1', '0', 'F', '0', '0', 'system:role:query', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1009, '角色新增', 101, 2, '', '', '', '1', '0', 'F', '0', '0', 'system:role:add', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1010, '角色修改', 101, 3, '', '', '', '1', '0', 'F', '0', '0', 'system:role:edit', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1011, '角色删除', 101, 4, '', '', '', '1', '0', 'F', '0', '0', 'system:role:remove', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1012, '角色导出', 101, 5, '', '', '', '1', '0', 'F', '0', '0', 'system:role:export', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1013, '菜单查询', 102, 1, '', '', '', '1', '0', 'F', '0', '0', 'system:menu:query', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1014, '菜单新增', 102, 2, '', '', '', '1', '0', 'F', '0', '0', 'system:menu:add', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1015, '菜单修改', 102, 3, '', '', '', '1', '0', 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1016, '菜单删除', 102, 4, '', '', '', '1', '0', 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1017, '部门查询', 103, 1, '', '', '', '1', '0', 'F', '0', '0', 'system:dept:query', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1018, '部门新增', 103, 2, '', '', '', '1', '0', 'F', '0', '0', 'system:dept:add', '#', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1020, '部门删除', 103, 4, '', '', '', '1', '0', 'F', '0', '0', 'system:dept:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1021, '岗位查询', 104, 1, '', '', '', '1', '0', 'F', '0', '0', 'system:post:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1022, '岗位新增', 104, 2, '', '', '', '1', '0', 'F', '0', '0', 'system:post:add', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1023, '岗位修改', 104, 3, '', '', '', '1', '0', 'F', '0', '0', 'system:post:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1024, '岗位删除', 104, 4, '', '', '', '1', '0', 'F', '0', '0', 'system:post:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1025, '岗位导出', 104, 5, '', '', '', '1', '0', 'F', '0', '0', 'system:post:export', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1026, '字典查询', 105, 1, '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1027, '字典新增', 105, 2, '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:add', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1029, '字典删除', 105, 4, '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1030, '字典导出', 105, 5, '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:export', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1031, '参数查询', 106, 1, '#', '', '', '1', '0', 'F', '0', '0', 'system:config:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1032, '参数新增', 106, 2, '#', '', '', '1', '0', 'F', '0', '0', 'system:config:add', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1033, '参数修改', 106, 3, '#', '', '', '1', '0', 'F', '0', '0', 'system:config:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1034, '参数删除', 106, 4, '#', '', '', '1', '0', 'F', '0', '0', 'system:config:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1035, '参数导出', 106, 5, '#', '', '', '1', '0', 'F', '0', '0', 'system:config:export', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1036, '公告查询', 107, 1, '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1037, '公告新增', 107, 2, '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:add', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1038, '公告修改', 107, 3, '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1039, '公告删除', 107, 4, '#', '', '', '1', '0', 'F', '0', '0', 'system:notice:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1040, '操作查询', 500, 1, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1041, '操作删除', 500, 2, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1042, '日志导出', 500, 4, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:operlog:export', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1043, '登录查询', 501, 1, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (100, '用户管理', 1, 1, '/system/user', '/system/user/index', '', '1', '1', 'C', '0', '0', 'system:user:list', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-07-10 14:27:23.032', '用户管理菜单', 'true    ');
INSERT INTO "public"."sys_menu" VALUES (1019, '部门修改', 103, 3, '', '', '', '1', '0', 'F', '0', '0', 'system:dept:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1028, '字典修改', 105, 3, '#', '', '', '1', '0', 'F', '0', '0', 'system:dict:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1044, '登录删除', 501, 2, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1045, '日志导出', 501, 3, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:export', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1050, '账户解锁', 501, 4, '#', '', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:unlock', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1600, '文件查询', 118, 1, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:query', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1601, '文件上传', 118, 2, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:upload', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1602, '文件下载', 118, 3, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:download', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1603, '文件删除', 118, 4, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:remove', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1604, '配置添加', 118, 5, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:add', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1605, '配置编辑', 118, 6, '#', '', '', '1', '0', 'F', '0', '0', 'system:oss:edit', '', 'admin', '2023-03-15 14:06:16', '', NULL, '', NULL);
INSERT INTO "public"."sys_menu" VALUES (1656187553642459138, '系统信息', 108, 3, '/monitor/systemInfo', '/monitor/systemInfo/index', NULL, '1', '1', 'C', '0', '0', NULL, '', 'admin', '2023-05-10 14:40:58', 'admin', '2023-05-10 14:40:58', '', '1       ');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_notice";
CREATE TABLE "public"."sys_notice" (
  "notice_id" int8 NOT NULL,
  "notice_title" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "notice_type" char(1) COLLATE "pg_catalog"."default" NOT NULL,
  "notice_content" bytea,
  "status" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_notice"."notice_id" IS '公告ID';
COMMENT ON COLUMN "public"."sys_notice"."notice_title" IS '公告标题';
COMMENT ON COLUMN "public"."sys_notice"."notice_type" IS '公告类型（1通知 2公告）';
COMMENT ON COLUMN "public"."sys_notice"."notice_content" IS '公告内容';
COMMENT ON COLUMN "public"."sys_notice"."status" IS '公告状态（0正常 1关闭）';
COMMENT ON COLUMN "public"."sys_notice"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_notice"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_notice"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_notice"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_notice"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_notice" IS '通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO "public"."sys_notice" VALUES (1, '温馨提醒：2018-07-01 新版本发布啦', '2', E'\\346\\226\\260\\347\\211\\210\\346\\234\\254\\345\\206\\205\\345\\256\\271', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '管理员');
INSERT INTO "public"."sys_notice" VALUES (2, '维护通知：2018-07-01 系统凌晨维护', '1', E'\\347\\273\\264\\346\\212\\244\\345\\206\\205\\345\\256\\271', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_oper_log";
CREATE TABLE "public"."sys_oper_log" (
  "oper_id" int8 NOT NULL,
  "title" varchar(50) COLLATE "pg_catalog"."default",
  "business_type" int4,
  "method" varchar(100) COLLATE "pg_catalog"."default",
  "request_method" varchar(10) COLLATE "pg_catalog"."default",
  "operator_type" int4,
  "oper_name" varchar(50) COLLATE "pg_catalog"."default",
  "dept_name" varchar(50) COLLATE "pg_catalog"."default",
  "oper_url" varchar(255) COLLATE "pg_catalog"."default",
  "oper_ip" varchar(128) COLLATE "pg_catalog"."default",
  "oper_location" varchar(255) COLLATE "pg_catalog"."default",
  "oper_param" varchar(2000) COLLATE "pg_catalog"."default",
  "json_result" varchar(2000) COLLATE "pg_catalog"."default",
  "status" int4,
  "error_msg" varchar(2000) COLLATE "pg_catalog"."default",
  "oper_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_oper_log"."oper_id" IS '日志主键';
COMMENT ON COLUMN "public"."sys_oper_log"."title" IS '模块标题';
COMMENT ON COLUMN "public"."sys_oper_log"."business_type" IS '业务类型（0其它 1新增 2修改 3删除）';
COMMENT ON COLUMN "public"."sys_oper_log"."method" IS '方法名称';
COMMENT ON COLUMN "public"."sys_oper_log"."request_method" IS '请求方式';
COMMENT ON COLUMN "public"."sys_oper_log"."operator_type" IS '操作类别（0其它 1后台用户 2手机端用户）';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_name" IS '操作人员';
COMMENT ON COLUMN "public"."sys_oper_log"."dept_name" IS '部门名称';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_url" IS '请求URL';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_ip" IS '主机地址';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_location" IS '操作地点';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_param" IS '请求参数';
COMMENT ON COLUMN "public"."sys_oper_log"."json_result" IS '返回参数';
COMMENT ON COLUMN "public"."sys_oper_log"."status" IS '操作状态（0正常 1异常）';
COMMENT ON COLUMN "public"."sys_oper_log"."error_msg" IS '错误消息';
COMMENT ON COLUMN "public"."sys_oper_log"."oper_time" IS '操作时间';
COMMENT ON TABLE "public"."sys_oper_log" IS '操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO "public"."sys_oper_log" VALUES (1643858818197098497, '操作日志', 9, 'com.university.web.controller.monitor.SysOperlogController.clean()', 'DELETE', 1, 'admin', '', '/monitor/operlog/clean', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:10:58');
INSERT INTO "public"."sys_oper_log" VALUES (1643858865315909633, '登录日志', 3, 'com.university.web.controller.monitor.SysLogininforController.remove()', 'DELETE', 1, 'admin', '', '/monitor/logininfor/1643857170225696769', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:11:10');
INSERT INTO "public"."sys_oper_log" VALUES (1643858879152918529, '登录日志', 9, 'com.university.web.controller.monitor.SysLogininforController.clean()', 'DELETE', 1, 'admin', '', '/monitor/logininfor/clean', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:11:13');
INSERT INTO "public"."sys_oper_log" VALUES (1643861488207138818, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-06 14:21:34","parentName":null,"parentId":1,"children":[],"menuId":106,"menuName":"参数设置","orderNum":7,"path":"/system/config","component":"/system/config/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:config:list","icon":null,"remark":"参数设置菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:21:35');
INSERT INTO "public"."sys_oper_log" VALUES (1643861550207340546, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-06 14:21:49","parentName":null,"parentId":1,"children":[],"menuId":107,"menuName":"通知公告","orderNum":8,"path":"/system/notice","component":"/system/notice/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:notice:list","icon":null,"remark":"通知公告菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:21:50');
INSERT INTO "public"."sys_oper_log" VALUES (1643861609925840897, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-06 14:22:03","parentName":null,"parentId":1,"children":[],"menuId":118,"menuName":"文件管理","orderNum":10,"path":"/system/oss","component":"/system/oss/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:oss:list","icon":null,"remark":"文件管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:22:04');
INSERT INTO "public"."sys_oper_log" VALUES (1643864164730933249, '字典类型', 2, 'com.university.web.controller.system.SysDictTypeController.edit()', 'PUT', 1, 'admin', '', '/system/dict/type', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-06 14:32:13","dictId":3,"dictName":"系统开关","dictType":"sys_normal_disable","status":"0","remark":"系统开关列表"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-06 14:32:13');
INSERT INTO "public"."sys_oper_log" VALUES (1644179057740963842, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 11:23:29","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"0","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 11:23:29');
INSERT INTO "public"."sys_oper_log" VALUES (1644179065273933826, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 11:23:31","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"1","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 11:23:31');
INSERT INTO "public"."sys_oper_log" VALUES (1644179070571339777, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 11:23:32","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"0","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 11:23:32');
INSERT INTO "public"."sys_oper_log" VALUES (1644249661361971202, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:04:02","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:04:03');
INSERT INTO "public"."sys_oper_log" VALUES (1661271225127247874, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1661266174933573633', '192.168.8.146', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:21:40');
INSERT INTO "public"."sys_oper_log" VALUES (1644179115102265346, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 11:23:43","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"1","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 11:23:43');
INSERT INTO "public"."sys_oper_log" VALUES (1644179127454490625, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 11:23:45","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"0","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 11:23:46');
INSERT INTO "public"."sys_oper_log" VALUES (1644208006315466753, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 13:18:31","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"1","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 13:18:31');
INSERT INTO "public"."sys_oper_log" VALUES (1644208028754993153, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updateProfile()', 'PUT', 1, 'admin', '', '/system/user/profile', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 13:18:36","userId":1,"deptId":null,"userName":null,"nickName":"疯狂的狮子Li","userType":"sys_user","email":"crazyLionLi@163.com","phonenumber":"15888888888","sex":"0","avatar":null,"status":"0","delFlag":"0","loginIp":"192.168.8.42","loginDate":"2023-04-07 08:49:39","remark":"管理员","dept":{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"parentName":null,"parentId":101,"children":[],"deptId":103,"deptName":"研发部门","orderNum":1,"leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"ancestors":"0,100,101"},"roles":[{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"roleId":1,"roleName":"超级管理员","roleKey":"admin","roleSort":1,"dataScope":"1","menuCheckStrictly":null,"deptCheckStrictly":null,"status":"0","delFlag":null,"remark":null,"flag":false,"menuIds":null,"deptIds":null,"admin":true}],"roleIds":null,"postIds":null,"roleId":null,"admin":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 13:18:37');
INSERT INTO "public"."sys_oper_log" VALUES (1644217982987624450, '用户管理', 2, 'com.university.web.controller.system.SysUserController.resetPwd()', 'PUT', 1, 'admin', '', '/system/user/resetPwd', '192.168.8.42', '内网IP', '{"createBy":null,"createTime":null,"updateBy":"admin","updateTime":"2023-04-07 13:58:09","userId":3,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":null,"delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 13:58:10');
INSERT INTO "public"."sys_oper_log" VALUES (1644218114525192194, '个人信息', 2, 'com.university.web.controller.system.SysProfileController.updatePwd()', 'PUT', 1, 'test', '', '/system/user/profile/updatePwd', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 13:58:41');
INSERT INTO "public"."sys_oper_log" VALUES (1644223582555430913, '用户管理', 6, 'com.university.web.controller.system.SysUserController.importData()', 'POST', 1, 'test', '', '/system/user/importData', '192.168.8.42', '内网IP', 'false', '', 1, '很抱歉，导入失败！共 2 条数据格式不正确，错误如下：<br/>1、账号 null 导入失败：参数校验异常<br/>2、账号 null 导入失败：参数校验异常', '2023-04-07 14:20:25');
INSERT INTO "public"."sys_oper_log" VALUES (1644225645205086209, '用户管理', 2, 'com.university.web.controller.system.SysUserController.changeStatus()', 'PUT', 1, 'admin', '', '/system/user/changeStatus', '192.168.8.252', '内网IP', '{"createBy":null,"createTime":null,"updateBy":"admin","updateTime":"2023-04-07 14:28:36","userId":2,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":"1","delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 14:28:37');
INSERT INTO "public"."sys_oper_log" VALUES (1644225656835891202, '用户管理', 2, 'com.university.web.controller.system.SysUserController.changeStatus()', 'PUT', 1, 'admin', '', '/system/user/changeStatus', '192.168.8.252', '内网IP', '{"createBy":null,"createTime":null,"updateBy":"admin","updateTime":"2023-04-07 14:28:39","userId":2,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":"0","delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 14:28:39');
INSERT INTO "public"."sys_oper_log" VALUES (1661271179669381121, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1661268760373862401', '192.168.8.146', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:21:29');
INSERT INTO "public"."sys_oper_log" VALUES (1644249759387049986, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:04:25","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:04:26');
INSERT INTO "public"."sys_oper_log" VALUES (1644249958788456449, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:05:13","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:05:14');
INSERT INTO "public"."sys_oper_log" VALUES (1644250864699400194, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:08:49","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"Setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:08:50');
INSERT INTO "public"."sys_oper_log" VALUES (1644251206010888194, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:10:10","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:10:11');
INSERT INTO "public"."sys_oper_log" VALUES (1644256585608421378, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:31:33","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"Setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:31:33');
INSERT INTO "public"."sys_oper_log" VALUES (1644257322170146817, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:34:29","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:34:29');
INSERT INTO "public"."sys_oper_log" VALUES (1644258276596604930, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:38:16","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:38:17');
INSERT INTO "public"."sys_oper_log" VALUES (1644259280641679361, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:42:16","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":null,"remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:42:16');
INSERT INTO "public"."sys_oper_log" VALUES (1644259373398712321, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:42:38","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":null,"remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:42:38');
INSERT INTO "public"."sys_oper_log" VALUES (1644259487940960258, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:43:05","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"questionLine","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:43:05');
INSERT INTO "public"."sys_oper_log" VALUES (1644261914702340097, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:52:44","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"questionLine","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:52:44');
INSERT INTO "public"."sys_oper_log" VALUES (1644261994008240129, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:53:02","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"questionLine","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:53:03');
INSERT INTO "public"."sys_oper_log" VALUES (1644262271469838338, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:09","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:09');
INSERT INTO "public"."sys_oper_log" VALUES (1644262288284803073, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:13","parentName":null,"parentId":1,"children":[],"menuId":101,"menuName":"角色管理","orderNum":2,"path":"/system/role","component":"/system/role/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:role:list","icon":"","remark":"角色管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:13');
INSERT INTO "public"."sys_oper_log" VALUES (1644262310321676290, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:18","parentName":null,"parentId":1,"children":[],"menuId":102,"menuName":"菜单管理","orderNum":3,"path":"/system/menu","component":"/system/menu/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:menu:list","icon":"","remark":"菜单管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:18');
INSERT INTO "public"."sys_oper_log" VALUES (1644262329099575297, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:22","parentName":null,"parentId":1,"children":[],"menuId":103,"menuName":"部门管理","orderNum":4,"path":"/system/dept","component":"/system/dept/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:dept:list","icon":"","remark":"部门管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:23');
INSERT INTO "public"."sys_oper_log" VALUES (1644262341065924609, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:25","parentName":null,"parentId":1,"children":[],"menuId":104,"menuName":"岗位管理","orderNum":5,"path":"/system/post","component":"/system/post/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:post:list","icon":"","remark":"岗位管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:26');
INSERT INTO "public"."sys_oper_log" VALUES (1644262353657225217, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:28","parentName":null,"parentId":1,"children":[],"menuId":105,"menuName":"字典管理","orderNum":6,"path":"/system/dict","component":"/system/dict/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:dict:list","icon":"","remark":"字典管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:29');
INSERT INTO "public"."sys_oper_log" VALUES (1644262365250281473, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:31","parentName":null,"parentId":1,"children":[],"menuId":106,"menuName":"参数设置","orderNum":7,"path":"/system/config","component":"/system/config/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:config:list","icon":"","remark":"参数设置菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:31');
INSERT INTO "public"."sys_oper_log" VALUES (1644262376813977601, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:34","parentName":null,"parentId":1,"children":[],"menuId":107,"menuName":"通知公告","orderNum":8,"path":"/system/notice","component":"/system/notice/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:notice:list","icon":"","remark":"通知公告菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:34');
INSERT INTO "public"."sys_oper_log" VALUES (1644262387576561665, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:36","parentName":null,"parentId":1,"children":[],"menuId":108,"menuName":"日志管理","orderNum":9,"path":"log","component":"","queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"","remark":"日志管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:37');
INSERT INTO "public"."sys_oper_log" VALUES (1644262398381088770, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:54:39","parentName":null,"parentId":1,"children":[],"menuId":118,"menuName":"文件管理","orderNum":10,"path":"/system/oss","component":"/system/oss/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"1","perms":"system:oss:list","icon":"","remark":"文件管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:54:39');
INSERT INTO "public"."sys_oper_log" VALUES (1644263038515765249, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:57:11","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"lollipop","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:57:12');
INSERT INTO "public"."sys_oper_log" VALUES (1644263065980067842, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 16:57:18","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 16:57:19');
INSERT INTO "public"."sys_oper_log" VALUES (1644264422170517506, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:02:41","parentName":null,"parentId":0,"children":[],"deptId":100,"deptName":"广东航天宏图","orderNum":0,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:02:42');
INSERT INTO "public"."sys_oper_log" VALUES (1644264472393113602, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:02:53","parentName":"若依科技","parentId":100,"children":[],"deptId":102,"deptName":"广东公司","orderNum":2,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:02:54');
INSERT INTO "public"."sys_oper_log" VALUES (1644264485047328769, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:02:56","parentName":"若依科技","parentId":100,"children":[],"deptId":101,"deptName":"深圳公司","orderNum":1,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:02:57');
INSERT INTO "public"."sys_oper_log" VALUES (1644264530941403138, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:02:57","parentName":"广东航天宏图","parentId":100,"children":[],"deptId":101,"deptName":"广东公司","orderNum":1,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":500,"msg":"修改部门''广东公司''失败，部门名称已存在","data":null}', 0, '', '2023-04-07 17:03:08');
INSERT INTO "public"."sys_oper_log" VALUES (1644264549949988866, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:02:54","parentName":"广东航天宏图","parentId":100,"children":[],"deptId":102,"deptName":"深圳公司","orderNum":2,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":500,"msg":"修改部门''深圳公司''失败，部门名称已存在","data":null}', 0, '', '2023-04-07 17:03:12');
INSERT INTO "public"."sys_oper_log" VALUES (1644264574117568514, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:03:18","parentName":"广东航天宏图","parentId":100,"children":[],"deptId":102,"deptName":"广东公司1","orderNum":2,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:03:18');
INSERT INTO "public"."sys_oper_log" VALUES (1644264595789537282, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:03:23","parentName":"广东航天宏图","parentId":100,"children":[],"deptId":101,"deptName":"广东公司","orderNum":1,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:03:23');
INSERT INTO "public"."sys_oper_log" VALUES (1644264619076313090, '部门管理', 2, 'com.university.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:03:28","parentName":"广东航天宏图","parentId":100,"children":[],"deptId":102,"deptName":"深圳公司","orderNum":2,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0,100"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:03:29');
INSERT INTO "public"."sys_oper_log" VALUES (1644268059772936194, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:17:09","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"delete","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:17:09');
INSERT INTO "public"."sys_oper_log" VALUES (1644268078932516865, '菜单管理', 2, 'com.university.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-07 17:17:13","parentName":null,"parentId":0,"children":[],"menuId":1,"menuName":"系统管理","orderNum":1,"path":"system","component":null,"queryParam":"","isFrame":"1","isCache":"0","menuType":"M","visible":"0","status":"0","perms":"","icon":"setting","remark":"系统管理目录","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-07 17:17:14');
INSERT INTO "public"."sys_oper_log" VALUES (1645685702451015681, '用户管理', 5, 'com.university.web.controller.system.SysUserController.export()', 'POST', 1, 'admin', '', '/system/user/export', '192.168.8.42', '内网IP', '{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"userId":null,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":null,"delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '', 0, '', '2023-04-11 15:10:21');
INSERT INTO "public"."sys_oper_log" VALUES (1645686132203597826, '用户管理', 5, 'com.university.web.controller.system.SysUserController.export()', 'POST', 1, 'admin', '', '/system/user/export', '192.168.8.42', '内网IP', '{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"userId":null,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":null,"delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '', 0, '', '2023-04-11 15:12:04');
INSERT INTO "public"."sys_oper_log" VALUES (1645686356984737794, '用户管理', 5, 'com.university.web.controller.system.SysUserController.export()', 'POST', 1, 'admin', '', '/system/user/export', '192.168.8.42', '内网IP', '{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"userId":null,"deptId":null,"userName":null,"nickName":null,"userType":null,"email":null,"phonenumber":null,"sex":null,"avatar":null,"status":null,"delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":null,"postIds":null,"roleId":null,"admin":false}', '', 0, '', '2023-04-11 15:12:58');
INSERT INTO "public"."sys_oper_log" VALUES (1645688568775454721, '登录日志', 9, 'com.university.web.controller.monitor.SysLogininforController.clean()', 'DELETE', 1, 'admin', '', '/monitor/logininfor/clean', '192.168.8.138', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-11 15:21:45');
INSERT INTO "public"."sys_oper_log" VALUES (1661271188276092930, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1661267656923783169', '192.168.8.146', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:21:31');
INSERT INTO "public"."sys_oper_log" VALUES (1647888287098486785, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-04-17 17:02:38","updateBy":"admin","updateTime":"2023-04-17 17:02:38","parentName":null,"parentId":0,"children":[],"menuId":"1647888286918131713","menuName":"管理1","orderNum":1,"path":"/test","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"arrowUpLine","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-17 17:02:39');
INSERT INTO "public"."sys_oper_log" VALUES (1647888769804156929, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1647888286918131713', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-17 17:04:34');
INSERT INTO "public"."sys_oper_log" VALUES (1648230951731867650, '个人信息', 2, 'com.htht.web.controller.system.SysProfileController.updatePwd()', 'PUT', 1, 'admin', '', '/system/user/profile/updatePwd', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-18 15:44:16');
INSERT INTO "public"."sys_oper_log" VALUES (1648231120711987201, '个人信息', 2, 'com.htht.web.controller.system.SysProfileController.updatePwd()', 'PUT', 1, 'admin', '', '/system/user/profile/updatePwd', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-18 15:44:56');
INSERT INTO "public"."sys_oper_log" VALUES (1648511047071264770, '个人信息', 2, 'com.htht.web.controller.system.SysProfileController.updatePwd()', 'PUT', 1, 'test', '', '/system/user/profile/updatePwd', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-19 10:17:16');
INSERT INTO "public"."sys_oper_log" VALUES (1648512045139456002, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-19 10:21:14","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-19 10:21:14');
INSERT INTO "public"."sys_oper_log" VALUES (1648512159371325442, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-04-19 10:21:41","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-04-19 10:21:41');
INSERT INTO "public"."sys_oper_log" VALUES (1655467615424360449, '用户管理', 3, 'com.htht.web.controller.system.SysUserController.remove()', 'DELETE', 1, 'admin', '', '/system/user/4', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-08 15:00:11');
INSERT INTO "public"."sys_oper_log" VALUES (1656125119502233602, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:32:52","updateBy":"admin","updateTime":"2023-05-10 10:32:52","parentName":null,"parentId":0,"children":[],"menuId":"1656125119393181698","menuName":"目录1","orderNum":2,"path":"/tes","component":"/tes/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"dept","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:32:52');
INSERT INTO "public"."sys_oper_log" VALUES (1656125254395244545, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:33:24","updateBy":"admin","updateTime":"2023-05-10 10:33:24","parentName":null,"parentId":"1656125119393181698","children":[],"menuId":"1656125254361690113","menuName":"目录1-1","orderNum":1,"path":"/test/","component":"/test/","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":null,"remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:33:25');
INSERT INTO "public"."sys_oper_log" VALUES (1656126585646362625, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:38:42","updateBy":"admin","updateTime":"2023-05-10 10:38:42","parentName":null,"parentId":0,"children":[],"menuId":"1656126585608613889","menuName":"我的目录","orderNum":2,"path":"test","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"informationLine","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:38:42');
INSERT INTO "public"."sys_oper_log" VALUES (1656126809307623426, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:39:35","updateBy":"admin","updateTime":"2023-05-10 10:39:35","parentName":null,"parentId":"1656126585608613889","children":[],"menuId":"1656126809278263298","menuName":"目录1-1","orderNum":1,"path":"/test/caidan","component":"/test/caidan/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"card","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:39:35');
INSERT INTO "public"."sys_oper_log" VALUES (1656126855738568705, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:38:42","updateBy":"admin","updateTime":"2023-05-10 10:39:46","parentName":null,"parentId":0,"children":[],"menuId":"1656126585608613889","menuName":"我的目录","orderNum":2,"path":"test","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"informationLine","remark":"","showParent":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:39:46');
INSERT INTO "public"."sys_oper_log" VALUES (1656126963448295425, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:39:35","updateBy":"admin","updateTime":"2023-05-10 10:40:12","parentName":null,"parentId":"1656126585608613889","children":[],"menuId":"1656126809278263298","menuName":"目录1-1","orderNum":1,"path":"/test/caidan","component":"/test/caidan/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"card","remark":"","showParent":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:40:12');
INSERT INTO "public"."sys_oper_log" VALUES (1656127392370405378, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 10:41:54","updateBy":"admin","updateTime":"2023-05-10 10:41:54","parentName":null,"parentId":0,"children":[],"menuId":"1656127392303296514","menuName":"测试菜单","orderNum":3,"path":"/caidan","component":"/caidan/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"informationLine","remark":null,"showParent":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 10:41:54');
INSERT INTO "public"."sys_oper_log" VALUES (1661271212598861826, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1661269486407884801', '192.168.8.146', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:21:37');
INSERT INTO "public"."sys_oper_log" VALUES (1656187553701179394, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-05-10 14:40:57","updateBy":"admin","updateTime":"2023-05-10 14:40:57","parentName":null,"parentId":108,"children":[],"menuId":"1656187553642459138","menuName":"系统信息","orderNum":3,"path":"/monitor/systemInfo","component":"/monitor/systemInfo/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":null,"remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-10 14:40:58');
INSERT INTO "public"."sys_oper_log" VALUES (1658376183965921282, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.122', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 15:37:48","updateBy":"admin","updateTime":"2023-05-16 15:37:48","parentName":null,"parentId":0,"children":[],"menuId":"1658376183840092162","menuName":"首页","orderNum":1,"path":"/home","component":"/home/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":null,"remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 15:37:48');
INSERT INTO "public"."sys_oper_log" VALUES (1658376619368230914, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.122', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 15:37:48","updateBy":"admin","updateTime":"2023-05-16 15:39:31","parentName":null,"parentId":0,"children":[],"menuId":"1658376183840092162","menuName":"首页","orderNum":1,"path":"/welcome","component":"/welcome/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"#","remark":"","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 15:39:32');
INSERT INTO "public"."sys_oper_log" VALUES (1658377358794665985, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.122', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 15:37:48","updateBy":"admin","updateTime":"2023-05-16 15:42:28","parentName":null,"parentId":0,"children":[],"menuId":"1658376183840092162","menuName":"首页","orderNum":1,"path":"/welcome","component":"/welcome/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"welcome","icon":"#","remark":"","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 15:42:28');
INSERT INTO "public"."sys_oper_log" VALUES (1658377477191479297, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', '', '/system/menu', '192.168.8.122', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 15:37:48","updateBy":"admin","updateTime":"2023-05-16 15:42:56","parentName":null,"parentId":0,"children":[],"menuId":"1658376183840092162","menuName":"首页","orderNum":1,"path":"/welcome","component":"/welcome/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"","icon":"#","remark":"","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 15:42:56');
INSERT INTO "public"."sys_oper_log" VALUES (1658390421938216961, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 16:34:22","updateBy":"admin","updateTime":"2023-05-16 16:34:22","parentName":null,"parentId":0,"children":[],"menuId":"1658390421778833410","menuName":"首页目录","orderNum":2,"path":"firstTerm","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"officeBuilding","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 16:34:23');
INSERT INTO "public"."sys_oper_log" VALUES (1658390446894325761, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1658390421778833410', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 16:34:29');
INSERT INTO "public"."sys_oper_log" VALUES (1658390517467684865, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.42', '内网IP', '{"createBy":"admin","createTime":"2023-05-16 16:34:45","updateBy":"admin","updateTime":"2023-05-16 16:34:45","parentName":null,"parentId":0,"children":[],"menuId":"1658390517400576002","menuName":"首页目录","orderNum":2,"path":"firstTerm","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"officeBuilding","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 16:34:45');
INSERT INTO "public"."sys_oper_log" VALUES (1658390528762945538, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1658390517400576002', '192.168.8.42', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-16 16:34:48');
INSERT INTO "public"."sys_oper_log" VALUES (1661266174975516674, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.146', '内网IP', '{"createBy":"admin","createTime":"2023-05-24 15:01:35","updateBy":"admin","updateTime":"2023-05-24 15:01:35","parentName":null,"parentId":0,"children":[],"menuId":"1661266174933573633","menuName":"安全管理","orderNum":2,"path":"safetyManagement","component":null,"queryParam":null,"isFrame":"1","isCache":"1","menuType":"M","visible":"0","status":"0","icon":"listCheck","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:01:36');
INSERT INTO "public"."sys_oper_log" VALUES (1661267656957337601, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.146', '内网IP', '{"createBy":"admin","createTime":"2023-05-24 15:07:28","updateBy":"admin","updateTime":"2023-05-24 15:07:28","parentName":null,"parentId":"1661266174933573633","children":[],"menuId":"1661267656923783169","menuName":"电子围栏","orderNum":1,"path":"/safetyManagement/electronicFence","component":"/safetyManagement/electronicFence/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":null,"remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:07:29');
INSERT INTO "public"."sys_oper_log" VALUES (1661268760419999745, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.146', '内网IP', '{"createBy":"admin","createTime":"2023-05-24 15:11:52","updateBy":"admin","updateTime":"2023-05-24 15:11:52","parentName":null,"parentId":"1661266174933573633","children":[],"menuId":"1661268760373862401","menuName":"轨迹分析","orderNum":2,"path":"/safetyManagement/trajectoryAnalysis","component":"/safetyManagement/trajectoryAnalysis","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":null,"remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:11:52');
INSERT INTO "public"."sys_oper_log" VALUES (1661269486454022145, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', '', '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-05-24 15:14:45","updateBy":"admin","updateTime":"2023-05-24 15:14:45","parentName":null,"parentId":"1661266174933573633","children":[],"menuId":"1661269486407884801","menuName":"测试","orderNum":4,"path":"/safetyManagem/test","component":"/safetyManagem/test","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","icon":"card","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-05-24 15:14:45');
INSERT INTO "public"."sys_oper_log" VALUES (1661271153446592514, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', '', '/system/menu/1661266174933573633', '192.168.8.146', '内网IP', '{}', '{"code":601,"msg":"存在子菜单,不允许删除","data":null}', 0, '', '2023-05-24 15:21:23');
INSERT INTO "public"."sys_oper_log" VALUES (1665963757367042050, '部门管理', 2, 'com.htht.web.controller.system.SysDeptController.edit()', 'PUT', 1, 'admin', '', '/system/dept', '192.168.8.160', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-06 14:08:06","parentName":null,"parentId":0,"children":[],"deptId":100,"deptName":"广东HTHT","orderNum":0,"leader":"若依","phone":"15888888888","email":"ry@qq.com","status":"0","delFlag":"0","ancestors":"0"}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-06-06 14:08:07');
INSERT INTO "public"."sys_oper_log" VALUES (1671074939442667521, '用户管理', 1, 'com.htht.web.controller.system.SysUserController.add()', 'POST', 1, 'admin', '', '/system/user', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-20 16:38:07","updateBy":"admin","updateTime":"2023-06-20 16:38:07","userId":"1671074939354587138","deptId":103,"userName":"liaozhenshan","nickName":"廖震山","userType":null,"email":"378272027@qq.com","phonenumber":"15220801780","sex":"0","avatar":null,"status":"0","delFlag":null,"loginIp":null,"loginDate":null,"remark":"测试新增用户","dept":null,"roles":null,"roleIds":[2],"postIds":[1],"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-06-20 16:38:07');
INSERT INTO "public"."sys_oper_log" VALUES (1671075272378130434, '用户管理', 3, 'com.htht.web.controller.system.SysUserController.remove()', 'DELETE', 1, 'admin', '', '/system/user/1671074939354587138', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-06-20 16:39:27');
INSERT INTO "public"."sys_oper_log" VALUES (1671075475625713665, '用户管理', 1, 'com.htht.web.controller.system.SysUserController.add()', 'POST', 1, 'admin', '', '/system/user', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-20 16:40:15","updateBy":"admin","updateTime":"2023-06-20 16:40:15","userId":"1671075475575382018","deptId":103,"userName":"13800138000","nickName":"aa","userType":null,"email":"378272027@qq.com","phonenumber":"15220801780","sex":"0","avatar":null,"status":"0","delFlag":null,"loginIp":null,"loginDate":null,"remark":"aa","dept":null,"roles":null,"roleIds":[2],"postIds":[1],"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-06-20 16:40:15');
INSERT INTO "public"."sys_oper_log" VALUES (1671075559222386690, '用户管理', 3, 'com.htht.web.controller.system.SysUserController.remove()', 'DELETE', 1, '13800138000', '', '/system/user/1671075475575382018', '192.168.8.252', '内网IP', '{}', '{"code":500,"msg":"当前用户不能删除","data":null}', 0, '', '2023-06-20 16:40:35');
INSERT INTO "public"."sys_oper_log" VALUES (1671075624515117058, '用户管理', 3, 'com.htht.web.controller.system.SysUserController.remove()', 'DELETE', 1, 'admin', '', '/system/user/1671075475575382018', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, '', '2023-06-20 16:40:51');
INSERT INTO "public"."sys_oper_log" VALUES (1673240674319429633, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:03:58","updateBy":"admin","updateTime":"2023-06-26 16:03:58","parentName":null,"parentId":1,"children":[],"menuId":"1673240673728032770","menuName":"测试管理","orderNum":6,"path":"/system/test","component":"/system/test/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:test:list","icon":"homeFilled","remark":null,"showParent":true}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "is_frame" is of type integer but expression is of type character varying
  建议：You will need to rewrite or cast the expression.
  位置：241
### The error may exist in com/htht/system/mapper/SysMenuMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysMenuMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO sys_menu  ( menu_id, menu_name, order_num, path, component,  is_frame, is_cache, menu_type, visible, status, perms, icon,  show_parent, parent_id, create_by, create_time, update_by, update_time )  VALUES  ( ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: column "is_frame" is of type integer but expression is of type character varying
  建议：You will need to rewrite or cast the expression.
  位置：241
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "is_frame" is of type integer but expression is of type character varying
  建议：You will need to rewrite or cast the expression.
  位置：241', '2023-06-26 16:03:58.723');
INSERT INTO "public"."sys_oper_log" VALUES (1673241816050921474, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:08:30","updateBy":"admin","updateTime":"2023-06-26 16:08:30","parentName":null,"parentId":1,"children":[],"menuId":"1673241816050921473","menuName":"测试管理","orderNum":8,"path":"/system/test","component":"/system/test/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:test:list","icon":"videoPlay","remark":null,"showParent":true}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "show_parent" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：273
### The error may exist in com/htht/system/mapper/SysMenuMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysMenuMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO sys_menu  ( menu_id, menu_name, order_num, path, component,  is_frame, is_cache, menu_type, visible, status, perms, icon,  show_parent, parent_id, create_by, create_time, update_by, update_time )  VALUES  ( ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: column "show_parent" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：273
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "show_parent" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：273', '2023-06-26 16:08:30.943');
INSERT INTO "public"."sys_oper_log" VALUES (1673242258868760577, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:10:16","updateBy":"admin","updateTime":"2023-06-26 16:10:16","parentName":null,"parentId":1,"children":[],"menuId":"1673242258805846017","menuName":"测试管理","orderNum":9,"path":"/system/test","component":"/system/test/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:test:list","icon":"ubuntuFill","remark":null,"showParent":true}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: value too long for type character(1)
### The error may exist in com/htht/system/mapper/SysMenuMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysMenuMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO sys_menu  ( menu_id, menu_name, order_num, path, component,  is_frame, is_cache, menu_type, visible, status, perms, icon,  show_parent, parent_id, create_by, create_time, update_by, update_time )  VALUES  ( ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: value too long for type character(1)
; ERROR: value too long for type character(1); nested exception is org.postgresql.util.PSQLException: ERROR: value too long for type character(1)', '2023-06-26 16:10:16.511');
INSERT INTO "public"."sys_oper_log" VALUES (1673242622934347778, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:11:43","updateBy":"admin","updateTime":"2023-06-26 16:11:43","parentName":null,"parentId":1,"children":[],"menuId":"1673242622934347777","menuName":"测试管理","orderNum":9,"path":"/system/test","component":"/system/test/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:test:list","icon":"listCheck","remark":null,"showParent":true}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: value too long for type character(2)
### The error may exist in com/htht/system/mapper/SysMenuMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysMenuMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO sys_menu  ( menu_id, menu_name, order_num, path, component,  is_frame, is_cache, menu_type, visible, status, perms, icon,  show_parent, parent_id, create_by, create_time, update_by, update_time )  VALUES  ( ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: value too long for type character(2)
; ERROR: value too long for type character(2); nested exception is org.postgresql.util.PSQLException: ERROR: value too long for type character(2)', '2023-06-26 16:11:43.322');
INSERT INTO "public"."sys_oper_log" VALUES (1673243123021213697, '菜单管理', 1, 'com.htht.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:13:42","updateBy":"admin","updateTime":"2023-06-26 16:13:42","parentName":null,"parentId":1,"children":[],"menuId":"1673243122991853570","menuName":"测试管理","orderNum":9,"path":"/system/test","component":"/system/test/index","queryParam":null,"isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:test:list","icon":"listCheck","remark":null,"showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-06-26 16:13:42.538');
INSERT INTO "public"."sys_oper_log" VALUES (1673244526875734018, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:19:17","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:19:17.245');
INSERT INTO "public"."sys_oper_log" VALUES (1673244794707210241, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:20:21","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:20:21.099');
INSERT INTO "public"."sys_oper_log" VALUES (1673244853129670658, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:20:35","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:20:35.038');
INSERT INTO "public"."sys_oper_log" VALUES (1673244760557187074, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:20:12","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:20:12.97');
INSERT INTO "public"."sys_oper_log" VALUES (1673244928845246465, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:20:53","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:20:53.08');
INSERT INTO "public"."sys_oper_log" VALUES (1673245465519026177, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:23:01","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', NULL, 1, '
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
### The error may exist in com/htht/system/mapper/SysRoleMapper.java (best guess)
### The error may involve com.htht.system.mapper.SysRoleMapper.updateById-Inline
### The error occurred while setting parameters
### SQL: UPDATE sys_role SET role_name = ?, role_key = ?, role_sort = ?, data_scope = ?, menu_check_strictly = ?, dept_check_strictly = ?, status = ?, remark = ?, create_by = ?, create_time = ?, update_by = ?, update_time = ? WHERE role_id = ? AND del_flag = ''0''
### Cause: org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107
; bad SQL grammar []; nested exception is org.postgresql.util.PSQLException: ERROR: column "menu_check_strictly" is of type smallint but expression is of type boolean
  建议：You will need to rewrite or cast the expression.
  位置：107', '2023-06-26 16:23:01.035');
INSERT INTO "public"."sys_oper_log" VALUES (1673245920831696897, '角色管理', 2, 'com.htht.web.controller.system.SysRoleController.dataScope()', 'PUT', 1, 'admin', NULL, '/system/role/dataScope', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-06-26 16:24:49","roleId":2,"roleName":"普通角色","roleKey":"common","roleSort":2,"dataScope":"2","menuCheckStrictly":true,"deptCheckStrictly":true,"status":"0","delFlag":"0","remark":"普通角色","flag":false,"menuIds":null,"deptIds":[100,101,103,105],"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-06-26 16:24:49.601');
INSERT INTO "public"."sys_oper_log" VALUES (1673246436529762305, '用户管理', 1, 'com.htht.web.controller.system.SysUserController.add()', 'POST', 1, 'admin', NULL, '/system/user', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-06-26 16:26:52","updateBy":"admin","updateTime":"2023-06-26 16:26:52","userId":"1673246436466847745","deptId":103,"userName":"liaozhenshan","nickName":"廖震山","userType":null,"email":"378272027@qq.com","phonenumber":"15220801780","sex":"0","avatar":null,"status":"0","delFlag":null,"loginIp":null,"loginDate":null,"remark":null,"dept":null,"roles":null,"roleIds":[2],"postIds":[4],"roleId":null,"admin":false}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-06-26 16:26:52.553');
INSERT INTO "public"."sys_oper_log" VALUES (1673247713959571457, '菜单管理', 3, 'com.htht.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/1673243122991853570', '192.168.8.252', '内网IP', '{}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-06-26 16:31:57.113');
INSERT INTO "public"."sys_oper_log" VALUES (1678288085546000386, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-07-10 14:20:35","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":false}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-07-10 14:20:35.328');
INSERT INTO "public"."sys_oper_log" VALUES (1678288617555714050, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-07-10 14:22:42","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-07-10 14:22:42.179');
INSERT INTO "public"."sys_oper_log" VALUES (1678289751628406786, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-07-10 14:27:12","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"1","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-07-10 14:27:12.561');
INSERT INTO "public"."sys_oper_log" VALUES (1678289795538575362, '菜单管理', 2, 'com.htht.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.8.252', '内网IP', '{"createBy":"admin","createTime":"2023-03-15 14:06:16","updateBy":"admin","updateTime":"2023-07-10 14:27:23","parentName":null,"parentId":1,"children":[],"menuId":100,"menuName":"用户管理","orderNum":1,"path":"/system/user","component":"/system/user/index","queryParam":"","isFrame":"1","isCache":"1","menuType":"C","visible":"0","status":"0","perms":"system:user:list","icon":"","remark":"用户管理菜单","showParent":true}', '{"code":200,"msg":"操作成功","data":null}', 0, NULL, '2023-07-10 14:27:23.036');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_oss";
CREATE TABLE "public"."sys_oss" (
  "oss_id" int8 NOT NULL,
  "file_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "original_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "file_suffix" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "url" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "service" varchar(20) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_oss"."oss_id" IS '对象存储主键';
COMMENT ON COLUMN "public"."sys_oss"."file_name" IS '文件名';
COMMENT ON COLUMN "public"."sys_oss"."original_name" IS '原名';
COMMENT ON COLUMN "public"."sys_oss"."file_suffix" IS '文件后缀名';
COMMENT ON COLUMN "public"."sys_oss"."url" IS 'URL地址';
COMMENT ON COLUMN "public"."sys_oss"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_oss"."create_by" IS '上传人';
COMMENT ON COLUMN "public"."sys_oss"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_oss"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."sys_oss"."service" IS '服务商';
COMMENT ON TABLE "public"."sys_oss" IS 'OSS对象存储表';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oss_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_oss_config";
CREATE TABLE "public"."sys_oss_config" (
  "oss_config_id" int8 NOT NULL,
  "config_key" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "access_key" varchar(255) COLLATE "pg_catalog"."default",
  "secret_key" varchar(255) COLLATE "pg_catalog"."default",
  "bucket_name" varchar(255) COLLATE "pg_catalog"."default",
  "prefix" varchar(255) COLLATE "pg_catalog"."default",
  "endpoint" varchar(255) COLLATE "pg_catalog"."default",
  "domain" varchar(255) COLLATE "pg_catalog"."default",
  "is_https" char(1) COLLATE "pg_catalog"."default",
  "region" varchar(255) COLLATE "pg_catalog"."default",
  "access_policy" char(1) COLLATE "pg_catalog"."default" NOT NULL,
  "status" char(1) COLLATE "pg_catalog"."default",
  "ext1" varchar(255) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_oss_config"."oss_config_id" IS '主建';
COMMENT ON COLUMN "public"."sys_oss_config"."config_key" IS '配置key';
COMMENT ON COLUMN "public"."sys_oss_config"."access_key" IS 'accessKey';
COMMENT ON COLUMN "public"."sys_oss_config"."secret_key" IS '秘钥';
COMMENT ON COLUMN "public"."sys_oss_config"."bucket_name" IS '桶名称';
COMMENT ON COLUMN "public"."sys_oss_config"."prefix" IS '前缀';
COMMENT ON COLUMN "public"."sys_oss_config"."endpoint" IS '访问站点';
COMMENT ON COLUMN "public"."sys_oss_config"."domain" IS '自定义域名';
COMMENT ON COLUMN "public"."sys_oss_config"."is_https" IS '是否https（Y=是,N=否）';
COMMENT ON COLUMN "public"."sys_oss_config"."region" IS '域';
COMMENT ON COLUMN "public"."sys_oss_config"."access_policy" IS '桶权限类型(0=private 1=public 2=custom)';
COMMENT ON COLUMN "public"."sys_oss_config"."status" IS '状态（0=正常,1=停用）';
COMMENT ON COLUMN "public"."sys_oss_config"."ext1" IS '扩展字段';
COMMENT ON COLUMN "public"."sys_oss_config"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_oss_config"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_oss_config"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_oss_config"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_oss_config"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_oss_config" IS '对象存储配置表';

-- ----------------------------
-- Records of sys_oss_config
-- ----------------------------
INSERT INTO "public"."sys_oss_config" VALUES (1, 'minio', 'ruoyi', 'ruoyi123', 'ruoyi', '', '127.0.0.1:9000', '', 'N', '', '1', '0', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', NULL);
INSERT INTO "public"."sys_oss_config" VALUES (2, 'qiniu', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi', '', 's3-cn-north-1.qiniucs.com', '', 'N', '', '1', '1', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', NULL);
INSERT INTO "public"."sys_oss_config" VALUES (3, 'aliyun', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi', '', 'oss-cn-beijing.aliyuncs.com', '', 'N', '', '1', '1', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', NULL);
INSERT INTO "public"."sys_oss_config" VALUES (4, 'qcloud', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi-1250000000', '', 'cos.ap-beijing.myqcloud.com', '', 'N', 'ap-beijing', '1', '1', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', NULL);
INSERT INTO "public"."sys_oss_config" VALUES (5, 'image', 'ruoyi', 'ruoyi123', 'ruoyi', 'image', '127.0.0.1:9000', '', 'N', '', '1', '1', '', 'admin', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', NULL);

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_post";
CREATE TABLE "public"."sys_post" (
  "post_id" int8 NOT NULL,
  "post_code" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "post_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "post_sort" int4 NOT NULL,
  "status" char(1) COLLATE "pg_catalog"."default" NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_post"."post_id" IS '岗位ID';
COMMENT ON COLUMN "public"."sys_post"."post_code" IS '岗位编码';
COMMENT ON COLUMN "public"."sys_post"."post_name" IS '岗位名称';
COMMENT ON COLUMN "public"."sys_post"."post_sort" IS '显示顺序';
COMMENT ON COLUMN "public"."sys_post"."status" IS '状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_post"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_post"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_post"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_post"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_post"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_post" IS '岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO "public"."sys_post" VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2023-03-15 14:06:16', '', NULL, '');
INSERT INTO "public"."sys_post" VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2023-03-15 14:06:16', '', NULL, '');
INSERT INTO "public"."sys_post" VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2023-03-15 14:06:16', '', NULL, '');
INSERT INTO "public"."sys_post" VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2023-03-15 14:06:16', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
  "role_id" int8 NOT NULL,
  "role_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "role_key" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "role_sort" int4 NOT NULL,
  "data_scope" char(1) COLLATE "pg_catalog"."default",
  "menu_check_strictly" char(8) COLLATE "pg_catalog"."default",
  "dept_check_strictly" char(8) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default" NOT NULL,
  "del_flag" char(1) COLLATE "pg_catalog"."default",
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_role"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."sys_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."role_key" IS '角色权限字符串';
COMMENT ON COLUMN "public"."sys_role"."role_sort" IS '显示顺序';
COMMENT ON COLUMN "public"."sys_role"."data_scope" IS '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）';
COMMENT ON COLUMN "public"."sys_role"."menu_check_strictly" IS '菜单树选择项是否关联显示';
COMMENT ON COLUMN "public"."sys_role"."dept_check_strictly" IS '部门树选择项是否关联显示';
COMMENT ON COLUMN "public"."sys_role"."status" IS '角色状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_role"."del_flag" IS '删除标志（0代表存在 2代表删除）';
COMMENT ON COLUMN "public"."sys_role"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_role"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_role" IS '角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES (1, '超级管理员', 'admin', 1, '1', '1       ', '1       ', '0', '0', 'admin', '2023-03-15 14:06:16', '', NULL, '超级管理员');
INSERT INTO "public"."sys_role" VALUES (3, '本部门及以下', 'test1', 3, '2', '1       ', '1       ', '0', '0', 'admin', '2023-03-15 14:06:33', 'admin', '2023-03-27 14:17:45', NULL);
INSERT INTO "public"."sys_role" VALUES (4, '仅本人', 'test2', 4, '5', '1       ', '1       ', '0', '0', 'admin', '2023-03-15 14:06:33', 'admin', '2023-03-24 16:57:53', NULL);
INSERT INTO "public"."sys_role" VALUES (2, '普通角色', 'common', 2, '2', 'true    ', 'true    ', '0', '0', 'admin', '2023-03-15 14:06:16', 'admin', '2023-06-26 16:24:49.558', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_dept";
CREATE TABLE "public"."sys_role_dept" (
  "role_id" int8 NOT NULL,
  "dept_id" int8 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_role_dept"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."sys_role_dept"."dept_id" IS '部门ID';
COMMENT ON TABLE "public"."sys_role_dept" IS '角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO "public"."sys_role_dept" VALUES (3, 100);
INSERT INTO "public"."sys_role_dept" VALUES (3, 101);
INSERT INTO "public"."sys_role_dept" VALUES (3, 103);
INSERT INTO "public"."sys_role_dept" VALUES (3, 104);
INSERT INTO "public"."sys_role_dept" VALUES (3, 105);
INSERT INTO "public"."sys_role_dept" VALUES (3, 106);
INSERT INTO "public"."sys_role_dept" VALUES (2, 100);
INSERT INTO "public"."sys_role_dept" VALUES (2, 101);
INSERT INTO "public"."sys_role_dept" VALUES (2, 103);
INSERT INTO "public"."sys_role_dept" VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_menu";
CREATE TABLE "public"."sys_role_menu" (
  "role_id" int8 NOT NULL,
  "menu_id" int8 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_role_menu"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."sys_role_menu"."menu_id" IS '菜单ID';
COMMENT ON TABLE "public"."sys_role_menu" IS '角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO "public"."sys_role_menu" VALUES (2, 1);
INSERT INTO "public"."sys_role_menu" VALUES (2, 100);
INSERT INTO "public"."sys_role_menu" VALUES (2, 101);
INSERT INTO "public"."sys_role_menu" VALUES (2, 102);
INSERT INTO "public"."sys_role_menu" VALUES (2, 103);
INSERT INTO "public"."sys_role_menu" VALUES (2, 104);
INSERT INTO "public"."sys_role_menu" VALUES (2, 105);
INSERT INTO "public"."sys_role_menu" VALUES (2, 106);
INSERT INTO "public"."sys_role_menu" VALUES (2, 107);
INSERT INTO "public"."sys_role_menu" VALUES (2, 108);
INSERT INTO "public"."sys_role_menu" VALUES (2, 118);
INSERT INTO "public"."sys_role_menu" VALUES (2, 500);
INSERT INTO "public"."sys_role_menu" VALUES (2, 501);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1001);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1002);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1003);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1004);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1005);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1006);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1007);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1008);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1009);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1010);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1011);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1012);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1013);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1014);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1015);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1016);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1017);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1018);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1019);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1020);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1021);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1022);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1023);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1024);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1025);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1026);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1027);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1028);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1029);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1030);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1031);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1032);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1033);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1034);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1035);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1036);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1037);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1038);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1039);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1040);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1041);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1042);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1043);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1044);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1045);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1050);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1600);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1601);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1602);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1603);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1604);
INSERT INTO "public"."sys_role_menu" VALUES (2, 1605);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1);
INSERT INTO "public"."sys_role_menu" VALUES (3, 100);
INSERT INTO "public"."sys_role_menu" VALUES (3, 101);
INSERT INTO "public"."sys_role_menu" VALUES (3, 102);
INSERT INTO "public"."sys_role_menu" VALUES (3, 103);
INSERT INTO "public"."sys_role_menu" VALUES (3, 104);
INSERT INTO "public"."sys_role_menu" VALUES (3, 105);
INSERT INTO "public"."sys_role_menu" VALUES (3, 106);
INSERT INTO "public"."sys_role_menu" VALUES (3, 107);
INSERT INTO "public"."sys_role_menu" VALUES (3, 108);
INSERT INTO "public"."sys_role_menu" VALUES (3, 500);
INSERT INTO "public"."sys_role_menu" VALUES (3, 501);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1001);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1002);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1003);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1004);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1005);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1006);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1007);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1008);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1009);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1010);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1011);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1012);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1013);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1014);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1015);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1016);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1017);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1018);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1019);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1020);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1021);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1022);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1023);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1024);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1025);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1026);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1027);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1028);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1029);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1030);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1031);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1032);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1033);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1034);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1035);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1036);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1037);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1038);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1039);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1040);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1041);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1042);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1043);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1044);
INSERT INTO "public"."sys_role_menu" VALUES (3, 1045);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1);
INSERT INTO "public"."sys_role_menu" VALUES (4, 100);
INSERT INTO "public"."sys_role_menu" VALUES (4, 101);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1001);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1002);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1003);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1004);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1005);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1006);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1007);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1008);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1009);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1010);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1011);
INSERT INTO "public"."sys_role_menu" VALUES (4, 1012);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
  "user_id" int8 NOT NULL,
  "dept_id" int8,
  "user_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "nick_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "user_type" varchar(10) COLLATE "pg_catalog"."default",
  "email" varchar(50) COLLATE "pg_catalog"."default",
  "phonenumber" varchar(11) COLLATE "pg_catalog"."default",
  "sex" char(1) COLLATE "pg_catalog"."default",
  "avatar" varchar(100) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "status" char(1) COLLATE "pg_catalog"."default",
  "del_flag" char(1) COLLATE "pg_catalog"."default" DEFAULT 0,
  "login_ip" varchar(128) COLLATE "pg_catalog"."default",
  "login_date" timestamp(6),
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "remark" varchar(500) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user"."dept_id" IS '部门ID';
COMMENT ON COLUMN "public"."sys_user"."user_name" IS '用户账号';
COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '用户昵称';
COMMENT ON COLUMN "public"."sys_user"."user_type" IS '用户类型（sys_user系统用户）';
COMMENT ON COLUMN "public"."sys_user"."email" IS '用户邮箱';
COMMENT ON COLUMN "public"."sys_user"."phonenumber" IS '手机号码';
COMMENT ON COLUMN "public"."sys_user"."sex" IS '用户性别（0男 1女 2未知）';
COMMENT ON COLUMN "public"."sys_user"."avatar" IS '头像地址';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."status" IS '帐号状态（0正常 1停用）';
COMMENT ON COLUMN "public"."sys_user"."del_flag" IS '删除标志（0代表存在 2代表删除）';
COMMENT ON COLUMN "public"."sys_user"."login_ip" IS '最后登录IP';
COMMENT ON COLUMN "public"."sys_user"."login_date" IS '最后登录时间';
COMMENT ON COLUMN "public"."sys_user"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user"."remark" IS '备注';
COMMENT ON TABLE "public"."sys_user" IS '用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES (2, 105, 'lionli', '疯狂的狮子Li', 'sys_user', 'crazyLionLi@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2023-03-15 14:06:16', 'admin', '2023-03-15 14:06:16', 'admin', '2023-04-07 14:28:39', '测试员');
INSERT INTO "public"."sys_user" VALUES (3, 108, 'test', '本部门及以下 密码666666', 'sys_user', '', '', '0', '', '$2a$10$zPvZVqV5xVMVWhI.rUN7mOKplux5DQTofsn3EoXTFCKh05HkEjELy', '0', '0', '192.168.8.252', '2023-04-19 10:17:30', 'admin', '2023-03-15 14:06:33', 'test', '2023-04-19 10:17:30', NULL);
INSERT INTO "public"."sys_user" VALUES (4, 102, 'test1', '仅本人 密码666666', 'sys_user', '', '', '0', '', '$2a$10$62Ty/HCnsIr0MxjYM8sDO.JyhQulNZCFb4fqMQO2V2TVzJKd/E1ru', '0', '2', '127.0.0.1', '2023-03-20 09:11:30', 'admin', '2023-03-15 14:06:33', 'admin', '2023-03-30 16:44:58', NULL);
INSERT INTO "public"."sys_user" VALUES (1, 103, 'admin', '疯狂的狮子Li', 'sys_user', 'crazyLionLi@163.com', '15888888888', '0', '', '$2a$10$0gC6a5sEzc4KmtxOomI8ouvUv7sCn2ofgre4eXOaofvL5oWVGA8Re', '0', '0', '192.168.8.252', '2023-07-10 14:05:10.491', 'admin', '2023-03-15 14:06:16', 'admin', '2023-07-10 14:05:10.498', '管理员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_post";
CREATE TABLE "public"."sys_user_post" (
  "user_id" int8 NOT NULL,
  "post_id" int8 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_user_post"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user_post"."post_id" IS '岗位ID';
COMMENT ON TABLE "public"."sys_user_post" IS '用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO "public"."sys_user_post" VALUES (1, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
  "user_id" int8 NOT NULL,
  "role_id" int8 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_user_role"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user_role"."role_id" IS '角色ID';
COMMENT ON TABLE "public"."sys_user_role" IS '用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO "public"."sys_user_role" VALUES (1, 1);
INSERT INTO "public"."sys_user_role" VALUES (2, 2);
INSERT INTO "public"."sys_user_role" VALUES (3, 2);
INSERT INTO "public"."sys_user_role" VALUES (3, 3);

-- ----------------------------
-- Table structure for test_demo
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_demo";
CREATE TABLE "public"."test_demo" (
  "id" int8 NOT NULL,
  "dept_id" int8,
  "user_id" int8,
  "order_num" int4,
  "test_key" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "del_flag" int4
)
;
COMMENT ON COLUMN "public"."test_demo"."id" IS '主键';
COMMENT ON COLUMN "public"."test_demo"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."test_demo"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."test_demo"."order_num" IS '排序号';
COMMENT ON COLUMN "public"."test_demo"."test_key" IS 'key键';
COMMENT ON COLUMN "public"."test_demo"."value" IS '值';
COMMENT ON COLUMN "public"."test_demo"."version" IS '版本';
COMMENT ON COLUMN "public"."test_demo"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."test_demo"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."test_demo"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."test_demo"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."test_demo"."del_flag" IS '删除标志';
COMMENT ON TABLE "public"."test_demo" IS '测试单表';

-- ----------------------------
-- Records of test_demo
-- ----------------------------
INSERT INTO "public"."test_demo" VALUES (1, 102, 4, 1, '测试数据权限', '测试', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (2, 102, 3, 2, '子节点1', '111', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (3, 102, 3, 3, '子节点2', '222', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (4, 108, 4, 4, '测试数据', 'demo', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (5, 108, 3, 13, '子节点11', '1111', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (6, 108, 3, 12, '子节点22', '2222', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (7, 108, 3, 11, '子节点33', '3333', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (8, 108, 3, 10, '子节点44', '4444', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (9, 108, 3, 9, '子节点55', '5555', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (10, 108, 3, 8, '子节点66', '6666', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (11, 108, 3, 7, '子节点77', '7777', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (12, 108, 3, 6, '子节点88', '8888', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_demo" VALUES (13, 108, 3, 5, '子节点99', '9999', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);

-- ----------------------------
-- Table structure for test_tree
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_tree";
CREATE TABLE "public"."test_tree" (
  "id" int8 NOT NULL,
  "parent_id" int8,
  "dept_id" int8,
  "user_id" int8,
  "tree_name" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_by" varchar(64) COLLATE "pg_catalog"."default",
  "del_flag" int4
)
;
COMMENT ON COLUMN "public"."test_tree"."id" IS '主键';
COMMENT ON COLUMN "public"."test_tree"."parent_id" IS '父id';
COMMENT ON COLUMN "public"."test_tree"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."test_tree"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."test_tree"."tree_name" IS '值';
COMMENT ON COLUMN "public"."test_tree"."version" IS '版本';
COMMENT ON COLUMN "public"."test_tree"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."test_tree"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."test_tree"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."test_tree"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."test_tree"."del_flag" IS '删除标志';
COMMENT ON TABLE "public"."test_tree" IS '测试树表';

-- ----------------------------
-- Records of test_tree
-- ----------------------------
INSERT INTO "public"."test_tree" VALUES (1, 0, 102, 4, '测试数据权限', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (2, 1, 102, 3, '子节点1', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (3, 2, 102, 3, '子节点2', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (4, 0, 108, 4, '测试树1', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (5, 4, 108, 3, '子节点11', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (6, 4, 108, 3, '子节点22', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (7, 4, 108, 3, '子节点33', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (8, 5, 108, 3, '子节点44', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (9, 6, 108, 3, '子节点55', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (10, 7, 108, 3, '子节点66', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (11, 7, 108, 3, '子节点77', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (12, 10, 108, 3, '子节点88', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);
INSERT INTO "public"."test_tree" VALUES (13, 10, 108, 3, '子节点99', 0, '2023-03-15 14:06:33', 'admin', NULL, NULL, 0);

-- ----------------------------
-- Table structure for xxl_job_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_group";
CREATE TABLE "public"."xxl_job_group" (
  "id" int4 NOT NULL,
  "app_name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "title" varchar(12) COLLATE "pg_catalog"."default" NOT NULL,
  "address_type" int2 NOT NULL,
  "address_list" text COLLATE "pg_catalog"."default",
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."xxl_job_group"."app_name" IS '执行器AppName';
COMMENT ON COLUMN "public"."xxl_job_group"."title" IS '执行器名称';
COMMENT ON COLUMN "public"."xxl_job_group"."address_type" IS '执行器地址类型：0=自动注册、1=手动录入';
COMMENT ON COLUMN "public"."xxl_job_group"."address_list" IS '执行器地址列表，多地址逗号分隔';

-- ----------------------------
-- Records of xxl_job_group
-- ----------------------------
INSERT INTO "public"."xxl_job_group" VALUES (1, 'xxl-job-executor', '示例执行器', 0, NULL, '2023-05-10 13:55:51');

-- ----------------------------
-- Table structure for xxl_job_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_info";
CREATE TABLE "public"."xxl_job_info" (
  "id" int4 NOT NULL,
  "job_group" int4 NOT NULL,
  "job_desc" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "add_time" timestamp(6),
  "update_time" timestamp(6),
  "author" varchar(64) COLLATE "pg_catalog"."default",
  "alarm_email" varchar(255) COLLATE "pg_catalog"."default",
  "schedule_type" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "schedule_conf" varchar(128) COLLATE "pg_catalog"."default",
  "misfire_strategy" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "executor_route_strategy" varchar(50) COLLATE "pg_catalog"."default",
  "executor_handler" varchar(255) COLLATE "pg_catalog"."default",
  "executor_param" varchar(512) COLLATE "pg_catalog"."default",
  "executor_block_strategy" varchar(50) COLLATE "pg_catalog"."default",
  "executor_timeout" int4 NOT NULL,
  "executor_fail_retry_count" int4 NOT NULL,
  "glue_type" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "glue_source" text COLLATE "pg_catalog"."default",
  "glue_remark" varchar(128) COLLATE "pg_catalog"."default",
  "glue_updatetime" timestamp(6),
  "child_jobid" varchar(255) COLLATE "pg_catalog"."default",
  "trigger_status" int2 NOT NULL,
  "trigger_last_time" int8 NOT NULL,
  "trigger_next_time" int8 NOT NULL
)
;
COMMENT ON COLUMN "public"."xxl_job_info"."job_group" IS '执行器主键ID';
COMMENT ON COLUMN "public"."xxl_job_info"."author" IS '作者';
COMMENT ON COLUMN "public"."xxl_job_info"."alarm_email" IS '报警邮件';
COMMENT ON COLUMN "public"."xxl_job_info"."schedule_type" IS '调度类型';
COMMENT ON COLUMN "public"."xxl_job_info"."schedule_conf" IS '调度配置，值含义取决于调度类型';
COMMENT ON COLUMN "public"."xxl_job_info"."misfire_strategy" IS '调度过期策略';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_route_strategy" IS '执行器路由策略';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_handler" IS '执行器任务handler';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_param" IS '执行器任务参数';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_block_strategy" IS '阻塞处理策略';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_timeout" IS '任务执行超时时间，单位秒';
COMMENT ON COLUMN "public"."xxl_job_info"."executor_fail_retry_count" IS '失败重试次数';
COMMENT ON COLUMN "public"."xxl_job_info"."glue_type" IS 'GLUE类型';
COMMENT ON COLUMN "public"."xxl_job_info"."glue_source" IS 'GLUE源代码';
COMMENT ON COLUMN "public"."xxl_job_info"."glue_remark" IS 'GLUE备注';
COMMENT ON COLUMN "public"."xxl_job_info"."glue_updatetime" IS 'GLUE更新时间';
COMMENT ON COLUMN "public"."xxl_job_info"."child_jobid" IS '子任务ID，多个逗号分隔';
COMMENT ON COLUMN "public"."xxl_job_info"."trigger_status" IS '调度状态：0-停止，1-运行';
COMMENT ON COLUMN "public"."xxl_job_info"."trigger_last_time" IS '上次调度时间';
COMMENT ON COLUMN "public"."xxl_job_info"."trigger_next_time" IS '下次调度时间';

-- ----------------------------
-- Records of xxl_job_info
-- ----------------------------
INSERT INTO "public"."xxl_job_info" VALUES (1, 1, '测试任务1', '2018-11-03 22:21:31', '2018-11-03 22:21:31', 'XXL', '', 'CRON', '0 0 0 * * ? *', 'DO_NOTHING', 'FIRST', 'demoJobHandler', '', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2018-11-03 22:21:31', '', 0, 0, 0);

-- ----------------------------
-- Table structure for xxl_job_lock
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_lock";
CREATE TABLE "public"."xxl_job_lock" (
  "lock_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."xxl_job_lock"."lock_name" IS '锁名称';

-- ----------------------------
-- Records of xxl_job_lock
-- ----------------------------
INSERT INTO "public"."xxl_job_lock" VALUES ('schedule_lock');

-- ----------------------------
-- Table structure for xxl_job_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_log";
CREATE TABLE "public"."xxl_job_log" (
  "id" int8 NOT NULL,
  "job_group" int4 NOT NULL,
  "job_id" int4 NOT NULL,
  "executor_address" varchar(255) COLLATE "pg_catalog"."default",
  "executor_handler" varchar(255) COLLATE "pg_catalog"."default",
  "executor_param" varchar(512) COLLATE "pg_catalog"."default",
  "executor_sharding_param" varchar(20) COLLATE "pg_catalog"."default",
  "executor_fail_retry_count" int4 NOT NULL,
  "trigger_time" timestamp(6),
  "trigger_code" int4 NOT NULL,
  "trigger_msg" text COLLATE "pg_catalog"."default",
  "handle_time" timestamp(6),
  "handle_code" int4 NOT NULL,
  "handle_msg" text COLLATE "pg_catalog"."default",
  "alarm_status" int2 NOT NULL
)
;
COMMENT ON COLUMN "public"."xxl_job_log"."job_group" IS '执行器主键ID';
COMMENT ON COLUMN "public"."xxl_job_log"."job_id" IS '任务，主键ID';
COMMENT ON COLUMN "public"."xxl_job_log"."executor_address" IS '执行器地址，本次执行的地址';
COMMENT ON COLUMN "public"."xxl_job_log"."executor_handler" IS '执行器任务handler';
COMMENT ON COLUMN "public"."xxl_job_log"."executor_param" IS '执行器任务参数';
COMMENT ON COLUMN "public"."xxl_job_log"."executor_sharding_param" IS '执行器任务分片参数，格式如 1/2';
COMMENT ON COLUMN "public"."xxl_job_log"."executor_fail_retry_count" IS '失败重试次数';
COMMENT ON COLUMN "public"."xxl_job_log"."trigger_time" IS '调度-时间';
COMMENT ON COLUMN "public"."xxl_job_log"."trigger_code" IS '调度-结果';
COMMENT ON COLUMN "public"."xxl_job_log"."trigger_msg" IS '调度-日志';
COMMENT ON COLUMN "public"."xxl_job_log"."handle_time" IS '执行-时间';
COMMENT ON COLUMN "public"."xxl_job_log"."handle_code" IS '执行-状态';
COMMENT ON COLUMN "public"."xxl_job_log"."handle_msg" IS '执行-日志';
COMMENT ON COLUMN "public"."xxl_job_log"."alarm_status" IS '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败';

-- ----------------------------
-- Records of xxl_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_log_report
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_log_report";
CREATE TABLE "public"."xxl_job_log_report" (
  "id" int4 NOT NULL,
  "trigger_day" timestamp(6),
  "running_count" int4 NOT NULL,
  "suc_count" int4 NOT NULL,
  "fail_count" int4 NOT NULL,
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."xxl_job_log_report"."trigger_day" IS '调度-时间';
COMMENT ON COLUMN "public"."xxl_job_log_report"."running_count" IS '运行中-日志数量';
COMMENT ON COLUMN "public"."xxl_job_log_report"."suc_count" IS '执行成功-日志数量';
COMMENT ON COLUMN "public"."xxl_job_log_report"."fail_count" IS '执行失败-日志数量';

-- ----------------------------
-- Records of xxl_job_log_report
-- ----------------------------
INSERT INTO "public"."xxl_job_log_report" VALUES (1, '2023-05-10 00:00:00', 0, 0, 0, NULL);
INSERT INTO "public"."xxl_job_log_report" VALUES (2, '2023-05-09 00:00:00', 0, 0, 0, NULL);
INSERT INTO "public"."xxl_job_log_report" VALUES (3, '2023-05-08 00:00:00', 0, 0, 0, NULL);

-- ----------------------------
-- Table structure for xxl_job_logglue
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_logglue";
CREATE TABLE "public"."xxl_job_logglue" (
  "id" int4 NOT NULL,
  "job_id" int4 NOT NULL,
  "glue_type" varchar(50) COLLATE "pg_catalog"."default",
  "glue_source" text COLLATE "pg_catalog"."default",
  "glue_remark" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "add_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."xxl_job_logglue"."job_id" IS '任务，主键ID';
COMMENT ON COLUMN "public"."xxl_job_logglue"."glue_type" IS 'GLUE类型';
COMMENT ON COLUMN "public"."xxl_job_logglue"."glue_source" IS 'GLUE源代码';
COMMENT ON COLUMN "public"."xxl_job_logglue"."glue_remark" IS 'GLUE备注';

-- ----------------------------
-- Records of xxl_job_logglue
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_registry
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_registry";
CREATE TABLE "public"."xxl_job_registry" (
  "id" int4 NOT NULL,
  "registry_group" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "registry_key" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "registry_value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "update_time" timestamp(6)
)
;

-- ----------------------------
-- Records of xxl_job_registry
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_user";
CREATE TABLE "public"."xxl_job_user" (
  "id" int4 NOT NULL,
  "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "role" int2 NOT NULL,
  "permission" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."xxl_job_user"."username" IS '账号';
COMMENT ON COLUMN "public"."xxl_job_user"."password" IS '密码';
COMMENT ON COLUMN "public"."xxl_job_user"."role" IS '角色：0-普通用户、1-管理员';
COMMENT ON COLUMN "public"."xxl_job_user"."permission" IS '权限：执行器ID列表，多个逗号分割';

-- ----------------------------
-- Records of xxl_job_user
-- ----------------------------
INSERT INTO "public"."xxl_job_user" VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL);

-- ----------------------------
-- Primary Key structure for table gen_table
-- ----------------------------
ALTER TABLE "public"."gen_table" ADD CONSTRAINT "gen_table_pkey" PRIMARY KEY ("table_id");

-- ----------------------------
-- Primary Key structure for table gen_table_column
-- ----------------------------
ALTER TABLE "public"."gen_table_column" ADD CONSTRAINT "gen_table_column_pkey" PRIMARY KEY ("column_id");

-- ----------------------------
-- Primary Key structure for table sys_config
-- ----------------------------
ALTER TABLE "public"."sys_config" ADD CONSTRAINT "sys_config_pkey" PRIMARY KEY ("config_id");

-- ----------------------------
-- Primary Key structure for table sys_dept
-- ----------------------------
ALTER TABLE "public"."sys_dept" ADD CONSTRAINT "sys_dept_pkey" PRIMARY KEY ("dept_id");

-- ----------------------------
-- Primary Key structure for table sys_dict_data
-- ----------------------------
ALTER TABLE "public"."sys_dict_data" ADD CONSTRAINT "sys_dict_data_pkey" PRIMARY KEY ("dict_code");

-- ----------------------------
-- Indexes structure for table sys_dict_type
-- ----------------------------
CREATE INDEX "dict_type" ON "public"."sys_dict_type" USING btree (
  "dict_type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table sys_dict_type
-- ----------------------------
ALTER TABLE "public"."sys_dict_type" ADD CONSTRAINT "sys_dict_type_pkey" PRIMARY KEY ("dict_id");

-- ----------------------------
-- Primary Key structure for table sys_file
-- ----------------------------
ALTER TABLE "public"."sys_file" ADD CONSTRAINT "sys_file_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table sys_logininfor
-- ----------------------------
CREATE INDEX "idx_sys_logininfor_lt" ON "public"."sys_logininfor" USING btree (
  "login_time" "pg_catalog"."timestamp_ops" ASC NULLS LAST
);
CREATE INDEX "idx_sys_logininfor_s" ON "public"."sys_logininfor" USING btree (
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table sys_logininfor
-- ----------------------------
ALTER TABLE "public"."sys_logininfor" ADD CONSTRAINT "sys_logininfor_pkey" PRIMARY KEY ("info_id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("menu_id");

-- ----------------------------
-- Primary Key structure for table sys_notice
-- ----------------------------
ALTER TABLE "public"."sys_notice" ADD CONSTRAINT "sys_notice_pkey" PRIMARY KEY ("notice_id");

-- ----------------------------
-- Indexes structure for table sys_oper_log
-- ----------------------------
CREATE INDEX "idx_sys_oper_log_bt" ON "public"."sys_oper_log" USING btree (
  "business_type" "pg_catalog"."int4_ops" ASC NULLS LAST
);
CREATE INDEX "idx_sys_oper_log_ot" ON "public"."sys_oper_log" USING btree (
  "oper_time" "pg_catalog"."timestamp_ops" ASC NULLS LAST
);
CREATE INDEX "idx_sys_oper_log_s" ON "public"."sys_oper_log" USING btree (
  "status" "pg_catalog"."int4_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table sys_oper_log
-- ----------------------------
ALTER TABLE "public"."sys_oper_log" ADD CONSTRAINT "sys_oper_log_pkey" PRIMARY KEY ("oper_id");

-- ----------------------------
-- Primary Key structure for table sys_oss
-- ----------------------------
ALTER TABLE "public"."sys_oss" ADD CONSTRAINT "sys_oss_pkey" PRIMARY KEY ("oss_id");

-- ----------------------------
-- Primary Key structure for table sys_oss_config
-- ----------------------------
ALTER TABLE "public"."sys_oss_config" ADD CONSTRAINT "sys_oss_config_pkey" PRIMARY KEY ("oss_config_id");

-- ----------------------------
-- Primary Key structure for table sys_post
-- ----------------------------
ALTER TABLE "public"."sys_post" ADD CONSTRAINT "sys_post_pkey" PRIMARY KEY ("post_id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table sys_role_dept
-- ----------------------------
ALTER TABLE "public"."sys_role_dept" ADD CONSTRAINT "sys_role_dept_pkey" PRIMARY KEY ("role_id", "dept_id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "public"."sys_role_menu" ADD CONSTRAINT "sys_role_menu_pkey" PRIMARY KEY ("role_id", "menu_id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Primary Key structure for table sys_user_post
-- ----------------------------
ALTER TABLE "public"."sys_user_post" ADD CONSTRAINT "sys_user_post_pkey" PRIMARY KEY ("user_id", "post_id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD CONSTRAINT "sys_user_role_pkey" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Primary Key structure for table test_demo
-- ----------------------------
ALTER TABLE "public"."test_demo" ADD CONSTRAINT "test_demo_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table test_tree
-- ----------------------------
ALTER TABLE "public"."test_tree" ADD CONSTRAINT "test_tree_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_group
-- ----------------------------
ALTER TABLE "public"."xxl_job_group" ADD CONSTRAINT "xxl_job_group_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_info
-- ----------------------------
ALTER TABLE "public"."xxl_job_info" ADD CONSTRAINT "xxl_job_info_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_lock
-- ----------------------------
ALTER TABLE "public"."xxl_job_lock" ADD CONSTRAINT "xxl_job_lock_pkey" PRIMARY KEY ("lock_name");

-- ----------------------------
-- Indexes structure for table xxl_job_log
-- ----------------------------
CREATE INDEX "I_handle_code" ON "public"."xxl_job_log" USING btree (
  "handle_code" "pg_catalog"."int4_ops" ASC NULLS LAST
);
CREATE INDEX "I_trigger_time" ON "public"."xxl_job_log" USING btree (
  "trigger_time" "pg_catalog"."timestamp_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table xxl_job_log
-- ----------------------------
ALTER TABLE "public"."xxl_job_log" ADD CONSTRAINT "xxl_job_log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_log_report
-- ----------------------------
CREATE INDEX "i_trigger_day" ON "public"."xxl_job_log_report" USING btree (
  "trigger_day" "pg_catalog"."timestamp_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table xxl_job_log_report
-- ----------------------------
ALTER TABLE "public"."xxl_job_log_report" ADD CONSTRAINT "xxl_job_log_report_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_logglue
-- ----------------------------
ALTER TABLE "public"."xxl_job_logglue" ADD CONSTRAINT "xxl_job_logglue_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_registry
-- ----------------------------
CREATE INDEX "i_g_k_v" ON "public"."xxl_job_registry" USING btree (
  "registry_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "registry_key" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "registry_value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table xxl_job_registry
-- ----------------------------
ALTER TABLE "public"."xxl_job_registry" ADD CONSTRAINT "xxl_job_registry_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_user
-- ----------------------------
CREATE INDEX "i_username" ON "public"."xxl_job_user" USING btree (
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table xxl_job_user
-- ----------------------------
ALTER TABLE "public"."xxl_job_user" ADD CONSTRAINT "xxl_job_user_pkey" PRIMARY KEY ("id");
