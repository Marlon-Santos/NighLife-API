package com.nightlife.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nightlife.model.EventRegistration;

public interface Events extends JpaRepository<EventRegistration, Long>{
    List<EventRegistration> findAllByEventDate(Date date);

    EventRegistration findByEventNameIgnoreCase(String name);

    List<EventRegistration> findAllByOrderByEventCapacityAsc();

    List<EventRegistration> findAllByOrderByEventCapacityDesc();

    List<EventRegistration> findAllByOrderByEventDateDesc();

    List<EventRegistration> findAllByOrderByEventDateAsc();

    List<EventRegistration> findAllByOrderByEventNameAsc();

    List<EventRegistration> findAllByOrderByEventNameDesc();

    List<EventRegistration> findAllByOrderByPriceAsc();

    List<EventRegistration> findAllByOrderByPriceDesc();
}