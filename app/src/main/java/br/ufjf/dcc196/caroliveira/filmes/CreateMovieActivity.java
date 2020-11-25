package br.ufjf.dcc196.caroliveira.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
        finish();
    }

    public void onButtonAddClick(View view) {
        String title = editTextTitle.getText().toString();
        String year = editTextYear.getText().toString();
        String style = editTextStyle.getText().toString();
        String director = editTextDirector.getText().toString();

        if (title.isEmpty()){
            editTextTitle.requestFocus();
        } else if (year.isEmpty()){
            editTextYear.requestFocus();
        } else if (style.isEmpty()){
            editTextStyle.requestFocus();
        } else if (director.isEmpty()){
            editTextDirector.requestFocus();
        } else {
            Intent result = new Intent();
            result.putExtra("title", title);
            result.putExtra("year", year);
            result.putExtra("style", style);
            result.putExtra("director", director);
            result.putExtra("watched", checkBoxWatched.isChecked());
            setResult(RESULT_OK, result);
            finish();
        }
    }
}