package com.yan.outdoor;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yan.outdoor.schema.OutdoorActivity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { OutdoorApplication.class })
public class MongoTemplateTest{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	//@Ignore
	@Test
	public void insert() {
		/*
	    "title" : "塔尔寺村-北灵山-塔尔寺村环穿，赏秋景",
	    "activityTime" : "10月21日（本周日）",
	    "meetAddress" : "公主坟地铁站A口向北200米，新兴宾馆门口",
	    "meetTime" : "10月21日早上7点10集合,7点30发车。",
	    "trafficType" : "包车（车费AA，报名预收80元包车费用，多退少补）",
	    "difficultyIndex" : "1.0，全程11公里，上升750米，下降750米",
	    "info" : "线路：塔尔寺村-北灵山-塔尔寺村环穿，赏秋景\n活动时间：10月21日（本周日）\n集合地点：公主坟地铁站A口向北200米，新兴宾馆门口\n集合时间：10月21日早上7点10集合,7点30发车。\n交通方式：包车（车费AA，报名预收80元包车费用，多退少补）\n难度系数：1.0，全程11公里，上升750米，下降750米\n\n行程安排：\n07:10  集合\n07:30  发车\n11:00  到达塔尔寺村，开始登山\n16:30  环穿到塔尔寺村，坐车返程\n19:30  到达公主坟地铁站\n备注：所有时间均为预估时间\n\n去的进报名群！\n"
	    */
		OutdoorActivity outdoorActivity = new OutdoorActivity();

		outdoorActivity.setYear("2018");
		outdoorActivity.setTitle("塔尔寺村-北灵山-塔尔寺村环穿，赏秋景");
		outdoorActivity.setActivityTime("10月21日（本周日）");
		outdoorActivity.setMeetAddress("公主坟地铁站A口向北200米，新兴宾馆门口");
		outdoorActivity.setMeetTime("10月21日早上7点10集合,7点30发车。");
		outdoorActivity.setTrafficType("包车（车费AA，报名预收80元包车费用，多退少补）");
		outdoorActivity.setDifficultyIndex("1.0，全程11公里，上升750米，下降750米");
		outdoorActivity.setInfo("线路：塔尔寺村-北灵山-塔尔寺村环穿，赏秋景\n活动时间：10月21日（本周日）\n集合地点：公主坟地铁站A口向北200米，新兴宾馆门口\n集合时间：10月21日早上7点10集合,7点30发车。\n交通方式：包车（车费AA，报名预收80元包车费用，多退少补）\n难度系数：1.0，全程11公里，上升750米，下降750米\n\n行程安排：\n07:10  集合\n07:30  发车\n11:00  到达塔尔寺村，开始登山\n16:30  环穿到塔尔寺村，坐车返程\n19:30  到达公主坟地铁站\n备注：所有时间均为预估时间\n\n去的进报名群！\n");
		
		outdoorActivity.setValidStatus("1");
		outdoorActivity.setInsertTime(new Date());
		outdoorActivity.setUpdateTime(new Date());
		
		mongoTemplate.save(outdoorActivity, "OutdoorActivity");
	}

}
