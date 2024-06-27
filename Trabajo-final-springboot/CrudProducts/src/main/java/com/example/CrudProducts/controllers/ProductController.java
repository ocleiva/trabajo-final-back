package com.example.CrudProducts.controllers;

import com.example.CrudProducts.model.Product;
import com.example.CrudProducts.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    /********** CONTROLADOR PARA OBTENER PRODUCTOS **********/
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {return productService.getProducts();}

    /********** CONTROLADOR PARA CREAR PRODUCTO **********/
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object>newProducts (@Valid @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            //Manejo de errores
            List <String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return productService.newProduct(product);
    }

    /********** CONTROLADOR PARA ACTUALIZAR PRODUCTO **********/
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    /********** CONTROLADOR PARA ELIMINAR PRODUCTO **********/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

    /********** CONTROLADOR PARA COMPROBAR EXISTENCIA DE PRODUCTO **********/
    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findByIdProduct(@PathVariable("id") Long id) {
        return productService.findByIdProduct(id);
    }

}

