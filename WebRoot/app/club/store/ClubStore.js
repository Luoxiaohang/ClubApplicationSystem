Ext.define("MyApp.club.store.ClubStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.club.model.ClubModel',
	autoLoad : true,
	pageSize : 16,
	proxy : {
		type : 'ajax',
		extraParams : {
			state : 0,
			clubName:null
		},
		url : SYSTEM_CONTEXTPATH + '/club/showAllClub',
		reader : {
			type : 'json',
			root : 'list',
			// 指定reader 的totalProperty。否则就只有一页
			totalProperty : 'totalCount'
		},
		actionMethods : {
			read :'POST'
		}
	}
});

