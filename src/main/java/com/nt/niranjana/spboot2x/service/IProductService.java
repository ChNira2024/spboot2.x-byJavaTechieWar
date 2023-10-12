package com.nt.niranjana.spboot2x.service;

	import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.Product;

@Service
public interface IProductService 
{


//	    @PostConstruct
//	    public void initDB() {
//	        List<Product> products = IntStream.rangeClosed(1, 200)
//	                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//	                .collect(Collectors.toList());
//	        repository.saveAll(products);
//	    }


		public List<Product> storeMoreProducts(List<Product> products);
		
	    public List<Product> findAllProducts();
	    
	    public Product updateProduct(int productID,Product productRequest);


	    public List<Product> findProductsWithSorting(String anyFieldName);


	    public Page<Product> findProductsWithPagination(int offset,int pageSize);
	    

	    public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String AnyFieldName);
	    

	}
