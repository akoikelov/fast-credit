package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.CashBox;

import java.util.List;

public interface CashBoxDAO extends FieldValueExists {
  List<CashBox> findAllForSelect();
}