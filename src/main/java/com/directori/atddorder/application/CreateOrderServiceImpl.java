package com.directori.atddorder.application;

import com.directori.atddorder.domain.PendingOrder;
import com.directori.atddorder.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {

  private final PendingOrderRepository pendingOrderRepository;

  public CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
    this.pendingOrderRepository = pendingOrderRepository;
  }

  @Override
  public PendingOrder createPendingOrder(PendingOrderRequest request) {
    PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
    return pendingOrderRepository.save(pendingOrder);
  }

}
