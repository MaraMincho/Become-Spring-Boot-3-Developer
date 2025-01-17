import org.junit.jupiter.api.*;

public class JUnitTest {

    @DisplayName("1 + 2는 3이다.")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(sum, a + b);
    }

    @DisplayName("1 + 3는 4이다.")
    @Test
    public void junitFailedTest() {
        int a = 1;
        int b = 3;
        int sum = 3;
        Assertions.assertEquals(sum, a + b); // 실패하는 케이스
    }
}
