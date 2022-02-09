package com.examplez.roomdatabase.viewmodels;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.examplez.roomdatabase.Repositories.EmployeeRepository;
import com.examplez.roomdatabase.database.MyDatabase;
import com.examplez.roomdatabase.models.Employee;
import com.examplez.roomdatabase.models.Salary;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository employeeRepository;

//    private final LiveData<List<Employee>> mAllEmployee;

    public EmployeeViewModel(Application application) {
        super(application);
        employeeRepository = new EmployeeRepository(application);
//        mAllWords = mRepository.getAllWords();
//        mAllEmployee = employeeRepository.get
    }

    public void insertEmployee(Employee... employee) {
        employeeRepository.insertEmployee(employee);

    }


    public void updateEmployee(Employee... employee) {
        employeeRepository.updateEmployee(employee);

    }


    public void deleteEmployee(Employee... employees) {
        employeeRepository.deleteEmployee(employees);
    }


    public void deleteEmployee(String email) {
        employeeRepository.deleteEmployee(email);
    }


    public LiveData<List<Salary>> getAllEmployees() {
        return employeeRepository.getAllEmployees();


    }


    public LiveData<List<Salary>> getAllEmployeesByEmail(String email) {
        return employeeRepository.getAllEmployeesByEmail(email);


    }


    public LiveData<List<Salary>> getAllEmployeesByName(String name) {
        return employeeRepository.getAllEmployeesByName(name);


    }

}
