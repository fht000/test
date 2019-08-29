package com.jdz.servermall.service;

import com.jdz.apimall.model.AdsSalesroomNotice;

import java.util.List;

/**
 * 商铺公告 服务层
 *
 * @author ruoyi
 * @date 2019-08-02
 */
public interface IAdsSalesroomNoticeService {
    /**
     * 查询商铺公告信息
     *
     * @param noticeId 商铺公告ID
     * @return 商铺公告信息
     */
    public AdsSalesroomNotice selectAdsSalesroomNoticeById(String noticeId);

    /**
     * 查询商铺公告列表
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 商铺公告集合
     */
    public List<AdsSalesroomNotice> selectAdsSalesroomNoticeList(AdsSalesroomNotice adsSalesroomNotice);

    /**
     * 查询商铺公告列表
     *
     * @param adsSalesroomNotice 商铺公告数量
     * @return 商铺公告集合
     */
    public int selectAdsSalesroomNoticeTotal(AdsSalesroomNotice adsSalesroomNotice);

    /**
     * 新增商铺公告
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 结果
     */
    public int insertAdsSalesroomNotice(AdsSalesroomNotice adsSalesroomNotice);

    /**
     * 修改商铺公告
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 结果
     */
    public int updateAdsSalesroomNotice(AdsSalesroomNotice adsSalesroomNotice);

    /**
     * 删除商铺公告信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsSalesroomNoticeById(String ids);

}
