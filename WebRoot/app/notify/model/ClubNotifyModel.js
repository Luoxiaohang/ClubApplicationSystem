Ext.define('MyApp.notify.model.ClubNotifyModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		type : 'int'
	}, {
		name : 'state',
		type : 'int'
	}, {
		name : 'clubName',
		type : 'string'
	}, {
		name : 'userName',
		type : 'string'
	} ]
});