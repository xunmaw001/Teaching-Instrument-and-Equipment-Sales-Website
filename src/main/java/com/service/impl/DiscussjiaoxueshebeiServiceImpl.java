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


import com.dao.DiscussjiaoxueshebeiDao;
import com.entity.DiscussjiaoxueshebeiEntity;
import com.service.DiscussjiaoxueshebeiService;
import com.entity.vo.DiscussjiaoxueshebeiVO;
import com.entity.view.DiscussjiaoxueshebeiView;

@Service("discussjiaoxueshebeiService")
public class DiscussjiaoxueshebeiServiceImpl extends ServiceImpl<DiscussjiaoxueshebeiDao, DiscussjiaoxueshebeiEntity> implements DiscussjiaoxueshebeiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaoxueshebeiEntity> page = this.selectPage(
                new Query<DiscussjiaoxueshebeiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaoxueshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaoxueshebeiEntity> wrapper) {
		  Page<DiscussjiaoxueshebeiView> page =new Query<DiscussjiaoxueshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiaoxueshebeiVO> selectListVO(Wrapper<DiscussjiaoxueshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaoxueshebeiVO selectVO(Wrapper<DiscussjiaoxueshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaoxueshebeiView> selectListView(Wrapper<DiscussjiaoxueshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaoxueshebeiView selectView(Wrapper<DiscussjiaoxueshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
