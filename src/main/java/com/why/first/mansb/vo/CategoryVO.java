package com.why.first.mansb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.why.first.mansb.dto.CategoryDTO;

import java.util.List;

public class CategoryVO {
    @JsonUnwrapped
    private CategoryDTO majorCategory;
    @JsonProperty("children")
    private List<CategoryDTO> minorCategories;

    public CategoryDTO getMajorCategory() {
        return majorCategory;
    }

    public void setMajorCategory(CategoryDTO majorCategory) {
        this.majorCategory = majorCategory;
    }

    public List<CategoryDTO> getMinorCategories() {
        return minorCategories;
    }

    public void setMinorCategories(List<CategoryDTO> minorCategories) {
        this.minorCategories = minorCategories;
    }
}
