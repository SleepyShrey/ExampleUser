package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.entity.ProductEntity;
import br.com.darchanjo.examples.entity.ProductEntityDTO;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> getAllProducts();

    ProductEntity addProduct(ProductEntityDTO productEntity);
}
