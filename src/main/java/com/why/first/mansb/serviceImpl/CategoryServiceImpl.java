package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.CategoryDO;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.dto.factory.CategoryDTOFactory;
import com.why.first.mansb.repository.CategoryDao;
import com.why.first.mansb.service.CategoryService;
import com.why.first.mansb.vo.CategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<CategoryVO> getCategories() {
        List<CategoryVO> result = new ArrayList<>();


        List<CategoryDO> majorCategories = this.categoryDao.findByLevel(0);


        for (CategoryDO majorCategory : majorCategories) {
            CategoryVO categoryVO = new CategoryVO();
            CategoryDTO categoryDTO = CategoryDTOFactory.getByDO(majorCategory);
            categoryVO.setMajorCategory(categoryDTO);
            List<CategoryDO> minorCategories = this.categoryDao.findMinors(1, categoryDTO.getUuid());
            List<CategoryDTO> categoryDTOs = CategoryDTOFactory.getByDOs(minorCategories);
            categoryVO.setMinorCategories(categoryDTOs);
            result.add(categoryVO);
        }

        return result;
    }
}
