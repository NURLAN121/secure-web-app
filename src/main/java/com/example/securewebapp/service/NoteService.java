package com.example.securewebapp.service;

import com.example.securewebapp.model.Note;
import com.example.securewebapp.model.User;
import com.example.securewebapp.repository.NoteRepository;
import com.example.securewebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public List<Note> getNotesForUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return noteRepository.findByUser(user);
    }

    public void addNote(String content, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = new Note();
        note.setContent(content);
        note.setUser(user);

        noteRepository.save(note);
    }

    public void deleteNote(Long noteId, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        // 🔐 OWNERSHIP CHECK
        if (!note.getUser().getId().equals(user.getId())) {
            // deliberately 404 to avoid information disclosure
            throw new RuntimeException("Note not found");
        }

        noteRepository.delete(note);
    }
}
