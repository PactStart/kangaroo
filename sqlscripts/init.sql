/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : kangaroo

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-04 23:01:18
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id`            INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '自增长主键',
  `namespace`     VARCHAR(20)  NOT NULL
  COMMENT '命名空间',
  `name`          VARCHAR(50)  NOT NULL DEFAULT ''
  COMMENT '配置名称',
  `value`         VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '配置值',
  `config_type`   INT(11)      NOT NULL
  COMMENT '配置类型，1、bool，2、int，3、string、4、json',
  `default_value` VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '默认值',
  `description`   VARCHAR(50)  NOT NULL DEFAULT ''
  COMMENT '配置描述',
  `json_schema`   TEXT         NOT NULL
  COMMENT '配置值约束',
  `operator`      VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新时间',
  `operate_ip`    VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '最后一个更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for config_log
-- ----------------------------
DROP TABLE IF EXISTS `config_log`;
CREATE TABLE `config_log` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '自增长主键',
  `namespace`    VARCHAR(20)  NOT NULL
  COMMENT '命名空间',
  `name`         VARCHAR(50)  NOT NULL DEFAULT ''
  COMMENT '配置名称',
  `old_type`     INT(11)      NOT NULL
  COMMENT '原类型',
  `new_type`     INT(11)      NOT NULL
  COMMENT '新类型',
  `old_value`    VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '原来的配置值',
  `new_value`    VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '新的配置值',
  `operator`     VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  `operate_ip`   VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for member_notice
-- ----------------------------
DROP TABLE IF EXISTS `member_notice`;
CREATE TABLE `member_notice` (
  `id`          BIGINT(20)    NOT NULL AUTO_INCREMENT,
  `member_id`   INT(11)       NOT NULL
  COMMENT '会员id',
  `nickname`    VARCHAR(50)   NOT NULL
  COMMENT '会员昵称',
  `status`      INT(11)       NOT NULL
  COMMENT '发送状态，0正在发送，1发送成功，2发送失败',
  `biz_type`    INT(11)       NOT NULL
  COMMENT '业务类型',
  `show_type`   INT(11)       NOT NULL
  COMMENT '显示类型',
  `title`       VARCHAR(255)  NOT NULL
  COMMENT '标题',
  `content`     VARCHAR(1024) NOT NULL
  COMMENT '通知内容',
  `readed`      BIT(1)        NOT NULL
  COMMENT '是否已读',
  `create_time` DATETIME      NOT NULL
  COMMENT '通知时间',
  `del`         BIT(1)                 DEFAULT NULL
  COMMENT '是否删除',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='业务通知';

-- ----------------------------
-- Table structure for platform_notice
-- ----------------------------
DROP TABLE IF EXISTS `platform_notice`;
CREATE TABLE `platform_notice` (
  `id`           INT(11)       NOT NULL AUTO_INCREMENT,
  `status`       INT(11)       NOT NULL
  COMMENT '状态，1草稿，2已发布，3已删除',
  `title`        VARCHAR(50)   NOT NULL
  COMMENT '通知标题',
  `content`      VARCHAR(1024) NOT NULL
  COMMENT '通知内容',
  `read_count`   INT(11)       NOT NULL DEFAULT '0'
  COMMENT '已读数量',
  `create_time`  DATETIME      NOT NULL
  COMMENT '创建时间',
  `operator`     VARCHAR(20)   NOT NULL
  COMMENT '操作人',
  `operate_time` DATETIME      NOT NULL
  COMMENT '操作时间',
  `operate_ip`   VARCHAR(20)   NOT NULL
  COMMENT '操作人ip',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='平台通知';

-- ----------------------------
-- Table structure for platform_notice_readed
-- ----------------------------
DROP TABLE IF EXISTS `platform_notice_readed`;
CREATE TABLE `platform_notice_readed` (
  `id`                 INT(11)  NOT NULL AUTO_INCREMENT,
  `platform_notice_id` INT(11)  NOT NULL
  COMMENT '平台通知id',
  `member_id`          INT(11)  NOT NULL
  COMMENT '会员id',
  `create_time`        DATETIME NOT NULL
  COMMENT '阅读时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='平台通知已读记录';

-- ----------------------------
-- Table structure for sms_day_count
-- ----------------------------
DROP TABLE IF EXISTS `sms_day_count`;
CREATE TABLE `sms_day_count` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '自增长主键',
  `year`      INT(11) NOT NULL
  COMMENT '年',
  `month`     INT(11) NOT NULL
  COMMENT '月',
  `day`       INT(11) NOT NULL
  COMMENT '日',
  `success`   INT(11) NOT NULL
  COMMENT '增量',
  `fail`      INT(11) NOT NULL
  COMMENT '总数',
  `stat_time` DATE    NOT NULL
  COMMENT '统计时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='短信发送每日统计';

-- ----------------------------
-- Table structure for sms_record
-- ----------------------------
DROP TABLE IF EXISTS `sms_record`;
CREATE TABLE `sms_record` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '自增长主键',
  `template_id`  VARCHAR(50)  NOT NULL
  COMMENT '短信模板id',
  `content`      VARCHAR(255) NOT NULL
  COMMENT '短信内容',
  `params`       VARCHAR(100) NOT NULL DEFAULT ''
  COMMENT '短信参数，json格式',
  `phone`        VARCHAR(11)  NOT NULL
  COMMENT '手机号',
  `success`      BIT(1)       NOT NULL
  COMMENT '是否发送成功',
  `remark`       VARCHAR(50)  NOT NULL DEFAULT ''
  COMMENT '备注，失败时为失败原因',
  `operator`     VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '发送者',
  `operate_time` DATETIME     NOT NULL
  COMMENT '发送时间',
  `operate_ip`   VARCHAR(20)  NOT NULL
  COMMENT '发送者ip',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='短信发送记录';

-- ----------------------------
-- Table structure for sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `template_id`  VARCHAR(16)  NOT NULL
  COMMENT '模板id',
  `type`         INT(11)      NOT NULL
  COMMENT '模板类型，1通知短信，2验证短信',
  `template`     VARCHAR(255) NOT NULL
  COMMENT '模板内容',
  `operator`     VARCHAR(20)  NOT NULL
  COMMENT '最后一次修改人',
  `operate_time` DATETIME     NOT NULL
  COMMENT '最后一次修改时间',
  PRIMARY KEY (`template_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='短信模板';

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id`           INT(11)       NOT NULL AUTO_INCREMENT,
  `source`       INT(11)       NOT NULL
  COMMENT '来源',
  `member_id`    INT(11)       NOT NULL
  COMMENT '用户id',
  `contact_info` VARCHAR(255)  NOT NULL
  COMMENT '联系方式',
  `problem_type` INT(11)       NOT NULL
  COMMENT '问题类型(0-功能异常，1-设计不合理，2-其他问题)',
  `content`      VARCHAR(255)  NOT NULL
  COMMENT '建议内容',
  `attachs`      VARCHAR(1024) NOT NULL
  COMMENT '附件',
  `status`       INT(11)       NOT NULL
  COMMENT '状态',
  `create_time`  DATETIME      NOT NULL
  COMMENT '创建时间',
  `reply`        VARCHAR(255)  NOT NULL
  COMMENT '回复',
  `operator`     VARCHAR(20)   NOT NULL
  COMMENT '处理人',
  `operate_time` DATETIME      NOT NULL
  COMMENT '处理时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_acl
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl`;
CREATE TABLE `sys_acl` (
  `id`            INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '权限id',
  `code`          VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '权限码',
  `name`          VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '权限名称',
  `acl_module_id` INT(11)      NOT NULL DEFAULT '0'
  COMMENT '权限所在的权限模块id',
  `url`           VARCHAR(100) NOT NULL DEFAULT ''
  COMMENT '请求的url, 可以填正则表达式',
  `type`          INT(11)      NOT NULL DEFAULT '3'
  COMMENT '类型，1：菜单，2：按钮，3：其他',
  `status`        INT(11)      NOT NULL DEFAULT '1'
  COMMENT '状态，1：正常，0：冻结',
  `seq`           INT(11)      NOT NULL DEFAULT '0'
  COMMENT '权限在当前模块下的顺序，由小到大',
  `remark`        VARCHAR(200)          DEFAULT ''
  COMMENT '备注',
  `operator`      VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新时间',
  `operate_ip`    VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '最后一个更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_acl_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '权限模块id',
  `name`         VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '权限模块名称',
  `parent_id`    INT(11)      NOT NULL DEFAULT '0'
  COMMENT '上级权限模块id',
  `level`        VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '权限模块层级',
  `seq`          INT(11)      NOT NULL DEFAULT '0'
  COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status`       INT(11)      NOT NULL DEFAULT '1'
  COMMENT '状态，1：正常，0：冻结',
  `remark`       VARCHAR(200)          DEFAULT ''
  COMMENT '备注',
  `operator`     VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次操作时间',
  `operate_ip`   VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '部门id',
  `name`         VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '部门名称',
  `parent_id`    INT(11)      NOT NULL DEFAULT '0'
  COMMENT '上级部门id',
  `level`        VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '部门层级',
  `seq`          INT(11)      NOT NULL DEFAULT '0'
  COMMENT '部门在当前层级下的顺序，由小到大',
  `remark`       VARCHAR(200)          DEFAULT ''
  COMMENT '备注',
  `operator`     VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次操作时间',
  `operate_ip`   VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT,
  `type`         INT(11)     NOT NULL DEFAULT '0'
  COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
  `target_id`    INT(11)     NOT NULL
  COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
  `old_value`    TEXT COMMENT '旧值',
  `new_value`    TEXT COMMENT '新值',
  `operator`     VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新的时间',
  `operate_ip`   VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '最后一次更新者的ip地址',
  `status`       INT(11)     NOT NULL DEFAULT '0'
  COMMENT '当前是否复原过，0：没有，1：复原过',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '角色id',
  `name`         VARCHAR(20) NOT NULL
  COMMENT '角色名称',
  `type`         INT(11)     NOT NULL DEFAULT '1'
  COMMENT '角色的类型，1：管理员角色，2：其他',
  `status`       INT(11)     NOT NULL DEFAULT '1'
  COMMENT '状态，1：可用，0：冻结',
  `remark`       VARCHAR(200)         DEFAULT ''
  COMMENT '备注',
  `operator`     VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新的时间',
  `operate_ip`   VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_role_acl
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `role_id`      INT(11)      NOT NULL
  COMMENT '角色id',
  `acl_id`       INT(11)      NOT NULL
  COMMENT '权限id',
  `operator`     VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新的时间',
  `operate_ip`   VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '最后一次更新者的ip',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT,
  `role_id`      INT(11)     NOT NULL
  COMMENT '角色id',
  `user_id`      INT(11)     NOT NULL
  COMMENT '用户id',
  `operator`     VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新的时间',
  `operate_ip`   VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '用户id',
  `username`     VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '用户名称',
  `telephone`    VARCHAR(13) NOT NULL DEFAULT ''
  COMMENT '手机号',
  `mail`         VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '邮箱',
  `password`     VARCHAR(40) NOT NULL DEFAULT ''
  COMMENT '加密后的密码',
  `dept_id`      INT(11)     NOT NULL DEFAULT '0'
  COMMENT '用户所在部门的id',
  `status`       INT(11)     NOT NULL DEFAULT '1'
  COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark`       VARCHAR(200)         DEFAULT ''
  COMMENT '备注',
  `operator`     VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '操作者',
  `operate_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后一次更新时间',
  `operate_ip`   VARCHAR(20) NOT NULL DEFAULT ''
  COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_version
-- ----------------------------
DROP TABLE IF EXISTS `sys_version`;
CREATE TABLE `sys_version` (
  `id`              INT(11)      NOT NULL AUTO_INCREMENT,
  `status`          INT(11)      NOT NULL
  COMMENT '版本状态，1草稿，2已发布，3已回滚，4已删除',
  `version_owner`   VARCHAR(10)  NOT NULL
  COMMENT '版本归属，Android,iOS,Backend,Frontend',
  `platform`        VARCHAR(20)  NOT NULL
  COMMENT '平台',
  `version_name`    VARCHAR(20)  NOT NULL
  COMMENT '版本名称',
  `version_seq`     INT(11)      NOT NULL
  COMMENT '版本顺序号',
  `git_tag`         VARCHAR(255) NOT NULL
  COMMENT '每个版本对应的git的tag',
  `compatible`      BIT(1)       NOT NULL
  COMMENT '是否兼容以前版本',
  `force_update`    BIT(1)       NOT NULL
  COMMENT '是否强制更新',
  `version_summary` VARCHAR(255) NOT NULL
  COMMENT '版本概要',
  `version_detail`  VARCHAR(255) NOT NULL
  COMMENT '版本详情',
  `version_time`    DATETIME     NOT NULL
  COMMENT '版本发布时间',
  `download_url`    VARCHAR(255) NOT NULL
  COMMENT '下载地址',
  `attachs`         VARCHAR(255) NOT NULL
  COMMENT '附件',
  `operator`        VARCHAR(20)  NOT NULL
  COMMENT '操作人',
  `operate_time`    DATETIME     NOT NULL
  COMMENT '操作时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='系统版本管理';

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file` (
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `user_id`       INT(11)      NOT NULL
  COMMENT '用户id',
  `user_type`     INT(11)      NOT NULL
  COMMENT '用户类型，1member，2sysuser',
  `biz_type`      INT(11)      NOT NULL
  COMMENT '业务类型',
  `resource_type` INT(11)      NOT NULL
  COMMENT '资源类型，1图片，2语音，3视频',
  `media_type`    VARCHAR(64)  NOT NULL
  COMMENT '媒体类型，例如image/jpeg,image/mp4',
  `url`           VARCHAR(255) NOT NULL
  COMMENT '资源地址',
  `size`          BIGINT(11)   NOT NULL
  COMMENT '资源大小，单位字节',
  `width`         INT(11)      NOT NULL
  COMMENT '图片宽度',
  `height`        INT(11)      NOT NULL
  COMMENT '图片高度',
  `create_time`   DATETIME     NOT NULL
  COMMENT '上传时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

