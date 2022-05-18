package com.codegym.dto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CartDto {
    Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto,currentValue+1);
        } else {
            productMap.put(productDto,1);
        }
    }

    public void subProduct(ProductDto productDto) {

        Integer currentValue = productMap.get(productDto);
        if (currentValue == 0) {
            productMap.put(productDto, currentValue);
        } else {
            productMap.put(productDto, currentValue - 1);
        }
    }

    public void deleteProduct(ProductDto productDto) {
        productMap.remove(productDto);
    }

    public void deleteAll(){
        productMap.clear();
    }

//    public Float totalPayment(){
//        float payment = 0;
//        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
public String totalPayment(){
    Locale locale = new Locale("vi","vn");
    NumberFormat vn = NumberFormat.getInstance(locale);

    float payment = 0;
    for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
        payment += entry.getKey().getPrice() * (float) entry.getValue();
    }

    return vn.format(payment);
}
}
