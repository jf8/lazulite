INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('1', 'admin', 'junfu.chen@daphne.com.cn', '15036092123', 'df4ca6094c7462ef691df1368ba3c6e1', '8caae1e0673f964bf89237e3998416c5', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('2', 'showcase', 'showcase@sishuok.com', '13412345672', '5f915c55c6d43da136a42e3ebabbecfc', 'hSSixwNQwt', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('3', 'sys', 'sys@sishuok.com', '13412345673', 'a10b3c7af051a81fe2506318f982ce28', 'MANHOoCpnb', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('4', 'maintain', 'maintain@sishuok.com', '13412345674', '594813c5eb02b210dacc1a36c2482fc1', 'iY71e4dtoa', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('5', 'create', 'create@sishuok.com', '13412345675', 'a6d5988a698dec63c6eea71994dd7be0', 'iruPxupgfb', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('6', 'update', 'update@sishuok.com', '13412345676', 'fffa26ac5c47ec1bf9a37d9823816074', '2WQx5LmvlV', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('7', 'delete', 'delete@sishuok.com', '13412345677', '4c472bf1d56f440d2953803ab4eea8d4', 'E8KSvr1C7d', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('8', 'view', 'view@sishuok.com', '13412345678', 'c919215efcef4064858bf02f8776c00d', 'XFJZQOXWZW', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('9', 'audit', 'audit@sishuok.com', '13412345679', '15d8f7b8da8045d24c71a92a142ffad7', 'BI2XbXMUr7', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('10', 'monitor', 'monitor@sishuok.com', '1341234580', 'e1549e68ad21fe888ae36ec4965116cd', 'iY71e4d123', TO_TIMESTAMP('2015-06-05 16:50:52', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');
INSERT INTO SYS_USER (id, username, email, mobile_phone_number, password, salt, create_date, status, deleted, admin) VALUES ('11', 'chenjunfu', 'l._6@163.com', '13838195108', 'cc8df38af3d2e38974edf2397ba744ce', 'kHWv0qZvjj', TO_TIMESTAMP('2015-06-07 20:58:36', 'YYYY-MM-DD HH24:MI:SS'), 'normal', '0', '1');


INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('1', '超级管理员', 'admin', '拥有所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('2', '示例管理员', 'example_admin', '拥有示例管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('3', '系统管理员', 'sys_admin', '拥有系统管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('4', '维护管理员', 'conf_admin', '拥有维护管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('5', '新增管理员', 'create_admin', '拥有新增/查看管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('6', '修改管理员', 'update_admin', '拥有修改/查看管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('7', '删除管理员', 'delete_admin', '拥有删除/查看管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('8', '查看管理员', 'view_admin', '拥有查看管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('9', '审核管理员', 'audit_admin', '拥有审核管理的所有权限', '1');
INSERT INTO SYS_ROLE (id, name, role, description, is_show) VALUES ('10', '监控管理员', 'audit_admin', '拥有审核管理的所有权限', '1');


insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (1, null, null, '资源', 0, '0/', 1, null, 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (2, null, 'showcase', '示例管理', 1, '0/1/', 1, null, 6, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (3, null, 'sample', '示例列表', 2, '0/1/2/', 1, '/showcase/sample', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (4, null, 'deleted', '逻辑删除列表', 2, '0/1/2/', 1, '/showcase/deleted', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (5, null, 'move', '可移动列表', 2, '0/1/2/', 1, '/showcase/move', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (6, null, 'upload', '文件上传列表', 2, '0/1/2/', 1, '/showcase/upload', 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (7, null, 'tree', '树列表', 2, '0/1/2/', 1, '/showcase/tree', 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (8, null, 'editor', '编辑器列表', 2, '0/1/2/', 1, '/showcase/editor', 6, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (9, 'ztree_file', 'parentchild', '父子表（小数据量）', 2, '0/1/2/', 1, '/showcase/parentchild', 7, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (10, null, null, '父子表（大数据量）管理', 2, '0/1/2/', 1, null, 8, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (11, null, 'productCategory', '类别列表', 10, '0/1/2/10/', 1, '/showcase/product/category', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (12, null, 'product', '产品列表', 10, '0/1/2/10/', 1, '/showcase/product/product', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (13, null, null, '状态管理', 2, '0/1/2/', 1, null, 9, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (14, null, 'statusAudit', '审核状态列表', 13, '0/1/2/13/', 1, '/showcase/status/audit', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (15, null, 'statusShow', '显示状态列表', 13, '0/1/2/13/', 1, '/showcase/status/show', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (16, null, 'sys', '系统管理', 1, '0/1/', 1, null, 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (17, null, null, '用户管理', 16, '0/1/16/', 1, null, 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (18, null, 'user', '用户列表', 17, '0/1/16/17/', 1, '/admin/sys/user/main', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (19, null, 'userOnline', '在线用户列表', 17, '0/1/16/17/', 1, '/admin/sys/user/online', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (20, null, 'userStatusHistory', '状态变更历史列表', 17, '0/1/16/17/', 1, '/admin/sys/user/statusHistory', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (21, null, 'userLastOnline', '用户最后在线历史列表', 17, '0/1/16/17/', 1, '/admin/sys/user/lastOnline', 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (22, null, null, '组织机构管理', 16, '0/1/16/', 1, null, 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (23, null, 'organization', '组织机构列表', 22, '0/1/16/22/', 1, '/admin/sys/organization/organization', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (24, null, 'job', '工作职务列表', 22, '0/1/16/22/', 1, '/admin/sys/organization/job', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (25, null, 'resource', '资源列表', 16, '0/1/16/', 1, '/admin/sys/resource', 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (26, null, null, '权限管理', 16, '0/1/16/', 1, null, 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (27, null, 'permission', '权限列表', 26, '0/1/16/26/', 1, '/admin/sys/permission/permission', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (28, null, 'role', '授权权限给角色', 26, '0/1/16/26/', 1, '/admin/sys/permission/role', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (29, null, 'group', '分组列表', 16, '0/1/16/', 1, '/admin/sys/group', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (30, null, 'auth', '授权角色给实体', 26, '0/1/16/26/', 1, '/admin/sys/auth', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (31, null, null, '个人中心', 1, '0/1/', 1, null, 7, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (32, null, null, '我的消息', 31, '0/1/31/', 1, '/admin/personal/message', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (33, null, 'maintain', '开发维护', 1, '0/1/', 1, null, 8, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (34, null, 'icon', '图标管理', 33, '0/1/33/', 1, '/admin/maintain/icon', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (35, null, 'keyvalue', '键值对', 33, '0/1/33/', 1, '/admin/maintain/keyvalue', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (37, null, 'staticResource', '静态资源版本控制', 33, '0/1/33/', 1, '/admin/maintain/staticResource', 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (38, null, 'onlineEditor', '在线编辑', 33, '0/1/33/', 1, '/admin/maintain/editor', 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (39, null, 'monitor', '系统监控', 1, '0/1/', 1, null, 9, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (40, null, 'userOnline', '在线用户列表', 39, '0/1/39/', 1, '/admin/sys/user/online', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (41, null, 'db', '数据库监控', 39, '0/1/39/', 1, '/admin/monitor/druid/index.html', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (42, null, 'hibernate', 'hibernate监控', 39, '0/1/39/', 1, '/admin/monitor/hibernate', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (43, null, 'ql', '执行SQL/JPA QL', 39, '0/1/39/', 1, '/admin/monitor/db/sql', 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (44, null, 'ehcache', 'ehcache监控', 39, '0/1/39/', 1, '/admin/monitor/ehcache', 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (45, null, 'jvm', 'jvm监控', 39, '0/1/39/', 1, '/admin/monitor/jvm', 6, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (46, null, 'excel', 'Excel导入/导出', 2, '0/1/2/', 1, '/showcase/excel', 10, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (47, null, null, '我的通知', 31, '0/1/31/', 1, '/admin/personal/notification', 2, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (48, null, 'notificationTemplate', '通知模板', 33, '0/1/33/', 1, '/admin/maintain/notification/template', 1, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (49, null, 'dynamicTask', '任务调度', 33, '0/1/33/', 1, '/admin/maintain/dynamicTask', 6, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (50, null, null, '新节点', 2, '0/1/2/', 0, null, 11, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (235, 'ztree_file', 'activitys', '抢兑码', 6100, '0/1/6100/', 0, '/activities/activitys', 10, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (7251, 'ztree_file', 'activity', '活动管理', 6100, '0/1/6100/', 1, '/activities/activity', 3, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (6100, 'ztree_folder', 'activities', '营销活动', 1, '0/1/', 1, null, 4, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (219, 'ztree_file', 'adpush', '广告推送', 6100, '0/1/6100/', 0, '/activities/adpush', 9, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (217, 'ztree_file', 'activitysteps', '活动阶段', 6100, '0/1/6100/', 0, '/activities/activitysteps', 8, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (443, 'ztree_file', 'activities:coupon', '优惠券2', 6100, '0/1/6100/', 0, '/activities/coupon', 15, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (345, 'ztree_file', 'hpoint', '积分兑换', 6100, '0/1/6100/', 0, '/activities/hpoint', 13, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (157, 'ztree_file', 'coupon', '优惠卷', 6100, '0/1/6100/', 0, '/activities/coupon', 5, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (213, 'ztree_file', 'activity', '新增活动', 6100, '0/1/6100/', 0, '/activities/activity', 7, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (236, 'ztree_file', 'promotion', '活动促销', 6100, '0/1/6100/', 0, '/activities/promotion', 11, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (304, 'ztree_file', 'activities:activity', '活动树', 6100, '0/1/6100/', 0, '/activities/activity/tree/main?id=162', 12, null);

insert into SYS_RESOURCE (ID, ICON, IDENTITY, NAME, PARENT_ID, PARENT_IDS, IS_SHOW, URL, WEIGHT, DIY)
values (359, 'ztree_file', 'hpoint', '赠送积分', 6100, '0/1/6100/', 0, '/activities/hpoint/516/create', 14, null);



-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('1', '所有', '*', '所有数据操作的权限', '1');
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('2', '新增', 'create', '新增数据操作的权限', '1');
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('3', '修改', 'update', '修改数据操作的权限', '1');
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('4', '删除', 'delete', '删除数据操作的权限', '1');
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('5', '查看', 'view', '查看数据操作的权限', '1');
INSERT INTO SYS_PERMISSION (id, name, permission, description, is_show) VALUES ('6', '审核', 'audit', '审核数据操作的权限', '1');


INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('1', '0', '0', '1', '0', '1', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('2', '0', '0', '2', '0', '2', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('3', '0', '0', '3', '0', '3', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('4', '0', '0', '4', '0', '4', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('5', '0', '0', '5', '0', '5', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('6', '0', '0', '6', '0', '6', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('7', '0', '0', '7', '0', '7', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('8', '0', '0', '8', '0', '8', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('9', '0', '0', '9', '0', '9', 'user');
INSERT INTO SYS_AUTH (id, organization_id, job_id, user_id, group_id, role_ids, type) VALUES ('10', '0', '0', '10', '0', '10', 'user');



INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('1', '1', '2', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('2', '1', '16', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('3', '1', '33', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('4', '1', '39', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('5', '2', '2', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('6', '3', '16', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('7', '4', '33', '1');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('8', '5', '2', '2,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('9', '5', '16', '2,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('10', '5', '33', '2,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('11', '5', '39', '2,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('12', '6', '2', '3,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('13', '6', '16', '3,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('14', '6', '33', '3,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('15', '6', '39', '3,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('16', '7', '2', '4,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('17', '7', '16', '4,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('18', '7', '33', '4,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('19', '7', '39', '4,5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('20', '8', '2', '5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('21', '8', '16', '5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('22', '8', '33', '5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('23', '8', '39', '5');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('24', '9', '7', '5,6');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('25', '9', '14', '5,6');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('26', '9', '15', '5,6');
INSERT INTO SYS_ROLE_RESOURCE_PERMISSION (id, role_id, resource_id, permission_ids) VALUES ('27', '10', '39', '1');



