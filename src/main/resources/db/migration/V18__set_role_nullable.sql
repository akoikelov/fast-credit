alter table employees
drop column role;

alter table employees
add column role varchar(20);