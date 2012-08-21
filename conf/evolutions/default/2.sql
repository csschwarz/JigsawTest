# --- !Ups

insert into user(username, password, first_name, last_name) values('test', 'test', 'Firstname', 'Lastname');

insert into skill_info(name, category) values('Java', 'Programming');
insert into skill_info(name, category) values('Groovy', 'Programming');
insert into skill_info(name, category) values('Python', 'Programming');
insert into skill_info(name, category) values('Ruby', 'Programming');
insert into skill_info(name, category) values('Perl', 'Programming');
insert into skill_info(name, category) values('Javascript', 'Programming');
insert into skill_info(name, category) values('F#', 'Programming');
insert into skill_info(name, category) values('C#', 'Programming');
insert into skill_info(name, category) values('PHP', 'Programming');
insert into skill_info(name, category) values('Ruby on Rails', 'Programming');
insert into skill_info(name, category) values('C++', 'Programming');
insert into skill_info(name, category) values('SQL', 'Programming');
insert into skill_info(name, category) values('Dev Ops', 'Programming');
insert into skill_info(name, category) values('iOS', 'Programming');
insert into skill_info(name, category) values('Android', 'Programming');
insert into skill_info(name, category) values('HTML', 'Programming');
insert into skill_info(name, category) values('HTML5', 'Programming');
insert into skill_info(name, category) values('Scala', 'Programming');
insert into skill_info(name, category) values('CSS', 'Programming');
insert into skill_info(name, category) values('JSP', 'Programming');



# --- !Downs

delete from user;
delete from skill_info;
