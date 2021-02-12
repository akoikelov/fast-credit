create table authorities
(username varchar(50),
 authority varchar(25),
 CONSTRAINT authorities_fk
 FOREIGN KEY (username)
 REFERENCES employees (username)
);
create index authorities_username on authorities(username);