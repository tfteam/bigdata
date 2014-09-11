package com.bigdata.service;

import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;

import java.util.List;

/**
 * Created by log on 14-4-4.
 */
public interface UserBehaviorService {
    /**
     * 插入商品信息
     * @param userBehaviorDOList
     * @return
     */
    public ResultBase<?> insertUserBehaviors(List<UserBehaviorDO> userBehaviorDOList);

    public ResultBase<?> insertOneUserBehaviors(UserBehaviorDO userBehaviorDO);

    public ResultBase<List<UserBehaviorDO>> queryByUserId(Long userId);
}
