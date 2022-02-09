package com.examplez.roomdatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.examplez.roomdatabase.models.Salary;

import java.util.Date;
import java.util.List;

@Dao
public interface SalaryDao {
    @Insert
    public void InsertSalary(Salary salary);

    @Update
    public void UpdateSalary(Salary salary);

    @Delete
    public void DeleteSalary(Salary salary);

    @Query("SELECT * FROM salary WHERE empId=:empId ORDER BY date DESC")
    LiveData<List<Salary>> getEmployeeSalaries(long empId);

    @Query("SELECT * FROM salary WHERE empId=:empId AND date>= :from AND date <=:to ORDER BY date DESC")
    LiveData<List<Salary>> getEmployeeSalaries(long empId, Date from, Date to);

    @Query("SELECT sum(amount) FROM salary WHERE empId = :empId ")
    Double getSalariesSum(long empId);

}
