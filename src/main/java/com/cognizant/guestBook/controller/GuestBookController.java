package com.cognizant.guestBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class GuestBookController {

    @GetMapping
    public ResponseEntity<?> getAllEntries()
    {
        List<String> listOfString = Arrays.asList("ABD");
        return ResponseEntity.ok(listOfString);
    }

}
