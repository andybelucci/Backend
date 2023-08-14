package com.anderson.booksale.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Data
@Table(name = "tb_Livro")
@Getter
@Entity
public class Livro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TITULO é requerido!")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter de 3 a 50 caracteres.")
    private String titulo;

    @NotEmpty(message = "Campo NOME_AUTOR é requerido!")
    @Length(min = 3, max = 50, message = "O campo NOME_AUTOR deve ter de 3 a 50 caracteres.")
    private String nome_autor;

    @NotEmpty(message = "Campo TEXTO é requerido!")
    @Length(min = 3, max = 2000000, message = "O campo TEXTO deve ter de 3 a 2.000.000 caracteres.")
    private String texto;

    @ManyToOne
    @JsonIgnore
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
