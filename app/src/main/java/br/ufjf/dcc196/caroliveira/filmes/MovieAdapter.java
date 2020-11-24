package br.ufjf.dcc196.caroliveira.filmes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View movieView = inflater.inflate(R.layout.movie_layout, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(movieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.textViewTitle.setText(movies.get(position).getTitle());
        holder.textViewYear.setText(movies.get(position).getYear());
        holder.textViewStyle.setText(movies.get(position).getStyle());
        holder.textViewDirector.setText("de " + movies.get(position).getDirector());
        holder.textViewWatched.setText(movies.get(position).getWatched()? "Já assistido" : "Não asssistido");
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewYear;
        private TextView textViewStyle;
        private TextView textViewDirector;
        private TextView textViewWatched;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewYear = itemView.findViewById(R.id.textViewYear);
            textViewStyle = itemView.findViewById(R.id.textViewStyle);
            textViewDirector = itemView.findViewById(R.id.textViewDirector);
            textViewWatched = itemView.findViewById(R.id.textViewWatched);
        }
    }
}
