package com.itheima;

import com.itheima.service.DeptService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

//如果需要测试的代码与 spring项目无关, 可以将这个注解删除
@SpringBootTest
class TliasWebManagementApplicationTests {
    @Autowired
    private DeptService deptService;

    @Test
    public void testExe(){
        deptService.selectAll();

        deptService.deleteById(66);
    }
}
