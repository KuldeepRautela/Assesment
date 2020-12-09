package com.example.assesment.jetpack.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.assesment.jetpack.dao.EmployeeDao;
import com.example.assesment.jetpack.model.Employee;

@Database(entities = Employee.class,version = 1)
public abstract class EmployeeDB  extends RoomDatabase {
    private static String DB_NAME ="EMPLOYEE_DB";
    private static  EmployeeDB employeeDB;
    public static Context context;
    public static EmployeeDB getInstance(){
        if(employeeDB==null)
            employeeDB = Room.databaseBuilder(context,EmployeeDB.class,DB_NAME).fallbackToDestructiveMigration().build();
        return employeeDB;
    }
    public abstract EmployeeDao getDaoInstance();
}
