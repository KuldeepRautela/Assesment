package com.example.assesment.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assesment.OnclickItem;
import com.example.assesment.R;
import com.example.assesment.jetpack.model.Employee;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<Employee> employeeList;
    private OnclickItem onclickItem;
    private Context context;
    public EmployeeAdapter(OnclickItem onclickItem ,List<Employee> employeeList){
        this.employeeList=employeeList;
        this.onclickItem = onclickItem;
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new EmployeeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private CircleImageView imageView;
        public EmployeeViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.id_img);
            nameTextView = itemView.findViewById(R.id.id_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickItem.onClickItem(getAdapterPosition());
                }
            });
        }

        public void bind(int position) {
            nameTextView.setText(employeeList.get(position).getName());
            if (!employeeList.get(position).getPicture().equals("")) {
                Glide.with(context).load(Uri.parse(employeeList.get(position).getPicture())).into(imageView);
//                Glide.with(context).load(employeeList.get(position).getPicture()).into(imageView);

            }
        }
    }
}

