
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