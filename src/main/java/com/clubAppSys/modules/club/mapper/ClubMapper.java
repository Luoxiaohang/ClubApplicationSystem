package com.clubAppSys.modules.club.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clubAppSys.common.base.BaseMapper;
import com.clubAppSys.modules.club.DTO.ClubDTO;
import com.clubAppSys.modules.club.model.Club;

public interface ClubMapper<T> extends BaseMapper<T> {
	/**
	 * 根据用户id
	 * 查看某个用户加入了哪些社团
	 * @param userId
	 * @return
	 */
	List<ClubDTO> selectClubByUser(Integer userId,Integer state);
	/**
	 * 根据所有社团
	 * @param state
	 * @return
	 */
	List<ClubDTO> selectAll(@Param("start")int start, @Param("limit")int limit,@Param("state")int state);
	
	//根据社团id搜索社团
	ClubDTO selectByPrimaryKey(Integer id);

	//根据名字搜索社团
	List<ClubDTO> selectByName(String name);
	
	//根据主键id删除社团
	int deleteByPrimaryKey(Integer id);
	
	//根据名字删除社团
	int deleteByName(String name);
	
	//添加社团
	int insert(Club record);

	//根据主键id更新社团信息
	int updateByPrimaryKey(Club record);
	/**
	 * 根据id更新社团状态,用于通过社团创建申请
	 */
	int updateStateByPrimaryKey(Integer state,Integer id);
	/**
	 * 获取数据总数
	 * 
	 * @return
	 */
	int getTotalCount();
}