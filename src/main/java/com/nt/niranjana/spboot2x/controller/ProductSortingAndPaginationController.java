package com.nt.niranjana.spboot2x.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.spboot2x.entity.Product;
import com.nt.niranjana.spboot2x.model.ProductAPIResponse;
import com.nt.niranjana.spboot2x.service.IProductService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/products")

public class ProductSortingAndPaginationController 
{
	@Autowired
    private IProductService service;

	@PostMapping(value="/storeProduct",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_staff,auth:role_admin",notes = "This endpoint helps to store product in db")
	@PreAuthorize("hasRole('ROLE_ADMIN') AND hasRole('ROLE_USER')")
    private ProductAPIResponse<List<Product>> storeProduct(@RequestBody List<Product> products) 
    {
        List<Product> totalProductStored = service.storeMoreProducts(products);
        return new ProductAPIResponse<>(totalProductStored.size(), totalProductStored);
    }
	
    @GetMapping(value="/getAllProducts",produces = {"application/json","application/xml"})
    @ApiOperation(value="auth:role_staff",notes = "This endpoint helps to get all the product")
	@PreAuthorize("hasRole('ROLE_ADMIN') AND hasRole('ROLE_USER')")
    private ProductAPIResponse<List<Product>> getProducts() 
    {
        List<Product> allProducts = service.findAllProducts();
        return new ProductAPIResponse<>(allProducts.size(), allProducts);
    }
    
    @PutMapping(value="/updateProductsUsingItsProductID/{productID}",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    @ApiOperation(value="auth:role_staff,auth:role_admin",notes = "This endpoint helps to update the product using its ID")
	@PreAuthorize("hasRole('ROLE_ADMIN') AND hasRole('ROLE_USER')")
    private ProductAPIResponse<Product> updateProductsUsingProductID(@PathVariable int productID,@RequestBody Product productRequest) 
    {
        Product updatedProduct = service.updateProduct(productID, productRequest);
        return new ProductAPIResponse<>(updatedProduct.getId(),updatedProduct);
    }
  //Pagination and sort using any field name
    @GetMapping("/{anyFieldName}")
    private ProductAPIResponse<List<Product>> getProductsWithSort(@PathVariable String anyFieldName) 
    {
        List<Product> allProductsWithSort = service.findProductsWithSorting(anyFieldName);
        return new ProductAPIResponse<>(allProductsWithSort.size(), allProductsWithSort);
    }
    
    @GetMapping("/pagination/{offset}/{pageSize}")
    private ProductAPIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) 
    {
        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
        return new ProductAPIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    //Pagination and sort using any field name
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{AnyFieldName}")
    private ProductAPIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String AnyFieldName) 
    {
        Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, AnyFieldName);
        return new ProductAPIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}
