package com.anderson.booksale.service;

import com.anderson.booksale.domain.Categoria;
import com.anderson.booksale.domain.Livro;
import com.anderson.booksale.repositories.CategoriaRepository;
import com.anderson.booksale.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Livro de Ficção");
        Categoria cat3 = new Categoria(null, "Terror", "Livro de Terror");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Sobre código limpo",cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V Gerstner", "Sobre código limpo",cat1);
        Livro l3 = new Livro(null, "Pet Cemitery", "Stephen King", "Sobre cemitério de animais",cat2);
        Livro l4 = new Livro(null, "Time Machine", "H G Wells", "Sobre automação",cat2);
        Livro l5 = new Livro(null, "I`m Robot", "Isaac Asimov", "Sobre IA",cat2);

       cat1.getLivros().addAll(Arrays.asList(l1, l2));
       cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
