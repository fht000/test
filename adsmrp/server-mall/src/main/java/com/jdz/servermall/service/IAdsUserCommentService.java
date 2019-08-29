package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsUserComment;

import java.util.List;

/**
 * 用户评论 服务层
 *
 * @author ruoyi
 * @date 2019-08-08
 */
public interface IAdsUserCommentService {
    /**
     * 查询用户评论信息
     *
     * @param adsUserComment 用户评论ID
     * @return 用户评论信息
     */
    public AdsUserComment selectAdsUserCommentByComment(AdsUserComment adsUserComment);

    /**
     * 查询用户评论列表
     *
     * @param adsUserComment 用户评论信息
     * @return 用户评论集合
     */
    public List<AdsUserComment> selectAdsUserCommentList(AdsUserComment adsUserComment);

    /**
     * 新增用户评论
     *
     * @param adsUserComment 用户评论信息
     * @return 结果
     */
    public int insertAdsUserComment(AdsUserComment adsUserComment);

    /**
     * 修改用户评论
     *
     * @param adsUserComment 用户评论信息
     * @return 结果
     */
    public int updateAdsUserComment(AdsUserComment adsUserComment);

    /**
     * 删除用户评论信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsUserCommentByIds(String ids);

}
