package com.kensbunker.estore.productsservice.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = -8482229492093895662L;
    
    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;
    private BigDecimal price;
    private Integer quantity;
}