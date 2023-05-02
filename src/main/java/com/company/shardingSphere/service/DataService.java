package com.company.shardingSphere.service;

import com.company.shardingSphere.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class DataService {

    @Autowired
    private UserService userService;

    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(50,50, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5000), new ThreadPoolExecutor.CallerRunsPolicy());
    /**
     * 多线程插入海量数据
     */
    public void batchInsertData(int dataSize,int groupSize){
        int group = dataSize%groupSize==0?dataSize/groupSize:dataSize/groupSize+1;
        List<Future> tasks = new ArrayList<>(group+1);
        for(int i=0; i<group; i++){
            AtomicInteger startAtomic = new AtomicInteger(i*groupSize);
            AtomicInteger endAtomic = new AtomicInteger(Math.min((i + 1) * groupSize, dataSize)-1);
            Future task = threadPool.submit(()->{
                log.info("当前线程ID:{},数据起始值:{},数据结束值:{}", Thread.currentThread().getId(), startAtomic.get(),
                        endAtomic.get());
                List<User> users = new ArrayList<>();
                for(long k=startAtomic.get(); k<=endAtomic.get(); k++){
                    User user = new User();
                    user.setId(null);
                    user.setName("admin-"+k);
                    user.setAge(k);
                    user.setEmail(k+"@gmail.com");
                    users.add(user);
                }
                userService.saveBatch(users);
            });
            tasks.add(task);
        }
        for(Future task: tasks){
            try {
                task.get();
            }catch (Exception e){
                log.info("当前线程ID:{},异常原因:{}", Thread.currentThread().getId(), e.getMessage());
            }
        }
    }
}
