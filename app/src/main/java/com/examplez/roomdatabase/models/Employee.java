package com.examplez.roomdatabase.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.examplez.roomdatabase.converters.DateConverter;

import java.util.Date;

@TypeConverters({DateConverter.class})
@Entity
public class Employee {
    @PrimaryKey()
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private Date birthday;

    public Employee(@NonNull Long id, String name, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public Employee() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
