/*
    Создать таблицу филиалов
*/

CREATE TABLE affiliates
(
    id             serial primary key,
    title          VARCHAR(255) NOT NULL,
    max_sum_month  INT          NOT NULL,
    max_sum_day    INT          NOT NULL,
    max_days       INT          NOT NULL,
    min_percentage FLOAT        NOT NULL,
    comment        TEXT,
    phone          VARCHAR(30),
    address        VARCHAR(255),
    prefix         VARCHAR(10)  NOT NULL,

    CONSTRAINT affiliate_id_unique UNIQUE (id),
    CONSTRAINT affiliate_title_unique UNIQUE (title)
);