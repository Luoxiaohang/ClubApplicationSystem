package com.clubAppSys.modules.activity.mapper;

import com.clubAppSys.modules.activity.model.Activities;
import com.clubAppSys.modules.activity.model.ActivityAndState;
import com.clubAppSys.modules.activity.model.ActivityUsers;

import java.util.List;

public interface ActivityUsersMapper {
    int deleteUser(ActivityUsers activityUsers);

    int insert(ActivityUsers record);

    ActivityUsers selectByPrimaryKey(Integer id);

    List<ActivityUsers> selectAll();

    int updateByPrimaryKey(ActivityUsers activityUsers);
    
    Activities findJoinedpeopleNum(ActivityUsers activityUsers);
    
    int updateState(ActivityUsers activityUsers);
    
	List<ActivityAndState> getActivityAndState(Integer id);
	
	List<ActivityAndState> findActivityUser(Activities activities);
	
	List<ActivityUsers> selectByActivityKey(Integer id);
	
	int deleteByActivityKey(Activities activities);
}