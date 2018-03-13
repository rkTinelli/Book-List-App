package br.com.rktin.booklist;

import android.widget.EditText;
import android.widget.Spinner;

import br.com.rktin.booklist.modelo.Book;

/**
 * Created by rktin on 3/12/2018.
 */

public class form_helper {

    private final EditText campoNome;
    private final Spinner campoCategoria;
    private final EditText campoPreco;

    public  form_helper(addBookForm activity){
        campoNome = (EditText) activity.findViewById(R.id.form_nome_livro);
        campoCategoria = (Spinner) activity.findViewById(R.id.form_genero_livro);
        campoPreco = (EditText) activity.findViewById(R.id.form_preco_livro);
    }

    public Book getBook() {
        Book book = new Book();
        book.setNome(campoNome.getText().toString());
        book.setCategoria(campoCategoria.getSelectedItem().toString());
        book.setPreco(campoPreco.getText().toString());
        return book;
    }
}
