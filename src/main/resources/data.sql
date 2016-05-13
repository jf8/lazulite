insert into sys_user (username, password,email, enabled,mobile_phone_number,account_non_expired,account_non_locked,credentials_non_expired) values ('user', 'b6b0b3fba91589cb27903a65a53ca69e64e4363c76a5d270ec2bf74fe3f88c7801a95aeacf303625','l._6@163.com', true,'15036092123',true,true,true);

insert into sys_authorities (username, authority) values ('user', 'ROLE_ADMIN');