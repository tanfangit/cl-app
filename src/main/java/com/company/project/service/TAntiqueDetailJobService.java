package com.company.project.service;
import com.company.project.model.TAntiqueDetailJob;
import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/28.
 */
public interface TAntiqueDetailJobService extends Service<TAntiqueDetailJob> {
	/*获取 最后一个job*/
	TAntiqueDetailJob selectMaxTimeTAntiqueDetailJobByType(int type);
	
}
