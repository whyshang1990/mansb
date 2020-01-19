package com.why.first.mansb.controller;

import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.service.CategoryService;
import com.why.first.mansb.utils.ResponseUtil;
import com.why.first.mansb.vo.CategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public BaseResponse<List<CategoryVO>> getAllCategory() {
        List<CategoryVO> categoryVOs = this.categoryService.getCategories();
        return ResponseUtil.success(categoryVOs);
    }
}
