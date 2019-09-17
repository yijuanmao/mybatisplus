package com.example.demo;

import com.example.demo.base.entity.BaseEmployee;
import com.example.demo.base.service.IBaseEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	IBaseEmployeeService baseEmployeeService;
	@Test
	public void contextLoads() {

		String id = "bfa46604-c806-11e9-9ce5-00505684f17f";
		List<BaseEmployee> baseInfo = baseEmployeeService.list();
		System.out.println("長度為："+baseInfo);

	}

}
