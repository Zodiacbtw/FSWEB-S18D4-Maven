package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping()
    public List<Burger> getAll() {
        return burgerDao.findAll();
    }

    @GetMapping("{id}")
    public Burger get(@PathVariable long id) {
        Burger burger = burgerDao.findById(id);
        return burger;
    }

    @PostMapping()
    public Burger create(@RequestBody Burger burger) {
        BurgerValidation.validateBurger(burger);
        return burgerDao.save(burger);
    }

    @PutMapping()
    public Burger update(@RequestBody Burger burger) {
//        BurgerValidation.validateBurger(burger);
        return burgerDao.update(burger);
    }

    @DeleteMapping("{id}")
    public Burger delete(@PathVariable long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> getByPrice(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{type}")
    public List<Burger> getByBreadType(@PathVariable BreadType type) {
        return burgerDao.findByBreadType(type);
    }

    @GetMapping("/content/{content}")
    public List<Burger> getByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}