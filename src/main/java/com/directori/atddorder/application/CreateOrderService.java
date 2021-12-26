package com.directori.atddorder.application;

import com.directori.atddorder.domain.PendingOrder;

public interface CreateOrderService {

  PendingOrder createPendingOrder(PendingOrderRequest request);
}
