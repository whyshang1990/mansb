package com.why.first.mansb.dto;

import java.util.List;
import java.util.Map;

public class CategoryDTO {
    private Map<String, List<String>> categoryDetail;

    public Map<String, List<String>> getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(Map<String, List<String>> categoryDetail) {
        this.categoryDetail = categoryDetail;
    }
}
