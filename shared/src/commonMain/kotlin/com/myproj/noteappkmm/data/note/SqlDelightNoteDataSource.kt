package com.myproj.noteappkmm.data.note

import com.myproj.noteappkmm.domain.note.Note
import com.myproj.noteappkmm.domain.note.NoteDataSource
import com.myproj.noteappkmm.domain.time.DateTimeUtil
import com.plcoding.noteappkmm.database.NoteDatabase

class SqlDelightNoteDataSource(db: NoteDatabase): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}