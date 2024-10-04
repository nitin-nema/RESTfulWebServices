package com.example.RESTfulWebServices.Controller;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = Arrays.asList(new Product("Laptop", 1000), new Product("Phone", 500));
        model.addAttribute("products", products);
        return "productList"; // Returns the view productList.html
    }
}
