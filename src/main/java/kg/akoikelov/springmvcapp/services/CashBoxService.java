package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.CashBoxDAO;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashBoxService {
  CashBoxDAO cashBoxDAO;

  @Autowired
  public CashBoxService(CashBoxDAO cashBoxDAO) {
    this.cashBoxDAO = cashBoxDAO;
  }

  public List<CashBox> getAllForSelect() {
    return cashBoxDAO.findAllForSelect();
  }

  public PaginationData<CashBox> getCashBoxList(int page, int limit) {
    return cashBoxDAO.getAllForList(page, limit);
  }

  public CashBox getCashBox(int id) {
    return cashBoxDAO.getCashBoxById(id);
  }

  public boolean create(CashBox cashBox) {
    return cashBoxDAO.create(cashBox);
  }
}
