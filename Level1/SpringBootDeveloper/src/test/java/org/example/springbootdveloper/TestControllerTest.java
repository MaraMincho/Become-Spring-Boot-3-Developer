package org.example.springbootdveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("get all members: 아티클 조회에 성공한다")
    @Test
    public void getAllMembers() throws Exception {
        final String url = "/test";
        Member saveMember = memberRepository.save(new Member(1L, "홍길동"));

        // perform( ) 메서드는 요청을 전송하는 역할을 하는 메서드입니다
        final var secondResult = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // andExpect( ) 메서드는 응답을 검증합니다. TestController에서 만든 API는 응답으로
        //OK(200)을 반환하므로 이에 해당하는 메서드인 isOk를 사용해 응답 코드가 OK(200)인지 확인
        //합니다.
        secondResult
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(saveMember.getId()))
                .andExpect(jsonPath("$[0].name").value(saveMember.getName()));
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        result
                .andExpect(status().isOk()) // 3
                // 4 응답의 0번째 값이 DB에 저장한 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(saveMember.getId()))
                .andExpect(jsonPath("$[0].name").value(saveMember.getName()));
    }
}