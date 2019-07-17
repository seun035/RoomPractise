package com.oluwaseun.liadi.cantactroompractise.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ContactDao {

    @Insert
    public long createContact(Contact contact);


    @Delete
    public int deleteContact(Contact contact);


    @Update
    public int updateContact(Contact contact);


    @Query("SELECT * FROM contacts")
    public List<Contact> getAllContact();
}
