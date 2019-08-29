package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsUserComment;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsUserCommentMapper;
import com.jdz.servermall.service.IAdsUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户评论 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-08
 */
@Service
public class AdsUserCommentServiceImpl implements IAdsUserCommentService {
    @Autowired
    private AdsUserCommentMapper adsUserCommentMapper;

    /**
     * 查询用户评论信息
     *
     * @param adsUserComment 用户评论ID
     * @return 用户评论信息
     */
    @Override
    public AdsUserComment selectAdsUserCommentByComment(AdsUserComment adsUserComment) {
        return adsUserCommentMapper.selectAdsUserCommentByComment(adsUserComment);
    }

    /**
     * 查询用户评论列表
     *
     * @param adsUserComment 用户评论信息
     * @return 用户评论集合
     */
    @Override
    public List<AdsUserComment> selectAdsUserCommentList(AdsUserComment adsUserComment) {
        return adsUserCommentMapper.selectAdsUserCommentList(adsUserComment);
    }

    /**
     * 新增用户评论
     *
     * @param adsUserComment 用户评论信息
     * @return 结果
     */
    @Override
    public int insertAdsUserComment(AdsUserComment adsUserComment) {
        return adsUserCommentMapper.insertAdsUserComment(adsUserComment);
    }

    /**
     * 修改用户评论
     *
     * @param adsUserComment 用户评论信息
     * @return 结果
     */
    @Override
    public int updateAdsUserComment(AdsUserComment adsUserComment) {
        return adsUserCommentMapper.updateAdsUserComment(adsUserComment);
    }

    /**
     * 删除用户评论对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsUserCommentByIds(String ids) {
        return adsUserCommentMapper.deleteAdsUserCommentByIds(Convert.toStrArray(ids));
    }

}
