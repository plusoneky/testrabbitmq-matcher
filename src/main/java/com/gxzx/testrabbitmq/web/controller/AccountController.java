package com.gxzx.testrabbitmq.web.controller;

import com.gxzx.testrabbitmq.web.entity.Account;
import com.gxzx.testrabbitmq.web.service.IAccountService;

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
 * OTC账户表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Api(value = "OTC账户表", tags = "OTC账户表")
@RestController
@RequestMapping("/account")
public class AccountController {

	IAccountService accountServiceImpl;

	/**
	 * 推荐使用构造器注入
	 * @param accountServiceImpl
	 */	
	@Autowired
	AccountController(IAccountService accountServiceImpl) {
		this.accountServiceImpl = accountServiceImpl;
	}
	
	@ApiOperation(value = "新增OTC账户表", notes = "新增OTC账户表",  response = ApiResDto.class, httpMethod = "POST")
	@PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto insert(@ApiParam(required = true, value = "OTC账户表") @RequestBody ApiReqDto<Account> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean insertResult = accountServiceImpl.save(apiReqDto.getReqBizObj());
		if(!insertResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}
		return new ApiResDto();
	}		

	@ApiOperation(value = "根据OTC账户表的自增id，修改OTC账户表", notes = "根据OTC账户表的自增id，修改OTC账户表",  response = ApiResDto.class, httpMethod = "PUT")
	@PutMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto update(@ApiParam(required = true, value = "OTC账户表") @RequestBody ApiReqDto<Account> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean updateResult = accountServiceImpl.updateById(apiReqDto.getReqBizObj());
		if(!updateResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}		
		return new ApiResDto();		
	}
	
	@ApiOperation(value = "根据OTC账户表的自增id，删除OTC账户表", notes = "根据OTC账户表的自增id，删除OTC账户表",  response = ApiResDto.class, httpMethod = "DELETE")
	@DeleteMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto delete(@ApiParam(required = true, value = "OTC账户表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		boolean deleteResult = accountServiceImpl.removeById(id);
		if(!deleteResult){
			return new ApiResDto(new CustomException(CommErrCode.NotFound));
		}			
		return new ApiResDto();
	}		
		
	@ApiOperation(value = "根据OTC账户表的自增id，查询OTC账户表", notes = "根据OTC账户表的自增id，查询OTC账户表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto get(@ApiParam(required = true, value = "OTC账户表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		Account entity = accountServiceImpl.getById(id);
		return new ApiResDto(entity);
	}			
	
	@ApiOperation(value = "分页查询OTC账户表", notes = "分页查询OTC账户表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(
			@ApiParam(required = true, value = "页码（第几页）", example = "1") @RequestParam int pageNumber, 
			@ApiParam(required = true, value = "每页记录条数", example = "10") @RequestParam int pageSize,
			@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		Map<String, Object> resBizMap = new HashMap<String, Object>();
		Page<Account> page = new Page<Account>(pageNumber, pageSize);
		QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
		if (StringUtils.isNotBlank(searchText)) {
			wrapper.like("id", searchText);
		}
		//默认为按id倒序
		wrapper.orderByAsc("id");
		IPage<Account> userPage = accountServiceImpl.page(page, wrapper);
		resBizMap.put("total", Long.valueOf(userPage.getTotal()));
		resBizMap.put("records", userPage.getRecords());
		return new ApiResDto(resBizMap);
	}

	@ApiOperation(value = "列表（不分页）查询OTC账户表，最大100条", notes = "列表（不分页）查询OTC账户表，最大100条",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
		List<Account> pageResult = accountServiceImpl.list(wrapper);
		return new ApiResDto(pageResult);
	}

}
