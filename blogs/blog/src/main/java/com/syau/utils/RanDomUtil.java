package com.syau.utils;


import java.util.Random;

public class RanDomUtil {
	/*public String getRandNum() {
        String randNum = new Random().nextInt(1000000)+"";
        //System.out.println("生成"+randNum);
        if (randNum.length()!=6) {   //如果生成的不是6位数随机数则返回该方法继续生成
            return getRandNum();
        }
        return randNum;
    }*/
	public static String getRandom6() {
		Random random = new Random();
		String result = "";
		for(int i=0;i<6;i++) {
			result+=random.nextInt(10);
		}
		return result;
	}

}
