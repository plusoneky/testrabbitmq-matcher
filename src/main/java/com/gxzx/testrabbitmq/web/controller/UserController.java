package com.gxzx.testrabbitmq.web.controller;

import com.gxzx.testrabbitmq.web.entity.User;
import com.gxzx.testrabbitmq.web.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.gxzx.testrabbitmq.exception.CustomException;
import com.gxzx.testrabbitmq.exception.CustomException.CommErrCode;
import com.gxzx.testrabbitmq.dto.ApiReqDto;
import com.gxzx.testrabbitmq.dto.ApiResDto;

import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Api(value = "用户表", tags = "用户表")
@RestController
@RequestMapping("/user")
public class UserController {

	IUserService userServiceImpl;

	/**
	 * 推荐使用构造器注入
	 * @param userServiceImpl
	 */	
	@Autowired
	UserController(IUserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@ApiOperation(value = "新增用户表", notes = "新增用户表",  response = ApiResDto.class, httpMethod = "POST")
	@PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto insert(@ApiParam(required = true, value = "用户表") @RequestBody ApiReqDto<User> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean insertResult = userServiceImpl.save(apiReqDto.getReqBizObj());
		if(!insertResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}
		return new ApiResDto();
	}		

	@ApiOperation(value = "根据用户表的自增id，修改用户表", notes = "根据用户表的自增id，修改用户表",  response = ApiResDto.class, httpMethod = "PUT")
	@PutMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto update(@ApiParam(required = true, value = "用户表") @RequestBody ApiReqDto<User> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean updateResult = userServiceImpl.updateById(apiReqDto.getReqBizObj());
		if(!updateResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}		
		return new ApiResDto();		
	}
	
	@ApiOperation(value = "根据用户表的自增id，删除用户表", notes = "根据用户表的自增id，删除用户表",  response = ApiResDto.class, httpMethod = "DELETE")
	@DeleteMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto delete(@ApiParam(required = true, value = "用户表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		boolean deleteResult = userServiceImpl.removeById(id);
		if(!deleteResult){
			return new ApiResDto(new CustomException(CommErrCode.NotFound));
		}			
		return new ApiResDto();
	}		
		
	@ApiOperation(value = "根据用户表的自增id，查询用户表", notes = "根据用户表的自增id，查询用户表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto get(@ApiParam(required = true, value = "用户表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		User entity = userServiceImpl.getById(id);
		return new ApiResDto(entity);
	}			
	
	@ApiOperation(value = "分页查询用户表", notes = "分页查询用户表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(
			@ApiParam(required = true, value = "页码（第几页）", example = "1") @RequestParam int pageNumber, 
			@ApiParam(required = true, value = "每页记录条数", example = "10") @RequestParam int pageSize,
			@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		Map<String, Object> resBizMap = new HashMap<String, Object>();
		Page<User> page = new Page<User>(pageNumber, pageSize);
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		if (StringUtils.isNotBlank(searchText)) {
			wrapper.like("id", searchText);
		}
		//默认为按id倒序
		wrapper.orderByAsc("id");
		IPage<User> userPage = userServiceImpl.page(page, wrapper);
		resBizMap.put("total", Long.valueOf(userPage.getTotal()));
		resBizMap.put("records", userPage.getRecords());
		return new ApiResDto(resBizMap);
	}

	@ApiOperation(value = "列表（不分页）查询用户表，最大100条", notes = "列表（不分页）查询用户表，最大100条",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		List<User> pageResult = userServiceImpl.list(wrapper);
		return new ApiResDto(pageResult);
	}

}
