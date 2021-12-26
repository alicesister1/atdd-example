package com.directori.atddorder.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.directori.atddorder.application.PendingOrderRequest;
import com.directori.atddorder.application.PendingOrderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderApiIntegrationTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void createPendingOrderTest() throws Exception {
    // Arrange
    long productId = 1L;
    int quantity = 2;
    PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

    // Act
    MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andReturn().getResponse();

    // Assert
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
    assertThat(pendingOrderResponse.getId()).isGreaterThan(0L);
  }
}
