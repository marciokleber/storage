package br.lab.marciokjls.storage.controller;

import br.lab.marciokjls.storage.domain.Product;
import br.lab.marciokjls.storage.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id){
        var product = productRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findById(){
        var products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PostMapping()
    public ResponseEntity save(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Salvo com sucesso!");
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Removido com sucesso!");
    }

    @PutMapping("/product/{id}")
    public ResponseEntity update(@PathVariable("id") Long id ,@RequestBody Product altProduct){
        var product = productRepository.findById(id).get();
        BeanUtils.copyProperties(altProduct,product);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Atualizado com sucesso!");
    }
}
