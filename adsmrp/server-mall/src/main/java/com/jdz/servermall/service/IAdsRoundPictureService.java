package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsRoundPicture;

import java.util.List;

/**
 * 商家轮播图 服务层
 *
 * @author ruoyi
 * @date 2019-08-13
 */
public interface IAdsRoundPictureService {
    /**
     * 查询商家轮播图信息
     *
     * @param pictureId 商家轮播图ID
     * @return 商家轮播图信息
     */
    public AdsRoundPicture selectAdsRoundPictureById(String pictureId);

    /**
     * 查询商家轮播图列表
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 商家轮播图集合
     */
    public List<AdsRoundPicture> selectAdsRoundPictureList(AdsRoundPicture adsRoundPicture);

    /**
     * 查询商家轮播图數量
     *
     * @param adsRoundPicture 商家轮播图數量
     * @return 商家轮播图集合
     */
    public int selectAdsRoundPictureTotal(AdsRoundPicture adsRoundPicture);

    /**
     * 新增商家轮播图
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 结果
     */
    public int insertAdsRoundPicture(AdsRoundPicture adsRoundPicture);

    /**
     * 修改商家轮播图
     *
     * @param adsRoundPicture 商家轮播图信息
     * @return 结果
     */
    public int updateAdsRoundPicture(AdsRoundPicture adsRoundPicture);

    /**
     * 删除商家轮播图信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsRoundPictureByIds(String ids);

}
