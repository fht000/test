package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsOrderReback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户退货订单 数据层
 *
 * @author fht
 * @date 2019-08-09
 */
@Mapper
public interface AdsOrderRebackMapper {
    /**
     * 查询用户退货订单信息
     *
     * @param rebackId 用户退货订单ID
     * @return 用户退货订单信息
     */
    public AdsOrderReback selectAdsOrderRebackById(String rebackId);

    /**
     * 查询用户退货订单列表
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 用户退货订单集合
     */
    public List<AdsOrderReback> selectAdsOrderRebackList(AdsOrderReback adsOrderReback);


    /**
     * 查询用户退货订单列表数量
     * @param adsOrderReback 用户退货订单信息
     * @return 用户退货订单数量
     */
    public int selectAdsOrderRebackTotal(AdsOrderReback adsOrderReback);

    /**
     * 新增用户退货订单
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 结果
     */
    public int insertAdsOrderReback(AdsOrderReback adsOrderReback);

    /**
     * 修改用户退货订单
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 结果
     */
    public int updateAdsOrderReback(AdsOrderReback adsOrderReback);

    /**
     * 删除用户退货订单
     *
     * @param rebackId 用户退货订单ID
     * @return 结果
     */
    public int deleteAdsOrderRebackById(String rebackId);

    /**
     * 批量删除用户退货订单
     *
     * @param rebackIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsOrderRebackByIds(String[] rebackIds);

}