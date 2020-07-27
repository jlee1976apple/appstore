create table app (id bigint not null auto_increment, avg_rating double precision not null, cost double precision not null, current_version varchar(255), description longtext, image longblob, name varchar(255), total_ratings double precision not null, platform_type_id bigint, primary key (id));
create table platform_type (id bigint not null auto_increment, name varchar(255), primary key (id));
create table rating (id bigint not null auto_increment, comments longtext, rating double precision not null, username varchar(255), mobile_app_id bigint, primary key (id));
create table review (id bigint not null auto_increment, review longtext, username varchar(255), app_id bigint, primary key (id));
alter table app add constraint FKrh14ew86nhd0h6ht7cfdpn5du foreign key (platform_type_id) references platform_type (id);
alter table rating add constraint FKma0ynnn87vt7jss25xc2a9dnu foreign key (mobile_app_id) references app (id);
alter table review add constraint FKgs7bcotf7vnyg54ryf9bjnn1p foreign key (app_id) references app (id);