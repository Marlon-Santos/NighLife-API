package com.nightlife.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.nightlife.repository.EventPlace;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class EventRegistration {

    @ApiModelProperty(value = "", accessMode = ApiModelProperty.AccessMode.READ_WRITE,hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonInclude(Include.NON_NULL)
    private String eventName;

    @JsonInclude(Include.NON_NULL)
    private Long eventCapacity;

    @JsonInclude(Include.NON_NULL)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @JsonInclude(Include.NON_NULL)
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private StatusMusic status;

    @JsonInclude(Include.NON_NULL)
    private String eventPlaceAddress;
    
    @JsonInclude(Include.NON_NULL)
    private String RegisterEventPlaceName;
    
    @JsonIgnore
    @ManyToOne
    private RegisterEventPlace eventPlace;
    
    @JsonIgnore
    @OneToMany(mappedBy = "eventRegistration",cascade = CascadeType.ALL)
    private List<Historic> ticketList;
    public void registerEventPlace(EventPlace eventPlace) throws Exception {
        RegisterEventPlace registerEventPlace = eventPlace.findByPartyPlaceIgnoreCase(getRegisterEventPlaceName());
        if (registerEventPlace != null) {
            this.setEventPlace(registerEventPlace);
        } else {
            throw new Exception("RegisterEventPlaceName not found");
        }
    }

    public EventRegistration() {
    }

    
    public String getRegisterEventPlaceName() {
        return RegisterEventPlaceName;
    }

    public void setRegisterEventPlaceName(String registerEventPlaceName) {
        RegisterEventPlaceName = registerEventPlaceName;
    }

    public List<Historic> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Historic> ticketList) {
        this.ticketList = ticketList;
    }

    

    public String getEventPlaceAddress() {
		return eventPlaceAddress;
	}

	public void setEventPlaceAddress(String eventPlaceAddress) {
		this.eventPlaceAddress = eventPlaceAddress;
	}

	public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(Long eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public StatusMusic getStatus() {
        return status;
    }

    public void setStatus(StatusMusic status) {
        this.status = status;
    }

    public RegisterEventPlace getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(RegisterEventPlace eventPlace) {
        this.eventPlace = eventPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EventRegistration other = (EventRegistration) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public void save(EventRegistration eventregistration) {
        // TODO Auto-generated method stub

    }

}