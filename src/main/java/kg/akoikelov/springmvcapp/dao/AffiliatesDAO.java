package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.utils.PaginationData;

public interface AffiliatesDAO {

  Affiliate findById(int id);

  boolean create(Affiliate affiliate);

  boolean update(Affiliate affiliate);

  boolean delete(int id);

  PaginationData<Affiliate> findForList(int page, int limit);
}
