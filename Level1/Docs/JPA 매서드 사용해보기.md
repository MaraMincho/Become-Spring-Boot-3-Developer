
```java
@Service
public class MemberService {

@Autowired
MemberRepository memberRepository;

public void test() {
    // 1 생성(Create)
    memberRepository.save(new Member(1L, "A"));
    // 2 조회(Read)
    Optional<Member> member = memberRepository.findById(1L); // 단건 조회
    List<Member> allMembers = memberRepository.findAll(); // 전체 조회
    // 3 삭제(Delete)
    memberRepository.deleteById(1L);
    }
}

```


기본적인 사용 입니다.

<br/><br/><br/>

```java
@Entity // 1 엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 2 기본 생성자
@AllArgsConstructor

public class Member {
    @Id // 3 id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false) // 5 name이라는 not null 컬럼과 매핑
    private String name;
}

```

- (1) @Entity의 속성 중에 name을 사용하면 name의 값을 가진 테이블 이름과 매핑되고, 테이블 이름을 지정하지 않으면 클래스 이름과 같은이름의 테이블과 매핑됩니다.
    - `@Entity(name = "member_list")` `member_list` 라는 이름을 가진 테이블과 매핑

<br/>

- (2) `protected` 기본 생성자입니다. 엔티티는 반드시 기본 생성자가 있어야 하고, 접근 제어자는`public` 또는 `protected여`야 합니다.
  - **(public보다는 protected가 더 안전하다 why? -> 정리 필요)**

<br/>


- (3) @Id는 Long 타입의 id 필드를 테이블의 기본키로지정합니다.
  


<br/>

- (4) @GeneratedValue는 기본키의 생성 방식을 결정합니다. 여기서는 자동으로 기본키가 증가되도록 지정했습니다. 

### 자동키 생성 설정 방식

- AUTO : 선택한 데이터베이스 방언(dialect)에 따라 방식을 자동으로 선택(기본값)
- IDENTITY : 기본키 생성을 데이터베이스에 위임(= AUTO_INCREMENT)
- SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본키를 할당하는 방법. 오라클에서 주로 사용
- TABLE : 키 생성 테이블 사용

<br/>
@Column 애너테이션은 데이터베이스의 컬럼과 필드를 매핑해줍니다. 
- (5)
- name : 필드와 매핑할 컬럼 이름. 설정하지 않으면 필드 이름으로 지정해줍니다.
- nullable : 컬럼의 null 허용 여부. 설정하지 않으면 true(nullable)
- unique : 컬럼의 유일한 값(unique) 여부. 설정하지 않으면 false(non·unique)
- columnDefinition : 컬럼 정보 설정. default값을 줄 수 있습니다.



# 레포지토리

```java
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //...
}
```

리포지토리는 엔티티에 있는 데이터들을 조회하거나 저장, 변경, 삭제를 할 때 사용하는 인터페이스로, 스프링 데이터 JPA에서 제공하는 인터페이스인 JpaRepository 클래스를 상속받아 간단하게 구현할 수 있습니다.

![alt text](/Images/image4.png)