package com.jdz.servermall.service.impl;

import java.util.List;

import com.jdz.apimall.model.AdsSalesroomNotice;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsSalesroomNoticeMapper;
import com.jdz.servermall.service.IAdsSalesroomNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商铺公告 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class AdsSalesroomNoticeServiceImpl implements IAdsSalesroomNoticeService {
    @Autowired
    private AdsSalesroomNoticeMapper adsSalesroomNoticeMapper;

    /**
     * 查询商铺公告信息
     *
     * @param noticeId 商铺公告ID
     * @return 商铺公告信息
     */
    @Override
    public AdsSalesroomNotice selectAdsSalesroomNoticeById(String noticeId) {
        return adsSalesroomNoticeMapper.selectAdsSalesroomNoticeById(noticeId);
    }

    /**
     * 查询商铺公告列表
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 商铺公告集合
     */
    @Override
    public List<AdsSalesroomNotice> selectAdsSalesroomNoticeList(AdsSalesroomNotice adsSalesroomNotice) {
        return adsSalesroomNoticeMapper.selectAdsSalesroomNoticeList(adsSalesroomNotice);
    }

    @Override
    public int selectAdsSalesroomNoticeTotal(AdsSalesroomNotice adsSalesroomNotice) {
        return adsSalesroomNoticeMapper.selectAdsSalesroomNoticeTotal(adsSalesroomNotice);
    }

    /**
     * 新增商铺公告
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 结果
     */
    @Override
    public int insertAdsSalesroomNotice(AdsSalesroomNotice adsSalesroomNotice) {
        return adsSalesroomNoticeMapper.insertAdsSalesroomNotice(adsSalesroomNotice);
    }

    /**
     * 修改商铺公告
     *
     * @param adsSalesroomNotice 商铺公告信息
     * @return 结果
     */
    @Override
    public int updateAdsSalesroomNotice(AdsSalesroomNotice adsSalesroomNotice) {
        return adsSalesroomNoticeMapper.updateAdsSalesroomNotice(adsSalesroomNotice);
    }

    /**
     * 删除商铺公告对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAdsSalesroomNoticeById(String id) {
        return adsSalesroomNoticeMapper.deleteAdsSalesroomNoticeByIds(Convert.toStrArray(id));
    }

}
