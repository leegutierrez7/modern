package com.library.modern.repository;

import com.library.modern.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>  {

}
