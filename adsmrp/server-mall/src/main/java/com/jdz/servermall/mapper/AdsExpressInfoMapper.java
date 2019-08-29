package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsExpressInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 快递公司 数据层
 *
 * @author fht
 * @date 2019-08-10
 */

@Mapper
public interface AdsExpressInfoMapper {
    /**
     * 查询快递公司信息
     *
     * @param expressId 快递公司ID
     * @return 快递公司信息
     */
    public AdsExpressInfo selectAdsExpressInfoById(String expressId);

    /**
     * 查询快递公司列表
     *
     * @param adsExpressInfo 快递公司信息
     * @return 快递公司集合
     */
    public List<AdsExpressInfo> selectAdsExpressInfoList(AdsExpressInfo adsExpressInfo);

    /**
     * 查询快递公司数量
     *
     * @param adsExpressInfo 快递公司信息
     * @return 快递公司集合
     */
    public int selectAdsExpressInfoTotal(AdsExpressInfo adsExpressInfo);

    /**
     * 新增快递公司
     *
     * @param adsExpressInfo 快递公司信息
     * @return 结果
     */
    public int insertAdsExpressInfo(AdsExpressInfo adsExpressInfo);

    /**
     * 修改快递公司
     *
     * @param adsExpressInfo 快递公司信息
     * @return 结果
     */
    public int updateAdsExpressInfo(AdsExpressInfo adsExpressInfo);

    /**
     * 删除快递公司
     *
     * @param expressId 快递公司ID
     * @return 结果
     */
    public int deleteAdsExpressInfoById(String expressId);

    /**
     * 批量删除快递公司
     *
     * @param expressIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsExpressInfoByIds(String[] expressIds);

}