package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsPlate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 板块 数据层
 *
 * @author ruoyi
 * @date 2019-08-07
 */
@Mapper
public interface AdsPlateMapper {
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
    public int insertAdsPlate(AdsPlate adsPlate);

    /**
     * 修改板块
     *
     * @param adsPlate 板块信息
     * @return 结果
     */
    public int updateAdsPlate(AdsPlate adsPlate);

    /**
     * 删除板块
     *
     * @param plateId 板块ID
     * @return 结果
     */
    public int deleteAdsPlateById(String plateId);

    /**
     * 批量删除板块
     *
     * @param plateIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsPlateByIds(String[] plateIds);

}