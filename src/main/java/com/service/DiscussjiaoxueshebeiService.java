package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiaoxueshebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiaoxueshebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiaoxueshebeiView;


/**
 * 教学设备评论表
 *
 * @author 
 * @email 
 * @date 2023-04-28 14:18:54
 */
public interface DiscussjiaoxueshebeiService extends IService<DiscussjiaoxueshebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiaoxueshebeiVO> selectListVO(Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
   	
   	DiscussjiaoxueshebeiVO selectVO(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
   	
   	List<DiscussjiaoxueshebeiView> selectListView(Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
   	
   	DiscussjiaoxueshebeiView selectView(@Param("ew") Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiaoxueshebeiEntity> wrapper);
   	

}

