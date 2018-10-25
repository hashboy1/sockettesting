package com.socketServer.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadSafetyTesting {
	
	
	public static void main( String[] args ) throws Exception
    {
    	
		ThreadPoolExecutor tpe=new ThreadPoolExecutor(10, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100));
		
		 while (true)
	        {
			 tpe.execute(new TSHandler());
	        }
		
    }

}
