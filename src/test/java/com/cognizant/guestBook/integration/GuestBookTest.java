package com.cognizant.guestBook.integration;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.repository.GuestBookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("qa")
@AutoConfigureRestDocs
public class GuestBookTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GuestBookRepo guestBookRepo;

    @Test
    public void getAllEntriesTest() throws Exception {

        GuestBookEntity guestBookEntity = new GuestBookEntity();
        guestBookEntity.setName("TestName");
        guestBookEntity.setComment("TestComment");
        guestBookRepo.save(guestBookEntity);

        RequestBuilder requestBuilder = get("/");
        mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andDo(print())
        .andDo(document("Guest Book", responseFields(
                fieldWithPath("[0].name").description("Name of Guest."),
                fieldWithPath("[0].comment").description("Guest Comment.")
        )))

        ;
    }

}
