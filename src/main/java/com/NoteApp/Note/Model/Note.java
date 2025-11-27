package com.NoteApp.Note.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private int noteId;
    @Column(name = "note_title")
    private String noteTitle;
    @Column(name = "note_desc")
    private String noteDesc;
    @Column(name = "note_date")
    private LocalDate noteDate;
    @Column(name = "note_time")
    private String noteTime;
    @PrePersist
    public void setTimestamps() {
        this.noteDate = LocalDate.now();
        this.noteTime = LocalTime.now().toString();
    }

}
