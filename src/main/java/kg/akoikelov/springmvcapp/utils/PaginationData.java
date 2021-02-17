package kg.akoikelov.springmvcapp.utils;

import java.util.List;

public class PaginationData<T> {

  private final List<T> data;
  private final int allCount;

  public PaginationData(List<T> data, int allCount) {
    this.data = data;
    this.allCount = allCount;
  }

  public List<T> getData() {
    return data;
  }

  public int getAllCount() {
    return allCount;
  }
}
