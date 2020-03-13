package com.nightlife.repository;

import com.nightlife.model.RegisterEventPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventPlace extends JpaRepository<RegisterEventPlace, Long> {

    RegisterEventPlace findByPartyPlaceIgnoreCase(String name);

    List<RegisterEventPlace> findAllByOrderByPartyPlaceAsc();

    List<RegisterEventPlace> findAllByOrderByPartyPlaceDesc();
}
