package com.socketServer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemUtil {

	
	public static String getSystemDate()
	{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentdate=df.format(new Date());
        return currentdate;
		
	}
	
}
