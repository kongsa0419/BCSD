package controller;

import domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public Product responseHello(){
        Product product = new Product();
        product.setId(1);
        product.setName("ABCchocolate");
        product.setPrice(3.45f);
        product.setCountryCode("KOR");
        return product;
    }

}
