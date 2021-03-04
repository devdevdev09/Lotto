package com.heo.lotto.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
// import static
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    private MockMvc mockMvc;
    private RestDocumentationResultHandler document;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp(){
        this.document = document(
            "{class-name}/{method-name}",
            preprocessResponse(prettyPrint())
        );

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.restDocumentation)
        .uris().withScheme("http").withHost("127.0.0.1").withPort(2222))
        .alwaysDo(document)
        .build();
    }

    @Test
    public void getLotto() throws Exception{
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/lotto/{cnt}", "6")  
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document.document(
                    pathParameters(
                        parameterWithName("cnt").description("요청할 수[1~6]")
                    ),responseFields(
                        fieldWithPath("num1").description("첫번째숫자"),
                        fieldWithPath("num2").description("두번째숫자"),
                        fieldWithPath("num3").description("세번째숫자"),
                        fieldWithPath("num4").description("네번째숫자"),
                        fieldWithPath("num5").description("다섯번째숫자"),
                        fieldWithPath("num6").description("여섯번째숫자")
                    )
                ))
                .andExpect(jsonPath("num1", is(notNullValue())))
                .andExpect(jsonPath("num2", is(notNullValue())))
                .andExpect(jsonPath("num3", is(notNullValue())))
                .andExpect(jsonPath("num4", is(notNullValue())))
                .andExpect(jsonPath("num5", is(notNullValue())))
                .andExpect(jsonPath("num6", is(notNullValue())));
    }

    @Test
    public void testss(){
        System.out.println("test");
    }


       
}
