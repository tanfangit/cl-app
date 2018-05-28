package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.TAntiqueDetailJob;

public interface TAntiqueDetailJobMapper extends Mapper<TAntiqueDetailJob> {
	/*获取 最后一个job*/
	TAntiqueDetailJob selectMaxTimeTAntiqueDetailJobByType(int type);
}