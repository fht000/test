package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsMallAddress;

import java.util.List;

/**
 * 商城地址 服务层
 *
 * @author fht
 * @date 2019-08-19
 */
public interface IAdsMallAddressService {
    /**
     * 查询商城地址信息
     *
     * @param addressId 商城地址ID
     * @return 商城地址信息
     */
    public AdsMallAddress selectAdsMallAddressById(String addressId);

    /**
     * 查询商城地址列表
     *
     * @param adsMallAddress 商城地址信息
     * @return 商城地址集合
     */
    public List<AdsMallAddress> selectAdsMallAddressList(AdsMallAddress adsMallAddress);

    /**
     * 新增商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    public int insertAdsMallAddress(AdsMallAddress adsMallAddress);

    /**
     * 修改商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    public int updateAdsMallAddress(AdsMallAddress adsMallAddress);

    int updateAdsMallAddressDefault(AdsMallAddress adsMallAddress);

    /**
     * 删除商城地址信息
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsMallAddressById(String id);

}
