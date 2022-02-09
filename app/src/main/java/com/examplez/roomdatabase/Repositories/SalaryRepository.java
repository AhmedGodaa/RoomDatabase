package com.examplez.roomdatabase.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.examplez.roomdatabase.dao.EmployeeDao;
import com.examplez.roomdatabase.dao.SalaryDao;
import com.examplez.roomdatabase.database.MyDatabase;
import com.examplez.roomdatabase.listeners.DatabaseListener;
import com.examplez.roomdatabase.models.Employee;
import com.examplez.roomdatabase.models.Salary;

import java.util.Date;
import java.util.List;

public class SalaryRepository {

    SalaryDao salaryDao;

    public SalaryRepository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        salaryDao = db.salaryDao();

    }


    public void insertSalary(Salary salary) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            salaryDao.InsertSalary(salary);
        });

    }


    public void updateSalary(Salary salary) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            salaryDao.UpdateSalary(salary);
        });


    }


    public void deleteSalary(Salary salary) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            salaryDao.DeleteSalary(salary);
        });


    }


    public LiveData<List<Salary>> getEmployeeSalaries(long empId) {
        return salaryDao.getEmployeeSalaries(empId);


    }


    public  LiveData<List<Salary>> getEmployeeSalaries(long empId, Date from, Date to) {
        return salaryDao.getEmployeeSalaries(empId, from, to);


    }

    public void getSalariesSum(long empId, DatabaseListener listener) {
        MyDatabase.databaseWriteExecutor.execute(() -> {
            double value = salaryDao.getSalariesSum(empId);
            listener.onValueSubmit(value);
        });

    }


}
