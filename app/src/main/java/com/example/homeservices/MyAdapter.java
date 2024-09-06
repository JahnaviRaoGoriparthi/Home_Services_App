package com.example.homeservices;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;
    private OnItemClickListener listener;


    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.nameTextView.setText(item.getName());
        holder.mobileTextView.setText(item.getMobile());
        holder.addressTextView.setText(item.getAddress());
        holder.itemView.setSelected(item.isSelected());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView mobileTextView;
        public TextView addressTextView;
        Button booking;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            mobileTextView = itemView.findViewById(R.id.mobileTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            booking=itemView.findViewById(R.id.book_now);


          booking.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  int position = getAdapterPosition();
                  Item item=itemList.get(position);
                  String name=item.getName().toString();
                  String mobile=item.getMobile();
                  String address=item.getAddress();

                  Intent i=new Intent(addressTextView.getContext(),ConfirmServiceProvider.class);
                  i.putExtra("SPname",name);
                  i.putExtra("SPmobile",mobile);
                  i.putExtra("SPaddress",address);
                  addressTextView.getContext().startActivity(i);
              }

          });
        }
    }
}