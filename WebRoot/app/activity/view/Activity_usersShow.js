Ext.define('MyApp.activity.view.Activity_usersShow', {
	extend : 'Ext.window.Window',
	alias : 'widget.Activity_usersShow',
	requires : [ 'Ext.form.*' ],
	id : 'Activity_usersShow',
	title : '活动参与人',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 500,
	defaults : {
		margins : '5 5 5 5'
	},
	
	record : null,
	
	initComponent : function() {
		var activityUserStore=Ext.create("MyApp.activity.store.ActivityUserStore");
		activityUserStore.proxy.extraParams.id = this.record.data.id;
		activityUserStore.load();
		this.items=[{
			xtype:'gridpanel',
			store:activityUserStore,
			anchor:'100% 100%',
			layout:'anchor',
			columns : [ {
				header : '参与人',
				dataIndex : 'userNickName',
				flex:1,
				align : 'center'
			}]
		}];
		this.callParent(arguments);
	}
});

