package com.directori.atddorder.application;

import com.directori.atddorder.application.CreateOrderService;
import com.directori.atddorder.application.PendingOrderRequest;
import com.directori.atddorder.domain.PendingOrder;
import com.directori.atddorder.domain.PendingOrderRepository;
import com.directori.atddorder.infra.PendingOrderRepositoryMemoryImpl;

// static이 아닌 inner class는 GC가 안되는 문제를 갖고있으므로 static 붙임
public class CreateOrderServiceImpl implements CreateOrderService {

  private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

  @Override
  public PendingOrder createPendingOrder(PendingOrderRequest request) {
    PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
    return pendingOrderRepository.save(pendingOrder);
  }

}
