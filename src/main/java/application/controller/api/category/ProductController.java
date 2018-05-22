package application.controller.api.category;

import application.data.category.model.Product;
import application.data.category.service.CategoryService;
import application.data.category.service.ProductService;
import application.model.ProductDataModel;
import application.model.common.BaseApiResult;
import application.model.common.DataApiResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/detail/{productId}")
    public BaseApiResult getProductById(@PathVariable int productId) {
        DataApiResult result = new DataApiResult();
        Product product = productService.findOne(productId);

        if(product != null) {
            result.setSuccess(true);
            result.setMessage("found this product successfull");
            System.out.println("getProductById successfull");
            try {
                ModelMapper modelMapper = new ModelMapper();
                ProductDataModel productDataModel = modelMapper.map(product, ProductDataModel.class);
                result.setData(productDataModel);
                System.out.println("getProductById setData successfull");
            } catch (Exception e) {
                System.out.println("getProductById setData fail");
                logger.error(e.getMessage());
            }
        } else {
            result.setSuccess(false);
            result.setMessage("not found this product");
            System.out.println("getProductById fail");
            result.setData(null);
        }
        System.out.println(result.getData().toString());
        return result;
    }

}
