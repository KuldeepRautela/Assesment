package com.example.assesment.jetpack.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assesment.jetpack.model.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployeeData(List<Employee> employees);

    @Query("select * from Employee")
    LiveData<List<Employee>> getEmployeeData();

    @Query("update Employee SET picture =:pic where number =:num")
    void updateEmployeeData(String pic,String num);
}
