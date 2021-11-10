package com.softwareEng.Daycare.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwareEng.Daycare.R;
import com.softwareEng.Daycare.Staff;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StaffRecyAdapter extends RecyclerView.Adapter<StaffRecyAdapter.StaffHolder> {

    ArrayList<Staff> staff;
    Context context;
    public StaffRecyAdapter(Context context, ArrayList<Staff> staff){
        this.staff = staff;
        this.context = context;
    }

    public class StaffHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile;
        TextView tvStaffName;
        TextView tvStaffType;
        public StaffHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvStaffName = (TextView) itemView.findViewById(R.id.tvStN);
            tvStaffType =(TextView) itemView.findViewById(R.id.tvStt);
//            ivProfile = itemView.findViewById(R.id.ivProfile);
        }
    }
    @NonNull
    @NotNull
    @Override
    public StaffRecyAdapter.StaffHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_layout,parent,false);
        StaffHolder staffHolder = new StaffHolder(view);
        return staffHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StaffRecyAdapter.StaffHolder holder, int position) {
//        holder.tvStaffType.setText(staff.get(position).getRole().getRole());
        holder.tvStaffName.setText(staff.get(position).getSurname()+" "+staff.get(position).getFirstName());
        Log.i("StaffS",staff.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        Log.i("size",""+staff.size());
        return staff.size();
    }
}
