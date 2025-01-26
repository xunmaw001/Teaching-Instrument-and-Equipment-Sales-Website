package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussjiaoxueshebeiEntity;
import com.entity.view.DiscussjiaoxueshebeiView;

import com.service.DiscussjiaoxueshebeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 教学设备评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-28 14:18:54
 */
@RestController
@RequestMapping("/discussjiaoxueshebei")
public class DiscussjiaoxueshebeiController {
    @Autowired
    private DiscussjiaoxueshebeiService discussjiaoxueshebeiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiaoxueshebeiEntity discussjiaoxueshebei, 
		HttpServletRequest request){

        EntityWrapper<DiscussjiaoxueshebeiEntity> ew = new EntityWrapper<DiscussjiaoxueshebeiEntity>();

    	PageUtils page = discussjiaoxueshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaoxueshebei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiaoxueshebeiEntity discussjiaoxueshebei, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiaoxueshebeiEntity> ew = new EntityWrapper<DiscussjiaoxueshebeiEntity>();

    	PageUtils page = discussjiaoxueshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaoxueshebei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiaoxueshebeiEntity discussjiaoxueshebei){
       	EntityWrapper<DiscussjiaoxueshebeiEntity> ew = new EntityWrapper<DiscussjiaoxueshebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiaoxueshebei, "discussjiaoxueshebei")); 
        return R.ok().put("data", discussjiaoxueshebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiaoxueshebeiEntity discussjiaoxueshebei){
        EntityWrapper< DiscussjiaoxueshebeiEntity> ew = new EntityWrapper< DiscussjiaoxueshebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiaoxueshebei, "discussjiaoxueshebei")); 
		DiscussjiaoxueshebeiView discussjiaoxueshebeiView =  discussjiaoxueshebeiService.selectView(ew);
		return R.ok("查询教学设备评论表成功").put("data", discussjiaoxueshebeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiaoxueshebeiEntity discussjiaoxueshebei = discussjiaoxueshebeiService.selectById(id);
        return R.ok().put("data", discussjiaoxueshebei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiaoxueshebeiEntity discussjiaoxueshebei = discussjiaoxueshebeiService.selectById(id);
        return R.ok().put("data", discussjiaoxueshebei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiaoxueshebeiEntity discussjiaoxueshebei, HttpServletRequest request){
    	discussjiaoxueshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiaoxueshebei);

        discussjiaoxueshebeiService.insert(discussjiaoxueshebei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiaoxueshebeiEntity discussjiaoxueshebei, HttpServletRequest request){
    	discussjiaoxueshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiaoxueshebei);

        discussjiaoxueshebeiService.insert(discussjiaoxueshebei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussjiaoxueshebeiEntity discussjiaoxueshebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiaoxueshebei);
        discussjiaoxueshebeiService.updateById(discussjiaoxueshebei);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiaoxueshebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	








}
