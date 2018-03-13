package br.com.rktin.booklist;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rktin.booklist.modelo.Book;

public class addBookForm extends AppCompatActivity {

    private form_helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_form);

        helper = new form_helper(this);

        loadSpinnerContent();
    }

    private void loadSpinnerContent() {
        //Load Adapter with content
        Spinner spinner = findViewById(R.id.form_genero_livro);

        ArrayAdapter<String> spinnesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.genero)){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnesAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_form,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.confirm_book:
                Book book = helper.getBook();
                VerifyAndSaveBook(book);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void VerifyAndSaveBook(Book book) {
        if (book.getNome().isEmpty()) {
            Toast.makeText(this, "Nome inválido", Toast.LENGTH_SHORT).show();
            return;
        } else if (book.getCategoria().equals("Categoria")){
            Toast.makeText(this, "Categoria inválida", Toast.LENGTH_SHORT).show();
            return;
        } else if (book.getPreco().isEmpty()){
            Toast.makeText(this, "Preço inválido", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "Livro \"" + book.getNome() + "\" salvo!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
