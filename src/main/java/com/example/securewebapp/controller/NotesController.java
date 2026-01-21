package com.example.securewebapp.controller;

import com.example.securewebapp.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String notes(Model model, Authentication authentication) {
        String email = authentication.getName();
        model.addAttribute("notes", noteService.getNotesForUser(email));
        return "notes";
    }

    @PostMapping("/notes")
    public String addNote(@RequestParam String content,
                          Authentication authentication) {

        noteService.addNote(content, authentication.getName());
        return "redirect:/notes";
    }

    @PostMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable Long id,
                             Authentication authentication) {

        noteService.deleteNote(id, authentication.getName());
        return "redirect:/notes";
    }
}
