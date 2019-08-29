package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.model.AdsRoundPicture;
import com.jdz.jdzcommon.bean.PageInfoVo;
import com.jdz.jdzcommon.config.LogHelperConfig;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsRoundPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商家轮播图 信息操作处理
 *
 * @author fht
 * @date 2019-08-13
 */
@Controller
@RequestMapping("/adsRoundPicture")
public class AdsRoundPictureInfoController extends BaseController {

    @Autowired
    private IAdsRoundPictureService adsRoundPictureService;


    /**
     * 查询商家轮播图列表
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String jsonString) {
        AdsRoundPicture adsRoundPicture = JSON.parseObject(jsonString,AdsRoundPicture.class);
        startDivPage(adsRoundPicture.getPageNum(),adsRoundPicture.getPageSize());
        List<AdsRoundPicture> list = adsRoundPictureService.selectAdsRoundPictureList(adsRoundPicture);
        int total = adsRoundPictureService.selectAdsRoundPictureTotal(adsRoundPicture);
        PageInfoVo pageInfoVo = new PageInfoVo();
        pageInfoVo.setObject(list);
        pageInfoVo.setTotal(total);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(pageInfoVo));
    }


    /**
     * 查询商家轮播图
     * @param jsonString
     * @return
     */
    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String jsonString){
        AdsRoundPicture adsRoundPicture = adsRoundPictureService.selectAdsRoundPictureById(jsonString);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsRoundPicture));
    }

    /**
     * 新增保存商家轮播图
     */
    @PostMapping("/add")
    @ResponseBody
    public Response addSave(String jsonString) {
        AdsRoundPicture adsRoundPicture = JSON.parseObject(jsonString,AdsRoundPicture.class);
        try {
            int insertAdsRoundPicture = adsRoundPictureService.insertAdsRoundPicture(adsRoundPicture);
            if (insertAdsRoundPicture <= 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"新增轮播图失败");
        } catch (Exception e) {
            LogHelperConfig.writeErrLog("新增失败","add",e.getMessage());
            new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"新增轮播图失败");
        }
       return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),"新增轮播图成功");
    }


    /**
     * 修改保存商家轮播图
     */
    @PostMapping("/edit")
    @ResponseBody
    public Response editSave(String jsonString) {
        AdsRoundPicture adsRoundPicture = JSON.parseObject(jsonString,AdsRoundPicture.class);
        try {
            int insertAdsRoundPicture = adsRoundPictureService.updateAdsRoundPicture(adsRoundPicture);
            if (insertAdsRoundPicture <= 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"更新轮播图失败");
        } catch (Exception e) {
            LogHelperConfig.writeErrLog("更新失败","edit",e.getMessage());
            new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"更新轮播图失败");
        }
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),"更新轮播图成功");
    }

    /**
     * 删除商家轮播图
     */
    @PostMapping("/del")
    @ResponseBody
    public Response remove(String id) {
        try {
            int deleteAdsRoundPicture = adsRoundPictureService.deleteAdsRoundPictureByIds(id);
            if (deleteAdsRoundPicture <= 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"删除轮播图失败");
        } catch (Exception e) {
            LogHelperConfig.writeErrLog("删除失败","del",e.getMessage());
            new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorParam.getValue(),"删除轮播图失败");
        }
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),"删除轮播图成功");
    }

}
