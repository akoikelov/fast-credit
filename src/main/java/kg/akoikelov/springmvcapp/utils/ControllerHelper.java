package kg.akoikelov.springmvcapp.utils;

import java.util.Map;

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

  public static String getQueryFromRequest(Map<String, String> params) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Map.Entry<String, String> entry: params.entrySet()) {
      stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
    }

    return stringBuilder.toString();
  }

}
