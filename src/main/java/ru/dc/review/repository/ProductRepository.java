package ru.dc.review.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dc.review.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
