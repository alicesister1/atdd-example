package com.directori.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.directori.atddorder.domain.PendingOrder;
import com.directori.atddorder.domain.PendingOrderRepository;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {

  private CreateOrderService createOrderService = new CreateOrderServiceImpl();

  @Test
  void createPendingOrder() {
    // Arrange
    long productId = 1L;
    int quantity = 2;
    PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

    PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
    assertThat(pendingOrder.getId()).isPositive();
  }

  // static이 아닌 inner class는 GC가 안되는 문제를 갖고있으므로 static 붙임
  private static class CreateOrderServiceImpl implements CreateOrderService {

    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
      PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
      return pendingOrderRepository.save(pendingOrder);
    }

  }

  private static class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public PendingOrder save(PendingOrder pendingOrder) {
      pendingOrder.assignId(nextId());
      return pendingOrder;
    }

    private long nextId() {
      return atomicLong.getAndIncrement();
    }
  }
}
