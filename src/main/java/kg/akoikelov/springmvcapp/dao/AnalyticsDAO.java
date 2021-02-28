package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Analytics;
import kg.akoikelov.springmvcapp.utils.PaginationData;

public interface AnalyticsDAO extends FieldValueExists {
  PaginationData<Analytics> getAnalyticsList(int page, int limit);

  Analytics getAnalyticsById(int id);

  boolean update(Analytics analytics);

  boolean delete(int id);

  boolean create(Analytics analytics);
}
