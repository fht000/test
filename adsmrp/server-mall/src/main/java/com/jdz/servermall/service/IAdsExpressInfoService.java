package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsExpressInfo;

import java.util.List;

/**
 * 快递公司 服务层
 *
 * @author fht
 * @date 2019-08-10
 */
public interface IAdsExpressInfoService {
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
     * 查询快递公司列表数量
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
     * 删除快递公司信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsExpressInfoByIds(String ids);

    /**
     * 删除快递公司信息
     *
     * @return 结果
     */
    public int deleteAdsExpressInfoById(String id);

}
