package application.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String admin(Model model) {
    //        long totalProducts = productService.getTotalProduct();
    //        if(totalProducts <= 0) {
    //            ArrayList<Product> listProduct = new ArrayList<>();
    //            for(int i = 0; i< 8; i++) {
    //                Product p = new Product();
    //                p.setProductName(productNameList[i]);
    //                p.setProductImg(images[i]);
    //                p.setProductPrice(100 + i);
    //                p.setCategory(1);
    //                //p.setProductLink("/detail");
    //                listProduct.add(p);
    //            }
    //            productService.addNewListProduct(listProduct);
    //        }
        return "admin/admin";
    }

    @RequestMapping(path = "category", method = RequestMethod.GET)
    public String adminCategory(Model model) {
        return "admin/category_detail";
    }


    @RequestMapping(path = "product_detail", method = RequestMethod.GET)
    public String adminProductDetail(Model model) {
        return "admin/product_detail";
    }
}
