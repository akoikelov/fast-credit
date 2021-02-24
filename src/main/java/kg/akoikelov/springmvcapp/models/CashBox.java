package kg.akoikelov.springmvcapp.models;

import java.util.Date;

public class CashBox {
  /** Primary Key */
  private int id;
  /** Title */
  private String title;
  /** Affiliate */
  private Affiliate affiliate;
  /** Comment */
  private String comment;

  private int affiliateId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Affiliate getAffiliate() {
    return affiliate;
  }

  public void setAffiliate(Affiliate affiliate) {
    this.affiliate = affiliate;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getAffiliateId() {
    return affiliateId;
  }

  public void setAffiliateId(int affiliateId) {
    this.affiliateId = affiliateId;
  }

  public CashBox copy() {
    CashBox cashBox = new CashBox();
    cashBox.setTitle("copy " + new Date());
    cashBox.setComment(this.comment);
    cashBox.setAffiliateId(this.affiliateId);
    return cashBox;
  }
}
