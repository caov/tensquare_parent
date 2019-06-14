package com.tensquare.article.pojo;

import javax.persistence.Id;
import java.util.Date;

/**
 * @program: tensquare_parent
 * @description: 文章评论实体类
 * @author: cf
 * @create: 2019-06-14 17:19
 */
public class Comment {
    @Id
    private String id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}
