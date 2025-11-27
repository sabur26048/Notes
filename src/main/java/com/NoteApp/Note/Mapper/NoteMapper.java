package com.NoteApp.Note.Mapper;

import com.NoteApp.Note.DTO.NoteRequest;
import com.NoteApp.Note.DTO.NoteResponse;
import com.NoteApp.Note.Model.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public Note toEntity(NoteRequest request) {
        Note note = new Note();
        note.setNoteTitle(request.getNoteTitle());
        note.setNoteDesc(request.getNoteDesc());
        return note;
    }

    public NoteResponse toDto(Note note) {
        NoteResponse res = new NoteResponse();
        res.setNoteId(note.getNoteId());
        res.setNoteTitle(note.getNoteTitle());
        res.setNoteDesc(note.getNoteDesc());
        res.setNoteDate(note.getNoteDate().toString());
        res.setNoteTime(note.getNoteTime());
        return res;
    }
}
