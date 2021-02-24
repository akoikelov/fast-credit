package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.dao.AffiliatesDAO;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.validation.Unique;

import javax.validation.constraints.*;

/**
 * Класс для формы создания филиала Мы можем наследовать от класса филиала чтобы получить его поля
 */
@Unique.List({
  @Unique(
      fieldName = "title",
      service = AffiliatesDAO.class,
      message = "Филиал с таким названием есть"),
  @Unique(
      fieldName = "prefix",
      service = AffiliatesDAO.class,
      message = "Префикс с таким названием есть")
})
public class AffiliateForm {

  private int id;

  @NotNull()
  @NotBlank()
  @Size(min = 2, max = 10)
  private String title;

  @Min(value = 0)
  private int maxSumMonth;

  @Min(value = 0)
  private int maxSumDay;

  @Min(value = 1)
  private int maxDays;

  @Min(value = 1)
  private int maxMonths;

  @DecimalMin(value = "0.01")
  private float minPercentage;

  private String comment;
  private String phone;
  private String address;

  @NotNull()
  @NotBlank()
  @Size(min = 2, max = 10)
  private String prefix;

  public AffiliateForm(Affiliate affiliate) {
    this.id = affiliate.getId();
    this.title = affiliate.getTitle();
    this.maxSumMonth = affiliate.getMaxSumMonth();
    this.maxSumDay = affiliate.getMaxSumDay();
    this.maxDays = affiliate.getMaxDays();
    this.maxMonths = affiliate.getMaxMonths();
    this.minPercentage = affiliate.getMinPercentage();
    this.comment = affiliate.getComment();
    this.phone = affiliate.getPhone();
    this.address = affiliate.getAddress();
    this.prefix = affiliate.getPrefix();
  }

  public AffiliateForm() {}

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

  public int getMaxSumMonth() {
    return maxSumMonth;
  }

  public void setMaxSumMonth(int maxSumMonth) {
    this.maxSumMonth = maxSumMonth;
  }

  public int getMaxSumDay() {
    return maxSumDay;
  }

  public void setMaxSumDay(int maxSumDay) {
    this.maxSumDay = maxSumDay;
  }

  public int getMaxDays() {
    return maxDays;
  }

  public void setMaxDays(int maxDays) {
    this.maxDays = maxDays;
  }

  public int getMaxMonths() {
    return maxMonths;
  }

  public void setMaxMonths(int maxMonths) {
    this.maxMonths = maxMonths;
  }

  public float getMinPercentage() {
    return minPercentage;
  }

  public void setMinPercentage(float minPercentage) {
    this.minPercentage = minPercentage;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public Affiliate build() {
    return new Affiliate(
        title,
        maxSumMonth,
        maxSumDay,
        maxDays,
        maxMonths,
        minPercentage,
        comment,
        phone,
        address,
        prefix);
  }
}
