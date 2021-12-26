package com.directori.atddorder.application;

import com.directori.atddorder.domain.PendingOrder;
import lombok.Getter;

@Getter
public class PendingOrderResponse {

  private final long id;
  private final long productId;
  private final int quantity;

  public PendingOrderResponse(PendingOrder pendingOrder) {
    this.id = pendingOrder.getId();
    this.productId = pendingOrder.getProductId();
    this.quantity = pendingOrder.getQuantity();
  }
}
