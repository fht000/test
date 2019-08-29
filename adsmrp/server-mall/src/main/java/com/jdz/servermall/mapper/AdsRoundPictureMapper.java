package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsRoundPicture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商家轮播图 数据层
 *
 * @author fht
 * @date 2019-08-13
 */

@Mapper
public interface AdsRoundPictureMapper {
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
     * 删除商家轮播图
     *
     * @param pictureId 商家轮播图ID
     * @return 结果
     */
    public int deleteAdsRoundPictureById(String pictureId);

    /**
     * 批量删除商家轮播图
     *
     * @param pictureIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsRoundPictureByIds(String[] pictureIds);

}