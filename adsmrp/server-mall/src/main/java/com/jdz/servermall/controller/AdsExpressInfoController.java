package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IExpressInterface;
import com.jdz.apimall.model.AdsExpressInfo;
import com.jdz.jdzcommon.bean.PageInfoVo;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsExpressInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 快递公司 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-10
 */
@Controller
@RequestMapping("/adsExpressInfo")
public class AdsExpressInfoController extends BaseController implements IExpressInterface {
    private String prefix = "system/adsExpressInfo";

    @Autowired
    private IAdsExpressInfoService adsExpressInfoService;

    @RequiresPermissions("system:adsExpressInfo:view")
    @GetMapping()
    public String adsExpressInfo() {
        return prefix + "/adsExpressInfo";
    }

    /**
     * 查询快递公司列表
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String jsonString) {
        AdsExpressInfo adsExpressInfo = JSON.parseObject(jsonString,AdsExpressInfo.class);
        startDivPage(adsExpressInfo.getPageNum(),adsExpressInfo.getPageSize());
        List<AdsExpressInfo> list = adsExpressInfoService.selectAdsExpressInfoList(adsExpressInfo);
        int selectAdsExpressInfoTotal = adsExpressInfoService.selectAdsExpressInfoTotal(adsExpressInfo);
        PageInfoVo pageInfoVo = new PageInfoVo();
        pageInfoVo.setObject(list);
        pageInfoVo.setTotal(selectAdsExpressInfoTotal);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(pageInfoVo));
    }

    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String expressId) {
        AdsExpressInfo adsExpressInfo = adsExpressInfoService.selectAdsExpressInfoById(expressId);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsExpressInfo));
    }


    /**
     * 新增保存快递公司
     */
    @PostMapping("/add")
    @ResponseBody
    public Response add(String jsonString) {
        AdsExpressInfo adsExpressInfo = JSON.parseObject(jsonString,AdsExpressInfo.class);
        try {
            adsExpressInfoService.insertAdsExpressInfo(adsExpressInfo);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),MsgEnum.ErrorParam.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }


    /**
     * 修改保存快递公司
     */
    @PostMapping("/edit")
    @ResponseBody
    public Response edit(String jsonString) {
        AdsExpressInfo adsExpressInfo = JSON.parseObject(jsonString,AdsExpressInfo.class);
        try {
            adsExpressInfoService.updateAdsExpressInfo(adsExpressInfo);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),MsgEnum.ErrorParam.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 删除快递公司
     */
    @PostMapping("/del")
    @ResponseBody
    public Response del(String expressId) {
        try {
            adsExpressInfoService.deleteAdsExpressInfoById(expressId);
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),MsgEnum.ErrorParam.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }


}
