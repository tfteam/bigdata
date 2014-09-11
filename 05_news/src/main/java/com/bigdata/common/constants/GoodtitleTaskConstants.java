package com.bigdata.common.constants;

/**
 * Created by log on 14-3-27.
 */
public interface GoodtitleTaskConstants {
    interface GoodtitleTaskStatus{
        public static int Waiting = 0;
        public static int Runing = 1;
        public static int End = 2;
    }

    interface GoodtitleTaskConstant{
        //超过LongTime的时间，提示长时间未进行体检
        public static int LongTime = -7;
    }

    interface GoodtitleTaskScore{
        public static int FULLMARK = 100;
    }

    interface GoodtitleInfo{
        public static double LENGTH = 30.0;
    }

    interface  GoodtitleResultKey{
        public static String CHECK_LENGTH = "字数检查";
    }

    interface GoodtitleResultDetail{
        public static String LENGTH_GOOD = "达到30个字";
        public static String LENGTH_POOR = "少于30个字";
    }
}
