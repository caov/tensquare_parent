package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findById(id));
    }

    /**
     * 增加
     * @param article
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody Article article  ){
        articleService.add(article);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param article
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Article article, @PathVariable String id ){
        article.setId(id);
        articleService.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        articleService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}