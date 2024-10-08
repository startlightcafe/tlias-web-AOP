package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    /////////////////////////////



    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result selectAll(){
        log.info("查询全部部门数据");
        List<Dept> depts = deptService.selectAll();
        return Result.success(depts);
    }

    //删除部门信息
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("根据Id删除部门");
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门 (服务端发送过来的是 Json 格式的数据, 要添加注解@RequestBody)
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("新增部门: {}", dept);
        deptService.insert(dept);
        return Result.success();
    }
}
