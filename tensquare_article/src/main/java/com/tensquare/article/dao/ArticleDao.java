package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: tensquare_parent
 * @description: 文章Dao层
 * @author: cf
 * @create: 2019-06-14 14:48
 */
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true)
    public void examine(String id);

    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup = thumbup+1 WHERE id = ?", nativeQuery = true)
    public void updateThumbup(String id);
}
