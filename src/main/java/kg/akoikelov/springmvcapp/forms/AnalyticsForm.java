package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.dao.AnalyticsDAO;
import kg.akoikelov.springmvcapp.models.Analytics;
import kg.akoikelov.springmvcapp.validation.Unique;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Unique.List({
  @Unique(
      message = "Аналитика с таким именем есть",
      service = AnalyticsDAO.class,
      fieldName = "title")
})
@Component
public class AnalyticsForm {
  private int id;
  @NotNull @NotBlank private String title;
  private String comment;
  private boolean isIncome;

  public AnalyticsForm() {}

  public AnalyticsForm(Analytics analytics) {
    this.id = analytics.getId();
    this.title = analytics.getTitle();
    this.comment = analytics.getComment();
    this.isIncome = analytics.getIsIncome();
  }

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

  public boolean getIsIncome() {
    return isIncome;
  }

  public void setIsIncome(boolean income) {
    isIncome = income;
  }

  public Analytics build() {
    return new Analytics(id, title, comment, isIncome);
  }
}
