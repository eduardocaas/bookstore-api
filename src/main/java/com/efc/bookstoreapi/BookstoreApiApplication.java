package com.efc.bookstoreapi;

import com.efc.bookstoreapi.domain.Categoria;
import com.efc.bookstoreapi.domain.Livro;
import com.efc.bookstoreapi.repositories.CategoriaRepository;
import com.efc.bookstoreapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApiApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria c1 = new Categoria(null, "Informática" , "Livros de Programação");
        Livro l1 = new Livro(null, "Código Limpo" , "Robert Martin" , "Lorem ipsum dolor sit amet" , c1);

        c1.getLivros().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(c1));
        this.livroRepository.saveAll(Arrays.asList(l1));
    }
}
