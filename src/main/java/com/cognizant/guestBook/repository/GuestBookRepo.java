package com.cognizant.guestBook.repository;

import com.cognizant.guestBook.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBookRepo extends JpaRepository<GuestBookEntity, Long> {

}
