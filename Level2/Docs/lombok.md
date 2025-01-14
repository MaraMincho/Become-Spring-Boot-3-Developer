# Lombok이란
LomBok이란 어노테이션 기반으로 코드 자동완성 기능을 제공하는 라이브러리이다. 
Spring, Spring Boot 로 Web 개발을 하다보면 반복되는 코드가 자주 등장하며 가독성을 떨어트린다.
예를 들어보면 Getter, Setter, ToString, Constructor(생성자)가 대표적인 예제일 것이다. 


# 예시
- 레거시 코드가 DTO, VO class의 경우 필드 개수가 30-50개 있을 수 있습니다. 
- 만약 이 필드에 getter, setter, toString 코드를 만들게 되면 그야말로 지옥
- class 코드의 길이가 2배 이상으로 불필요하게 된다.


# lombok의 장점
- 어노테이션을 통한 코드 자동 생성을 통한 생산성, 편의성 증가
- Code의 길이가 줄어듬으로 가독성, 유지보수성 향상
- Builder 패턴의 적용, Log 생성 등등 편의성

# Annotaion(어노테이션) 정리 


|어노테이션| 설명|
|:-|:-|
|@Getter|	code가 컴파일 될 때 getter 메서드들을 생성한다. <br/> 속성 @Getter(lazy = true) 사용시 최초 한번만 Getter 호출. 이후 캐시된 값을 사용|
|@Setter|	code가 컴파일 될 때 setter 메서드들을 생성한다.|
|@ToString|	toString() 메서드를 생성한다.|
|@EqualsAndHashCode|	사용 객체에 대해서 equals(), hashCode() 메서드를 생성한다.|
|@Data|	@Getter(모든속성), @Setter(final이 붙지 않은), @ToString, @EqualsAndHashCode, @RequiredArgsConstructor <br/> 위의 어노테이션들을 합쳐둔 어노테이션이다.|
|@NoArgsConstructor|	파라미터(매개변수)가 없는 생성자를 생성한다.|
|@RequiredArgsConstructor|	final, @NonNull이 있는 필드를 포함하여 생성자를 생성한다.|
|@AllArgsConstructor|	모든 필드를 파라미터(매개변수)로 갖는 생성자를 생성한다.|
|@Builder|	해당 클래스에 빌더 패턴을 사용할 수 있도록 해준다. |
|@Log|	log라는 변수를 이용하여 로그 기능을 사용할 수 있다.<br/> 컴파일시 : private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(this.class.getName()); -> 해당 코드가 생성되는것이다. |
|@Log4j, @Slf4J| 	Log4J(Slf4J) 설정을 이용하여 로그 기능 사용할 수있다. <br/> 마찬가지로 log 변수를 통해 사용 한다.|
|@SneakyThrows|	예외 발생시 Throwable 타입으로 반환해준다. JVM(.class) 에서 검사 여부 관계없이 모든 예외에 대해 throw동작. <br/> - 논란의 여지가 있는 어노테이션!! - 사용시 주의! <br/>- 롬복 공식 홈페이지에서는 신중하게 사용하라는 권고 있음.|
|@Synchronized|	Method 에서 동기화 설정. <br/> 동기화 관련 문제 발생을 해당 어노테이션을 통해 가상의 필드 레벨에서 조금이나마 안전하게 락을 걸어준다. |
|@NonNull|	필드의 값이 null이 될 수 없음을 명시해준다.|
|@Value|	불변 클래스를(Immutable Class) 생성해준다. <br/> 모든 필드를 Private, Final 로 설정하고, Setter를 생성하지 않는다.(상수로 만들어준다.) <br/> FInal 이 붙기 때문에 Setter는 존재할 수가 없는것이다.|