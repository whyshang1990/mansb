package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.CategoryDO;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.dto.SubCategoryDTO;
import com.why.first.mansb.repository.CategoryDao;
import com.why.first.mansb.service.CategoryService;
import com.why.first.mansb.utils.JsonUtil;
import com.why.first.mansb.vo.CategoryVO;
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
    public CategoryVO getTopCategories() {
        CategoryVO result = new CategoryVO();
        List<CategoryDTO> tops = this.categoryDao.getTops();
        List<SubCategoryDTO> subs = this.categoryDao.getSubs();

        LOGGER.info("tops: {}", JsonUtil.toJson(tops));
        LOGGER.info("subs: {}", JsonUtil.toJson(subs));
        result.setTopCategories(tops);

        Map<String, List<CategoryDTO>> subMap = new HashMap<>();
        for (SubCategoryDTO sub : subs) {
            CategoryDTO child = sub.getCategoryDTO();
            List<CategoryDTO> list;
            if (CollectionUtils.isEmpty(subMap.get(sub.getTopUuid()))) {
                list = new ArrayList<>();
                list.add(child);
            } else {
                list = subMap.get(sub.getTopUuid());
                list.add(sub.getCategoryDTO());
            }

            subMap.put(sub.getTopUuid(), list);
        }

        result.setSubCategories(subMap);
        return result;
    }
}
