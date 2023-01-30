package com.efc.bookstoreapi.repositories;

import com.efc.bookstoreapi.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
