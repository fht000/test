package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsMallAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商城地址 数据层
 *
 * @author fht
 * @date 2019-08-19
 */
@Mapper
public interface AdsMallAddressMapper {
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

    /**
     * 修改默认商城地址
     *
     * @param adsMallAddress 商城地址信息
     * @return 结果
     */
    public int updateAdsMallAddressDefault(AdsMallAddress adsMallAddress);

    /**
     * 删除商城地址
     *
     * @param addressId 商城地址ID
     * @return 结果
     */
    public int deleteAdsMallAddressById(String addressId);

    /**
     * 批量删除商城地址
     *
     * @param addressIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsMallAddressByIds(String[] addressIds);

}