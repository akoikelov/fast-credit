package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.utils.PaginationData;

import java.util.List;

public interface CashBoxDAO extends FieldValueExists {
    List<CashBox> findAllForSelect();

    PaginationData<CashBox> getAllForList(int page, int limit);

    CashBox getCashBoxById(int id);

    boolean create(CashBox cashBox);

    boolean update(CashBox cashBox);
}
