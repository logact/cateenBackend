package com.logact.cateen.service.page.impl;

import com.logact.cateen.dao.ShopDao;
import com.logact.cateen.entity.ShopEntity;
import com.logact.cateen.service.page.ShopService;
import com.logact.cateen.vo.shop.ShopDatas;
import com.logact.cateen.vo.shop.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author: logact
 * @date: Created in 2020/5/19 23:03
 * @description:
 */
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;
    @Override
    public ShopDatas getDatas(Integer id) {
        ShopDatas shopDatas = new ShopDatas();
        ShopInfo shopInfo = new ShopInfo();
        ShopEntity shopEntity = shopDao.selectById(id);
        shopInfo.setCollectNum(shopEntity.getCollectednumber());
        shopInfo.setDesc(shopEntity.getDescr());
        shopInfo.setId(shopEntity.getId());
        shopInfo.setLocation(shopEntity.getLocation());
        List<String> images = Arrays.asList(shopEntity.getImages().split(","));
        shopInfo.setImages(images);
        shopInfo.setRate(shopEntity.getRate());
        shopInfo.setView(shopEntity.getView().toString());
        shopInfo.setName(shopEntity.getName());
//这里两条数据使用mongoDb中的数据
//        shopInfo.setRecommendMenu();
//        shopInfo.setToDayMenu();
        shopDatas.setShopInfo(shopInfo);
        return shopDatas;
    }
}
