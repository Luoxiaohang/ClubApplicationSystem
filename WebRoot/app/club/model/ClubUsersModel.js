Ext.define('MyApp.club.model.ClubUsersModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'clubId',
		type : 'int'
	}, {
		name : 'clubUserName',
		type : 'string'
	},
	{
		name : 'schoolName',
		type : 'string'
	},
	{
		name : 'description',
		type : 'string'
	},
	{
		name : 'foundTime',
		type : 'string'
	},
	{
		name : 'clubUserId',
		type : 'int'
	},{
		name : 'clubName',
		type : 'string'
	}, {
		name : 'clubUserPosition',
		type : 'string'
	}, {
		name : 'mail',
		type : 'string'
	}, {
		name : 'phone',
		type : 'string'
	} ,{
		name : 'joinTime',
		type : 'string'
	},{
		name : 'state',
		type : 'Integer'
	}]
});