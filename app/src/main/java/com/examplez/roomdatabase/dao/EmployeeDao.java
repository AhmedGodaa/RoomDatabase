package com.examplez.roomdatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.examplez.roomdatabase.converters.DateConverter;
import com.examplez.roomdatabase.models.Employee;
import com.examplez.roomdatabase.models.Salary;

import java.util.List;

@Dao
@TypeConverters({DateConverter.class})
public interface EmployeeDao {
    @Insert
    void insertEmployee(Employee... employee);

    @Update
    void updateEmployee(Employee... employee);

    @Delete
    void deleteEmployee(Employee... employees);

    @Query("DELETE FROM Employee WHERE email =:email")
    LiveData<List<Salary>> deleteEmployee(String email);

    @Query("SELECT * FROM Employee ORDER BY name ASC")
    LiveData<List<Salary>> getAllEmployees();

    @Query("SELECT * FROM Employee WHERE email=:email")
    LiveData<List<Salary>> getAllEmployeesByEmail(String email);

    @Query("SELECT * FROM Employee WHERE name LIKE '%'||:name||'%'")
    LiveData<List<Salary>> getAllEmployeesByName(String name);





}
