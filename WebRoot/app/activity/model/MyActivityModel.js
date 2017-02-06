Ext.define('MyApp.activity.model.MyActivityModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		type : 'int'
	}, {
		name : 'clubId',
		type : 'int'
	}, {
		name : 'clubName',
		type : 'string'
	}, {
		name : 'userNickName',
		type : 'string'
	}, {
		name : 'foundUserName',
		type : 'string'
	},{
		name : 'foundUserId',
		type : 'int'
	},{
		name : 'theme',
		type : 'string'
	}, {
		name : 'foundTime',
		type : 'string'
	}, {
		name : 'startTime',
		type : 'string'
	}, {
		name : 'endTime',
		type : 'string'
	}, {
		name : 'isPublic',
		type : 'int',
	}, {
		name : 'place',
		type : 'string'
	}, {
		name : 'description',
		type : 'string'
	}, {
		name : 'peopleNum',
		type : 'int'
	}, {
		name : 'state',
		type : 'int'
	} ]
});