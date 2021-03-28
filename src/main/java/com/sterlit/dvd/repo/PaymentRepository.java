package com.sterlit.dvd.repo;

import com.sterlit.dvd.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
