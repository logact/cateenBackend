package com.logact.cateen.controller.pageController;

import com.logact.cateen.service.page.ActivityService;
import com.logact.cateen.vo.activity.ActivityDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: logact
 * @date: Created in 2020/5/19 20:50
 * @description:
 */
@RestController
@RequestMapping("/activity")
public class ActivityPageController {
    @Autowired
    ActivityService activityService;
    @RequestMapping("/datas")
    public ActivityDatas getDatas(){
        return  activityService.getDatas();
    }
}
