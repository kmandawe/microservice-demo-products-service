package com.kensbunker.estore.productsservice.query;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.kensbunker.estore.productsservice.core.data.ProductEntity;
import com.kensbunker.estore.productsservice.core.data.ProductsRepository;
import com.kensbunker.estore.productsservice.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
  
  private final ProductsRepository productsRepository;

  public ProductEventsHandler(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  @EventHandler
  public void on(ProductCreatedEvent event) {
    ProductEntity productEntity = new ProductEntity();
    BeanUtils.copyProperties(event, productEntity);
    
    productsRepository.save(productEntity);
  }
}
