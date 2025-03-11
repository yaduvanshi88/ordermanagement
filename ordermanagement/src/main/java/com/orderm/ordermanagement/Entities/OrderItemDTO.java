package com.orderm.ordermanagement.Entities;

public class OrderItemDTO 
{
    private Long productId;
    private Integer quantity;
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public OrderItemDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderItemDTO() {
        
    }


    
    

}
