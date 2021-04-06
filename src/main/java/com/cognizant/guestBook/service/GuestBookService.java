package com.cognizant.guestBook.service;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.repository.GuestBookRepo;
import com.cognizant.guestBook.request.GuestBookRequest;
import com.cognizant.guestBook.response.GuestBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepo guestBookRepo;

    public List<GuestBookEntity> getAllEntries()
    {
        return this.guestBookRepo.findAll();
    }

    public GuestBookResponse createComment(GuestBookRequest guestBookRequest) {
        GuestBookEntity savedEntity = new GuestBookEntity();
        savedEntity.setName(guestBookRequest.getName());
        savedEntity.setComment(guestBookRequest.getComment());

        guestBookRepo.save(savedEntity);

        GuestBookResponse response = new GuestBookResponse();
        response.setMessage("Comment is Successfully Created.");

        return response;
    }
}
