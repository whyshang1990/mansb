package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.CategoryDO;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.repository.CategoryDao;
import com.why.first.mansb.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Resource
    private CategoryDao categoryDao;

    @Override
    public CategoryDTO getCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<CategoryDO> categories = this.categoryDao.findAll();
        Map<String, List<String>> tempMap = new HashMap();
        for (CategoryDO category : categories) {
            if (category.getLevel() == 1) {
                tempMap.put(category.getName(), new ArrayList<>());
            }
            categories.remove(category);
        }

        for (CategoryDO category : categories) {
            if (category.getLevel() == 1) {
                List<String> children = tempMap.get(category.getParentName());
                if (!CollectionUtils.isEmpty(children)) {
                    children.add(category.getName());
                }
            }
        }
        categoryDTO.setCategoryDetail(tempMap);
        return categoryDTO;
    }
}
