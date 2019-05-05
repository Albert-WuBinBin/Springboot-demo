package com.wbb.mybatis.controller;


import com.wbb.mybatis.HttpClientUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ConcurrentTest {

    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args){

        CountDownLatch latch=new CountDownLatch(1);

        for(int i=0;i<5;i++){//模拟5个用户
            AnalogUser analogUser = new AnalogUser("user"+i,"123","1","20.024",latch);
            analogUser.start();
        }
        latch.countDown();//计数器減一  所有线程释放 并发访问。
        System.out.println("所有模拟请求结束  at "+sdf.format(new Date()));

    }

    static class AnalogUser extends Thread{
        String workerName;//模拟用户姓名
        String openId;
        String openType;
        String amount;
        CountDownLatch latch;

        public AnalogUser(String workerName, String openId, String openType, String amount,
                          CountDownLatch latch) {
            super();
            this.workerName = workerName;
            this.openId = openId;
            this.openType = openType;
            this.amount = amount;
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                latch.await(); //一直阻塞当前线程，直到计时器的值为0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            post();//发送post 请求
        }

        public void post(){
            System.out.println("模拟用户： "+workerName+" 开始发送模拟请求  at "+sdf.format(new Date()));
            Map<String,String> body  = new HashMap<>();
            body.put("openId",openId);
            body.put("openType",openType);
            body.put("amount",amount);
            System.out.println("模拟用户： "+workerName+"  操作结果："+HttpClientUtils.doPost("http://localhost:8080/wallet/update",null,body)); ;
            System.out.println("模拟用户： "+workerName+" 模拟请求结束  at "+sdf.format(new Date()));

        }
    }
}
