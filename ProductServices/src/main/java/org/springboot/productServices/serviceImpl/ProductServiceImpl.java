package org.springboot.productServices.serviceImpl;

import java.util.List;

import org.springboot.productServices.model.Product;
import org.springboot.productServices.repository.ProductRepository;
import org.springboot.productServices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void addProduct(Product product) 
	{
		productRepo.save(product);
		
	}

	@Override
	public Product getProductById(Long id)
    {
		return productRepo.findById(id).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public List<Product> getAllProduct() 
	{
		return productRepo.findAll();
	}

	@Override
	public void updateProduct(Product product) 
	{
		productRepo.save(product);
	}

	@Override
	public void deleteProduct(Product product) 
	{
		productRepo.delete(product);
	}

	@Override
	public void deleteProductById(Long id) 
	{
		productRepo.deleteById(id);
	}

	@Override
	public Product updateProduct(long id, Product product) 
	{
		
		return productRepo.findById(id).map(item -> 
		{
			item.setProductName(product.getProductName());
			item.setBrand(product.getBrand());
			item.setPrice(product.getPrice());
			
			return productRepo.save(item);
			
		}).orElseThrow(()-> new RuntimeException("No Record Found with ID: " + id));
	}

}
