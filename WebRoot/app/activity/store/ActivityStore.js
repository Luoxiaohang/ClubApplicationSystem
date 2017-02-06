Ext.define("MyApp.activity.store.ActivityStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.activity.model.MyActivityModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/Activity/findActivityAndState',
		reader : {
			type : 'json',
			root : 'list'
		},
		actionMethods : {
			read : 'POST'
		}
			
		
	}
});
