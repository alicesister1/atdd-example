package com.directori.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.directori.atddorder.domain.PendingOrder;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {

  private CreateOrderService createOrderService = new CreateOrderServiceImpl();

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
