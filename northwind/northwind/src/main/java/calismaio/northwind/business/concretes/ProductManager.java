package calismaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import calismaio.northwind.business.abstracts.ProductService;
import calismaio.northwind.core.utilities.results.DataResult;
import calismaio.northwind.core.utilities.results.Result;
import calismaio.northwind.core.utilities.results.SuccessDataResult;
import calismaio.northwind.core.utilities.results.SuccessResult;
import calismaio.northwind.dataAccess.abstracts.ProductDao;
import calismaio.northwind.entities.concretes.Product;
import calismaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao; 

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}



	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi");
				
	}



	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Urun eklendi");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"data listelendi");
	}



	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business code 
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryId),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}



	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
	}

}
