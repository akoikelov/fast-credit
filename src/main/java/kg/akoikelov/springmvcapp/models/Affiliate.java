package kg.akoikelov.springmvcapp.models;

/** Филиал */
public class Affiliate {

  /** ID */
  private int id;
  /** Название */
  private String title;
  /** Макс сумма при помесячной оплате */
  private int maxSumMonth;
  /** Макс сумма при ежедневной оплате */
  private int maxSumDay;
  /** Макс кол-во дней */
  private int maxDays;
  /** Макс кол-во месяцев; */
  private int maxMonths;
  /** Мин процент */
  private float minPercentage;
  /** Комментарий */
  private String comment;
  /** Номер телефона */
  private String phone;
  /** Адрес */
  private String address;
  /** Префикс филиала (используется для клиентов) */
  private String prefix;

  public Affiliate(int id) {
    this.id = id;
  }

  public Affiliate() {}

  public Affiliate(
      String title,
      int maxSumMonth,
      int maxSumDay,
      int maxDays,
      int maxMonths,
      float minPercentage,
      String comment,
      String phone,
      String address,
      String prefix) {
    this.title = title;
    this.maxSumMonth = maxSumMonth;
    this.maxSumDay = maxSumDay;
    this.maxDays = maxDays;
    this.maxMonths = maxMonths;
    this.minPercentage = minPercentage;
    this.comment = comment;
    this.phone = phone;
    this.address = address;
    this.prefix = prefix;
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

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
