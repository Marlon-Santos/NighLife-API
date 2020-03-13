package com.nightlife.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Historic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();
    @ManyToOne
    private EventRegistration eventRegistration;
    @ManyToOne
    private Client client;

    public Historic() {
    }

    public Historic(EventRegistration eventRegistration) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        this.eventRegistration = eventRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Historic ticket = (Historic) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public EventRegistration getEventRegistration() {
        return eventRegistration;
    }

    public void setEventRegistration(EventRegistration eventRegistration) {
        this.eventRegistration = eventRegistration;
    }
}
