package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsPlateGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 板块商品 数据层
 *
 * @author ruoyi
 * @date 2019-08-08
 */
@Mapper
public interface AdsPlateGoodsMapper {
    /**
     * 查询板块商品信息
     *
     * @param id 板块商品ID
     * @return 板块商品信息
     */
    public AdsPlateGoods selectAdsPlateGoodsById(String id);

    /**
     * 查询板块商品列表
     *
     * @param adsPlateGoods 板块商品信息
     * @return 板块商品集合
     */
    public List<AdsPlateGoods> selectAdsPlateGoodsList(AdsPlateGoods adsPlateGoods);

    /**
     * 新增板块商品
     *
     * @param adsPlateGoods 板块商品信息
     * @return 结果
     */
    public int insertAdsPlateGoods(AdsPlateGoods adsPlateGoods);

    /**
     * 批量新增板块商品
     *
     * @param adsPlateGoodsList 板块商品信息
     * @return 结果
     */
    public int insertBatchAdsPlateGoods(List<AdsPlateGoods> adsPlateGoodsList);

    /**
     * 修改板块商品
     *
     * @param adsPlateGoods 板块商品信息
     * @return 结果
     */
    public int updateAdsPlateGoods(AdsPlateGoods adsPlateGoods);

    /**
     * 删除板块商品
     *
     * @param id 板块商品ID
     * @return 结果
     */
    public int deleteAdsPlateGoodsById(String id);

    /**
     * 批量删除板块商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsPlateGoodsByIds(String[] ids);

}