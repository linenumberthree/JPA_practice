package com.example.demoboard.repository;

import com.example.demoboard.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findArticleByBoardId(Long boardId);
    Article findArticleByBoard_CreatorId(Long creatorId);
}
