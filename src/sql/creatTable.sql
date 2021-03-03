create table sqlLog
(
    id          int unsigned NOT NULL AUTO_INCREMENT,
    type        varchar(20)  not null,
    log_sql     text,
    sql_text         text,
    create_time datetime default now(),
    primary key (id)
)

drop table sys_email_configuration;
CREATE TABLE `sys_email_configuration`
(
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `brand_unit_no` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌部编号',
    `brand_unit_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌部名称',
    `email_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱地址',
    `status` int(11) DEFAULT 0  COMMENT '1.启用 0.禁用',
    `remark` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
    `create_user` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '建档人',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '建档时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `update_user` char(32) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin CHECKSUM = 1 DELAY_KEY_WRITE = 1 ROW_FORMAT = DYNAMIC COMMENT = '邮箱配置表';

drop table sys_email_configuration;



