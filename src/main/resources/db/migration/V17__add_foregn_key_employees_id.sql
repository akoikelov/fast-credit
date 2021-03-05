alter table customer
add constraint fk_employeesCreateId
foreign key (employee_create_id)
references employees(id);
alter table customer
    add constraint fk_employeesUpdateId
        foreign key (employee_update_id)
            references employees(id);
