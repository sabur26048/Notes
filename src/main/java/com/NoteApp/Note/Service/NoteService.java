package com.NoteApp.Note.Service;

import com.NoteApp.Note.DTO.NoteRequest;
import com.NoteApp.Note.DTO.NoteResponse;
import com.NoteApp.Note.Mapper.NoteMapper;
import com.NoteApp.Note.Model.Note;
import com.NoteApp.Note.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteMapper noteMapper ;

    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    public NoteResponse newNote(NoteRequest dto){
        Note note = noteMapper.toEntity(dto);
        return noteMapper.toDto(noteRepository.save(note));
    }
    public void deleteNote(Integer id){
        noteRepository.deleteById(id);
    }

    public Note getNoteById(int id){
        Note tempNote = noteRepository.findById(id).get();
        return tempNote;
    }
}
