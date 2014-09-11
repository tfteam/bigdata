package com.springapp.mvc;

import com.bigdata.common.DAOException;
import com.bigdata.common.FileOp;
import com.bigdata.common.util.DateUtil;
import com.bigdata.common.util.ExcelUtil;
import com.bigdata.dao.UserBehaviorDAO;
import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import com.bigdata.service.UserBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by log on 14-4-6.
 */

public class TestMain {
    private static String excelPath = "src/main/java/new_data.xls";
    /*private static String fileName = "G:" + File.separator + "Program Factory" + File.separator + "bigdata project"
            + File.separator + "20140909" + File.separator+"test.txt";*/
    private static String fileName = "src/main/java/dataset.txt";
    public static void main(String[] args) throws SQLException, DAOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/*.xml");

        ArrayList<UserBehaviorDO> userBehaviorDOList = new ArrayList<UserBehaviorDO>();
        FileOp fileOp = new FileOp(userBehaviorDOList);
        fileOp.readFrom(fileName);
        for(UserBehaviorDO userBehavior : userBehaviorDOList) {
            System.out.println (userBehavior.getUserId());
        }

        //List<UserBehaviorDO> userBehaviorDOList = ExcelUtil.importToDb(excelPath);
        UserBehaviorService userBehaviorService = (UserBehaviorService)ctx.getBean("userBehaviorService");
        ResultBase<?> result =  userBehaviorService.insertUserBehaviors(userBehaviorDOList);
        System.out.println(result.getErrorMsg());
        System.out.println(result.isSuccess());

    }
}
