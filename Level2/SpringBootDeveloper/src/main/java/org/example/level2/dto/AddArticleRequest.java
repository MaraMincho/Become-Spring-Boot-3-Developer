package org.example.level2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.level2.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// 추후에 블로그 글을 추가할 때 저장할 엔티티로 변환하는 용도로 사용합니다.
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
