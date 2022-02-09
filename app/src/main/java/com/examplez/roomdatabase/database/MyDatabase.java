package com.examplez.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.examplez.roomdatabase.dao.EmployeeDao;
import com.examplez.roomdatabase.dao.SalaryDao;
import com.examplez.roomdatabase.models.Employee;
import com.examplez.roomdatabase.models.Salary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class, Salary.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    public abstract SalaryDao salaryDao();

    // عمل object واحد من ال database لتنجنب اني كل شويه اعمل instance في كل كلاس مبدا SINGLETON
//    object واحد علي مستوي المشورع
    private static volatile MyDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "my_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}