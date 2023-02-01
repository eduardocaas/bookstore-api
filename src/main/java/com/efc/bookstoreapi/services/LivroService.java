package com.efc.bookstoreapi.services;

import com.efc.bookstoreapi.domain.Categoria;
import com.efc.bookstoreapi.domain.Livro;
import com.efc.bookstoreapi.exceptions.ObjectNotFoundException;
import com.efc.bookstoreapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {

        Optional<Livro> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll() {
        return repo.findAll();
    }

    public List<Livro> findAllCategoria(Integer id) {
        Categoria obj = categoriaService.findById(id);
        return obj.getLivros();
    }

    public Livro create(Integer idCat, Livro obj) {
        obj.setId(null);
        Categoria categoria = categoriaService.findById(idCat);
        obj.setCategoria(categoria);
        return repo.save(obj);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        if (obj.getTitulo() != null){
            newObj.setTitulo(obj.getTitulo());
        }
        if (obj.getNome_autor() != null){
            newObj.setNome_autor(obj.getNome_autor());
        }
        if (obj.getTexto() != null){
            newObj.setTexto(obj.getTexto());
        }
    }


    public void delete(Integer id) {
        Livro obj = findById(id);
        repo.delete(obj);
    }
}
