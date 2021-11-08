package com.example.case_module4.controller;

import com.example.case_module4.model.Category;
import com.example.case_module4.model.City;
import com.example.case_module4.model.Room;
import com.example.case_module4.service.category.ICategoryService;
import com.example.case_module4.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IRoomService roomService;

    @GetMapping()
    public ResponseEntity<Iterable<Category>> showAllCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> crateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> editCity(@PathVariable Long id, Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (category.getId() != null) {
                category.setId(id);
            }
        }
        return crateCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Room> rooms = (List<Room>) roomService.findAllByCategory(categoryOptional.get());
            if (!rooms.isEmpty()) {
                return new ResponseEntity<>("Some room is in this category. Can not delete.", HttpStatus.NO_CONTENT);
            }
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
