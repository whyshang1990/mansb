package com.why.first.mansb.controller;

import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.service.CategoryService;
import com.why.first.mansb.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public BaseResponse<CategoryDTO> getAllCategory() {
        CategoryDTO categoryDTO = this.categoryService.getCategoryDTO();
        return ResponseUtil.success(categoryDTO);
    }
}
