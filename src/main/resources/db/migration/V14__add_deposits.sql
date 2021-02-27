create table deposits
(
    id                 INT GENERATED ALWAYS AS IDENTITY,
    customer_id        INT          NOT NULL,
    title              VARCHAR(255) NOT NULL,
    price              INT          NOT NULL,
    notes              TEXT,
    comment            TEXT,
    employee_create_id INT          NOT NULL,
    employee_update_id INT,

    PRIMARY KEY (id),
    CONSTRAINT deposit_id UNIQUE (id),
    CONSTRAINT fk_deposits_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_deposits_creator FOREIGN KEY (employee_create_id) REFERENCES employees (id),
    CONSTRAINT fk_deposits_editor FOREIGN KEY (employee_update_id) REFERENCES employees (id)
);

create index deposits_id_index on deposits (id);