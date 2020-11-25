package br.ufjf.dcc196.caroliveira.filmes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnMovieClickListener {
    public static final int REQUEST = 1;

    private RecyclerView recyclerViewMovies;
    private List<Movie> movies;
    private LinearLayoutManager layoutManager;
    private MovieAdapter movieAdapter;
    private ItemTouchHelper.SimpleCallback touchHelperCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = new ArrayList<Movie>(){{
            add(new Movie("A Órfã", "2009", "Terror", "Jaume Collet-Serra", false));
            add(new Movie("Uma linda mulher", "1990", "Romance", "Garry Marshall", true));
            add(new Movie("Minha Mãe é Uma Peça", "2013", "Comédia", "Andre Pellenz", false));
            add(new Movie("Eu Não Sou um Homem Fácil", "2018", "Comédia Romântica", "Éléonore Pourriat", true));
        }};

        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewMovies.setLayoutManager(layoutManager);
        movieAdapter = new MovieAdapter(movies, this);
        recyclerViewMovies.setAdapter(movieAdapter);

        touchHelperCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                movies.remove(viewHolder.getAdapterPosition());
                movieAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        new ItemTouchHelper(touchHelperCallback).attachToRecyclerView(recyclerViewMovies);
    }

    public void onButtonAddMovieClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateMovieActivity.class);
        startActivityForResult(intent, REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String title = data.getExtras().getString("title");
            String year = data.getExtras().getString("year");
            String style = data.getExtras().getString("style");
            String director = data.getExtras().getString("director");
            Boolean watched = data.getExtras().getBoolean("watched");
            Movie newMovie = new Movie(title, year, style, director, watched);
            movies.add(movies.size(), newMovie);
            movieAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Filme adicionado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMovieClick(View source, int position) {
        Boolean watched = !movies.get(position).getWatched();
        String message = watched ? "Já assisti!" : "Opa! Não vi ainda.";
        movies.get(position).setWatched(watched);
        movieAdapter.notifyItemChanged(position);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}