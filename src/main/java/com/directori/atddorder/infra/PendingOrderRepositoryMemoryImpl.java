package com.directori.atddorder.infra;

import com.directori.atddorder.domain.PendingOrder;
import com.directori.atddorder.domain.PendingOrderRepository;
import java.util.concurrent.atomic.AtomicLong;

public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

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
