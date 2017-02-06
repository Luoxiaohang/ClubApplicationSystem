Ext.define("MyApp.activity.store.ActivityUserStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.activity.model.MyActivityModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		extraParams : {
			id : 0,
		},
		url : SYSTEM_CONTEXTPATH + '/Activity/findActivityUser',
		reader : {
			type : 'json',
			root : 'list'
		},
		actionMethods : {
			read : 'POST'
		}
	}
});