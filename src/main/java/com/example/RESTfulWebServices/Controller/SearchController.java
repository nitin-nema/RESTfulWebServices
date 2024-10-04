package com.example.RESTfulWebServices.Controller;

//Handliong the query param

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api/search/")
public class SearchController {

    //search the product name,

    @RequestMapping(method = RequestMethod.GET, params ="name")
    public List<Product> searchProdyuctByName(@RequestParam("name") String name){
        return productService.searchProductByName(name);
    }


    //search with multiple quieries
    @RequestMapping(method = RequestMethod.GET, params = {"name","catgory"})
    public List<Product> searchProductByCatergory(
            @RequestParam("name") String name
            @RequestParam("category") String category
    ){
        return productService.searchProductByName&Cateogy(name, category);
    }
}
