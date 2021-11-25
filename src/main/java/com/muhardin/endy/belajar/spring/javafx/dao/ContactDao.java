package com.muhardin.endy.belajar.spring.javafx.dao;

import com.muhardin.endy.belajar.spring.javafx.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactDao extends PagingAndSortingRepository<Contact, String> {
}
