package com.example.mynotesapps.database

import androidx.paging.DataSource
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * from note ORDER BY id ASC")
    //fun getAllNotes(): LiveData<List<Note>>
    fun getAllNotes(): DataSource.Factory<Int, Note>

    //menambahkan dummy note
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Note>)
}