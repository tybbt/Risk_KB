drop table if exists category;
create table category (
                      id bigint not null comment 'id',
                      name varchar(50) comment '名称',
                      parent bigint not null comment '父类',
                      description varchar(100) comment '类别描述',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='风险类别';

insert into category (id, name, parent, description) values (1, '税号误报风险知识', 0, '历史报关单证中存在的申报要素与税号的对应关系。');
insert into category (id, name, parent, description) values (2, '商品要素误报风险知识', 0, '互联网大数据资源中的商品要素相关信息。');