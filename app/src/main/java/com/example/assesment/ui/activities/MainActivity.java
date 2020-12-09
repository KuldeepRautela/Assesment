package com.example.assesment.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.assesment.OnclickItem;
import com.example.assesment.R;
import com.example.assesment.jetpack.model.Employee;
import com.example.assesment.jetpack.room.EmployeeDB;
import com.example.assesment.jetpack.viewmodels.EmployeeViewModel;
import com.example.assesment.ui.adapters.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnclickItem {
    private EmployeeViewModel employeeViewModel;
    private List<Employee> employeeList =new ArrayList<>();
    private  EmployeeAdapter employeeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmployeeDB.context = getApplicationContext();
        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        populateList();
        employeeViewModel.getEmployeeData().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                if (employees.size()==0)
                    employeeViewModel.insertEmployeeData(populateList());
                else {
                    employeeList.clear();
                    employeeList.addAll(employees);
                    employeeAdapter.notifyDataSetChanged();
                }
            }
        });
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        employeeAdapter = new EmployeeAdapter(this, employeeList);
        RecyclerView recyclerView = findViewById(R.id.id_recyclerView);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Employee> populateList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Kuldeep", "9584789584", "Delhi", ""));
        list.add(new Employee("Kartik", "9488789584", "Delhi", ""));
        list.add(new Employee("Rahul", "7584789584", "Banglore", ""));
        list.add(new Employee("Ramesh", "8584789584", "Mumbai", ""));
        return list;
    }

    @Override
    public void onClickItem(int position) {
        Log.e("postion ", position + "");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("data", employeeList.get(position));
        startActivity(intent);
    }
}
