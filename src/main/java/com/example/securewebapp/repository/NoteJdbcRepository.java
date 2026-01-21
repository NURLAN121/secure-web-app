package com.example.securewebapp.repository;

import com.example.securewebapp.model.Note;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public NoteJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Note> findNotesByUserId(Long userId) {
        return jdbcTemplate.query(
                "SELECT id, content FROM notes WHERE user_id = ?",
                new Object[]{userId},
                (rs, rowNum) -> {
                    Note note = new Note();
                    note.setId(rs.getLong("id"));
                    note.setContent(rs.getString("content"));
                    return note;
                }
        );
    }
}
