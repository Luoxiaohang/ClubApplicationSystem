Ext.define("MyApp.notify.store.ClubNotifyStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.notify.model.ClubNotifyModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/Notify/getClubNotify',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});
