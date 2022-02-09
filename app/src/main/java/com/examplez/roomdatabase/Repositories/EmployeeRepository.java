package com.examplez.roomdatabase.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.examplez.roomdatabase.dao.EmployeeDao;
import com.examplez.roomdatabase.database.MyDatabase;
import com.examplez.roomdatabase.models.Employee;
import com.examplez.roomdatabase.models.Salary;

import java.util.List;

public class EmployeeRepository {
    EmployeeDao employeeDao;


    public EmployeeRepository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        employeeDao = db.employeeDao();
    }

    public void insertEmployee(Employee... employee) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            employeeDao.insertEmployee(employee);
        });


    }


    public void updateEmployee(Employee... employee) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            employeeDao.updateEmployee(employee);
        });

    }


    public void deleteEmployee(Employee... employees) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            employeeDao.deleteEmployee(employees);
        });

    }


    public void deleteEmployee(String email) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            employeeDao.deleteEmployee(email);
        });

    }


    public LiveData<List<Salary>> getAllEmployees() {
        return employeeDao.getAllEmployees();


    }


    public LiveData<List<Salary>> getAllEmployeesByEmail(String email) {
        return employeeDao.getAllEmployeesByEmail(email);


    }


    public LiveData<List<Salary>> getAllEmployeesByName(String name) {
        return employeeDao.getAllEmployeesByName(name);


    }

}
