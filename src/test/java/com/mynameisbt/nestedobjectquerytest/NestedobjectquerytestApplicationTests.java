package com.mynameisbt.nestedobjectquerytest;

import com.mynameisbt.nestedobjectquerytest.model.Article;
import com.mynameisbt.nestedobjectquerytest.model.Author;
import com.mynameisbt.nestedobjectquerytest.repositories.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NestedobjectquerytestApplicationTests {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchTemplate;



	private final Author johnSmith = new Author("John", "Smith");

	private final Author johnDoe = new Author("John", "Doe");
	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void before() {
		Article article = new Article("Spring Data Elasticsearch");
		article.setAuthors(asList(johnSmith, johnDoe));
		article.setTags("elasticsearch", "spring data");
		articleRepository.save(article);

		article = new Article("Search engines");
		article.setAuthors(asList(johnDoe));
		article.setTags("search engines", "tutorial");
		articleRepository.save(article);

		article = new Article("Second Article About Elasticsearch");
		article.setAuthors(asList(johnSmith));
		article.setTags("elasticsearch", "spring data");
		articleRepository.save(article);

		article = new Article("Elasticsearch Tutorial");
		article.setAuthors(asList(johnDoe));
		article.setTags("elasticsearch");
		articleRepository.save(article);
	}

	@AfterEach
	public void after() {
		articleRepository.deleteAll();
	}

	@Test
	public void givenArticleService_whenSaveArticle_thenIdIsAssigned() {
		final List<Author> authors = asList(new Author("John","Smith"), johnDoe);

		Article article = new Article("Making Search Elastic");
		article.setAuthors(authors);

		Page<Article> response = articleRepository.findByAuthorsFirstName("John", Pageable.unpaged());
		assertEquals(4,response.getTotalElements());
	}

}
