package application.data.category.service;

import application.data.category.model.PaginableItemList;
import application.data.category.model.Product;
import application.data.category.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

@Service
public class ProductService {

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;


    public long getTotalProduct() {
        return productRepository.getTotalProduct();
    }

    public PaginableItemList<Product> getListProduct(int pageSize, int pageNumber) {
        PaginableItemList<Product> paginableItemList = new PaginableItemList<>();
        paginableItemList.setPageSize(pageSize);
        paginableItemList.setPageNumber(pageNumber);

        Page<Product> pages = productRepository.findAll(new PageRequest(pageNumber, pageSize));
        paginableItemList.setTotalProducts(pages.getTotalElements());
        paginableItemList.setListData(pages.getContent());
        return paginableItemList;
    }

    public Product findOne(int productId) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("it's looking for product with id: " + productId);
        try {

            Product product = productRepository.getOne(productId);
            System.out.println("it's looking for product with id successfully" );
            System.out.println(product.getName());
            return product;
        } catch (Exception e) {
            System.out.println("it's looking for product with id fail" );
            logger.error(e.getMessage());

        }
        return null;
    }

}
