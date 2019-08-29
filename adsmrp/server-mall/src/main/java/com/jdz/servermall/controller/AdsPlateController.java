package com.jdz.servermall.controller;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IAdsPlateInterface;
import com.jdz.apimall.model.AdsPlate;
import com.jdz.apimall.model.AdsPlateGoods;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.service.IAdsPlateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 板块 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-07
 */
@Controller
@RequestMapping("/adsPlate")
public class AdsPlateController implements IAdsPlateInterface {

    @Autowired
    private IAdsPlateService adsPlateService;

    /**
     * 查询板块信息
     *
     * @param plateId 板块ID
     * @return 板块信息
     */
    @RequestMapping("/selectAdsPlateById")
    @ResponseBody
    @Override
    public Response selectAdsPlateById(@RequestParam("plateId") String plateId) {
        Response response = new Response();
        AdsPlate adsPlate = adsPlateService.selectAdsPlateById(plateId);
        String data = JSON.toJSONString(adsPlate);
        response.setContent(data);
        return response;
    }

    /**
     * 查询板块列表
     *
     * @param adsPlateJson 板块信息
     * @return 板块集合
     */
    @RequestMapping("/selectAdsPlateList")
    @ResponseBody
    @Override
    public Response selectAdsPlateList(@RequestParam("adsPlateJson") String adsPlateJson) {
        Response response = new Response();
        AdsPlate adsPlate = JSON.parseObject(adsPlateJson, AdsPlate.class);
        List<AdsPlate> adsPlateList = adsPlateService.selectAdsPlateList(adsPlate);
        if(CollectionUtils.isEmpty(adsPlateList)){
            adsPlateList = Collections.EMPTY_LIST;
        }
        String data = JSON.toJSONString(adsPlateList);
        response.setContent(data);
        return response;
    }

    /**
     * 新增板块
     *
     * @param adsPlateJson 板块信息
     * @return 结果
     */
    @RequestMapping("/insertAdsPlate")
    @ResponseBody
    @Override
    public Response insertAdsPlate(@RequestParam("adsPlateJson") String adsPlateJson, @RequestParam(value = "adsPlateGoodsJson",required = false) String adsPlateGoodsJson) {
        AdsPlate adsPlate = JSON.parseObject(adsPlateJson, AdsPlate.class);

        List<AdsPlateGoods> adsPlateGoodsList = JSON.parseArray(adsPlateGoodsJson,AdsPlateGoods.class);
        adsPlateService.insertAdsPlate(adsPlate,adsPlateGoodsList);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }

    /**
     * 修改板块
     *
     * @param adsPlateJson 板块信息
     * @return 结果
     */
    @RequestMapping("/updateAdsPlate")
    @ResponseBody
    @Override
    public Response updateAdsPlate(@RequestParam("adsPlateJson") String adsPlateJson
            , @RequestParam(value = "idsStr",required = false) String idsStr) {
        AdsPlate adsPlate = JSON.parseObject(adsPlateJson, AdsPlate.class);

        Set<String> set = null;
        if(StringUtils.isNotBlank(idsStr)){
            String[] idsArry = Convert.toStrArray(idsStr);
            set = new HashSet<String>(Arrays.asList(idsArry));
        }
        adsPlateService.updateAdsPlate(adsPlate,set);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }

    /**
     * 删除板块信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @RequestMapping("/deleteAdsPlateByIds")
    @ResponseBody
    @Override
    public Response deleteAdsPlateByIds(String ids, String merchantId) {
        Response response = new Response();
        try{
            Assert.hasText(ids, "id不能为空");
            Assert.hasText(merchantId, "商家id不能为空");
        }catch(IllegalArgumentException exception){
            response.setCode(ResponseCode.FAIL.getCode());
            response.setDescrible(exception.getMessage());
            return response;
        }
        adsPlateService.deleteAdsPlateByIds(ids,merchantId);
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescrible(), ResponseCode.SUCCESS.getDescrible());
    }
}
