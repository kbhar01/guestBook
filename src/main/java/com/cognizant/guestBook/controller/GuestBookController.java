package com.cognizant.guestBook.controller;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping
    public ResponseEntity<?> getAllEntries()
    {
        List<GuestBookEntity> entries = guestBookService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

}
