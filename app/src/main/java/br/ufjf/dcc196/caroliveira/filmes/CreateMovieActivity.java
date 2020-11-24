package br.ufjf.dcc196.caroliveira.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMovieActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextYear;
    private EditText editTextStyle;
    private EditText editTextDirector;
    private CheckBox checkBoxWatched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextYear = findViewById(R.id.editTextYear);
        editTextStyle = findViewById(R.id.editTextStyle);
        editTextDirector = findViewById(R.id.editTextDirector);
        checkBoxWatched = findViewById(R.id.checkBoxWatched);
    }

    public void onButtonCancelClick(View view) {
        String title = editTextTitle.getText().toString();
        String year = editTextYear.getText().toString();
        String style = editTextStyle.getText().toString();
        String director = editTextDirector.getText().toString();
        Boolean watched = checkBoxWatched.isChecked();
        Movie newMovie = new Movie(title, year, style, director, watched);
        finish();
    }

    public void onButtonAddClick(View view) {
        finish();
    }
}