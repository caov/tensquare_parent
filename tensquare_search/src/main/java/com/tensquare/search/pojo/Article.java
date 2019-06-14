package com.tensquare.search.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: tensquare_parent
 * @description: 文章实体类
 * @author: cf
 * @create: 2019-06-14 17:50
 */
@Document(indexName = "tensquare",type = "article")
public class Article {
}
