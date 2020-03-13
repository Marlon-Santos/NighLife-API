package com.nightlife.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class RegisterEventPlace {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@ApiModelProperty(value = "", accessMode = ApiModelProperty.AccessMode.READ_WRITE,hidden = true)
		private long id;
		
		@JsonInclude(Include.NON_NULL)
		@NotEmpty
		private String partyPlace;
		
		@JsonInclude(Include.NON_NULL)
		@NotEmpty
		private String address;
		
		@JsonIgnore
		@OneToMany(mappedBy = "eventPlace", cascade = CascadeType.ALL )
		private List<EventRegistration> events;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
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
			RegisterEventPlace other = (RegisterEventPlace) obj;
			if (id != other.id)
				return false;
			return true;
		}
	public long getId() {
			return id;
		}
	public void setId(long id) {
			this.id = id;
		}

		public String getPartyPlace() {
			return partyPlace;
		}
		
		public void setPartyPlace(String partyPlace) {
			this.partyPlace = partyPlace;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		public List<EventRegistration> getEvents() {
			return events;
		}
		
		public void setEvents(List<EventRegistration> events) {
			this.events = events;
		}
		
}
