package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @program: tensquare_parent
 * @description: 文章评论Service层
 * @author: cf
 * @create: 2019-06-14 17:23
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment){
        comment.setId( idWorker.nextId()+"" );
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }
}
