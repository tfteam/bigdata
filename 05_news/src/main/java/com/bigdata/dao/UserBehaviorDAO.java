package com.bigdata.dao;

import com.bigdata.common.DAOException;
import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;

/**
 * Created by log on 14-4-4.
 */
public interface UserBehaviorDAO {
    /**
     * 批量插入用户行为数据
     * @param userBehaviorDOList
     * @return
     * @throws DAOException
     * @throws java.sql.SQLException
     */
    public boolean batchInsert(List<UserBehaviorDO> userBehaviorDOList) throws DAOException, SQLException;

    public boolean insert(UserBehaviorDO userBehaviorDO)throws DAOException, SQLException;

    public List<UserBehaviorDO> queryByUserId(long userId) throws DAOException, SQLException;
}
