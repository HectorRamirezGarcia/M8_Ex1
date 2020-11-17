package com.example.m8_ex1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterIn extends RecyclerView.Adapter<AdapterIn.ViewHolderIn> {
    ArrayList<Incidencia> list;
    public AdapterIn(ArrayList<Incidencia> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderIn onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_in, parent, false);
        ViewHolderIn vh = new ViewHolderIn(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderIn holder, int position) {
        holder.Id.setText(list.get(position).getNameIn());
        holder.NameIn.setText(list.get(position).getSpinner());
        holder.Spinner.setText(list.get(position).getSpinner());
    }

    @Override
    public int getItemCount()  {
        return list.size();
    }

    public class ViewHolderIn extends RecyclerView.ViewHolder {
        TextView Id;
        TextView NameIn;
        TextView Spinner;
        public ViewHolderIn(@NonNull View itemView) {
            super(itemView);
            Id = itemView.findViewById(R.id.Id);
            NameIn = itemView.findViewById(R.id.NameIn);
            Spinner = itemView.findViewById(R.id.Category);
        }
    }
}
