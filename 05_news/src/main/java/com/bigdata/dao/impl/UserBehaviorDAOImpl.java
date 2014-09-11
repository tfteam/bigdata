package com.bigdata.dao.impl;

import com.bigdata.common.DAOException;
import com.bigdata.common.constants.Constants;
import com.bigdata.dao.BaseDAO;
import com.bigdata.dao.UserBehaviorDAO;
import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by log on 14-4-4.
 */
public class UserBehaviorDAOImpl extends BaseDAO implements UserBehaviorDAO {
    private String tablePrefix = "user_news_behavior";

    @Override
    public boolean batchInsert(List<UserBehaviorDO> userBehaviorDOList) throws DAOException, SQLException {
        int count = 0;
        SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();
        sqlMapClient.startBatch();
        for (UserBehaviorDO userBehaviorDO : userBehaviorDOList) {
            count++;
            userBehaviorDO.setTableName(tablePrefix);
            sqlMapClient.insert("UserBehavior.addUserBehavior", userBehaviorDO);
            if (count == Constants.DBConstant.BATCH_OPERATION_COUNT) {
                count = 0;
                sqlMapClient.executeBatch();
                sqlMapClient.startBatch();
            }
        }
        sqlMapClient.executeBatch();
        return true;
    }

    @Override
    public boolean   insert(UserBehaviorDO userBehaviorDO) throws DAOException, SQLException {
        userBehaviorDO.setTableName(tablePrefix);
        SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();
        Object a = sqlMapClient.insert("UserBehavior.addUserBehavior", userBehaviorDO);
        System.out.println(a.toString());
        return true;
    }

    @Override
    public List<UserBehaviorDO> queryByUserId(long userId) throws DAOException, SQLException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("tableName", tablePrefix);
        List<UserBehaviorDO> userBehaviorDOList = (List<UserBehaviorDO>)sqlMapClientTemplate.queryForList("UserBehavior.queryByUserId", map);
        return (userBehaviorDOList != null) ? userBehaviorDOList : new ArrayList<UserBehaviorDO>();
    }


}
