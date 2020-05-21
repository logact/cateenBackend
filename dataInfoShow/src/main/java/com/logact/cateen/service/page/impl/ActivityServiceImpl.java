package com.logact.cateen.service.page.impl;

import com.logact.cateen.dao.ActivityDao;
import com.logact.cateen.entity.ActivityEntity;
import com.logact.cateen.service.page.ActivityService;
import com.logact.cateen.vo.activity.Activity;
import com.logact.cateen.vo.activity.ActivityDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: logact
 * @date: Created in 2020/5/19 17:40
 * @description:
 */
@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;
    @Override
    public ActivityDatas getDatas() {
        ActivityDatas activityDatas = new ActivityDatas();
        List<Activity> startActivityList = new ArrayList<Activity>();
        List<Activity> readyActivityList = new ArrayList<Activity>();
        List<Activity> endActivityList = new ArrayList<Activity>();

        HashMap<String, Object> condition1 = new HashMap<String, Object>();
        condition1.put("statusCode", 1);
        List<ActivityEntity> activityEntities1 = activityDao.selectByMap(condition1);
        for (ActivityEntity activityEntity : activityEntities1) {
            Activity activity = new Activity();
            activity.setId(activityEntity.getId());
            activity.setDesc(activityEntity.getDescr());
            activity.setImgSrc(activityEntity.getImgsrc());
            activity.setStatus(activityEntity.getStatus());
            activity.setInitiator(activityEntity.getInitiator());
            activity.setTitle(activityEntity.getTitle());
            DateFormat df = DateFormat.getDateInstance();
            activity.setStartTime( df.format(activityEntity.getStarttime()));
            activity.setEndTime((df.format(activityEntity.getEndtime())));
            readyActivityList.add(activity);
        }
        activityDatas.setReadyActivityList(readyActivityList);



        HashMap<String, Object> condition2 = new HashMap<String, Object>();
        condition2.put("statusCode", 2);
        List<ActivityEntity> activityEntities2 = activityDao.selectByMap(condition2);
        for (ActivityEntity activityEntity : activityEntities2) {
            Activity activity = new Activity();
            activity.setId(activityEntity.getId());
            activity.setDesc(activityEntity.getDescr());
            activity.setImgSrc(activityEntity.getImgsrc());
            activity.setStatus(activityEntity.getStatus());
            activity.setInitiator(activityEntity.getInitiator());
            activity.setTitle(activityEntity.getTitle());
            DateFormat df = DateFormat.getDateInstance();
            activity.setStartTime( df.format(activityEntity.getStarttime()));
            activity.setEndTime((df.format(activityEntity.getEndtime())));
            startActivityList.add(activity);
        }
        activityDatas.setStartActivityList(startActivityList);


        HashMap<String, Object> condition3 = new HashMap<String, Object>();
        condition3.put("statusCode", 3);
        List<ActivityEntity> activityEntities3 = activityDao.selectByMap(condition3);
        for (ActivityEntity activityEntity : activityEntities3) {
            Activity activity = new Activity();
            activity.setId(activityEntity.getId());
            activity.setDesc(activityEntity.getDescr());
            activity.setImgSrc(activityEntity.getImgsrc());
            activity.setStatus(activityEntity.getStatus());
            activity.setInitiator(activityEntity.getInitiator());
            activity.setTitle(activityEntity.getTitle());
            DateFormat df = DateFormat.getDateInstance();
            activity.setStartTime( df.format(activityEntity.getStarttime()));
            activity.setEndTime((df.format(activityEntity.getEndtime())));
            endActivityList.add(activity);
        }
        activityDatas.setEndActivityList(endActivityList);
        return activityDatas;
    }
}
