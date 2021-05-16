package controller;


import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

@RequestMapping(value = "/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService mProductService;


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getProducts(){
        return new ResponseEntity(mProductService.getProducts(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity getProduct(@PathVariable int id){
        return new ResponseEntity(mProductService.getProduct(id), HttpStatus.OK);
    }

    // id는 auto_increment라서 Body에 안붙여도 됌
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insertProduct(@RequestBody Product pd){
        return new ResponseEntity(mProductService.insertProduct(pd), HttpStatus.OK);
    }


    //반환형으로 ResponseEntity 말고도 써봄. 필드가 빠진 domain 객체의 Patch도 문제없이 된다.
    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT,RequestMethod.PATCH})
    public int updateProduct(@PathVariable int id, @RequestBody Product body){
        body.setId(id);
        return mProductService.updateProduct(body);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteProduct(@PathVariable int id){
        return mProductService.deleteProduct(id);
    }



}
