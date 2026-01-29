package com.example.securewebapp.service;

import com.example.securewebapp.model.Note;
import com.example.securewebapp.model.User;
import com.example.securewebapp.repository.NoteRepository;
import com.example.securewebapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    void shouldAddNoteForUser() {

        User user = new User();
        user.setEmail("test@test.com");

        when(userRepository.findByEmail("test@test.com"))
                .thenReturn(java.util.Optional.of(user));


        noteService.addNote("hello", "test@test.com");


        verify(noteRepository, times(1)).save(any(Note.class));
    }
}
