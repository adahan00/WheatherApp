package kg.geektech.newsapplite.ui.home;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.newsapplite.databinding.ItemNewsBinding;
import kg.geektech.newsapplite.models.News;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ItemNewsBinding newsBinding;
    private ArrayList<News> list  = new ArrayList<>();

    public void addItem(News news){
        this.list.add(news);
        notifyItemInserted(0);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        newsBinding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent , false);
        return new ViewHolder(newsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#88AAA5"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#6DBDA0"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            newsBinding = itemView;
        }

        public void onBind(News news) {
            newsBinding.textViewTitle.setText(news.getTitle());
            newsBinding.textViewCreated.setText(news.getCreatedAt());
        }
    }
}
