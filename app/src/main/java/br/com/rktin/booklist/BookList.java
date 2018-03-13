package br.com.rktin.booklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class BookList extends AppCompatActivity {

    private ListView listBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        listBooks = findViewById(R.id.list_books);

        //access AddBook page
        Button button = findViewById(R.id.add_book_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddPage = new Intent(BookList.this, addBookForm.class);
                startActivity(goToAddPage);
            }
        });

    }
}
