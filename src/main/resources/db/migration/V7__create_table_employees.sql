create table employees
(
    id           INT GENERATED ALWAYS AS IDENTITY,
    username     VARCHAR(50) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    full_name    VARCHAR(100) NOT NULL,
    position     VARCHAR(30),
    salary       INT,
    is_working   SMALLINT DEFAULT 1,
    birthday     DATE,
    passport_id  VARCHAR(100),
    affiliate_id INT         NOT NULL,
    cashbox_id   INT         NOT NULL,
    comment      TEXT,
    role         VARCHAR(30) NOT NULL ,

    PRIMARY KEY (id),
    CONSTRAINT employees_id UNIQUE (id),
    CONSTRAINT employee_username UNIQUE (username),
    CONSTRAINT fk_affiliates_employee
        FOREIGN KEY (affiliate_id)
            REFERENCES affiliates (id),
    CONSTRAINT fk_cashboxes_employee
            FOREIGN KEY (cashbox_id)
            REFERENCES cashboxes(id)
);
create index employee_id_index on employees (id)