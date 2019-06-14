package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.concurrent.TimeUnit;

/**
 * @program: tensquare_parent
 * @description: 文章Service层
 * @author: cf
 * @create: 2019-06-14 14:49
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public void examine(String id){
        articleDao.examine(id);
    }

    public void updateThumbup(String id){
        articleDao.updateThumbup(id);
    }

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Article findById(String id) {
        //先从缓存中拿数据
        Article article = (Article)redisTemplate.opsForValue().get("article_"+id);
        //如果拿不到，就去数据库中查询
        if (article==null){
            article = articleDao.findById(id).get();
            //放入缓存中
            redisTemplate.opsForValue().set("article_"+id, article, 1, TimeUnit.DAYS);
        }
        return article;
    }

    /**
     * 增加
     * @param article
     */
    public void add(Article article) {
        article.setId( idWorker.nextId()+"" );
        articleDao.save(article);
    }

    /**
     * 修改
     * @param article
     */
    public void update(Article article) {
        //清除缓存中的数据
        redisTemplate.delete("article_"+article.getId());
        articleDao.save(article);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        //清除缓存中的数据
        redisTemplate.delete("article_"+id);
        articleDao.deleteById(id);
    }
}
