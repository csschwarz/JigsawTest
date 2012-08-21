# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table skill (
  user_id                   varchar(255),
  skill_info_id             integer,
  rating                    integer)
;

create table skill_info (
  id                        integer auto_increment not null,
  name                      varchar(255),
  category                  varchar(255),
  constraint pk_skill_info primary key (id))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  constraint pk_user primary key (username))
;

create sequence user_seq;

alter table skill add constraint fk_skill_user_1 foreign key (user_id) references user (username) on delete restrict on update restrict;
create index ix_skill_user_1 on skill (user_id);
alter table skill add constraint fk_skill_skillInfo_2 foreign key (skill_info_id) references skill_info (id) on delete restrict on update restrict;
create index ix_skill_skillInfo_2 on skill (skill_info_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists skill;

drop table if exists skill_info;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

