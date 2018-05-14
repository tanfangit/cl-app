package com.company.project.dto;

import java.util.List;

import com.company.project.model.TAccommodation;
import com.company.project.model.TAccommodationBanner;

public class TAccommodationDTO  extends TAccommodation{
    private List<TAccommodationBanner> banners;

	public List<TAccommodationBanner> getBanners() {
		return banners;
	}

	public void setBanners(List<TAccommodationBanner> banners) {
		this.banners = banners;
	}
    
}
