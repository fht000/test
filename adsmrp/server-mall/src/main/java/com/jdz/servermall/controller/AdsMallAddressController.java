package com.jdz.servermall.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jdz.apicommon.enums.MsgEnum;
import com.jdz.apicommon.enums.ResponseCode;
import com.jdz.apicommon.response.Response;
import com.jdz.apimall.mallinterface.IAddressInterface;
import com.jdz.apimall.model.AdsMallAddress;
import com.jdz.jdzcommon.controller.BaseController;
import com.jdz.servermall.service.IAdsMallAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商城地址 信息操作处理
 *
 * @author fht
 * @date 2019-08-19
 */
@RestController
@RequestMapping("/adsMallAddress")
public class AdsMallAddressController extends BaseController implements IAddressInterface {
    private String prefix = "system/adsMallAddress";

    @Autowired
    private IAdsMallAddressService adsMallAddressService;



    /**
     * 查询商城地址列表
     */
    @PostMapping("/list")
    public Response list(String jsonString) {
        AdsMallAddress adsMallAddress = JSON.parseObject(jsonString, AdsMallAddress.class);
        List<AdsMallAddress> adsMallAddresses = adsMallAddressService.selectAdsMallAddressList(adsMallAddress);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsMallAddresses));
    }

    /**
     * 查询商城地址
     */
    @PostMapping("/findOne")
    public Response findOne(String jsonString) {
        AdsMallAddress adsMallAddress = adsMallAddressService.selectAdsMallAddressById(jsonString);
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),JSON.toJSONString(adsMallAddress));
    }

    /**
     * 新增保存商城地址
     */
    @PostMapping("/add")
    public Response add(String jsonString) {
        AdsMallAddress adsMallAddress = JSON.parseObject(jsonString, AdsMallAddress.class);
        int mallAddress = adsMallAddressService.insertAdsMallAddress(adsMallAddress);
        if (mallAddress < 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorAddAddress.getValue(),MsgEnum.ErrorAddAddress.getValue());
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 修改保存商城地址
     */
    @PostMapping("/edit")
    public Response edit(String jsonString) {
        AdsMallAddress adsMallAddress = JSON.parseObject(jsonString, AdsMallAddress.class);
        int mallAddress = adsMallAddressService.updateAdsMallAddress(adsMallAddress);
        if (mallAddress < 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorEditAddress.getValue(),MsgEnum.ErrorEditAddress.getValue());
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 修改默认商城地址
     */
    @PostMapping("/editDefault")
    public Response editDefault(String jsonString) {
        AdsMallAddress adsMallAddress = JSON.parseObject(jsonString, AdsMallAddress.class);
        int mallAddress = adsMallAddressService.updateAdsMallAddressDefault(adsMallAddress);
        if (mallAddress < 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorEditAddress.getValue(),MsgEnum.ErrorEditAddress.getValue());
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }

    /**
     * 删除商城地址
     */
    @PostMapping("/del")
    public Response del(String id) {
        int mallAddress = adsMallAddressService.deleteAdsMallAddressById(id);
        if (mallAddress < 0) return new Response(ResponseCode.FAIL.getCode(),MsgEnum.ErrorDelAddress.getValue(),MsgEnum.ErrorDelAddress.getValue());
        return new Response(ResponseCode.SUCCESS.getCode(),MsgEnum.SuccessParam.getValue(),MsgEnum.SuccessParam.getValue());
    }
}
