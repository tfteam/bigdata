package com.bigdata.common;

import com.bigdata.entity.UserBehaviorDO;
import com.bigdata.common.newutil.DateUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by log on 14-9-10.
 */
public class FileOp {
    private List<UserBehaviorDO> userBehaviorList;

    public FileOp(ArrayList<UserBehaviorDO> source) {
        this.userBehaviorList = source;
    }

    public void readFrom (String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                //对第一行做特殊处理
                if (1 == line) {
                    tempString = tempString.substring(1);
                }
                // 显示行号
                System.out.println("line " + line + ": " + tempString);

                UserBehaviorDO userBehavior = this.splitFromString(tempString);
                userBehaviorList.add(userBehavior);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private UserBehaviorDO splitFromString(String tempString) {
        UserBehaviorDO userBehavior = new UserBehaviorDO();
        Pattern p = Pattern.compile("\t");

        if (null != tempString) {
            Matcher m = p.matcher(tempString);
            String temp = null;
            int index = 0, count = 0, start = 0;
            while(m.find()) {
                count++;
                start = m.start();
                temp = tempString.substring(index, start);
                if (count == 1) {
                    userBehavior.setUserId(Long.parseLong(temp));
                }
                else if(count == 2) {
                    userBehavior.setNewsId(Long.parseLong(temp));
                }
                else if(count == 3) {
                    userBehavior.setScanTime(DateUtil.TimeStamp2Date(temp));
                }
                else if(count == 4) {
                    userBehavior.setTitle(temp);
                }
                else if(count == 5) {
                    if(!temp.equals("NULL"))
                        userBehavior.setContent(temp);
                }
                index = m.end();
            }
            //recordContentEnd = start;
            //userBehavior.setContent(tempString.substring(recordContentStart + 1, recordContentEnd));
            String tempDate = tempString.substring(index, tempString.length());
            if (!tempDate.equals("NULL")) {
                int year = 0, month = 0, day = 0, hour = 0, min = 0;
                try {
                year = Integer.parseInt(tempDate.substring(0, 4));
                month = Integer.parseInt(tempDate.substring(5, 7));
                day = Integer.parseInt(tempDate.substring(8, 10));
                hour = Integer.parseInt(tempDate.substring(11, 13));
                min = Integer.parseInt(tempDate.substring(14, 16));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                    userBehavior.setPublishTime(DateUtil.getDateFromText(year, month, day, hour, min));
                }
                userBehavior.setPublishTime(DateUtil.getDateFromText(year, month, day, hour, min));
            }

        }
        return userBehavior;

    }

}
