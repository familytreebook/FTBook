package com.mytime.UserCenter.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="ftBookUserManager")
public class FtBookUserManager {

	@GetMapping(value="getUserById")
	@ResponseBody
	public Map<String,Object> getUser(@RequestParam Integer id){
		Map<String,Object> u = new HashMap<String,Object>();
		u.put("name", id+"name");
		u.put("id", id);
		return u;
	}
}
