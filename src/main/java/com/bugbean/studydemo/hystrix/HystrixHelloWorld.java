//package com.bugbean.studydemo.hystrix;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//import com.netflix.hystrix.HystrixCommandProperties;
//
//public class HystrixHelloWorld extends HystrixCommand {
//
////    protected HystrixHelloWorld() {
////        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("abc"))
////            .andThreadPoolPropertiesDefaults(
//////                    HystrixCommandProperties.Setter()；
//////                    .withCircuitBreakerErrorThresholdPercentage()；
////            )
////        );
////    }
//
//    public static void main(String[] args) {
//        HystrixHelloWorld hystrixHelloWorld = new HystrixHelloWorld();
//        hystrixHelloWorld.execute();
//
//    }
//
//    @Override
//    protected Object run() throws Exception {
//        return null;
//    }
//}
