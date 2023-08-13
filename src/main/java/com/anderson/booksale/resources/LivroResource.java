package com.anderson.booksale.resources;

import com.anderson.booksale.domain.Livro;
import com.anderson.booksale.dtos.LivroDTO;
import com.anderson.booksale.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
