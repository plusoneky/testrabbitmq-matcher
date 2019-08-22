package com.gxzx.testrabbitmq.web.controller;

import com.gxzx.testrabbitmq.web.entity.Coin;
import com.gxzx.testrabbitmq.web.service.ICoinService;

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
 * 币种配置表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Api(value = "币种配置表", tags = "币种配置表")
@RestController
@RequestMapping("/coin")
public class CoinController {

	ICoinService coinServiceImpl;

	/**
	 * 推荐使用构造器注入
	 * @param coinServiceImpl
	 */	
	@Autowired
	CoinController(ICoinService coinServiceImpl) {
		this.coinServiceImpl = coinServiceImpl;
	}
	
	@ApiOperation(value = "新增币种配置表", notes = "新增币种配置表",  response = ApiResDto.class, httpMethod = "POST")
	@PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto insert(@ApiParam(required = true, value = "币种配置表") @RequestBody ApiReqDto<Coin> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean insertResult = coinServiceImpl.save(apiReqDto.getReqBizObj());
		if(!insertResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}
		return new ApiResDto();
	}		

	@ApiOperation(value = "根据币种配置表的自增id，修改币种配置表", notes = "根据币种配置表的自增id，修改币种配置表",  response = ApiResDto.class, httpMethod = "PUT")
	@PutMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto update(@ApiParam(required = true, value = "币种配置表") @RequestBody ApiReqDto<Coin> apiReqDto) {
		if(apiReqDto==null || apiReqDto.getReqBizObj()==null){
			return new ApiResDto(new CustomException(CommErrCode.ParamIsInvalid));
		}
		boolean updateResult = coinServiceImpl.updateById(apiReqDto.getReqBizObj());
		if(!updateResult){
			return new ApiResDto(new CustomException(CommErrCode.SysErr));
		}		
		return new ApiResDto();		
	}
	
	@ApiOperation(value = "根据币种配置表的自增id，删除币种配置表", notes = "根据币种配置表的自增id，删除币种配置表",  response = ApiResDto.class, httpMethod = "DELETE")
	@DeleteMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto delete(@ApiParam(required = true, value = "币种配置表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		boolean deleteResult = coinServiceImpl.removeById(id);
		if(!deleteResult){
			return new ApiResDto(new CustomException(CommErrCode.NotFound));
		}			
		return new ApiResDto();
	}		
		
	@ApiOperation(value = "根据币种配置表的自增id，查询币种配置表", notes = "根据币种配置表的自增id，查询币种配置表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/{id:\\d+}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ApiResDto get(@ApiParam(required = true, value = "币种配置表的自增id", example = "0") @PathVariable(value = "id") long id) {	
		Coin entity = coinServiceImpl.getById(id);
		return new ApiResDto(entity);
	}			
	
	@ApiOperation(value = "分页查询币种配置表", notes = "分页查询币种配置表",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(
			@ApiParam(required = true, value = "页码（第几页）", example = "1") @RequestParam int pageNumber, 
			@ApiParam(required = true, value = "每页记录条数", example = "10") @RequestParam int pageSize,
			@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		Map<String, Object> resBizMap = new HashMap<String, Object>();
		Page<Coin> page = new Page<Coin>(pageNumber, pageSize);
		QueryWrapper<Coin> wrapper = new QueryWrapper<Coin>();
		if (StringUtils.isNotBlank(searchText)) {
			wrapper.like("id", searchText);
		}
		//默认为按id倒序
		wrapper.orderByAsc("id");
		IPage<Coin> userPage = coinServiceImpl.page(page, wrapper);
		resBizMap.put("total", Long.valueOf(userPage.getTotal()));
		resBizMap.put("records", userPage.getRecords());
		return new ApiResDto(resBizMap);
	}

	@ApiOperation(value = "列表（不分页）查询币种配置表，最大100条", notes = "列表（不分页）查询币种配置表，最大100条",  response = ApiResDto.class, httpMethod = "GET")
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	//TODO 这个模糊查询需要定制化修改
	public ApiResDto page(@ApiParam(required = true, value = "默认按名称模糊查询") @RequestParam(required=false) String searchText) {
		QueryWrapper<Coin> wrapper = new QueryWrapper<Coin>();
		List<Coin> pageResult = coinServiceImpl.list(wrapper);
		return new ApiResDto(pageResult);
	}

}