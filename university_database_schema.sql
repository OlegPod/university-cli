create table department (id bigint not null auto_increment, name varchar(255), head_id bigint, primary key (id)) engine=InnoDB;
create table department_lector (department_id bigint not null, lector_id bigint not null, primary key (department_id, lector_id)) engine=InnoDB;
create table lector (id bigint not null auto_increment, degree varchar(255), first_and_last_name varchar(255), salary double precision, primary key (id)) engine=InnoDB;
alter table department add constraint FKdb1vl8mut04igtg6992oob1ce foreign key (head_id) references lector (id);
alter table department_lector add constraint FKi5jwkssy8kawtqunhx7q3ui87 foreign key (lector_id) references lector (id);
alter table department_lector add constraint FK57g67o2p8vdphk23xbk7o5gy foreign key (department_id) references department (id);
