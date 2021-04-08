package com.cognizant.guestBook.controller;

import com.cognizant.guestBook.entity.GuestBookEntity;
import com.cognizant.guestBook.request.GuestBookRequest;
import com.cognizant.guestBook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping
    public ResponseEntity<?> getAllEntries() {
        List<GuestBookEntity> entries = guestBookService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    @PostMapping
    public ResponseEntity<?> addNewComment(@RequestBody GuestBookRequest guestBookRequest){
        return new ResponseEntity<>(guestBookService.createComment(guestBookRequest), HttpStatus.CREATED);
    }

}
