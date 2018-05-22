package application.controller.web;

import application.data.category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    private int activeProductId;
    @Autowired
    private ProductService productService;

    private String[] productNameList = {
            "Ao modal nữ phối hợp",
            "Áo lên cổ thuyền trễ vải",
            "Váy nữ Interlock giả da độn",
            "Váy maxi cổ sơmi",
            "Áo len cardigan 100% lông cừu",
            "Váy nữ dáng suông cổ tròn",
            "Váy nữ sát nách cổ tròn thắ eo",
            "Váy nữ sát nách cổ tim"
    };

    private String[] images = {
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6th17w006-sa195-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6te17w030-sa084-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6ds17c019-sg151-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6da17w001-sb089-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6tc17w013-sn079-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6ds17w039-sk010-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6ds17w034-sk010-33.jpg",
            "https://canifa.s3.amazonaws.com/media/catalog/product/cache_generated/500x/6ds17w035-sa282-33.jpg"
    };



    @GetMapping(path = "/")
    public String landing(Model model, @RequestParam(value = "pageSize", required = false) String ps,
                          @RequestParam(value = "pageNumber", required = false) String pn) {
        try{
            int pageSize = Integer.parseInt(ps);
            int pageNumber = Integer.parseInt(pn);
            if(pageSize > 0 && pageNumber >= 0) {
                model.addAttribute("paginableItem", productService.getListProduct(pageSize, pageNumber));
            } else {
                model.addAttribute("paginableItem", productService.getListProduct(8, 0));
            }
        } catch (Exception ex){
            System.out.println("------------------------------------------------pageSize Exception");
            System.out.println("------------------------------------------------pageNumber Exception");
            model.addAttribute("paginableItem", productService.getListProduct(8, 0));
            //ex.printStackTrace();
        }
        return "customer/home_landing";
    }

    @GetMapping(path = "/detail")
    public String productDetail(Model model) {

        model.addAttribute("productItem", productService.findOne(20));
        return "customer/product_detail";
    }

    @GetMapping(path = "/category")
    public String category(Model model) {
        return "customer/category";
    }



    //// Admin controller

}
