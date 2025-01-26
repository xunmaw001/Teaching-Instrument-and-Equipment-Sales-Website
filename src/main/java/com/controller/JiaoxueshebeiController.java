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

import com.entity.JiaoxueshebeiEntity;
import com.entity.view.JiaoxueshebeiView;

import com.service.JiaoxueshebeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 教学设备
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-28 14:18:53
 */
@RestController
@RequestMapping("/jiaoxueshebei")
public class JiaoxueshebeiController {
    @Autowired
    private JiaoxueshebeiService jiaoxueshebeiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoxueshebeiEntity jiaoxueshebei, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){

        EntityWrapper<JiaoxueshebeiEntity> ew = new EntityWrapper<JiaoxueshebeiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

    	PageUtils page = jiaoxueshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueshebei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoxueshebeiEntity jiaoxueshebei, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<JiaoxueshebeiEntity> ew = new EntityWrapper<JiaoxueshebeiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

    	PageUtils page = jiaoxueshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueshebei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoxueshebeiEntity jiaoxueshebei){
       	EntityWrapper<JiaoxueshebeiEntity> ew = new EntityWrapper<JiaoxueshebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoxueshebei, "jiaoxueshebei")); 
        return R.ok().put("data", jiaoxueshebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoxueshebeiEntity jiaoxueshebei){
        EntityWrapper< JiaoxueshebeiEntity> ew = new EntityWrapper< JiaoxueshebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoxueshebei, "jiaoxueshebei")); 
		JiaoxueshebeiView jiaoxueshebeiView =  jiaoxueshebeiService.selectView(ew);
		return R.ok("查询教学设备成功").put("data", jiaoxueshebeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoxueshebeiEntity jiaoxueshebei = jiaoxueshebeiService.selectById(id);
		jiaoxueshebei.setClicknum(jiaoxueshebei.getClicknum()+1);
		jiaoxueshebei.setClicktime(new Date());
		jiaoxueshebeiService.updateById(jiaoxueshebei);
        return R.ok().put("data", jiaoxueshebei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoxueshebeiEntity jiaoxueshebei = jiaoxueshebeiService.selectById(id);
		jiaoxueshebei.setClicknum(jiaoxueshebei.getClicknum()+1);
		jiaoxueshebei.setClicktime(new Date());
		jiaoxueshebeiService.updateById(jiaoxueshebei);
        return R.ok().put("data", jiaoxueshebei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxueshebeiEntity jiaoxueshebei, HttpServletRequest request){
    	jiaoxueshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxueshebei);

        jiaoxueshebeiService.insert(jiaoxueshebei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxueshebeiEntity jiaoxueshebei, HttpServletRequest request){
    	jiaoxueshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxueshebei);

        jiaoxueshebeiService.insert(jiaoxueshebei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoxueshebeiEntity jiaoxueshebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoxueshebei);
        jiaoxueshebeiService.updateById(jiaoxueshebei);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoxueshebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiaoxueshebeiEntity jiaoxueshebei, HttpServletRequest request,String pre){
        EntityWrapper<JiaoxueshebeiEntity> ew = new EntityWrapper<JiaoxueshebeiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jiaoxueshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueshebei), params), params));
        return R.ok().put("data", page);
    }








}
