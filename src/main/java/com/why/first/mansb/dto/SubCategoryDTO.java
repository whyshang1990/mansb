package com.why.first.mansb.dto;

public class SubCategoryDTO {
    private String topUuid;
    private CategoryDTO categoryDTO;

    public SubCategoryDTO(String topUuid, String uuid, String name) {
        this.topUuid = topUuid;
        this.categoryDTO = new CategoryDTO(uuid, name);
    }

    public String getTopUuid() {
        return topUuid;
    }

    public void setTopUuid(String topUuid) {
        this.topUuid = topUuid;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
