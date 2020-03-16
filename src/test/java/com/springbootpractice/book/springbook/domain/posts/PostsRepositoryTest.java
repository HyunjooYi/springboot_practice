package com.springbootpractice.book.springbook.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository repository;

    @After
    public void cleanAll() {
        repository.deleteAll();
        // 전체 테스트를 위해 동시 테스트 진행 중 데이터가 섞이지 않도록 단위 테스트 후에 deleteAll()을 매번 해주도록 한다.

    }

    @Test
    public void get_posts() {
        String title = "HarryPotter";
        String content = "Harry Potter and Something";
        String author = "J.K.Rolling";

        repository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        List<Posts> posts = repository.findAll();

        Posts p = posts.get(0);
        assertThat(p.getTitle()).isEqualTo(title);
        assertThat(p.getContent()).isEqualTo(content);
        assertThat(p.getAuthor()).isEqualTo(author);
    }

}
