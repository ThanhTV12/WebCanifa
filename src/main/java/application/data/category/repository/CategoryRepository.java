package application.data.category.repository;

import application.data.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query("select count(p.id) from tbl_category p")
    long getTotalCategoris();
}
