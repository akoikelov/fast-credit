create table auto_deposits
(
    id INT GENERATED ALWAYS AS IDENTITY,
    proxy VARCHAR(255),
    model VARCHAR(255) NOT NULL,
    id_number VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    year_color VARCHAR(255) NOT NULL,
    model_engine VARCHAR(255) NOT NULL,
    carcase VARCHAR(255) NOT NULL,
    certificate VARCHAR(255) NOT NULL,
    gov_number VARCHAR(255) NOT NULL,
    comment TEXT,
    is_arrested SMALLINT DEFAULT 1,
    ownership VARCHAR(255),
    employee_create_id INT          NOT NULL,
    employee_update_id INT,
    customer_id        INT          NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT auto_deposit_id UNIQUE (id),
    CONSTRAINT fk_auto_deposits_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_auto_deposits_creator FOREIGN KEY (employee_create_id) REFERENCES employees (id),
    CONSTRAINT fk_auto_deposits_editor FOREIGN KEY (employee_update_id) REFERENCES employees (id)
);

create index auto_deposits_id_index on auto_deposits (id);