package com.ktech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ktech.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	boolean existsBybookName(String bookName);
}
