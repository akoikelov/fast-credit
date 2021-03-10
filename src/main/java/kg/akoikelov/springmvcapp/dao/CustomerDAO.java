package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.utils.PaginationData;

public interface CustomerDAO extends FieldValueExists {
    boolean create(Customer customer);

    boolean update(Customer customer);

    Customer findById(int id);

    PaginationData<Customer> getList(int page, int limit);

    boolean delete(int id);

    boolean checkCustomer(int id);
}
