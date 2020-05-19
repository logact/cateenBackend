package com.logact.cateen.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logact.cateen.entity.FoodEntity;
import com.logact.cateen.service.FoodService;
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
@RequestMapping("cateen/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = foodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		FoodEntity food = foodService.getById(id);

         return R.ok().put("food", food);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FoodEntity food){
        System.out.println("foodService.save(food));");
        System.out.println(foodService.save(food));
        System.out.println("foodService.save(food));");
        return R.ok().put("food",foodService.save(food));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FoodEntity food){
		foodService.updateById(food);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		foodService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
