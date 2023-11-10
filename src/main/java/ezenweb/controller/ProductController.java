package ezenweb.controller;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    // 1. 카테고리 등록
    @PostMapping("/category")
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto){
        System.out.println(111);
        System.out.println(productCategoryDto);
        System.out.println("productCategoryDto = " + productCategoryDto);
        return productService.addCategory(productCategoryDto);
    }

    // 2. 카테고리 출력
    @GetMapping("/category")
    public List<ProductCategoryDto> printCategory(){
        return productService.printCategory();
    }

    // 3. 카테고리 수정
    @PutMapping("/category")
    public boolean updateCategory (@RequestParam ProductCategoryDto productCategoryDto){
        return productService.updateCategory(productCategoryDto);
    }

    // 4. 카테고리 삭제
    @DeleteMapping("/category")
    public boolean deleteCategory( @RequestParam int pcno ){
        return productService.deleteCategory(pcno);
    }



}
