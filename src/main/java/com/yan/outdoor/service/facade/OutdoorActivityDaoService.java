package com.yan.outdoor.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.outdoor.schema.OutdoorActivity;

public interface OutdoorActivityDaoService {

	/**
	 * 保存户外活动信息
	 * @param outdoorActivity
	 */
	public void saveOutdoorActivity(OutdoorActivity outdoorActivity);
	
	/**
	 * 根据条件查询户外活动信息
	 * @param condition
	 */
	public List<OutdoorActivity> findOutdoorActivityByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件统计户外活动信息条数
	 * @param condition
	 */
	public Long countOutdoorActivityByCondition(Map<String, Object> condition);

	/**
	 * 修改户外活动信息
	 * @param outdoorActivity
	 */
	public void updateOutdoorActivity(OutdoorActivity outdoorActivity);
	
}
