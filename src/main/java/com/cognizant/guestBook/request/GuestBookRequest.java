package com.cognizant.guestBook.request;

import lombok.Data;

@Data
public class GuestBookRequest {
    private String name;
    private String comment;
}
