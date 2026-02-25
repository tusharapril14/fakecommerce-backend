package com.example.fakecommerce.services;

import com.example.fakecommerce.dtos.CreateProductDTO;
import com.example.fakecommerce.dtos.ProductsWithDetailsResponseDTO;
import com.example.fakecommerce.dtos.ResponseProductDto;
import com.example.fakecommerce.repositories.CategoryRepository;
import com.example.fakecommerce.repositories.ProductRepository;
import com.example.fakecommerce.schema.Category;
import com.example.fakecommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
 private final ProductRepository productRepository;
 private final CategoryRepository categoryRepository;


    public List<ResponseProductDto> getAllProducts(){
        List<Product> products = this.productRepository.findAll();
//        List<ResponseProductDto> responseProductDtos = new ArrayList<>();
//          for(Product product : products){
//              ResponseProductDto responseProductDto = ResponseProductDto.builder()
//                      .title(product.getTitle())
//                      .price(product.getPrice())
//                      .imgUrl(product.getImgUrl())
//                      .rating(product.getRating())
//                      .description(product.getDescription())
//                      .build();
//              responseProductDtos.add(responseProductDto);
//          }
//          return responseProductDtos;
        return products.stream().map(product -> ResponseProductDto.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .imgUrl(product.getImgUrl())
                        .rating(product.getRating())
                        .description(product.getDescription())
                        .build())
                        .collect(Collectors.toList());
    }

    public ResponseProductDto getProductById(Long id){
        Product product = this.productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        return ResponseProductDto.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .imgUrl(product.getImgUrl())
                .rating(product.getRating())
                .description(product.getDescription())
                .build();
    }

    public List<ProductsWithDetailsResponseDTO> getAllProductsDetails(){
        List<Product> products = this.productRepository.findProductsWithDetails();
        return products.stream().map(product -> ProductsWithDetailsResponseDTO.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .imgUrl(product.getImgUrl())
                        .rating(product.getRating())
                        .description(product.getDescription())
                        .categoryName(product.getCategory().getName())
                        .build())
                        .collect(Collectors.toList());
    }

    public Product createProduct(CreateProductDTO reqDto){
        Category category = this.categoryRepository.findById(reqDto.getCategoryId()).orElseThrow();
        Product newProduct = Product.builder()
                            .title(reqDto.getTitle())

                            .price(reqDto.getPrice())
                            .rating(reqDto.getRating())
                            .imgUrl(reqDto.getImgUrl())
                            .category(category)
                            .description(reqDto.getDescription()).build();
        return this.productRepository.save(newProduct);
    }

    public ProductsWithDetailsResponseDTO getProductDetails(Long id) {
        Product product = this.productRepository.findProductWithDetails(id);
        return ProductsWithDetailsResponseDTO.builder().
                title(product.getTitle())
                .price(product.getPrice())
                .imgUrl(product.getImgUrl())
                .rating(product.getRating())
                .description(product.getDescription())
                .categoryName(product.getCategory().getName())
                .build();
    }

    public List<Product> getProductsByCategory(String category){
        return this.productRepository.findProductByCategoryName(category);
    }

    public String deleteProduct(Long id) {
        this.productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }

    public List<String> findAllCategories() {
        return this.productRepository.findAllDistinctCategories();
    }
}
