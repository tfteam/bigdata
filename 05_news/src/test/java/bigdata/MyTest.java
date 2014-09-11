package bigdata;

import com.bigdata.common.util.DateUtil;
import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import com.bigdata.service.UserBehaviorService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by log on 14-4-4.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:com/spring/dao.xml",
                "classpath:com/spring/datasource.xml",
                "classpath:com/spring/service.xml"
})
public class MyTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private UserBehaviorService userBehaviorService;

    @Test
    public void test(){
        UserBehaviorDO userBehaviorDO = new UserBehaviorDO();
        userBehaviorDO.setUserId(121L);
        /*userBehaviorDO.setBrandId(111L);
        userBehaviorDO.setType(1);
        userBehaviorDO.setVisitDatetime(DateUtil.strToTimestamp("2014-01-01"));*/
        ResultBase<?> result =  userBehaviorService.insertOneUserBehaviors(userBehaviorDO);
        System.out.println(result.getErrorMsg());
        System.out.println(result.isSuccess());


        ResultBase<List<UserBehaviorDO>> listResultBase = userBehaviorService.queryByUserId(userBehaviorDO.getUserId());
        List<UserBehaviorDO> userBehaviorDOList = listResultBase.getValue();
        if (userBehaviorDOList != null){
            for (UserBehaviorDO userBehaviorDON : userBehaviorDOList){
                System.out.println("id = " + userBehaviorDON.getId() + ";");
            }
        }
        else
            System.out.println("is null");

    }

    //@Test
    public void testInsert()
    {
        int i;
        Sheet sheet;
        Workbook book;
        Cell cell1, cell2, cell3, cell4;
        List<UserBehaviorDO> userBehaviorDOList = new ArrayList<UserBehaviorDO>();
        try {
            //t.xls为要读取的excel文件名
            System.out.println(System.getProperty("user.dir"));
            book= Workbook.getWorkbook(new File("src/main/java/t_alibaba_data.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0);
            //获取左上角的单元格
            cell1=sheet.getCell(0,0);
            System.out.println("标题："+cell1.getContents());


            i=1;
            while(true) {
                        //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                cell4 = sheet.getCell(3, i);
                if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                     break;
                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents());
                UserBehaviorDO userBehaviorDO = new UserBehaviorDO();
                userBehaviorDO.setUserId(Long.parseLong(cell1.getContents()));
                /*userBehaviorDO.setBrandId(Long.parseLong(cell2.getContents()));
                userBehaviorDO.setType(Integer.parseInt(cell3.getContents()));*/
                /*userBehaviorDO.setVisitDatetime(DateUtil.strToTimestamp(cell4.getContents()));*/
                userBehaviorDOList.add(userBehaviorDO);
                ResultBase<?> result =  userBehaviorService.insertOneUserBehaviors(userBehaviorDO);
                System.out.println(result.getErrorMsg());
                System.out.println(result.isSuccess());
                i++;
            }
            book.close();
        }

        catch(Exception e)  {
            System.out.println(e.getMessage());
        }

    }
}

