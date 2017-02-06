Ext.define('MyApp.activity.controller.MyActivityController', {
	extend : 'Ext.app.Controller',
	views : [ 'MyApp.activity.view.MyActivity_show',
			'MyApp.activity.view.MyActivity_detail' ],

	stores : [ 'MyApp.activity.store.MyActivityStore' ],

	refs : [ {
		ref : 'list',
		selector : 'ShowMyActivity'
	} ],

	init : function() {
		this.control({
			'#btn_my_activity_quit' : {
				click : this.onDelBtnClick
			},
			'#btn_my_activity_detail' : {
				click : this.onDetailBtnClick
			}
		});
	},

	onDetailBtnClick : function(button) {
		var record = this.getList().getSelectionModel().getSelection()[0];
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			var view = Ext.widget('DetailFunction', {
				FunctionRecord : record
			});
		}
	},
	onDelBtnClick : function(button) {
		console.log(button.text);
		var record = this.getList().getSelectionModel().getSelection()[0];
		var store = this.getList().getStore();
		var user = getUserInfo(-1);
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			Ext.Msg.confirm('提示', "确定要退出由  "+record.data.clubName+"  举办的  "+record.data.theme+"  活动吗?", function(btnId) {
				if (btnId == "yes") {
					Ext.Ajax.request({
						url : SYSTEM_CONTEXTPATH + "/Activity/QuitActivitiy",
						method : "Post",
						params : {
							userId : user.id,
							state : 0,
							activityId : record.data.id
						},
						success : function(response) {
							store.load();
							Ext.Msg.alert('提示', "退出成功");
							
						}
					});
				}
			});
		}
	}
});