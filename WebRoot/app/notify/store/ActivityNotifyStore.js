Ext.define("MyApp.notify.store.ActivityNotifyStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.notify.model.ActivityNotifyModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/Notify/getActivityNotify',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});
