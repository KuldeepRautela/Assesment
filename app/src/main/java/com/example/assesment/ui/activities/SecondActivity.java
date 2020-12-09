package com.example.assesment.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.assesment.R;
import com.example.assesment.jetpack.model.Employee;
import com.example.assesment.jetpack.viewmodels.EmployeeViewModel;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private CircleImageView imageView;
    private EmployeeViewModel employeeViewModel;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        employee = getIntent().getParcelableExtra("data");
        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        populateData();
    }

    private void populateData() {
        TextView name = findViewById(R.id.id_name);
        TextView address = findViewById(R.id.id_address);
        TextView phone = findViewById(R.id.id_number);
        imageView = findViewById(R.id.id_img);
        if(!employee.getPicture().equals("")) {
            Log.e("uri is ",employee.getPicture());
            Glide.with(getApplicationContext()).load(Uri.parse(employee.getPicture())).into(imageView);
        }
        name.setText("Name : " + employee.getName());
        phone.setText("Ph No : " + employee.getNumber());
        address.setText("Address : " + employee.getAddress());
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Log.e("exception ", e.getLocalizedMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            imageView.setImageBitmap(imageBitmap);
            String tempUri = getImageUri(getApplicationContext(), imageBitmap);
            Log.e("uri is ",tempUri);
            Glide.with(getApplicationContext()).load(Uri.parse(tempUri)).into(imageView);
            employeeViewModel.updateEmployeeData(tempUri, employee.getNumber());
        }
    }

    public String getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return path;
    }

    public void goToMovie(View view) {
        startActivity(new Intent(this, FinalAcivity.class));
    }
}
