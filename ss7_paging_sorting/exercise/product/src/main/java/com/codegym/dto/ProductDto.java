package com.codegym.dto;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ProductDto implements Validator {
    private int productId;
    private String productCode;
    @NotEmpty
    @NotBlank
    @Size(max = 300,message = "maximum character is 300")
    private String productName;
    @Range(min = 1, message = "the minimum of quantity is 1")
    private int quantity;
    @Range(min = 1000, message = "the minimum of price is 1000")
    private double price;
    private ProductType productType;

    public ProductDto() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.getProductName().contains("@")){
            errors.rejectValue("productName", "name","default error");
        }
    }
}
