package com.leslia.test.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.leslia.api.api.HelpCategoryService;
import com.leslia.api.pojo.HelpCategory;
import com.leslia.ware.base.BaseTestDubbo;
import org.junit.Test;

public class HelpCategoryTest extends BaseTestDubbo {

    @Reference
    private HelpCategoryService helpCategoryService;

    @Test
    public void getList(){
        Object result=helpCategoryService.getList();
        PageInfo<HelpCategory> pageInfo= (PageInfo<HelpCategory>)result;
        System.out.println(pageInfo.getList().size());
        System.out.println(pageInfo.getTotal());
    }

}
