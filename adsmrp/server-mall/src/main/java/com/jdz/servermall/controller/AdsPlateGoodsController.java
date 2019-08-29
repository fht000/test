package com.jdz.servermall.controller;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IAdsPlateGoodsInterface;
import com.jdz.apimall.model.AdsPlateGoods;
import com.jdz.servermall.service.IAdsPlateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * 板块商品 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/adsPlateGoods")
public class AdsPlateGoodsController implements IAdsPlateGoodsInterface {

    private String prefix = "system/adsPlateGoods";

    @Autowired
    private IAdsPlateGoodsService adsPlateGoodsService;


    /**
     * 查询板块商品信息
     *
     * @param plateId 板块商品ID
     * @return 板块商品信息
     */
    @RequestMapping("/selectAdsPlateGoodsById")
    @ResponseBody
    @Override
    public Response selectAdsPlateGoodsById(String plateId) {
        Response response = new Response();
        AdsPlateGoods adsPlateGoods = adsPlateGoodsService.selectAdsPlateGoodsById(plateId);
        String data = JSON.toJSONString(adsPlateGoods);
        response.setContent(data);
        return response;
    }

    /**
     * 查询板块商品列表
     *
     * @param adsPlateGoodsJson 板块商品信息
     * @return 板块商品集合
     */
    @RequestMapping("/selectAdsPlateGoodsList")
    @ResponseBody
    @Override
    public Response selectAdsPlateGoodsList(String adsPlateGoodsJson) {
        Response response = new Response();
        AdsPlateGoods adsPlateGoods = JSON.parseObject(adsPlateGoodsJson, AdsPlateGoods.class);
        List<AdsPlateGoods> adsPlateGoodsList = adsPlateGoodsService.selectAdsPlateGoodsList(adsPlateGoods);
        if(CollectionUtils.isEmpty(adsPlateGoodsList)){
            adsPlateGoodsList = Collections.EMPTY_LIST;
        }
        String data = JSON.toJSONString(adsPlateGoodsList);
        response.setContent(data);
        return response;
    }

    /**
     * 新增板块商品
     *
     * @param adsPlateGoodsJson 板块商品信息
     * @return 结果
     */
    @RequestMapping("/insertAdsPlateGoods")
    @ResponseBody
    @Override
    public Response insertAdsPlateGoods(String adsPlateGoodsJson) {
        AdsPlateGoods adsPlateGoods = JSON.parseObject(adsPlateGoodsJson, AdsPlateGoods.class);
        adsPlateGoodsService.insertAdsPlateGoods(adsPlateGoods);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }

    /**
     * 修改板块商品
     *
     * @param adsPlateGoodsJson 板块商品信息
     * @return 结果
     */
    @RequestMapping("/updateAdsPlateGoods")
    @ResponseBody
    @Override
    public Response updateAdsPlateGoods(String adsPlateGoodsJson) {
        AdsPlateGoods adsPlateGoods = JSON.parseObject(adsPlateGoodsJson, AdsPlateGoods.class);
        adsPlateGoodsService.updateAdsPlateGoods(adsPlateGoods);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }

    /**
     * 删除板块商品信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @RequestMapping("/deleteAdsPlateGoodsByIds")
    @ResponseBody
    @Override
    public Response deleteAdsPlateGoodsByIds(String ids) {
        adsPlateGoodsService.deleteAdsPlateGoodsByIds(ids);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }
}
