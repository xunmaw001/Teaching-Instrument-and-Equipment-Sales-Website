package com.dao;

import com.entity.DiscussjiaoxueshebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaoxueshebeiVO;
import com.entity.view.DiscussjiaoxueshebeiView;


/**
 * 教学设备评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-28 14:18:54
 */
public interface DiscussjiaoxueshebeiDao extends BaseMapper<DiscussjiaoxueshebeiEntity> {
	
	List<DiscussjiaoxueshebeiVO> selectListVO(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
	
	DiscussjiaoxueshebeiVO selectVO(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
	
	List<DiscussjiaoxueshebeiView> selectListView(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);

	List<DiscussjiaoxueshebeiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
	
	DiscussjiaoxueshebeiView selectView(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
	

}
