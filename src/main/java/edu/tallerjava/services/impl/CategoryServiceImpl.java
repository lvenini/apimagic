package edu.tallerjava.services.impl;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import edu.tallerjava.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getList(){
        return repository.findAll();
    }

    public Category save(Category category) {
        repository.save(category);
        return category;
    }

    public Optional<Category> findById(Long id){

        return  repository.findById(id);
    }
}
