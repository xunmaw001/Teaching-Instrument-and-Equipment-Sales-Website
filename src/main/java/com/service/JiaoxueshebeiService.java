package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoxueshebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoxueshebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxueshebeiView;


/**
 * 教学设备
 *
 * @author 
 * @email 
 * @date 2023-04-28 14:18:53
 */
public interface JiaoxueshebeiService extends IService<JiaoxueshebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxueshebeiVO> selectListVO(Wrapper<JiaoxueshebeiEntity> wrapper);
   	
   	JiaoxueshebeiVO selectVO(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
   	
   	List<JiaoxueshebeiView> selectListView(Wrapper<JiaoxueshebeiEntity> wrapper);
   	
   	JiaoxueshebeiView selectView(@Param("ew") Wrapper<JiaoxueshebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxueshebeiEntity> wrapper);
   	

}

