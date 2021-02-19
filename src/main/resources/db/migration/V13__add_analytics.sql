create table analytics
(
    id        INT GENERATED ALWAYS AS IDENTITY,
    title     varchar(50) NOT NULL,
    comment   text,
    is_income SMALLINT DEFAULT 1, -- Приход или расход ?

    PRIMARY KEY (id),
    CONSTRAINT analytics_id UNIQUE (id),
    CONSTRAINT analytics_title UNIQUE (title)
);
create index analytics_id_index on analytics (id)