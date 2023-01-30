package com.efc.bookstoreapi.services;

import com.efc.bookstoreapi.domain.Categoria;
import com.efc.bookstoreapi.domain.Livro;
import com.efc.bookstoreapi.repositories.CategoriaRepository;
import com.efc.bookstoreapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDB() {

        Categoria c1 = new Categoria(null, "Informática" , "Livros de Programação");
        Categoria c2 = new Categoria(null, "Literatura Brasileira" , "Livros de Literatura");
        Categoria c3 = new Categoria(null, "Ficção Científica" , "Livros de Ficção");

        Livro l1 = new Livro(null, "Código Limpo" , "Robert Martin" , "Lorem ipsum dolor sit amet" , c1);
        Livro l2 = new Livro(null, "Sistemas de Banco de Dados" , "Navathe" , "Lorem ipsum dolor sit amet" , c1);
        Livro l3 = new Livro(null, "O cortiço" , "Aluísio Azevedo" , "Lorem ipsum dolor sit amet" , c2);
        Livro l4 = new Livro(null, "Auto da Compadecida" , "Ariano Suassuna" , "Lorem ipsum dolor sit amet" , c2);
        Livro l5 = new Livro(null, "O Alienista" , "Machado de Assis" , "Lorem ipsum dolor sit amet" , c2);

        c1.getLivros().addAll(Arrays.asList(l1, l2));
        c2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        this.categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
}
