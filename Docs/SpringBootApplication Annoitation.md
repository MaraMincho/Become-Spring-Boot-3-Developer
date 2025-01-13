
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration // 스프링 부트 관련 설정
@ComponentScan(excludeFilters = {
@Filter(type = FilterType.CUSTOM,
    // 사용자가 등록한 빈을 읽고 등록
    classes = TypeExcludeFilter.class),
    @Filter(type = FilterType.CUSTOM,
    classes = AutoConfigurationExcludeFilter.class)
})
@EnableAutoConfiguration // 자동으로 등록된 빈을 읽고 등록
public @interface SpringBootApplication {
... 생략 ...
}
```

# @SpringBootConfiguration
스프링 부트 관련 설정을 나타내는 애너테이션입니다. 스프링을 아는 독자라면 @Configuration을 상속해서 만든 애너테이션입니다. 이 애너테이션은 개발자가 직접 사용하는 애너테이션은 아닙니다만 기존의 스프링 개발자를 위해 한 번 언급했습니다.

<br/><br/>

# @ComponentScan
사용자가 등록한 빈을 읽고 등록하는 애너테이션입니다. 이애너테이션은 @Component라는 애너테이션을 가진 클래스들을 찾아 빈으로 등록하는 역할을 합니다. 그렇다고 모든 빈에 @Component만 사용하는 게 아닙니다. @Component를 감싸는 애너테이션이 있는데 실제 개발을 하면 @Component 애너테이션보다는 용도에 따라 다른 애너테이션을 사용하므로 아래의애너테이션 정도는 미리 눈에 익히고 넘어가기를 권합니다.

|애너테이션 이름| 설명|
|:-|-:|
|@Configuration |설정 파일 등록|
|@Repository |ORM 매핑|
|@Controller, @RestController | 라우터|
|@Service| 비즈니스 로직|


<br/><br/>


# @EnableAutoConfiguration
스프링 부트에서 자동 구성을 활성화하는 애너테이션입니다. 이 애너테이션은 스프링 부트 서버가 실행될 때 스프링 부트의 메타 파일을 읽고 정의된 설정들을 자동으로 구성하는 역할을 수행합니다. 2.3.3절 ‘자동 구성’에서 살펴본 spring.factories을 기억하시나요? 그 파일에 클래스들이 모두 @EnableAutoConfiguration을 사용할 때 자동 설정됩니다.