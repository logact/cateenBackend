package com.logact.cateen.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logact.cateen.entity.LablefoodEntity;
import com.logact.cateen.service.LablefoodService;
import com.logact.common.utils.PageUtils;
import com.logact.common.utils.R;



/**
 *
 *
 * @author logact
 * @email logact@qq.com
 * @date 2020-05-18 11:11:40
 */
@RestController
@RequestMapping("cateen/lablefood")
public class LablefoodController {
    @Autowired
    private LablefoodService lablefoodService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lablefoodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		LablefoodEntity lablefood = lablefoodService.getById(id);

        return R.ok().put("lablefood", lablefood);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LablefoodEntity lablefood){
		lablefoodService.save(lablefood);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LablefoodEntity lablefood){
		lablefoodService.updateById(lablefood);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		lablefoodService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
