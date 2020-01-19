package com.why.first.mansb.dto.factory;

import com.why.first.mansb.domain.CategoryDO;
import com.why.first.mansb.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTOFactory {
    public static CategoryDTO getByDO(CategoryDO category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setUuid(category.getUuid());
        return categoryDTO;
    }

    public static List<CategoryDTO> getByDOs(List<CategoryDO> categories) {
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (CategoryDO categoryDO : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(categoryDO.getName());
            categoryDTO.setUuid(categoryDO.getUuid());
            categoryDTOs.add(categoryDTO);
        }

        return categoryDTOs;
    }

}
