//package com.example.client.client;
//
//import com.example.client.model.RegistrationDTO;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Slf4j
////@Component
//public class AuthClientHystrixImpl implements AuthClientHystrix {
//    @Autowired
//    public AuthClient authClient;
//
//    @Override
//    @HystrixCommand(
//            fallbackMethod = "createFallback"
////            ,
////            threadPoolKey = "itemByUserThreadPool",
////            threadPoolProperties = {
////                    @HystrixProperty(name="coreSize", value = "30"),
////                    //(requests per second at peak when the service is healthy * 99th percentile latency in seconds) + small amount of extra threads for overhead
////                    @HystrixProperty(name="maxQueueSize", value="10")
////            }
//    )
//    public void create(RegistrationDTO dto) {
//        authClient.create(dto);
//    }
//
//    public void createFallback(RegistrationDTO dto) {
//        log.error("FALLBACK!!!");
//    }
//
//}
