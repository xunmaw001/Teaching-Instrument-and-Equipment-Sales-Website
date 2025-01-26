package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiaoxueshebeiDao;
import com.entity.JiaoxueshebeiEntity;
import com.service.JiaoxueshebeiService;
import com.entity.vo.JiaoxueshebeiVO;
import com.entity.view.JiaoxueshebeiView;

@Service("jiaoxueshebeiService")
public class JiaoxueshebeiServiceImpl extends ServiceImpl<JiaoxueshebeiDao, JiaoxueshebeiEntity> implements JiaoxueshebeiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoxueshebeiEntity> page = this.selectPage(
                new Query<JiaoxueshebeiEntity>(params).getPage(),
                new EntityWrapper<JiaoxueshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoxueshebeiEntity> wrapper) {
		  Page<JiaoxueshebeiView> page =new Query<JiaoxueshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaoxueshebeiVO> selectListVO(Wrapper<JiaoxueshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoxueshebeiVO selectVO(Wrapper<JiaoxueshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoxueshebeiView> selectListView(Wrapper<JiaoxueshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoxueshebeiView selectView(Wrapper<JiaoxueshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
