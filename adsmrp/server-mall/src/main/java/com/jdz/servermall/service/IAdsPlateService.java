package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsPlate;
import com.jdz.apimall.model.AdsPlateGoods;

import java.util.List;
import java.util.Set;

/**
 * 板块 服务层
 *
 * @author ruoyi
 * @date 2019-08-07
 */
public interface IAdsPlateService {
    /**
     * 查询板块信息
     *
     * @param plateId 板块ID
     * @return 板块信息
     */
    public AdsPlate selectAdsPlateById(String plateId);

    /**
     * 查询板块列表
     *
     * @param adsPlate 板块信息
     * @return 板块集合
     */
    public List<AdsPlate> selectAdsPlateList(AdsPlate adsPlate);

    /**
     * 新增板块
     *
     * @param adsPlate 板块信息
     * @return 结果
     */
    public int insertAdsPlate(AdsPlate adsPlate, List<AdsPlateGoods> adsPlateGoodsList);

    /**
     * 修改板块
     *
     * @param adsPlate 板块信息
     * @return 结果
     */
    public int updateAdsPlate(AdsPlate adsPlate, Set<String> ids);

    /**
     * 删除板块信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsPlateByIds(String ids, String merchantId);

}
