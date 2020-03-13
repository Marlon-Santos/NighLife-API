package com.nightlife.repository;

import com.nightlife.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<Client,Long> {
}
