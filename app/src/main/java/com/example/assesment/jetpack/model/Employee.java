package com.example.assesment.jetpack.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee implements Parcelable {

//    Create an activity with a list of employees name, number, address and a picture of employee using sqlite database (You can use Room ORM if you know). On click of the list item one can check all details of the employee in another activity. On the second activity give an option to change the employee picture. Change picture should be captured from camera and should be stored in the database once it is captured.
//    Create another activity and use the following API to get data from the server and display these details in a list title,overview,release_date,vote_average and image. (Give a button in first activity to navigate in this functionality )
//    https://api.themoviedb.org/3/trending/movie/day?api_key=a9132f98accf2082321b03563d9668a8
//
//    You can use this api for display image (image path you will get in above api response as poster_path)
//    https://image.tmdb.org/t/p/w500/hBOH4PNnhcGPgZbZjBwkx9gnNxI.jpg

    private String name;
    @PrimaryKey
    @NonNull
    private String number;
    private String address;
    private String picture;

    public Employee(String name, String number, String address, String picture) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeString(this.address);
        dest.writeString(this.picture);
    }

    protected Employee(Parcel in) {
        this.name = in.readString();
        this.number = in.readString();
        this.address = in.readString();
        this.picture = in.readString();
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
