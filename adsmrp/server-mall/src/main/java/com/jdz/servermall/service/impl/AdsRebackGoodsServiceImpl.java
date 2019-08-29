package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsRebackGoods;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsRebackGoodsMapper;
import com.jdz.servermall.service.IAdsRebackGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 退货商品 服务层实现
 *
 * @author fht
 * @date 2019-08-09
 */
@Service
public class AdsRebackGoodsServiceImpl implements IAdsRebackGoodsService {
    @Autowired
    private AdsRebackGoodsMapper adsRebackGoodsMapper;

    /**
     * 查询退货商品信息
     *
     * @param adsRebackGoods 退货商品
     * @return 退货商品信息
     */
    @Override
    public AdsRebackGoods selectAdsRebackGoodsByReback(AdsRebackGoods adsRebackGoods) {
        return adsRebackGoodsMapper.selectAdsRebackGoodsByReback(adsRebackGoods);
    }

    /**
     * 查询退货商品列表
     *
     * @param adsRebackGoods 退货商品信息
     * @return 退货商品集合
     */
    @Override
    public List<AdsRebackGoods> selectAdsRebackGoodsList(AdsRebackGoods adsRebackGoods) {
        return adsRebackGoodsMapper.selectAdsRebackGoodsList(adsRebackGoods);
    }

    /**
     * 查询退货商品列表
     *
     * @param adsRebackGoods 退货商品信息数量
     * @return 退货商品集合
     */
    @Override
    public int selectAdsRebackGoodsTotal(AdsRebackGoods adsRebackGoods) {
        return adsRebackGoodsMapper.selectAdsRebackGoodsTotal(adsRebackGoods);
    }

    /**
     * 新增退货商品
     *
     * @param adsRebackGoods 退货商品信息
     * @return 结果
     */
    @Override
    public int insertAdsRebackGoods(AdsRebackGoods adsRebackGoods) {
        return adsRebackGoodsMapper.insertAdsRebackGoods(adsRebackGoods);
    }

    /**
     * 修改退货商品
     *
     * @param adsRebackGoods 退货商品信息
     * @return 结果
     */
    @Override
    public int updateAdsRebackGoods(AdsRebackGoods adsRebackGoods) {
        return adsRebackGoodsMapper.updateAdsRebackGoods(adsRebackGoods);
    }

    /**
     * 删除退货商品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsRebackGoodsByIds(String ids) {
        return adsRebackGoodsMapper.deleteAdsRebackGoodsByIds(Convert.toStrArray(ids));
    }

}
