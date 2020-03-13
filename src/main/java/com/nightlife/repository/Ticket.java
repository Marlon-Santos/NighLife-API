package com.nightlife.repository;

import com.nightlife.model.Historic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ticket  extends JpaRepository<Historic,Long> {
}
