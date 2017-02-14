package com.stt.cm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stt.cm.service.InsertSerImpl;

@Controller
@RequestMapping("/g")
public class TestMvc {
	
	@Resource
   InsertSerImpl serimpl;
	
	@RequestMapping(value="/add")
	public String test(){
		
		serimpl.add();
		
		return "success";
		
	}
	
	
}
