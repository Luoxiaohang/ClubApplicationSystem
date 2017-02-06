package com.clubAppSys.modules.club.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubAppSys.modules.club.DTO.ClubUsersDTO;
import com.clubAppSys.modules.club.mapper.ClubUsersMapper;
import com.clubAppSys.modules.club.model.Club;
import com.clubAppSys.modules.club.model.ClubUsers;

@Service("ClubUsersService")
public class ClubUsersService {

	@Autowired
	ClubUsersMapper mapper;

	public ClubUsersMapper getMapper() {
		return mapper;
	}
	
	/**
	 * 更新社团成员状态
	 */
	public boolean updateClubUsersState(ClubUsers clubUsers){
		int updateStateId= getMapper().updateClubUsersState(clubUsers);
		if(updateStateId!=-1){
			return true;
		}
		return false;
	}
	/**
	 * 某一用户申请加入某一社团
	 */
	public boolean usersAppClub(ClubUsers clubUsers){
		int appId= getMapper().usersAppClub(clubUsers);
		if(appId!=-1){
			return true;
		}
		return false;
	 }
	/**
	 * 
	 * @return
	 */
	public List<ClubUsersDTO> showMyMngClubUsersByClubIdAndState(Integer userId,ClubUsers clubUser){
		List<ClubUsersDTO> result=new ArrayList<>();
		//根据Id获取我管理的社团
		List<Club> clubs=getMapper().selectMyMngClub(userId);
		//获取我管理社团的申请成员信息
		for(Club club:clubs){
			List<ClubUsersDTO> users=getMapper().selectAllClubUsersByClubId(club.getId(),clubUser.getState());
			result.addAll(users);
		}
		return result;		
	}
	
	/**tested
	 * 根据社团id 显示同一社团所有社团成员信息
	 * @return
	 */
	public List<ClubUsersDTO> selectAllClubUsers(ClubUsers clubUser){
		return getMapper().selectClubUsersByClubIdAndState(clubUser);		
	}
	
	/**tested
	 * 根据clubId,userId在一个社团里搜索社团成员
	 * @param id
	 * @return
	 */
	public ClubUsersDTO selectById(Integer clubId,Integer userId){
		return getMapper().selectById(clubId,userId);		
	}
	/**tested
	 * 根据名字搜索社团成员
	 * @param name
	 * @return
	 */
	public List<ClubUsersDTO> selectByName(Integer clubId,String nickName){
		return getMapper().selectByName(clubId,nickName);		
	}
	/**tested
	 * 根据id删除社团成员
	 * @param id
	 * @return
	 */
	public boolean deleteClubUserById(Integer userId,Integer clubId){
		int delId= getMapper().deleteClubUserById(userId,clubId);
		if(delId!=-1){
			return true;
		}
		return false;
	}
	/**tested
	 * 根据名字删除社团成员
	 * @param clubUserName
	 * @param clubId
	 * @return
	 */
	public boolean deleteClubUserByName(ClubUsersDTO clubUsersDTO){
		int delId= getMapper().deleteClubUserByName(clubUsersDTO);
		if(delId!=-1){
			return true;
		}
		return false;
	}
	/**
	 * 添加社团成员
	 * @param record
	 */
	public int insert(String nickName,String clubName,String roleName,
			Date joinTime,Integer state){
		return getMapper().insert(nickName,clubName,roleName,joinTime, state);
	}
	/**
	 * 更新社团成员信息
	 * @param record
	 * @return
	 */
	public int updateByKey(Integer roleId, Date joinTime,Integer state,
			String clubName,String nickName){
		return getMapper().updateByKey(roleId, joinTime, state, 
				clubName, nickName);
	}

	/**
	 * 根据用户id
	 * 查看某用户加入了那些社团且显示职位
	 * @param userId
	 * @return
	 * 
	 */
	public List<ClubUsersDTO> selectClubByUser(Integer userId, Integer state) {
		
		return getMapper().selectClubByUser(userId,state);
	}
}
