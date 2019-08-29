package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsMallAddress;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsMallAddressMapper;
import com.jdz.servermall.service.IAdsMallAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商城地址 服务层实现
 *
 * @author fht
 * @date 2019-08-19
 */
@Service
public class AdsMallAddressServiceImpl implements IAdsMallAddressService {
    @Autowired
    private AdsMallAddressMapper adsMallAddressMapper;

    /**
     * 查询商城地址信息
     *
     * @param addressId 商城地址ID
     * @return 商城地址信息
     */
    @Override
    public AdsMallAddress selectAdsMallAddressById(String addressId) {
        return adsMallAddressMapper.selectAdsMallAddressById(addressId);
    }

    /**
     * 查询商城地址列表
     *
     * @param adsMallAddress 商城地址信息
     * @return 商城地址集合
     */
    @Override
    public List<AdsMallAddress> selectAdsMallAddressList(AdsMallAddress adsMallAddress) {
        return adsMallAddressMapper.selectAdsMallAddressList(adsMallAddress);
    }

    /**
     * 新增商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    @Override
    public int insertAdsMallAddress(AdsMallAddress adsMallAddress) {
        return adsMallAddressMapper.insertAdsMallAddress(adsMallAddress);
    }

    /**
     * 修改商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    @Override
    public int updateAdsMallAddress(AdsMallAddress adsMallAddress) {
        return adsMallAddressMapper.updateAdsMallAddress(adsMallAddress);
    }

    /**
     * 修改默认商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    @Override
    public int updateAdsMallAddressDefault(AdsMallAddress adsMallAddress) {
        return adsMallAddressMapper.updateAdsMallAddressDefault(adsMallAddress);
    }

    /**
     * 删除商城地址对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsMallAddressById(String id) {
        return adsMallAddressMapper.deleteAdsMallAddressById(id);
    }

}
