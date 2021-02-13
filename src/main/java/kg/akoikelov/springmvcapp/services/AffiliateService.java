package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.AffiliatesDAO;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService {

  AffiliatesDAO affiliatesDAO;

  @Autowired
  public AffiliateService(AffiliatesDAO affiliatesDAO) {
    this.affiliatesDAO = affiliatesDAO;
  }

  public PaginationData<Affiliate> getAffiliates(int page, int limit) {
    return affiliatesDAO.findForList(page, limit);
  }

  public boolean saveAffiliate(Affiliate affiliate) {
    return affiliatesDAO.create(affiliate);
  }
}
