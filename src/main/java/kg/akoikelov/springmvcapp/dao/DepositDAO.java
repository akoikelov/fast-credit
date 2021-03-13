package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Deposit;
import kg.akoikelov.springmvcapp.utils.PaginationData;

import java.util.List;

public interface DepositDAO extends FieldValueExists {
    List<Deposit> findAll(int id);

    PaginationData<Deposit> getAllForList(int page, int limit);

    Deposit getDepositById(int id);

    boolean create(Deposit deposit);

    boolean update(Deposit deposit);

    boolean checkDeposit(int id);
}
