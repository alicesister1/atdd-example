package com.directori.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.directori.atddorder.domain.PendingOrder;
import com.directori.atddorder.domain.PendingOrderRepository;
import com.directori.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {

  private final PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
  private final CreateOrderService createOrderService = new CreateOrderServiceImpl(
      pendingOrderRepository);

  @Test
  void createPendingOrder() {
    // Arrange
    long productId = 1L;
    int quantity = 2;
    PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

    // Act
    PendingOrder pendingOrder = createOrderService.createPendingOrder(request);

    // Assert
    assertThat(pendingOrder.getId()).isPositive();
  }

}
