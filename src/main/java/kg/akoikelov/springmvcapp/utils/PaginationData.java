package kg.akoikelov.springmvcapp.utils;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class PaginationData<T> {

    @JsonView(ViewsRest.forList.class)
    private final List<T> data;
    @JsonView(ViewsRest.forList.class)
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
