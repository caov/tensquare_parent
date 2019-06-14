package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: tensquare_parent
 * @description: 文章控制层
 * @author: cf
 * @create: 2019-06-14 14:50
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     *审核文章
     */
    @RequestMapping(value = "/examine/{articleId}", method= RequestMethod.PUT)
    public Result examine(@PathVariable String articleId){
        articleService.examine(articleId);
        return new Result(true, StatusCode.OK,"操作成功");
    }

    /**
     *点赞文章
     */
    @RequestMapping(value = "/thumbup/{articleId}", method= RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String articleId){
        articleService.updateThumbup(articleId);
        return new Result(true,StatusCode.OK,"操作成功");
    }
}
