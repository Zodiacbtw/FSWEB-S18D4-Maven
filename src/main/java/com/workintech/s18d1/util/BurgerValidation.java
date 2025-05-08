package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void validateBurger(Burger burger) {
        boolean isNameValid = burger.getName() != null;
        boolean isIdValid = burger.getIsVegan() != null;
        boolean isBreadTypeValid = burger.getBreadType() != null;
        boolean isPriceValid = burger.getPrice() != null;
        boolean isContentValid = burger.getIsVegan() != null;

        if (!isNameValid || !isIdValid || !isContentValid || !isBreadTypeValid || !isPriceValid) {
            throw new BurgerErrorException(
                    !isIdValid ? "Id cannot be empty" :
                    !isNameValid ? "Name cannot be empty" :
                    !isBreadTypeValid ? "Bread type cannot be empty" :
                    !isContentValid ? "Content cannot be empty" :
                    !isPriceValid ? "Price cannot be empty" : "Something went wrong"
                    , HttpStatus.BAD_REQUEST);
        }
    }
}