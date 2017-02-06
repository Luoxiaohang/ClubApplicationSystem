Ext.define("MyApp.club.store.ClubSearchStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.club.model.ClubModel',
	autoLoad : true,
	proxy : {
		actionMethods : {
			read : 'POST'
		},
		extraParams : {
			clubName : null
		},
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/club/searchClubByName',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});

