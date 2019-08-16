package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.services.CategoryService;
import edu.tallerjava.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> smoke(){
        ResponseEntity<List<Category>> response = new ResponseEntity<List<Category>>(categoryService.getList(), HttpStatus.OK);
        return response;
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id){
        return null;
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.OK);
    }

}
