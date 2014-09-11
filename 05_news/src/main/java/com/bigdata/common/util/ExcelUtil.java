package com.bigdata.common.util;

import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by log on 14-4-8.
 */
public class ExcelUtil {
    private static Integer EXCEL_MAXSIZE = 61000;
    public static List<UserBehaviorDO> importToDb(String excelPath){
        int i;
        Sheet[] sheets;
        Workbook book;
        Cell cell1, cell2, cell3, cell4;
        List<UserBehaviorDO> userBehaviorDOList = new ArrayList<UserBehaviorDO>();
        try {
            //excelPath为要读取的excel文件名
            book= Workbook.getWorkbook(new File(excelPath));

            //获得所有的工作表对象
            sheets = book.getSheets();

            for (Sheet sheet : sheets) {
                i=0;
                while(EXCEL_MAXSIZE > i) {
                    //获取每一行的单元格
                    cell1=sheet.getCell(0,i);//（列，行）
                    cell2=sheet.getCell(1,i);
                    cell3=sheet.getCell(2,i);
                    cell4 = sheet.getCell(3, i);
                    if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                        break;

                    //将每一行的数据设置到用户行为DO
                    UserBehaviorDO userBehaviorDO = new UserBehaviorDO();
                    userBehaviorDO.setUserId(Long.parseLong(cell1.getContents()));
                    /*userBehaviorDO.setBrandId(Long.parseLong(cell2.getContents()));
                    userBehaviorDO.setType(Integer.parseInt(cell3.getContents()));
                    userBehaviorDO.setVisitDatetime(DateUtil.strToTimestamp(cell4.getContents()));*/
                    userBehaviorDOList.add(userBehaviorDO);
                    i++;
                }
            }
            book.close();
        } catch(Exception e)  {
            System.out.println(e.getMessage());
        }
        System.out.print("数据条数 = " + userBehaviorDOList.size());
        return userBehaviorDOList;
    }
}
