package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsRoundPicture;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsRoundPictureMapper;
import com.jdz.servermall.service.IAdsRoundPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商家轮播图 服务层实现
 *
 * @author fht
 * @date 2019-08-13
 */
@Service
public class AdsRoundPictureServiceImpl implements IAdsRoundPictureService {
    @Autowired
    private AdsRoundPictureMapper adsRoundPictureMapper;

    /**
     * 查询商家轮播图信息
     *
     * @param pictureId 商家轮播图ID
     * @return 商家轮播图信息
     */
    @Override
    public AdsRoundPicture selectAdsRoundPictureById(String pictureId) {
        return adsRoundPictureMapper.selectAdsRoundPictureById(pictureId);
    }

    @Override
    public int selectAdsRoundPictureTotal(AdsRoundPicture adsRoundPicture) {
        return adsRoundPictureMapper.selectAdsRoundPictureTotal(adsRoundPicture);
    }

    /**
     * 查询商家轮播图列表
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 商家轮播图集合
     */
    @Override
    public List<AdsRoundPicture> selectAdsRoundPictureList(AdsRoundPicture adsRoundPicture) {
        return adsRoundPictureMapper.selectAdsRoundPictureList(adsRoundPicture);
    }

    /**
     * 新增商家轮播图
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 结果
     */
    @Override
    public int insertAdsRoundPicture(AdsRoundPicture adsRoundPicture) {
        return adsRoundPictureMapper.insertAdsRoundPicture(adsRoundPicture);
    }

    /**
     * 修改商家轮播图
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 结果
     */
    @Override
    public int updateAdsRoundPicture(AdsRoundPicture adsRoundPicture) {
        return adsRoundPictureMapper.updateAdsRoundPicture(adsRoundPicture);
    }

    /**
     * 删除商家轮播图对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsRoundPictureByIds(String id) {
        return adsRoundPictureMapper.deleteAdsRoundPictureById(id);
    }

}
