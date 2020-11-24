package br.ufjf.dcc196.caroliveira.filmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
        movieAdapter = new MovieAdapter(movies);
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
        startActivity(intent);
    }
}