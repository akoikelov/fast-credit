package kg.akoikelov.springmvcapp.utils;

public class ControllerHelper {
  public static int parseInt(String value) {
    int pageNumber = 1;
    try {
      pageNumber = Integer.parseInt(value);
    } catch (NumberFormatException ignored) {

    }
    if (pageNumber <= 0) {
      pageNumber = 1;
    }
    return pageNumber;
  }

  public static int pageCount(int rowsCount, int paginationLimit) {
    return (int) Math.ceil((rowsCount * 1.0) / paginationLimit);
  }
}
