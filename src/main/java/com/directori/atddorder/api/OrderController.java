package com.directori.atddorder.api;

import com.directori.atddorder.application.CreateOrderService;
import com.directori.atddorder.application.PendingOrderRequest;
import com.directori.atddorder.application.PendingOrderResponse;
import com.directori.atddorder.domain.PendingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private final CreateOrderService createOrderService;

  public OrderController(CreateOrderService createOrderService) {
    this.createOrderService = createOrderService;
  }

  @PostMapping("/orders/pendingOrder")
  public ResponseEntity<PendingOrderResponse> createPendingOrder(
      @RequestBody PendingOrderRequest request) {
    PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
    PendingOrderResponse response = new PendingOrderResponse(pendingOrder);
    return ResponseEntity.ok(response);
  }
}
