package com.anderson.booksale.service;

import com.anderson.booksale.domain.Categoria;
import com.anderson.booksale.dtos.CategoriaDTO;
import com.anderson.booksale.repositories.CategoriaRepository;
import com.anderson.booksale.service.exceptions.ObjectNotFoundException;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
