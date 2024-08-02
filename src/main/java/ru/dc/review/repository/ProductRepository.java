package ru.dc.review.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.review.entity.Product;

@RestController
public interface ProductRepository extends JpaRepository<Product, Long> {


}
