package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.CustomerDAO;
import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public PaginationData<Customer> getList(int page, int paginationNumber) {
        return customerDAO.getList(page, paginationNumber);
    }

    public boolean create(Customer customer) {
        return customerDAO.create(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.findById(id);
    }

    public boolean update(Customer customer) {
        return customerDAO.update(customer);
    }

    public boolean checkCustomer(int id) {
        return customerDAO.checkCustomer(id);
    }
}
