package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsRebackGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 退货商品 数据层
 *
 * @author fht
 * @date 2019-08-09
 */
@Mapper
public interface AdsRebackGoodsMapper {
    /**
     * 查询退货商品信息
     *
     * @param adsRebackGoods 退货商品I
     * @return 退货商品信息
     */
    public AdsRebackGoods selectAdsRebackGoodsByReback(AdsRebackGoods adsRebackGoods);

    /**
     * 查询退货商品列表
     *
     * @param adsRebackGoods 退货商品信息
     * @return 退货商品集合
     */
    public List<AdsRebackGoods> selectAdsRebackGoodsList(AdsRebackGoods adsRebackGoods);

    /**
     * 查询退货商品数量
     *
     * @param adsRebackGoods 退货商品信息
     * @return 退货商品集合
     */
    public int selectAdsRebackGoodsTotal(AdsRebackGoods adsRebackGoods);

    /**
     * 新增退货商品
     *
     * @param adsRebackGoods 退货商品信息
     * @return 结果
     */
    public int insertAdsRebackGoods(AdsRebackGoods adsRebackGoods);

    /**
     * 修改退货商品
     *
     * @param adsRebackGoods 退货商品信息
     * @return 结果
     */
    public int updateAdsRebackGoods(AdsRebackGoods adsRebackGoods);

    /**
     * 删除退货商品
     *
     * @param id 退货商品ID
     * @return 结果
     */
    public int deleteAdsRebackGoodsById(String id);

    /**
     * 批量删除退货商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsRebackGoodsByIds(String[] ids);

}