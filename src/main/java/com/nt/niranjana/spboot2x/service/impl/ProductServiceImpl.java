package com.nt.niranjana.spboot2x.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.Product;
import com.nt.niranjana.spboot2x.exception.ProductNotFoundException;
import com.nt.niranjana.spboot2x.repo.ProductRepository;
import com.nt.niranjana.spboot2x.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService 
{
	@Autowired
    private ProductRepository repository;
	
	@Override
	public List<Product> storeMoreProducts(List<Product> products) 
	{
		return repository.saveAll(products);
	}
	
	@Override
	public List<Product> findAllProducts() 
	{
		return repository.findAll();
	}
	
	@Override
	public Product updateProduct(int productID,Product productRequest) 
	{
		Product existingProductID = repository.findById(productID).orElse(null);
		System.out.println("existing productID: "+existingProductID);
        if (existingProductID != null) 
        {
		existingProductID.setName(productRequest.getName());
		existingProductID.setPrice(productRequest.getPrice());
		existingProductID.setQuantity(productRequest.getQuantity());
		return repository.save(existingProductID);
        }
        else
        {
        	 throw new ProductNotFoundException("Given product ID "+productID+ "might not there");
        }
	}

	@Override
	public List<Product> findProductsWithSorting(String anyFieldName) 
	{
		return  repository.findAll(Sort.by(Sort.Direction.ASC,anyFieldName));
	}

	@Override
	public Page<Product> findProductsWithPagination(int offset, int pageSize) //here pagesize means how many element want to see in singlepage  and offset is the singlepage number(like 0page,1page,2page....etc)
	{
		Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
	}

	@Override
	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String AnyFieldName)
	{
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(AnyFieldName)));
        return  products;
    }


}
