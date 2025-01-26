package com.dao;

import com.entity.JiaoxueshebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoxueshebeiVO;
import com.entity.view.JiaoxueshebeiView;


/**
 * 教学设备
 * 
 * @author 
 * @email 
 * @date 2023-04-28 14:18:53
 */
public interface JiaoxueshebeiDao extends BaseMapper<JiaoxueshebeiEntity> {
	
	List<JiaoxueshebeiVO> selectListVO(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
	
	JiaoxueshebeiVO selectVO(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
	
	List<JiaoxueshebeiView> selectListView(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);

	List<JiaoxueshebeiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
	
	JiaoxueshebeiView selectView(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
	

}
