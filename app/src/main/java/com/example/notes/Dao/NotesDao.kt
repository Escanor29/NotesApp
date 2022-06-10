package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Entity.Notes

@Dao
abstract class NotesDao {

    @Query("SELECT * FROM Notes")
    abstract fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    abstract fun deleteNotes(id: Int)

    @Update
    abstract fun updateNotes(notes: Notes)

}