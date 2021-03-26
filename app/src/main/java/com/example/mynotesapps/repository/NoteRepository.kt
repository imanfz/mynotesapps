package com.example.mynotesapps.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.mynotesapps.database.Note
import com.example.mynotesapps.database.NoteDao
import com.example.mynotesapps.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

//    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun getAllNotes(): DataSource.Factory<Int, Note> {
        return mNotesDao.getAllNotes()
    }

    fun insert(note: Note) {
        executorService.execute { mNotesDao.insert(note) }
    }

    fun delete(note: Note) {
        executorService.execute { mNotesDao.delete(note) }
    }

    fun update(note: Note) {
        executorService.execute { mNotesDao.update(note) }
    }
}