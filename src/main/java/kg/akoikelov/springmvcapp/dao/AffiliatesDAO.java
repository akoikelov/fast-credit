package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Affiliate;

public interface AffiliatesDAO {

  Affiliate findById(int id);

  boolean create(Affiliate affiliate);

  boolean update(Affiliate affiliate);

  boolean delete(int id);
}
