package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.DepositDAO;
import kg.akoikelov.springmvcapp.models.Deposit;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    DepositDAO depositDAO;

    public DepositService(DepositDAO depositDAO) {
        this.depositDAO = depositDAO;
    }

    public Deposit getDepositById(int id) {
        return depositDAO.getDepositById(id);
    }


    public boolean create(Deposit deposit) {
        return depositDAO.create(deposit);
    }
}
