package com.jdz.servermall.mapper;

import com.jdz.apimall.model.AdsSalesroomNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商铺公告 数据层
 *
 * @author fht
 * @date 2019-08-02
 */

@Mapper
public interface AdsSalesroomNoticeMapper {
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
     * 删除商铺公告
     *
     * @param noticeId 商铺公告ID
     * @return 结果
     */
    public int deleteAdsSalesroomNoticeById(String noticeId);

    /**
     * 批量删除商铺公告
     *
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdsSalesroomNoticeByIds(String[] noticeIds);

}