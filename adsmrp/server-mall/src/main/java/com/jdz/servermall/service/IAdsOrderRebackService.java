package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsOrderReback;

import java.util.List;

/**
 * 用户退货订单 服务层
 *
 * @author fht
 * @date 2019-08-09
 */
public interface IAdsOrderRebackService {
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
     * 查询用户退货订单数量
     *
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
     * 删除用户退货订单信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsOrderRebackByIds(String ids);

}
