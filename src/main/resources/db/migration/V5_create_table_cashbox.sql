/*
 Создать таблицу для кассы
 */

 create table cashboxes
(
    id INT GENERATED ALWAYS AS IDENTITY ,
    title VARCHAR (100) NOT NULL,
    affiliate_id INT NOT NULL ,
    comment TEXT,
  PRIMARY KEY (id),
  CONSTRAINT cashboxes_id UNIQUE (id),
  CONSTRAINT cashboxes_title UNIQUE (title),


   CONSTRAINT fk_affiliates
        FOREIGN KEY (affiliate_id)
           REFERENCES affiliates(id)




 );
create index cashbox_id_index on cashboxes(id)