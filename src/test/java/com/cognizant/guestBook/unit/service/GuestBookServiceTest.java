package com.cognizant.guestBook.unit.service;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.repository.GuestBookRepo;
import com.cognizant.guestBook.request.GuestBookRequest;
import com.cognizant.guestBook.response.GuestBookResponse;
import com.cognizant.guestBook.service.GuestBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("qa")
public class GuestBookServiceTest {

    @InjectMocks
    private GuestBookService guestBookService;

    @Mock
    private GuestBookRepo guestBookRepo;

    @Test
    public void addCommentTest(){
        GuestBookRequest guestBookRequest = new GuestBookRequest();
        guestBookRequest.setName("Test Name");
        guestBookRequest.setComment("This is test comment.");

        GuestBookResponse actualResponse = guestBookService.createComment(guestBookRequest);
        GuestBookEntity savedEntity = new GuestBookEntity();
        savedEntity.setName(guestBookRequest.getName());
        savedEntity.setComment(guestBookRequest.getComment());
        verify(guestBookRepo).save(savedEntity);

        assertNotNull(actualResponse);
        assertNotNull(actualResponse.getMessage());
        assertEquals(actualResponse.getMessage(), "Comment is Successfully Created.");
    }

    @Test
    public void getListTest(){
        GuestBookEntity g1=new GuestBookEntity(), g2=new GuestBookEntity();
        g1.setId(1L);g1.setName("G1");g1.setComment("G1 Comment");
        g2.setId(2L);g2.setName("G2");g2.setComment("G2 Comment");

        List<GuestBookEntity> guestBookEntities = Arrays.asList(g1, g2);

        when(guestBookRepo.findAll()).thenReturn(guestBookEntities);

        List<GuestBookEntity> actualList = guestBookService.getAllEntries();

        assertNotNull(actualList);
        assertEquals(actualList, guestBookEntities);
    }

}
