package com.logact.cateen.controller.pageController;

import com.logact.cateen.service.page.HomeService;
import com.logact.cateen.vo.home.HomeDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: logact
 * @date: Created in 2020/5/18 14:46
 * @description:
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService ;
    @GetMapping("/datas")
    public HomeDatas datas(){
        return homeService.getDatas();
    }
}
