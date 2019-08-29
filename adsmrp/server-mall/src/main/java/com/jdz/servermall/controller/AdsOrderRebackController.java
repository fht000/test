package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IOrderRebackInterface;
import com.jdz.apimall.model.AdsOrderReback;
import com.jdz.jdzcommon.bean.PageInfoVo;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsOrderRebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户退货订单 信息操作处理
 *
 * @author fht
 * @date 2019-08-09
 */
@Controller
@RequestMapping("/adsOrderReback")
public class AdsOrderRebackController extends BaseController implements IOrderRebackInterface {
    private String prefix = "system/adsOrderReback";

    @Autowired
    private IAdsOrderRebackService adsOrderRebackService;



    /**
    * 查询用户退货订单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String noticeJson) {
        AdsOrderReback adsOrderReback = JSON.parseObject(noticeJson, AdsOrderReback.class);
        startDivPage(adsOrderReback.getPageNum(),adsOrderReback.getPageSize());
        List<AdsOrderReback> list = adsOrderRebackService.selectAdsOrderRebackList(adsOrderReback);
        int total = adsOrderRebackService.selectAdsOrderRebackTotal(adsOrderReback);
        PageInfoVo pageInfoVo = new PageInfoVo();
        pageInfoVo.setObject(list);
        pageInfoVo.setTotal(total);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(pageInfoVo));
    }

    /**
     * 查询用户退货订单列表
     */
    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String noticeJson) {
        AdsOrderReback adsOrderReback = adsOrderRebackService.selectAdsOrderRebackById(noticeJson);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsOrderReback));
    }

    /**
     * 新增保存用户退货订单
     */
    @PostMapping("/add")
    @ResponseBody
    public Response add(String noticeJson) {
        AdsOrderReback adsOrderReback = JSON.parseObject(noticeJson, AdsOrderReback.class);
        try {
            adsOrderRebackService.insertAdsOrderReback(adsOrderReback);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorParam.getValue(),MsgEnum.ErrorParam.getValue());
        }
            return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),"新增退货订单成功");
    }

    /**
     * 修改保存用户退货订单
     */
    @PostMapping("/edit")
    @ResponseBody
    public Response edit(String noticeJson) {
        AdsOrderReback adsOrderReback = JSON.parseObject(noticeJson, AdsOrderReback.class);
        try {
            adsOrderRebackService.updateAdsOrderReback(adsOrderReback);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorParam.getValue(),MsgEnum.ErrorParam.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),"更新退货订单成功");
    }
}
