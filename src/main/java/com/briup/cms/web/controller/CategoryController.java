package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/savaAndUpdata")
    @ApiOperation("对栏目进行增加或修改")
    public Message saveAndUpdate(Category category){
        categoryService.saveAndUpdateCategory(category);
        return MessageUtil.success();
    }

    @GetMapping("/deleteCategoryById")
    @ApiOperation("通过id删除栏目")
    @ApiImplicitParam(name = "id",value = "栏目id",required = true,paramType = "query",dataType = "int")
    public Message deleteCategoryById(int id){
        categoryService.deleteCategoryById(id);
        return MessageUtil.success();
    }

    @GetMapping("/findCategoryById")
    @ApiOperation("通过id查找栏目")
    @ApiImplicitParam(name = "id",value = "栏目id",required = true,paramType = "query",dataType = "int")
    public Message<Category> findCategoryById(int id){
        return MessageUtil.success(categoryService.findCategoryById(id));
    }

    @GetMapping("/findAllCategory")
    @ApiOperation("查询所有的栏目")
    public Message<List<Category>> findAllCategory(){
        return MessageUtil.success(categoryService.findAllCategory());
    }



}
