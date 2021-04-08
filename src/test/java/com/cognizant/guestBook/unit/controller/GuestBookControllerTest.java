package com.cognizant.guestBook.unit.controller;

import com.cognizant.guestBook.controller.GuestBookController;
import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.request.GuestBookRequest;
import com.cognizant.guestBook.response.GuestBookResponse;
import com.cognizant.guestBook.service.GuestBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuestBookController.class)
@ActiveProfiles("qa")
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestBookService guestBookService;

    @InjectMocks
    private ObjectMapper mapper;

    @Test
    public void getAllEntriesShouldReturnListOfEntries() throws Exception {
        GuestBookEntity g1=new GuestBookEntity(), g2=new GuestBookEntity();
        g1.setName("G1");g1.setComment("G1 Comment");
        g2.setName("G2");g2.setComment("G2 Comment");

        List<GuestBookEntity> guestBookEntities = Arrays.asList(g1, g2);


        RequestBuilder rq = get("/");

        when(guestBookService.getAllEntries()).thenReturn(guestBookEntities);

        this.mockMvc.perform(rq)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("G1"))
                .andExpect(jsonPath("$[0].comment").value("G1 Comment"))
                .andExpect(jsonPath("$[1].name").value("G2"))
                .andExpect(jsonPath("$[1].comment").value("G2 Comment"))
                .andDo(print());

    }

    @Test
    public void addNewCommentTestShouldReturnSuccessMessage() throws Exception {
        GuestBookRequest tempRequest = new GuestBookRequest();
        tempRequest.setName("Superman");
        tempRequest.setComment("I like to Fly.");

        RequestBuilder rq = post("/")
                .content(mapper.writeValueAsString(tempRequest))
                .contentType(MediaType.APPLICATION_JSON)
                ;

        GuestBookResponse testResponse = new GuestBookResponse();
        testResponse.setMessage("Comment is Successfully Created.");

        when(guestBookService.createComment(any())).thenReturn(testResponse);

        mockMvc.perform(rq)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("message").value("Comment is Successfully Created."))
                .andDo(print());
    }

}
