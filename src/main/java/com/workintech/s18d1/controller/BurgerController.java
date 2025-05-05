package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
@Slf4j
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAllBurgers() {
        log.info("Getting all burgers");
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        log.info("Getting burger with id: {}", id);
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger) {
        log.info("Saving new burger: {}", burger);
        BurgerValidation.validateBurger(burger);
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger) {
        log.info("Updating burger with id: {}", burger.getId());
        BurgerValidation.validateBurger(burger);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable Long id) {
        log.info("Deleting burger with id: {}", id);
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable int price) {
        log.info("Finding burgers with price greater than: {}", price);
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        log.info("Finding burgers with bread type: {}", breadType);
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        log.info("Finding burgers containing: {}", content);
        return burgerDao.findByContent(content);
    }
} 