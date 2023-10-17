package br.lab.marciokjls.storage.repository;

import br.lab.marciokjls.storage.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
