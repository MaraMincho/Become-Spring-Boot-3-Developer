# JUnit이란

JUnit은 자바 언어를 위한 단위 테스트 프레임워크입니다. 단위 테스트라는 말이 생소할 텐데요.단위 테스트란, 작성한 코드가 의도대로 작동하는지 작은 단위로 검증하는 것을 의미합니다. 이때 단위는 보통 메서드가 됩니다. JUnit을 사용하면 단위 테스트를 작성하고 테스트하는 데 도움을줍니다. 사용법도 간단해 쉽게 익힐 수 있습니다. 무엇보다 테스트 결과가 직관적이라 좋죠. 구체적인 JUnit의 특징은 다음과 같습니다.


``` java

import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }
    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }
    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @Test
    public void test3() {
        System.out.println("test3");
    }
    @AfterAll // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }
    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}


```