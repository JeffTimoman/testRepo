package com.devtiro.database.devtirodatabase.dao;

import com.devtiro.database.devtirodatabase.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
