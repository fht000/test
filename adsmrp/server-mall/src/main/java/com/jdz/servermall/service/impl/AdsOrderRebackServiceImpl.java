package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsOrderReback;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsOrderRebackMapper;
import com.jdz.servermall.service.IAdsOrderRebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户退货订单 服务层实现
 *
 * @author fht
 * @date 2019-08-09
 */
@Service
public class AdsOrderRebackServiceImpl implements IAdsOrderRebackService {
    @Autowired
    private AdsOrderRebackMapper adsOrderRebackMapper;

    /**
     * 查询用户退货订单信息
     *
     * @param rebackId 用户退货订单ID
     * @return 用户退货订单信息
     */
    @Override
    public AdsOrderReback selectAdsOrderRebackById(String rebackId) {
        return adsOrderRebackMapper.selectAdsOrderRebackById(rebackId);
    }

    /**
     * 查询用户退货订单列表
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 用户退货订单集合
     */
    @Override
    public List<AdsOrderReback> selectAdsOrderRebackList(AdsOrderReback adsOrderReback) {
        return adsOrderRebackMapper.selectAdsOrderRebackList(adsOrderReback);
    }

    @Override
    public int selectAdsOrderRebackTotal(AdsOrderReback adsOrderReback) {
        return adsOrderRebackMapper.selectAdsOrderRebackTotal(adsOrderReback);
    }

    /**
     * 新增用户退货订单
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 结果
     */
    @Override
    public int insertAdsOrderReback(AdsOrderReback adsOrderReback) {
        return adsOrderRebackMapper.insertAdsOrderReback(adsOrderReback);
    }

    /**
     * 修改用户退货订单
     *
     * @param adsOrderReback 用户退货订单信息
     * @return 结果
     */
    @Override
    public int updateAdsOrderReback(AdsOrderReback adsOrderReback) {
        return adsOrderRebackMapper.updateAdsOrderReback(adsOrderReback);
    }

    /**
     * 删除用户退货订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsOrderRebackByIds(String ids) {
        return adsOrderRebackMapper.deleteAdsOrderRebackByIds(Convert.toStrArray(ids));
    }

}
