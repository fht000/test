package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IUserCommentInterface;
import com.jdz.apimall.model.AdsUserComment;
import com.jdz.jdzcommon.bean.AjaxResult;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户评论 信息操作处理
 *
 * @author fht
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/adsUserComment")
public class AdsUserCommentController extends BaseController implements IUserCommentInterface {

    @Autowired
    private IAdsUserCommentService adsUserCommentService;




    /**
     * 新增保存用户评论
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AdsUserComment adsUserComment) {
        return toAjax(adsUserCommentService.insertAdsUserComment(adsUserComment));
    }


    /**
     * 修改保存用户评论
     */
    @PostMapping("/edit")
    @ResponseBody
    public Response editSave(String jsonStr) {
        AdsUserComment adsUserComment = JSON.parseObject(jsonStr, AdsUserComment.class);
        try {

            adsUserCommentService.updateAdsUserComment(adsUserComment);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResponseCode.FAIL.getCode(), MsgEnum.ErrorParam.getValue(),"修改失败");
        }
        return new Response(ResponseCode.SUCCESS.getCode(), MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }


    /**
     * 查询评论
     * @param jsonStr
     * @return
     */
    @PostMapping("/findOne")
    @ResponseBody
    public Response findOne(String jsonStr) {
        AdsUserComment adsUserComment1 = JSON.parseObject(jsonStr, AdsUserComment.class);
        AdsUserComment adsUserComment = adsUserCommentService.selectAdsUserCommentByComment(adsUserComment1);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsUserComment));
    }

    /**
     * 查询评论列表
     * @param jsonStr
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public Response list(String jsonStr) {
        AdsUserComment adsUserComment1 = JSON.parseObject(jsonStr, AdsUserComment.class);
        List<AdsUserComment> adsUserComment = adsUserCommentService.selectAdsUserCommentList(adsUserComment1);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsUserComment));
    }
}
