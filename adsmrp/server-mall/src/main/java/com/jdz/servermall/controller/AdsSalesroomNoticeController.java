package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.INoticeInterface;
import com.jdz.apimall.model.AdsSalesroomNotice;
import com.jdz.jdzcommon.bean.PageInfoVo;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.jdzcommon.page.TableDataInfo;
import com.jdz.servermall.service.IAdsSalesroomNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商铺公告 信息操作处理
 *
 * @author fht
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/salesroomNotice")
public class AdsSalesroomNoticeController extends BaseController implements INoticeInterface {

    @Autowired
    private IAdsSalesroomNoticeService adsSalesroomNoticeService;


    /**
     * 查询商铺公告列表
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String noticeJson) {
        AdsSalesroomNotice adsSalesroomNotice = JSON.parseObject(noticeJson, AdsSalesroomNotice.class);
        startDivPage(adsSalesroomNotice.getPageNum(),adsSalesroomNotice.getPageSize());
        List<AdsSalesroomNotice> list = adsSalesroomNoticeService.selectAdsSalesroomNoticeList(adsSalesroomNotice);
        PageInfoVo pageInfoVo = new PageInfoVo();
        pageInfoVo.setObject(list);
        pageInfoVo.setTotal(adsSalesroomNoticeService.selectAdsSalesroomNoticeTotal(adsSalesroomNotice));
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(pageInfoVo));
    }

    /**
     * 查询商铺公告
     */
    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String noticeId) {
        AdsSalesroomNotice adsSalesroomNotice = adsSalesroomNoticeService.selectAdsSalesroomNoticeById(noticeId);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsSalesroomNotice));
    }

    /**
     * 新增保存商铺公告
     */
    @PostMapping("/addNotice")
    @ResponseBody
    public Response add(String noticeJson) {
        AdsSalesroomNotice adsSalesroomNotice = JSON.parseObject(noticeJson, AdsSalesroomNotice.class);
        try {
            int insertAdsSalesroomNotice = adsSalesroomNoticeService.insertAdsSalesroomNotice(adsSalesroomNotice);
            if (insertAdsSalesroomNotice <= 0){
                return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorAddSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
            }
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorAddSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 修改保存商铺公告
     */
    @PostMapping("/editNotice")
    @ResponseBody
    public Response edit(String noticeJson) {
        AdsSalesroomNotice adsSalesroomNotice = JSON.parseObject(noticeJson, AdsSalesroomNotice.class);
        try {
            int updateAdsSalesroomNotice = adsSalesroomNoticeService.updateAdsSalesroomNotice(adsSalesroomNotice);
            if ( updateAdsSalesroomNotice <= 0)
                return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorEditSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorEditSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 删除商铺公告
     */
    @PostMapping("/delNotice")
    @ResponseBody
    public Response del(String noticeId) {
        try {
            int deleteAdsSalesroomNoticeById = adsSalesroomNoticeService.deleteAdsSalesroomNoticeById(noticeId);
            if (deleteAdsSalesroomNoticeById <= 0)
                return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorAddSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
        }catch (Exception e){
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorAddSaleroomNotice.getValue(),MsgEnum.ErrorAddSaleroomNotice.getValue());
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }
}
