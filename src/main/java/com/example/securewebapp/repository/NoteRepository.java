package com.example.securewebapp.repository;

import com.example.securewebapp.model.Note;
import com.example.securewebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);

    void deleteByIdAndUser(Long id, User user);
}
