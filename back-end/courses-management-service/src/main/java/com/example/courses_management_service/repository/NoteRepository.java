package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository  extends MongoRepository<Note, String> {
}
