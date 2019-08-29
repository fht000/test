package com.jdz.servermall.service.impl;

import com.jdz.apimall.model.AdsPlate;
import com.jdz.apimall.model.AdsPlateGoods;
import com.jdz.jdzcommon.util.Convert;
import com.jdz.servermall.mapper.AdsPlateGoodsMapper;
import com.jdz.servermall.mapper.AdsPlateMapper;
import com.jdz.servermall.service.IAdsPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 板块 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-07
 */
@Service
public class AdsPlateServiceImpl implements IAdsPlateService {

    @Autowired
    private AdsPlateMapper adsPlateMapper;

    @Autowired
    private AdsPlateGoodsMapper adsPlateGoodsMapper;

    /**
     * 查询板块信息
     *
     * @param plateId 板块ID
     * @return 板块信息
     */
    @Override
    public AdsPlate selectAdsPlateById(String plateId) {
        return adsPlateMapper.selectAdsPlateById(plateId);
    }

    /**
     * 查询板块列表
     *
     * @param adsPlate 板块信息
     * @return 板块集合
     */
    @Override
    public List<AdsPlate> selectAdsPlateList(AdsPlate adsPlate) {
        return adsPlateMapper.selectAdsPlateList(adsPlate);
    }

    /**
     * 新增板块
     *
     * @param adsPlate 板块信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAdsPlate(AdsPlate adsPlate,List<AdsPlateGoods> adsPlateGoodsList) {
        if(!CollectionUtils.isEmpty(adsPlateGoodsList)){
            adsPlateGoodsMapper.insertBatchAdsPlateGoods(adsPlateGoodsList);
        }
        return adsPlateMapper.insertAdsPlate(adsPlate);
    }

    /**
     * 修改板块
     *
     * @param adsPlate 板块信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAdsPlate(AdsPlate adsPlate,Set<String> ids) {

        AdsPlateGoods query = new AdsPlateGoods();
        query.setMerchantId(adsPlate.getMerchantId());
        query.setPlateId(adsPlate.getPlateId());

        if(CollectionUtils.isEmpty(ids)){
            return adsPlateMapper.updateAdsPlate(adsPlate);
        }

        List<AdsPlateGoods> adsPlateGoodsList = adsPlateGoodsMapper.selectAdsPlateGoodsList(query);
        Set<String> currentExitIds = new HashSet<String>();
        Set<String> addId = new HashSet<String>();
        Set<String> updateId = new HashSet<String>();

        /** 处理要修改的商品 */
        if(!CollectionUtils.isEmpty(adsPlateGoodsList)){
            for(AdsPlateGoods adsPlateGoods : adsPlateGoodsList){
                currentExitIds.add(String.valueOf(adsPlateGoods.getGoodsId()));

                //注意 Set集合中的类型与比较的类型要一致
                if(!ids.contains(adsPlateGoods.getGoodsId())){
                    updateId.add(adsPlateGoods.getId());
                }
            }
        }

        /** 处理待新增的商品 */
        for(String id : ids){
            //注意 Set集合中的类型与比较的类型要一致
            if(!currentExitIds.contains(String.valueOf(id))){
                addId.add(id);
            }
        }

        //新增商品
        if(!CollectionUtils.isEmpty(addId)){

            List<AdsPlateGoods> adsPlateGoodsList1 = new ArrayList<AdsPlateGoods>();
            for(String id : addId){

                AdsPlateGoods adsPlateGoods = new AdsPlateGoods();

                adsPlateGoods.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                adsPlateGoods.setPlateId(adsPlate.getPlateId());
                adsPlateGoods.setGoodsId(id);
                adsPlateGoods.setMerchantId(adsPlate.getMerchantId());
                adsPlateGoodsList1.add(adsPlateGoods);
            }

            adsPlateGoodsMapper.insertBatchAdsPlateGoods(adsPlateGoodsList1);
        }

        //删除商品
        if(!CollectionUtils.isEmpty(updateId)){
            String[] updateIds = new String[updateId.size()];
            updateId.toArray(updateIds);
            adsPlateGoodsMapper.deleteAdsPlateGoodsByIds(updateIds);
        }

        return adsPlateMapper.updateAdsPlate(adsPlate);
    }

    /**
     * 删除板块对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteAdsPlateByIds(String ids,String merchantId) {

        String[] idsArry = Convert.toStrArray(ids);
        AdsPlateGoods query = new AdsPlateGoods();
        Set<String> set = new HashSet<String>();
        for(String id : idsArry){
            query.setMerchantId(merchantId);
            query.setPlateId(id);
            List<AdsPlateGoods> adsPlateGoodsList = adsPlateGoodsMapper.selectAdsPlateGoodsList(query);
            if(!CollectionUtils.isEmpty(adsPlateGoodsList) && adsPlateGoodsList.size() > 0){
                AdsPlateGoods adsPlateGoods = adsPlateGoodsList.get(0);
                set.add(adsPlateGoods.getId());
            }
        }

        String[] adsPlateGoodsIds = set.size() > 0 ? set.stream().toArray(String[]::new) : null;
        if(adsPlateGoodsIds != null){
            adsPlateGoodsMapper.deleteAdsPlateGoodsByIds(adsPlateGoodsIds);
        }
        return adsPlateMapper.deleteAdsPlateByIds(idsArry);
    }

}
