/**
 * CREATE Script for init of DB
 */

 --Create 3 person Entity

insert into person(id, first_name, last_name, age, favourite_colour)
values
(100, 'John', 'Wick', 29, 'red');

insert into hobby(id, hobby_name, person_id) values (200, 'shopping', 100);
insert into hobby(id, hobby_name, person_id) values (300, 'football', 100);


insert into person(id, first_name, last_name, age, favourite_colour)
values
(400, 'Sarah', 'Raven', 54, 'blue');

insert into hobby(id, hobby_name, person_id) values (500, 'chess', 400);


