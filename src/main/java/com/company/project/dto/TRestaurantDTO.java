package com.company.project.dto;

import java.util.List;

import com.company.project.model.TRestaurant;
import com.company.project.model.TRestaurantBanner;

public class TRestaurantDTO extends TRestaurant{
	private List<TRestaurantBanner> banners;

	public List<TRestaurantBanner> getBanners() {
		return banners;
	}

	public void setBanners(List<TRestaurantBanner> banners) {
		this.banners = banners;
	}
	
}
