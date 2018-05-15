package com.company.project.dto;

import java.util.List;

import com.company.project.model.TOtherreservations;
import com.company.project.model.TOtherreservationsAccommodation;

public class TOtherreservationsDTO extends TOtherreservations {
	private List<TOtherreservationsAccommodation>  accommodations;

	public List<TOtherreservationsAccommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(List<TOtherreservationsAccommodation> accommodations) {
		this.accommodations = accommodations;
	}
	

}
