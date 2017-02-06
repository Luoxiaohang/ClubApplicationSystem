Ext.define("MyApp.activity.store.MyActivityStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.activity.model.MyActivityModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/Activity/getMyActivity',
		reader : {
			type : 'json',
			root : 'list'
		},
		actionMethods : {
			read : 'GET'
		}
	
	}
});




