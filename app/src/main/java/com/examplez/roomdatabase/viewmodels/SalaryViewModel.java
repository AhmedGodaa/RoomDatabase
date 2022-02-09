package com.examplez.roomdatabase.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.examplez.roomdatabase.Repositories.EmployeeRepository;
import com.examplez.roomdatabase.Repositories.SalaryRepository;
import com.examplez.roomdatabase.database.MyDatabase;
import com.examplez.roomdatabase.listeners.DatabaseListener;
import com.examplez.roomdatabase.models.Salary;

import java.util.Date;
import java.util.List;

public class SalaryViewModel extends AndroidViewModel {
    private SalaryRepository salaryRepository;

    public SalaryViewModel(@NonNull Application application) {
        super(application);
        salaryRepository = new SalaryRepository(application);
    }

    public void InsertSalary(Salary salary) {
        salaryRepository.insertSalary(salary);
    }


    public void UpdateSalary(Salary salary) {
        salaryRepository.updateSalary(salary);

    }


    public void DeleteSalary(Salary salary) {
        salaryRepository.deleteSalary(salary);
    }


    public LiveData<List<Salary>> getEmployeeSalaries(long empId) {
        return salaryRepository.getEmployeeSalaries(empId);


    }


    public LiveData<List<Salary>> getEmployeeSalaries(long empId, Date from, Date to) {
        return salaryRepository.getEmployeeSalaries(empId, from, to);


    }

    public void getSalariesSum(long empId, DatabaseListener listener) {
        salaryRepository.getSalariesSum(empId, listener);
    }


}
