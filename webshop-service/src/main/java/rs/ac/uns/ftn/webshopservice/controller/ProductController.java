package rs.ac.uns.ftn.webshopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.webshopservice.dto.request.ProductToAddDTO;
import rs.ac.uns.ftn.webshopservice.dto.response.ProductDTO;
import rs.ac.uns.ftn.webshopservice.mappers.ProductMapper;
import rs.ac.uns.ftn.webshopservice.model.Product;
import rs.ac.uns.ftn.webshopservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/public")
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(ProductMapper.toListDto(products), HttpStatus.OK);
    }

    @GetMapping("/my-store")
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public ResponseEntity<List<ProductDTO>> getAllMyProducts() {
        List<Product> products = productService.getAllMyProducts();
        return new ResponseEntity<>(ProductMapper.toListDto(products), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public ResponseEntity<ProductDTO> add(@RequestBody ProductToAddDTO product) {
        Product newProduct = productService.add(product);
        return new ResponseEntity<>(new ProductDTO(newProduct), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
