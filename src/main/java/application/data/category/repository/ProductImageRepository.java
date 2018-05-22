package application.data.category.repository;

import application.data.category.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{
//    @Query("select count(p.id) from tbl_new_product p")
//    long getTotatProduc;
}
