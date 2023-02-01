package com.efc.bookstoreapi.services;

import com.efc.bookstoreapi.domain.Livro;
import com.efc.bookstoreapi.exceptions.ObjectNotFoundException;
import com.efc.bookstoreapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public Livro findById(Integer id) {

        Optional<Livro> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
    }

}
