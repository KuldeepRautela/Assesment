package com.example.assesment.jetpack.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.assesment.jetpack.model.Employee;
import com.example.assesment.jetpack.repo.EmployeeRepo;

import java.util.List;

public class EmployeeViewModel extends ViewModel {
    private EmployeeRepo employeeRepo = new EmployeeRepo();

    public void insertEmployeeData(List<Employee> employees) {
        employeeRepo.insertEmployeeData(employees);
    }

    public LiveData<List<Employee>> getEmployeeData() {
        return employeeRepo.getEmployeeData();
    }
    public void updateEmployeeData(final String pic, final String num) {
        employeeRepo.updateEmployeeData(pic,num);
    }
}
