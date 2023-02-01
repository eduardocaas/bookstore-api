package com.efc.bookstoreapi.services;

import com.efc.bookstoreapi.domain.Categoria;
import com.efc.bookstoreapi.dtos.CategoriaDTO;
import com.efc.bookstoreapi.exceptions.ObjectNotFoundException;
import com.efc.bookstoreapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findById(Integer id) {

        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repo.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        if (objDto.getNome() != null) {
            obj.setNome(objDto.getNome());
        }
        if (objDto.getDescricao() != null) {
            obj.setDescricao(objDto.getDescricao());
        }
        return repo.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repo.deleteById(id);
    }
}
