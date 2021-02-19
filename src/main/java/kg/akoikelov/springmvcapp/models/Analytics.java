package kg.akoikelov.springmvcapp.models;

public class Analytics {

  private int id;
  private String title;
  private String comment;
  private boolean isIncome;

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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isIncome() {
    return isIncome;
  }

  public void setIncome(boolean income) {
    isIncome = income;
  }
}
