package Controllers;

import models.Category;
import models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

//    @GetMapping("/categories")
//    public List<Category> getAllCategory() {
//        return new ArrayList<>();
//    }
//
//    @GetMapping("/categories/{categoryName}")
//    public List<Product> getProductsFromCategory(@PathVariable("categoryName") String categoryName ){
//        return new ArrayList<>();
//    }
}
