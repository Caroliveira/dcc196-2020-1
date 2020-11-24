package br.ufjf.dcc196.caroliveira.filmes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMovies;
    private List<Movie> movies;

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
    }
}