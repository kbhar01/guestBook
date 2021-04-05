package com.cognizant.guestBook.service;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.repository.GuestBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
}
