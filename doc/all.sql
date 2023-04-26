drop table if exists category;
create table category (
                      id bigint not null comment 'id',
                      `name` varchar(50) comment '名称',
                      parent bigint not null comment '父类',
                      `description` varchar(100) comment '类别描述',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='风险类别';

insert into category (id, name, parent, description) values (1, '税号误报风险知识', 0, '历史报关单证中存在的申报要素与税号的对应关系。');
insert into category (id, name, parent, description) values (2, '商品要素误报风险知识', 0, '互联网大数据资源中的商品要素相关信息。');

drop table if exists user;
create table user (
                          id bigint not null comment 'id',
                          `name` varchar(50) comment '姓名',
                          `password` varchar(50) comment '密码',
                          age int comment '年龄',
                          employee_id bigint not null comment '工号',
                          department varchar(50) comment '部门',
                          auth_level int comment '权限等级',
                          primary key (id)
) engine=innodb default charset=utf8mb4 comment='用户';

drop table if exists knowledge_management;
create table knowledge_management (
                      id bigint not null comment 'id',
                      `name` varchar(50) comment '名称',
                      state int comment '知识状态',
                      category varchar(50) not null comment '知识类别',
                      link_table_name varchar(50) comment '明细表名称',
                      activate_time DATE comment '启用时间',
                      expire_time DATE comment '截止时间',
                      manager bigint not null comment '负责人',
                      reviewer1 bigint comment '关联负责人1',
                      reviewer2 bigint comment '关联负责人2',
                      reviewer3 bigint comment '关联负责人3',
                      `number` int default 0 comment '条目数',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='风险知识管理';

drop table if exists knowledge;
create table knowledge (
                            id bigint not null comment 'id',
                            params varchar(150) comment '参数',
                            `values` varchar(150) comment '内容',
                            primary key (id)
) engine=innodb default charset=utf8mb4 comment='风险知识';

drop table if exists tax_report;
create table tax_report (
                      id bigint not null comment 'id',
                      g_name varchar(50) comment '商品名称',
                      tax_id bigint comment '税号',
                      relation_params varchar(150) comment '关联要素',
                      relation_values varchar(150) comment '关联要素内容',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='税号白样本';

drop table if exists tax_misreport;
create table tax_misreport (
                            id bigint not null comment 'id',
                            g_name varchar(50) comment '商品名称',
                            tax_id bigint comment '税号',
                            mis_tax_id bigint comment '误报税号',
                            relation_params varchar(150) comment '关联要素',
                            relation_values varchar(150) comment '关联要素内容',
                            tax_rate_difference int comment '税率变化',
                            quarantine_difference varchar(150) comment '检疫变化',
                            primary key (id)
) engine=innodb default charset=utf8mb4 comment='税号黑样本';

drop table if exists commodity_information;
create table commodity_information (
                               id bigint not null comment 'id',
                               information_type int not null comment '信息类型',
                               `trigger` varchar(50) comment '触发词',
                               entities varchar(100) not null comment '实体类型',
                               e_values varchar(100) not null comment '实体提及',
                               primary key (id)
) engine=innodb default charset=utf8mb4 comment='商品要素内容';

drop table if exists extraction_schema;
create table extraction_schema (
                               id bigint not null comment 'id',
                               information_type int not null comment '信息类型',
                               creator bigint not null comment '创建人',
                               expire_time DATE comment '失效日期',
                               `schema` varchar(100) comment '抽取框架',
                               primary key (id)
) engine=innodb default charset=utf8mb4 comment='抽取框架信息';

drop table if exists extraction_task;
create table extraction_task (
                      id bigint not null comment 'id',
                      `name` varchar(50) comment '名称',
                      category varchar(50) not null comment '知识类别',
                      activate_time DATE comment '启用时间',
                      expire_time DATE comment '截止时间',
                      manager bigint not null comment '负责人',
                      reviewer1 bigint comment '关联负责人1',
                      reviewer2 bigint comment '关联负责人2',
                      reviewer3 bigint comment '关联负责人3',
                      relation_params varchar(150) comment '关联要素',
                      relation_values varchar(150) comment '关联要素内容',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='风险知识管理';
