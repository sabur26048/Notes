package com.NoteApp.Note.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {
    private String noteTitle;
    private String noteDesc;
}
