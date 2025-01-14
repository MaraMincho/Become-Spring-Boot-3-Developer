
# @Builder 
@Builder 애너테이션은 롬복에서 지원하는 애너테이션인데요, 이 애너테이션을 생성자 위에 입력하면 빌더 패턴 방식으로 객체를 생성할 수 있어 편리합니다.

# Builder 패턴이란?

```java
// 빌더 패턴을 사용하지 않았을 때
new Article("abc", "def");
// 빌더 패턴을 사용했을 때
Article.builder()
    .title("abc")
    .content("def")
    .build();

```

### as is 

```java
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    private Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected Article() {}
}
```

### to be

```java
@Entity // 엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;
    @Builder // 빌더 패턴으로 객체 생성

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

```