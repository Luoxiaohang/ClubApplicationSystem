package com.clubAppSys.modules.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubAppSys.modules.club.DTO.ClubDTO;
import com.clubAppSys.modules.club.mapper.ClubMapper;
import com.clubAppSys.modules.club.model.Club;

@Service("ClubService")
public class ClubService {

	@Autowired
	ClubMapper mapper;

	public ClubMapper getMapper() {
		return mapper;
	}

	/**
	 * 根据用户id 查看某个用户加入了哪些社团
	 * 
	 * @param state
	 */
	public List<ClubDTO> selectClubByUser(Integer userId, Integer state) {
		return getMapper().selectClubByUser(userId, state);
	}

	/**
	 * tested 显示所有社团
	 * 
	 * @param state
	 */
	public List<ClubDTO> selectAll(int start, int limit, int state) {
		return getMapper().selectAll(start, limit, state);
	}

	/**
	 * tested 根据id搜索社团
	 * 
	 * @param id
	 * @return
	 */
	public ClubDTO selectByPrimaryKey(Integer id) {
		return getMapper().selectByPrimaryKey(id);
	}

	/**
	 * tested 根据社团名字搜索社团
	 * 
	 * @param name
	 * @return
	 */
	public List<ClubDTO> selectByName(String name) {
		return getMapper().selectByName(name);
	}

	/**
	 * tested 根据id删除社团
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		int delId = getMapper().deleteByPrimaryKey(id);
		if (delId != -1) {
			return true;
		}
		return false;
	}

	/**
	 * tested 根据名字删除社团,名字必须是全名
	 * 
	 * @param name
	 * @return
	 */
	public int deleteByName(String name) {
		return getMapper().deleteByName(name);
	}

	/**
	 * 添加社团
	 * 
	 * @param club
	 */
	public boolean insert(Club club) {
		int idNew = getMapper().insert(club);
		if (idNew != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据主键id更新社团信息
	 * 
	 * @param record
	 * @return
	 */
	public boolean updateByPrimaryKey(Club record) {
		int idUpdate = getMapper().updateByPrimaryKey(record);
		if (idUpdate != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据id更新社团状态,用于通过社团创建申请
	 */
	public boolean updateStateByPrimaryKey(Integer state, Integer id) {
		int idUpdate = getMapper().updateStateByPrimaryKey(state, id);
		if (idUpdate != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取数据总数
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return getMapper().getTotalCount();
	}

}
