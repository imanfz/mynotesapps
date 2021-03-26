package com.example.mynotesapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mynotesapps.database.Note
import com.example.mynotesapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    //fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
    /* LivePagedListBuilder digunakan untuk merubah DataSource menjadi PagedList dalam bentuk LiveData.
    PagedList adalah daftar yang memuat data dalam potongan (halaman) dari DataSource. */
    fun getAllNotes(): LiveData<PagedList<Note>> = LivePagedListBuilder(mNoteRepository.getAllNotes(), 20).build()
}