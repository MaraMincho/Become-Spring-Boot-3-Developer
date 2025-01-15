package org.example.level2.controller;

import lombok.RequiredArgsConstructor;
import org.example.level2.domain.Article;
import org.example.level2.dto.ArticleListViewResponse;
import org.example.level2.dto.ArticleViewResponse;
import org.example.level2.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> article = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", article); // 블로그 글 리스트 저장

        return "articleList"; // Article List라ㄹ는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse((article)));

        return "article"; // article html 리턴해줌
    }
}
