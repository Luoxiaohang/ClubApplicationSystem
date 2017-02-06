package com.clubAppSys.common;

public interface ConstantInfo {

	/**
	 * 系统当前用户
	 */
	String CURRENT_USER = "CURRENT_USER";

	/**
	 * 系统所有用户
	 */
	int SYSTEM_ROLE_USER_ALL = -1;

	/**
	 * 系统管理员
	 */
	int SYSTEM_ROLE_SYSTEM_MANAGER = 1;

	/**
	 * 社团管理员
	 */
	int SYSTEM_ROLE_CLUB_MANAGER = 2;

	/**
	 * 社团成员
	 */
	int SYSTEM_ROLE_CLUB_MEMBER = 3;

	/**
	 * 普通用户
	 */
	int SYSTEM_ROLE_USER = 4;

	/**
	 * 社团状态：申请中
	 */
	int CLUB_STATE_APP = 1;

	/**
	 * 社团状态：申请通过
	 */
	int CLUB_STATE_APP_ALLOW = 0;

	/**
	 * 社团状态：申请失败
	 */
	int CLUB_STATE_APP_REFUSE = 2;

	/**
	 * 社团状态：注销
	 */
	int CLUB_STATE_CANCLE = 3;
	/**
	 * 社团成员状态：申请中
	 */
	Integer CLUBUSERS_APP = 1;
	/**
	 * 社团成员状态：允许
	 */
	Integer CLUBUSERS_ALLOW = 0;
	/**
	 * 社团成员状态：拒绝
	 */
	Integer CLUBUSER_REFUSE = 2;
	/**
	 * 社团成员状态：退出社团申请
	 */
	Integer CLUBUSER_QUIT_APP = 3;
	/**
	 * 社团成员状态：退出社团申请允许
	 */
	Integer CLUBUSER_QUIT_ALLOW = 4;

	/**
	 * 活动创建成功
	 */
	Integer STATE_ACTIVITY_CREATED = 7;

	/**
	 * 创建活动申请
	 */
	Integer STATE_ACTIVITY_APPLY = 6;
	
	/**
	 * 创建活动被拒绝
	 */
	Integer STATE_ACTIVITY_REFUSE = 5;

	/**
	 * 活动取消
	 */
	Integer STATE_ACTIVITY_CANCLE = 4;

	/**
	 * 申请参加活动
	 */
	Integer STATE_ACTIVITY_USER_APPLY = 3;
	
	/**
	 * 批准参加活动
	 */
	Integer STATE_ACTIVITY_USER_JOINED = 1;

	/**
	 * 拒绝参加活动
	 */
	Integer STATE_ACTIVITY_USER_REFUSE = 2;
	
	/**
	 * 退出活动
	 */
	Integer STATE_ACTIVITY_USER_QUIT = 0;
}
