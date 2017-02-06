Ext.define('MyApp.notify.model.ActivityNotifyModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		type : 'int'
	}, {
		name : 'state',
		type : 'int'
	}, {
		name : 'userName',
		type : 'string'
	}, {
		name : 'theme',
		type : 'string'
	}, {
		name : 'clubName',
		type : 'string'
	} ]
});