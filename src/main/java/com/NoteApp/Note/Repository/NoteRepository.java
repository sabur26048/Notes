package com.NoteApp.Note.Repository;

import com.NoteApp.Note.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note ,Integer> {
}
