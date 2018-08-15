package com.rest.simple.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
class ProductDTO {
    @NotEmpty(message = "Product's name must not be null")
    private String name;
    @NotEmpty(message = "Product's code must not be null")
    @Size(min = 13, max = 13, message = "Product's code length must be 13 symbols")
    private String code;
}