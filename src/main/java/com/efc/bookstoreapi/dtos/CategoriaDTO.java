package com.efc.bookstoreapi.dtos;

import com.efc.bookstoreapi.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo NOME é requerido!")
    @Length(min = 3, message = "O campo NOME deve ter mais de 3 caracteres")
    private String nome;
    @NotEmpty(message = "Campo DESCRIÇÃO é requerido!")
    @Length(min = 3, message = "O campo DESCRIÇÃO deve ter mais de 3 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
