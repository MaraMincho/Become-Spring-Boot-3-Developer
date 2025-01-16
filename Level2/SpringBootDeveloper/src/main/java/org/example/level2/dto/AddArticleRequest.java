package org.example.level2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.level2.domain.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

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

    @Controller
    public static class ExampleController {
        @GetMapping("/thymeleaf/example")
        public String thymeleafExample(Model model) { // 뷰로 데이터를 넘겨주는 모델 객체
            Person examplePerson = new Person();
            examplePerson.setId(1L);
            examplePerson.setName("홍길동");
            examplePerson.setAge(11);
            examplePerson.setHobbies(List.of("운동", "독서"));

            model.addAttribute("person", examplePerson); // Person 객체 저장
            model.addAttribute("today", LocalDate.now());

            return "example"; // example.html이라는 뷰 조회
        }

        @Setter
        @Getter
        class Person {
            private Long id;
            private String name;
            private int age;
            private List<String> hobbies;
        }
    }
}
