package com.jdz.servermall.service.impl;

import com.jdz.apimall.model.AdsPlateGoods;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsPlateGoodsMapper;
import com.jdz.servermall.service.IAdsPlateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 板块商品 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-08
 */
@Service
public class AdsPlateGoodsServiceImpl implements IAdsPlateGoodsService {

    @Autowired
    private AdsPlateGoodsMapper adsPlateGoodsMapper;

    /**
     * 查询板块商品信息
     *
     * @param id 板块商品ID
     * @return 板块商品信息
     */
    @Override
    public AdsPlateGoods selectAdsPlateGoodsById(String id) {
        return adsPlateGoodsMapper.selectAdsPlateGoodsById(id);
    }

    /**
     * 查询板块商品列表
     *
     * @param adsPlateGoods 板块商品信息
     * @return 板块商品集合
     */
    @Override
    public List<AdsPlateGoods> selectAdsPlateGoodsList(AdsPlateGoods adsPlateGoods) {
        return adsPlateGoodsMapper.selectAdsPlateGoodsList(adsPlateGoods);
    }

    /**
     * 新增板块商品
     *
     * @param adsPlateGoods 板块商品信息
     * @return 结果
     */
    @Override
    public int insertAdsPlateGoods(AdsPlateGoods adsPlateGoods) {
        return adsPlateGoodsMapper.insertAdsPlateGoods(adsPlateGoods);
    }

    /**
     * 批量新增板块商品
     *
     * @param adsPlateGoodsList
     * @return
     */
    @Override
    public int insertBatchAdsPlateGoods(List<AdsPlateGoods> adsPlateGoodsList) {
        return adsPlateGoodsMapper.insertBatchAdsPlateGoods(adsPlateGoodsList);
    }

    /**
     * 修改板块商品
     *
     * @param adsPlateGoods 板块商品信息
     * @return 结果
     */
    @Override
    public int updateAdsPlateGoods(AdsPlateGoods adsPlateGoods) {
        return adsPlateGoodsMapper.updateAdsPlateGoods(adsPlateGoods);
    }

    /**
     * 删除板块商品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsPlateGoodsByIds(String ids) {
        return adsPlateGoodsMapper.deleteAdsPlateGoodsByIds(Convert.toStrArray(ids));
    }

}
