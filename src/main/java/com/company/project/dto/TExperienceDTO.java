package com.company.project.dto;

import java.util.List;

import com.company.project.model.TExperience;
import com.company.project.model.TExperienceBanner;

public class TExperienceDTO extends TExperience {
   private List<TExperienceBanner>  banners;

public List<TExperienceBanner> getBanners() {
	return banners;
}

public void setBanners(List<TExperienceBanner> banners) {
	this.banners = banners;
}
   
}
