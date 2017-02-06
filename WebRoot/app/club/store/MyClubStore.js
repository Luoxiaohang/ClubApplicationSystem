Ext.define("MyApp.club.store.MyClubStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.club.model.ClubUsersModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		extraParams : {
			userId : 0,
			state : 0,
		},
		url : SYSTEM_CONTEXTPATH + '/clubUsers/showClubByUser',
		reader : {
			type : 'json',
			root : 'list'
		},
		actionMethods : {
			read :'POST'
		}
	}
});

