package com.why.first.mansb.vo;

import com.why.first.mansb.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryVO {
    private List<CategoryDTO> topCategories;
    private Map<String, List<CategoryDTO>> subCategories;

    public List<CategoryDTO> getTopCategories() {
        return topCategories;
    }

    public void setTopCategories(List<CategoryDTO> topCategories) {
        this.topCategories = topCategories;
    }

    public Map<String, List<CategoryDTO>> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Map<String, List<CategoryDTO>> subCategories) {
        this.subCategories = subCategories;
    }
}
