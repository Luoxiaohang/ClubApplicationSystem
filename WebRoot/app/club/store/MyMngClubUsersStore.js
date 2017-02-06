Ext.define("MyApp.club.store.MyMngClubUsersStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.club.model.ClubUsersModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		extraParams : {
			state : 1
		},actionMethods : {
			read :'POST'
		},
		url : SYSTEM_CONTEXTPATH + '/clubUsers/showMyMngClubUsersByState',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});

