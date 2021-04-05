package com.cognizant.guestBook.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="guest_book")
@Data
public class GuestBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String comment;
}
