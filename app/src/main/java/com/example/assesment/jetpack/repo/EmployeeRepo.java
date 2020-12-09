package com.example.assesment.jetpack.repo;

import androidx.lifecycle.LiveData;

import com.example.assesment.jetpack.dao.EmployeeDao;
import com.example.assesment.jetpack.model.Employee;
import com.example.assesment.jetpack.room.EmployeeDB;

import java.util.List;

public class EmployeeRepo {
    private EmployeeDao employeeDao = EmployeeDB.getInstance().getDaoInstance();

    public void insertEmployeeData(final List<Employee> employees) {
    new Thread(){
        @Override
        public void run() {
            super.run();
        employeeDao.insertEmployeeData(employees);
        }
    }.start();
    }
    public LiveData<List<Employee>> getEmployeeData(){
        return employeeDao.getEmployeeData();
    }
    public void updateEmployeeData(final String pic, final String num) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                employeeDao.updateEmployeeData(pic,num);
            }
        }.start();
    }
}
