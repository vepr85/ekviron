package com.rest.simple.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by abyakimenko on 15.08.2018.
 */
@Getter
@Setter
@ToString
public class DocumentDTO {

    @NotEmpty(message = "Seller must not be null")
    @Size(min = 9, max = 9, message = "Seller's length must be 9 symbols")
    private String seller;
    @NotEmpty(message = "Customer must not be null")
    @Size(min = 9, max = 9, message = "Customer's length must be 9 symbols")
    private String customer;
    @NotNull(message = "Products must not be null")
    @NotEmpty(message = "Products must not be empty")
    private List<ProductDTO> products;
}
