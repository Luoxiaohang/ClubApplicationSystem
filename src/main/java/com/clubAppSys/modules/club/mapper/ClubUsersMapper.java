package com.clubAppSys.modules.club.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clubAppSys.modules.club.DTO.ClubUsersDTO;
import com.clubAppSys.modules.club.model.Club;
import com.clubAppSys.modules.club.model.ClubUsers;

public interface ClubUsersMapper {
	//根据社团id显示同一社团所有社团成员信息
	List<ClubUsersDTO> selectClubUsersByClubIdAndState(ClubUsers clubUser);
	/**
	 * 更新社团成员状态
	 */
	int updateClubUsersState(ClubUsers clubUsers);
	/**
	 * 某一用户申请加入某一社团
	 */
	int usersAppClub(ClubUsers clubUsers);
	//根据clubId,userId在一个社团里搜索社团成员
	ClubUsersDTO selectById(Integer clubId,Integer userId);
	//根据名字搜索社团成员
	List<ClubUsersDTO> selectByName(@Param("clubId")Integer clubId,@Param("nickName")String nickName);
	//根据id删除社团成员
	int deleteClubUserById(Integer userId,Integer clubId);
	//根据名字删除社团成员
	int deleteClubUserByName(ClubUsersDTO clubUsersDTO);
	//添加社团成员
	int insert(String nickName,String clubName,String roleName,
			Date joinTime,Integer state);
	//更新社团成员信息
	int updateByKey(Integer roleId, Date joinTime,Integer state,
			String clubName,String nickName);
	/**
	 * 
	 * @param clubUser
	 * @return
	 */
	List<ClubUsersDTO> showMyMngClubUsersByClubIdAndState(ClubUsers clubUser);
	
	/**
	 * 获取我管理的社团
	 * @param userId
	 * @return
	 */
	List<Club> selectMyMngClub(Integer userId);
	
	/**
	 * 根据社团Id获取社团的所有成员
	 * @param id
	 * @return
	 */
	List<ClubUsersDTO> selectAllClubUsersByClubId(@Param("clubId")Integer ClubId,@Param("state")int state);
	/**
	 * 根据用户id
	 * 查看某用户加入了那些社团且显示职位
	 * @param userId
	 * @return
	 * 
	 */
	List<ClubUsersDTO> selectClubByUser(Integer userId, Integer state);
}