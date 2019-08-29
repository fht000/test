package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IRebackGoodsInterface;
import com.jdz.apimall.model.AdsRebackGoods;
import com.jdz.jdzcommon.bean.PageInfoVo;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsRebackGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 退货商品 信息操作处理
 *
 * @author fht
 * @date 2019-08-09
 */
@Controller
@RequestMapping("/adsRebackGoods")
public class AdsRebackGoodsController extends BaseController implements IRebackGoodsInterface {

    @Autowired
    private IAdsRebackGoodsService adsRebackGoodsService;


    /**
     * 查询退货商品列表
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String noticeJson) {
        AdsRebackGoods adsRebackGoods = JSON.parseObject(noticeJson, AdsRebackGoods.class);
        startDivPage(adsRebackGoods.getPageNum(),adsRebackGoods.getPageSize());
        List<AdsRebackGoods> adsRebackGoods1 = adsRebackGoodsService.selectAdsRebackGoodsList(adsRebackGoods);
        int total = adsRebackGoodsService.selectAdsRebackGoodsTotal(adsRebackGoods);
        PageInfoVo pageInfoVo = new PageInfoVo();
        pageInfoVo.setTotal(total);
        pageInfoVo.setObject(adsRebackGoods1);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(pageInfoVo));
    }

    /**
     * 查询退货商品列表
     */
    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String noticeJson) {
        AdsRebackGoods adsRebackGoods = JSON.parseObject(noticeJson, AdsRebackGoods.class);
        List<AdsRebackGoods> adsRebackGoods1 = adsRebackGoodsService.selectAdsRebackGoodsList(adsRebackGoods);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsRebackGoods1));
    }

    /**
     * 新增保存退货商品
     */
    @PostMapping("/add")
    @ResponseBody
    public Response add(String noticeJson) {
        AdsRebackGoods adsRebackGoods = JSON.parseObject(noticeJson, AdsRebackGoods.class);
        try {
            adsRebackGoodsService.insertAdsRebackGoods(adsRebackGoods);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorParam.getValue(),"新增退货商品失败");
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),"新增退货商品成功");
    }
}
