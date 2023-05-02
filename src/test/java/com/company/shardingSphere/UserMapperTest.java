package com.company.shardingSphere;

import com.company.shardingSphere.mapper.UserMapper;
import com.company.shardingSphere.model.User;
import com.company.shardingSphere.service.DataService;
import com.company.shardingSphere.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private DataService dataService;



    @Test
    public void testBaseMapper(){
        List<User> users = new ArrayList<>(Arrays.asList(
                new User(null,"张飞", 15l,"1234@gmail.com"),
                new User(null,"关羽", 18l,"123674@gmail.com")));
       userService.saveBatch(users);
    }

    @Test
    public void testBatchInsert(){
        dataService.batchInsertData(10000000, 1000);
    }


}
