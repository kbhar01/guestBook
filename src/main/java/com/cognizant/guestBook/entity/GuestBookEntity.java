package com.cognizant.guestBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="guest_book")
@Data
public class GuestBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String name;
    private String comment;
}
