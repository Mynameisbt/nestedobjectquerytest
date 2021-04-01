package com.mynameisbt.nestedobjectquerytest.repositories;

import com.mynameisbt.nestedobjectquerytest.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

    Page<Article> findByAuthorsFirstName(String name, Pageable pageable);

}