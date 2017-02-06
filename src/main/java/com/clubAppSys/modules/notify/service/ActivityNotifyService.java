package com.clubAppSys.modules.notify.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubAppSys.common.ConstantInfo;
import com.clubAppSys.modules.notify.mapper.ActivityNotifyMapper;
import com.clubAppSys.modules.notify.model.ActivityNotify;

@Service("ActivityNotifyService")
public class ActivityNotifyService {

	@Autowired
	ActivityNotifyMapper mapper;

	public ActivityNotifyMapper getMapper() {
		return mapper;
	}

	/**
	 * 根据角色获取活动通知
	 * 
	 * @param id
	 * @return
	 */
	public List<ActivityNotify> getNotifyByUserRole(Integer roleId) {
		return null;
	}

	/**
	 * 获取活动通知
	 * 
	 * 1、社团管理员能收到 申请创建活动 、申请加入活动 的通知
	 * 
	 * 2、系统成员均能能收到活动创建成功、活动取消 的通知
	 * 
	 * 3、申请加入活动的用户能到收到加入活动被批准和被拒绝的通知
	 * 
	 * @param roleId
	 * @return
	 */
	public List<ActivityNotify> getActivityNotify(Integer userId, Integer roleId) {
		List<ActivityNotify> notifies = new ArrayList<>();
		// 获取活动创建成功的通知
		List<ActivityNotify> founded = getMapper().getActivityNotifyByState(
				ConstantInfo.STATE_ACTIVITY_CREATED);
		notifies.addAll(founded);

		// 获取 活动取消 的通知
		List<ActivityNotify> cancled = getMapper().getActivityNotifyByState(
				ConstantInfo.STATE_ACTIVITY_CREATED);
		notifies.addAll(cancled);

		switch (roleId) {
		case ConstantInfo.SYSTEM_ROLE_CLUB_MANAGER:
			// 获取 申请创建活动 的通知
			List<ActivityNotify> createApply = getMapper()
					.getActivityNotifyByState(ConstantInfo.STATE_ACTIVITY_APPLY);
			notifies.addAll(createApply);

			// 获取 申请加入活动 的通知
			List<ActivityNotify> joinApply = getMapper()
					.getActivityNotifyByState(
							ConstantInfo.STATE_ACTIVITY_USER_APPLY);
			notifies.addAll(joinApply);
			break;
		case ConstantInfo.SYSTEM_ROLE_CLUB_MEMBER:

		}
		// 系统当前用户能够收到该用户申请活动被拒绝的通知
		List<ActivityNotify> joinRefused = getMapper()
				.getActivityNotifyByStateAndUserId(userId,
						ConstantInfo.STATE_ACTIVITY_USER_REFUSE);
		notifies.addAll(joinRefused);

		// 系统当前用户能够收到该用户申请活动通过的通知
		List<ActivityNotify> joined = getMapper()
				.getActivityNotifyByStateAndUserId(userId,
						ConstantInfo.STATE_ACTIVITY_USER_JOINED);
		notifies.addAll(joined);

		return notifies;
	}
}
