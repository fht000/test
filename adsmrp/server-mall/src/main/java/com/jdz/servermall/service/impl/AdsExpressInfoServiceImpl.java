package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsExpressInfo;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsExpressInfoMapper;
import com.jdz.servermall.service.IAdsExpressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 快递公司 服务层实现
 *
 * @author fht
 * @date 2019-08-10
 */
@Service
public class AdsExpressInfoServiceImpl implements IAdsExpressInfoService {
    @Autowired
    private AdsExpressInfoMapper adsExpressInfoMapper;

    /**
     * 查询快递公司信息
     *
     * @param expressId 快递公司ID
     * @return 快递公司信息
     */
    @Override
    public AdsExpressInfo selectAdsExpressInfoById(String expressId) {
        return adsExpressInfoMapper.selectAdsExpressInfoById(expressId);
    }

    /**
     * 查询快递公司列表
     *
     * @param adsExpressInfo 快递公司信息
     * @return 快递公司集合
     */
    @Override
    public List<AdsExpressInfo> selectAdsExpressInfoList(AdsExpressInfo adsExpressInfo) {
        return adsExpressInfoMapper.selectAdsExpressInfoList(adsExpressInfo);
    }

    /**
     * 查询快递公司列表数量
     *
     * @param adsExpressInfo 快递公司信息
     * @return 快递公司集合
     */
    @Override
    public int selectAdsExpressInfoTotal(AdsExpressInfo adsExpressInfo) {
        return adsExpressInfoMapper.selectAdsExpressInfoTotal(adsExpressInfo);
    }

    /**
     * 新增快递公司
     *
     * @param adsExpressInfo 快递公司信息
     * @return 结果
     */
    @Override
    public int insertAdsExpressInfo(AdsExpressInfo adsExpressInfo) {
        return adsExpressInfoMapper.insertAdsExpressInfo(adsExpressInfo);
    }

    /**
     * 修改快递公司
     *
     * @param adsExpressInfo 快递公司信息
     * @return 结果
     */
    @Override
    public int updateAdsExpressInfo(AdsExpressInfo adsExpressInfo) {
        return adsExpressInfoMapper.updateAdsExpressInfo(adsExpressInfo);
    }

    /**
     * 删除快递公司对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsExpressInfoByIds(String ids) {
        return adsExpressInfoMapper.deleteAdsExpressInfoByIds(Convert.toStrArray(ids));
    }

    @Override
    public int deleteAdsExpressInfoById(String id) {
        return adsExpressInfoMapper.deleteAdsExpressInfoById(id);
    }

}
