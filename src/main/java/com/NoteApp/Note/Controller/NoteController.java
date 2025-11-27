package com.NoteApp.Note.Controller;

import com.NoteApp.Note.DTO.NoteRequest;
import com.NoteApp.Note.DTO.NoteResponse;
import com.NoteApp.Note.Model.Note;
import com.NoteApp.Note.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService service;

    @GetMapping("/")
    public String getStart(){
        return  "redirect:/notes";
    }
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return service.findAll();
    }

    @GetMapping("/notes/new")
    public String createNoteObj(Model model){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        LocalTime time1 = LocalTime.now().minusHours(12);
        String noteTime = time1.format(dateTimeFormatter);
       // model.addAttribute("noteObj" , new Note(0,null,null, LocalDate.now(),noteTime));
        return "note_form";
    }

    @PostMapping("/notes")
    public ResponseEntity<?> saveNoteObj(@RequestBody NoteRequest note) {
        NoteResponse saveNote = service.newNote(note);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "status", "SUCCESS",
                        "message", "Note saved successfully",
                        "data", saveNote
                ));
    }


    @PostMapping("/update")
    public String updateNoteObj(NoteRequest note, RedirectAttributes redirectAttributes){
        service.newNote(note);
        redirectAttributes.addFlashAttribute("message","Updated");
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable(name = "id") int id,RedirectAttributes redirectAttributes){
        service.deleteNote(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String getNoteByID(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("tempNote" , service.getNoteById(id));
        return "update_form";
    }
}
