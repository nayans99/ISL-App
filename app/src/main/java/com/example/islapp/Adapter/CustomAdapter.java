package com.example.islapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.islapp.Pojo.CustomPojo;
import com.example.islapp.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    private final Context context;
    View view;
    MyViewHolder holder;
    //Creating an arraylist of POJO objects
    private ArrayList<CustomPojo> list_members = new ArrayList<>();
    ArrayList<String> s = new ArrayList<>();

    public CustomAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.custom_row, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CustomPojo list_items = list_members.get(position);
        holder.user_name.setText(list_items.getName());
        holder.content.setText(list_items.getContent());
        if(list_items.isDone())
            holder.done_img.setImageResource(R.drawable.tick);
    }

    //Setting the arraylist
    public void setListContent(ArrayList<CustomPojo> list_members) {
        this.list_members = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }

    public void setListContent1(ArrayList<String> list_members) {
        this.s = list_members;
        notifyItemRangeChanged(0, list_members.size());

    }


    @Override
    public int getItemCount() {
        return list_members.size();
    }

    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView user_name, content;
        ImageView done_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name = itemView.findViewById(R.id.user_name);
            content = itemView.findViewById(R.id.content);
            done_img = itemView.findViewById(R.id.done);

        }

        @Override
        public void onClick(View v) {

        }
    }

}
