package com.techie.spring.cassandra.api.repository;

import com.techie.spring.cassandra.api.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book,String> {
}
