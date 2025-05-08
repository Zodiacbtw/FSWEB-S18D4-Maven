package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BurgerErrorException extends RuntimeException {
    private HttpStatus httpStatus;

    public BurgerErrorException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}