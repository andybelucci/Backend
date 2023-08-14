package com.anderson.booksale.dtos;

import com.anderson.booksale.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CategoriaDTO {

    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido!")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter de 3 a 100 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO é requerido!")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter de 3 a 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
