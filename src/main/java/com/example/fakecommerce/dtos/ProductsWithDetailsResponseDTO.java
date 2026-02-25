package com.example.fakecommerce.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductsWithDetailsResponseDTO extends ResponseProductDto{
    private String categoryName;
}
