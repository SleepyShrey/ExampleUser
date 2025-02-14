package br.com.darchanjo.examples.service;

import br.com.darchanjo.examples.entity.ProductEntity;
import br.com.darchanjo.examples.entity.ProductEntityDTO;
import br.com.darchanjo.examples.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity addProduct(ProductEntityDTO productEntity) {
        ProductEntity pe = new ProductEntity();
//        ProductValidation pv = new ProductValidation();
//        if(pv.validateQuantity(productEntity.getCount())){
            pe.setCount(productEntity.getCount());
//        }
//        else {
//            throw new ValidationErrorException("Failed to validate count");
//        }
        pe.setName(productEntity.getName());
        pe.setDescription(productEntity.getDescription());
        productRepo.save(pe);
        return pe;
    }
}

