package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.CashBoxDAO;
import kg.akoikelov.springmvcapp.models.CashBox;
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
}
