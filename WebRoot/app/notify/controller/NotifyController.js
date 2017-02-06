Ext.define('MyApp.notify.controller.NotifyController', {
	extend : 'Ext.app.Controller',
	stores : [ 'MyApp.notify.store.ClubNotifyStore',
			'MyApp.notify.store.ActivityNotifyStore' ]
});