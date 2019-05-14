package com.example.mvvm_must.Student;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void insert(Student student);

    @Update
    public void update(Student student);

    @Delete
    public void delete(Student student);

    @Query("DELETE FROM student_table")
    public void deleteAll();

    @Query("SELECT * FROM student_table ORDER BY ASC id")
    LiveData<List<Student>> getAll;
}
