package com.company.project.dto;

import java.util.List;

import com.company.project.model.TAntique;
import com.company.project.model.TAntiqueBanner;

public class TantiqueDTO extends TAntique{
	
	 	private List<TAntiqueBanner> banners;
	    
	    public List<TAntiqueBanner> getBanners() {
			return banners;
		}

		public void setBanners(List<TAntiqueBanner> banners) {
			this.banners = banners;
		}
}
