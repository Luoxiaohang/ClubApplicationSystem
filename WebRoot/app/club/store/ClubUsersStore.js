Ext.define("MyApp.club.store.ClubUsersStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.club.model.ClubUsersModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		extraParams : {
			clubId : 0,
			state : 0,
		},actionMethods : {
			read :'POST'
		},
		url : SYSTEM_CONTEXTPATH + '/clubUsers/showClubUsersById',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});

