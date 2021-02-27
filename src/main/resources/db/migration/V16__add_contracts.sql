create table contracts
(
    id INT GENERATED ALWAYS AS IDENTITY,
    identifier VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    till_date DATE NOT NULL,
    deposit_price INT,
    sum INT NOT NULL,
    type VARCHAR(10) NOT NULL,
    percentage FLOAT NOT NULL,
    percentage_text VARCHAR(255),
    time INT NOT NULL,
    comission INT NOT NULL,
    payment_days_of_week VARCHAR(255) NOT NULL,
    comments TEXT,

    cashbox_id INT NOT NULL,
    customer_id INT NOT NULL,
    deposit_id INT,
    auto_deposit_id INT,
    employee_id INT,
    affiliate_id INT NOT NULL,
    employee_create_id INT          NOT NULL,
    employee_update_id INT,

    PRIMARY KEY (id),
    CONSTRAINT contracts_id UNIQUE (id),
    CONSTRAINT contracts_identifier UNIQUE (identifier),

    CONSTRAINT fk_contracts_affiliate FOREIGN KEY (affiliate_id) REFERENCES affiliates (id),
    CONSTRAINT fk_contracts_cashbox FOREIGN KEY (cashbox_id) REFERENCES cashboxes (id),
    CONSTRAINT fk_contracts_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_contracts_deposit FOREIGN KEY (deposit_id) REFERENCES deposits (id),
    CONSTRAINT fk_contracts_auto_deposit FOREIGN KEY (auto_deposit_id) REFERENCES auto_deposits (id),
    CONSTRAINT fk_contracts_employee FOREIGN KEY (employee_id) REFERENCES employees (id),

    CONSTRAINT fk_contracts_creator FOREIGN KEY (employee_create_id) REFERENCES employees (id),
    CONSTRAINT fk_contracts_editor FOREIGN KEY (employee_update_id) REFERENCES employees (id)
);

create index contracts_id_index on contracts (id);
create index contracts_identifier_index on contracts (identifier);