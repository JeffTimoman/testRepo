package com.devtiro.database.devtirodatabase.dao.impl;

import com.devtiro.database.devtirodatabase.dao.AuthorDao;
import com.devtiro.database.devtirodatabase.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        int updated = jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)", author.getId(), author.getName(), author.getAge());
    }

    @Override
    public Optional<Author> findOne(long l) {
        return Optional.empty();
    }

    public static class AuthorRowMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
