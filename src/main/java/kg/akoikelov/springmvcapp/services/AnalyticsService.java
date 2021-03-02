package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.AnalyticsDAO;
import kg.akoikelov.springmvcapp.models.Analytics;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
  AnalyticsDAO analyticsDAO;

  @Autowired
  public AnalyticsService(AnalyticsDAO analyticsDAO) {
    this.analyticsDAO = analyticsDAO;
  }

  public PaginationData<Analytics> getAnalyticsList(int page, int limit) {
    return analyticsDAO.getAnalyticsList(page, limit);
  }

  public boolean create(Analytics analytics) {
    return analyticsDAO.create(analytics);
  }

  public Analytics getById(int id) {
    return analyticsDAO.getAnalyticsById(id);
  }

  public boolean update(Analytics analytics) {
    return analyticsDAO.update(analytics);
  }
}
