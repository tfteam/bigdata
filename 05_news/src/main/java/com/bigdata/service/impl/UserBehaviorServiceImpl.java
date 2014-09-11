package com.bigdata.service.impl;

import com.bigdata.dao.UserBehaviorDAO;
import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import com.bigdata.service.BaseService;
import com.bigdata.service.UserBehaviorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by log on 14-4-4.
 */
@Service
public class UserBehaviorServiceImpl extends BaseService implements UserBehaviorService{
    private static final Logger log = Logger.getLogger(UserBehaviorServiceImpl.class);
    @Autowired
    private UserBehaviorDAO userBehaviorDAO;

    @Override
    public ResultBase<?> insertUserBehaviors(List<UserBehaviorDO> userBehaviorDOList) {
        ResultBase<?> result = new ResultBase<Object>();
        try {
            result.setSuccess(this.userBehaviorDAO.batchInsert(userBehaviorDOList));
        } catch (Exception e) {
            log.error("ItemServiceImpl.insertItems", e);
            result.setErrorMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public ResultBase<?> insertOneUserBehaviors(UserBehaviorDO userBehaviorDO) {
        ResultBase<?> result = new ResultBase<Object>();
        try {
            result.setSuccess(this.userBehaviorDAO.insert(userBehaviorDO));
        } catch (Exception e) {
            log.error("ItemServiceImpl.insertItems", e);
            result.setErrorMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public ResultBase<List<UserBehaviorDO>> queryByUserId(Long userId) {
        ResultBase<List<UserBehaviorDO>> result = new ResultBase<List<UserBehaviorDO>>();
        try {

            List<UserBehaviorDO> userBehaviorDOList = this.userBehaviorDAO.queryByUserId(userId);
            result.setValue(userBehaviorDOList);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("ItemServiceImpl.queryItems", e);
            result.setErrorMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
}


