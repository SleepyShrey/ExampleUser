package br.com.darchanjo.examples.controller;


import br.com.darchanjo.examples.entity.ProductEntity;
import br.com.darchanjo.examples.entity.ProductEntityDTO;
import br.com.darchanjo.examples.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> get() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> post(@Valid @RequestBody ProductEntityDTO productEntityDTO)
    {
        return new ResponseEntity<>(productService.addProduct(productEntityDTO),HttpStatus.CREATED);
    }
}
