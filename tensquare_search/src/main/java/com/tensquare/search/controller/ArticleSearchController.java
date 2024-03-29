package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @program: tensquare_parent
 * @description: 文章搜索controller层
 * @author: cf
 * @create: 2019-06-17 15:21
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleSearchService.save(article);
        return  new Result(true, StatusCode.OK,"操作成功");
    }

    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.POST)
    public Result findByTitleOrContentLike(@PathVariable String keywords,
                                           @PathVariable int page,
                                           @PathVariable int size){
        Page<Article> articlePage = articleSearchService.findByTitleOrContentLike(keywords,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(articlePage.getTotalElements(),articlePage.getContent()));
    }
}
