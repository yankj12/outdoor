package com.yan.outdoor.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.yan.outdoor.schema.OutdoorActivity;
import com.yan.outdoor.service.facade.OutdoorActivityDaoService;

@Service
public class OutdoorActivityDaoServiceMangoImpl implements OutdoorActivityDaoService{

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveOutdoorActivity(OutdoorActivity outdoorActivity) {
		if(outdoorActivity != null){
			if(outdoorActivity.getInsertTime() == null){
				outdoorActivity.setInsertTime(new Date());
			}
			if(outdoorActivity.getUpdateTime() == null){
				outdoorActivity.setUpdateTime(new Date());
			}
			mongoTemplate.save(outdoorActivity, "OutdoorActivity");
		}
	}

	@Override
	public List<OutdoorActivity> findOutdoorActivityByCondition(Map<String, Object> condition) {
		Criteria criteria = null;
		
		int pageNo = 1;
		int pageSize = 10;
		
		int conditionCount = 0;
		
		for(Iterator<Entry<String, Object>> iterator = condition.entrySet().iterator();iterator.hasNext();) {
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			
			//因为查询条件改为了and，所以当条件为空字符串的时候不向查询条件中拼写
			if(value != null && !"".equals(value.toString().trim())){
				if ("id".equals(key)
						|| "year".equals(key)) {
					
					if(conditionCount < 1){
						criteria = Criteria.where(key).is(value.toString());
					}else{
						criteria.and(key).is(value.toString());
					}
					
					conditionCount++;
				}else if ("page".equals(key)) {
					pageNo = Integer.parseInt(value.toString());
				}else if ("rows".equals(key)) {
					pageSize = Integer.parseInt(value.toString());
				}else if("title".equals(key)
						|| "meetAddress".equals(key)
						|| "trafficType".equals(key)
						|| "difficultyIndex".equals(key)){
					if(conditionCount < 1){
						criteria = Criteria.where(key).regex("" + value.toString() + ".*", "i");
					}else{
						criteria.and(key).regex("" + value.toString() + ".*", "i");
					}
					
					conditionCount++;
				}else{
					
				}
			}
		}
		
		Query query = new Query();
		query.addCriteria(criteria);
		
		// 根据updateTime降序排序
		query.with(new Sort(Sort.Direction.DESC, "updateTime"));
		
		// 分页部分设置
		long skip = 0L;
		int limit = 10;
		
		skip = (pageNo - 1) * pageSize;
		limit = pageSize;
		
		query.skip(skip);
		query.limit(limit);
		
		List<OutdoorActivity> registries = mongoTemplate.find(Query.query(criteria), OutdoorActivity.class);
		return registries;
	}

	@Override
	public Long countOutdoorActivityByCondition(Map<String, Object> condition) {
		Criteria criteria = null;
		
		int conditionCount = 0;
		
		for(Iterator<Entry<String, Object>> iterator = condition.entrySet().iterator();iterator.hasNext();) {
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			
			//因为查询条件改为了and，所以当条件为空字符串的时候不向查询条件中拼写
			if(value != null && !"".equals(value.toString().trim())){
				if ("id".equals(key)
						|| "year".equals(key)) {
					
					if(conditionCount < 1){
						criteria = Criteria.where(key).is(value.toString());
					}else{
						criteria.and(key).is(value.toString());
					}
					
					conditionCount++;
				}else if ("page".equals(key)) {
					
				}else if ("rows".equals(key)) {
					
				}else if("title".equals(key)
						|| "meetAddress".equals(key)
						|| "trafficType".equals(key)
						|| "difficultyIndex".equals(key)){
					if(conditionCount < 1){
						criteria = Criteria.where(key).regex("" + value.toString() + ".*", "i");
					}else{
						criteria.and(key).regex("" + value.toString() + ".*", "i");
					}
					
					conditionCount++;
				}else{
					
				}
			}
		}
		
		Query query = new Query();
		query.addCriteria(criteria);
		
		Long totalCount = mongoTemplate.count(query, OutdoorActivity.class);
		return totalCount;
	}

	@Override
	public void updateOutdoorActivity(OutdoorActivity outdoorActivity) {
		if(outdoorActivity != null){
			
			if(outdoorActivity.getUpdateTime() == null){
				outdoorActivity.setUpdateTime(new Date());
			}
			mongoTemplate.save(outdoorActivity, "OutdoorActivity");
		}
	}
	
}
