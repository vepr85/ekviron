package com.rest.simple.controller;

import com.rest.simple.ErrorResponse;
import com.rest.simple.dto.DocumentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by abyakimenko on 15.08.2018.
 */
@RestController
@RequestMapping(value = "/product", produces = "application/json;charset=UTF-8")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public void saveProduct(@Valid @RequestBody DocumentDTO product) {
        logger.info("Income product: {}", product);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {

        String errorMsg = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse.builder().message(errorMsg).build();
    }
}
