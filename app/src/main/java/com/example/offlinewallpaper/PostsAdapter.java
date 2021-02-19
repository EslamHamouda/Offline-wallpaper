package com.example.offlinewallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private Context context;
    private int[] placeList;

    public PostsAdapter(int[] postItems,Context context){
       this.context=context;
        this.placeList=postItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container, parent,
                        false
                );
                return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageView.setImageResource(placeList[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(context,DetailActivity.class);
intent.putExtra("Image",placeList[holder.getAdapterPosition()]);
context.startActivity(intent);
            }
        });
//******************************************************************

    }

    @Override
    public int getItemCount() {
        return placeList.length;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ViewHolder( View view){
            super(view);
            imageView=view.findViewById(R.id.imagePost);
        }
    }
}
