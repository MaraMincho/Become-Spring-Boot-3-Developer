package org.example.level2.service;

import lombok.RequiredArgsConstructor;
import org.example.level2.domain.Article;
import org.example.level2.dto.AddArticleRequest;
import org.example.level2.dto.UpdateArticleRequest;
import org.example.level2.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// 빈을 생성자로 생성하는 롬복에서 지원하는 애너테이션입니다.
// final, 혹은 @NotNull 붙은 필드로 생성자를 만들어줍니다.
@RequiredArgsConstructor // 즉 생성자를 annotation 으로 위임해줌
@Service // 빈 컴포넌트로 등록하는 애너테이션
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 매서드
    public Article save(AddArticleRequest request, String userName) {
        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 여기서 발생한 에러는 어디에서 처리되는지 알 수 있을까요?
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());
        return article;
    }

    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().
                getName();
        if (!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }
}
