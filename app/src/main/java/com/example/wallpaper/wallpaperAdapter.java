package com.example.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class wallpaperAdapter extends RecyclerView.Adapter<wallpaperViewHolder> {
    private Context context;
    private List<wallpaperModel> wallpaperModelList;

    public wallpaperAdapter(Context context, List<wallpaperModel> wallpaperModelList) {
        this.context = context;
        this.wallpaperModelList = wallpaperModelList;
    }

    @NonNull
    @Override
    public wallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new wallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wallpaperViewHolder holder, final int position) {
        Glide.with(context).load(wallpaperModelList.get(position).getMediumUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FullScreenWalpaper.class)
                        .putExtra("originalUrl", wallpaperModelList.get(position).getOriginalUrl())
                );
            }
        });

    }

    @Override
    public int getItemCount() {
        return wallpaperModelList.size();
    }
}

class wallpaperViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public wallpaperViewHolder(@Nullable View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewItem);
    }
}
