Ext.define('MyApp.activity.controller.ActivityController', {
	extend : 'Ext.app.Controller',
	views : [ 'MyApp.activity.view.Activity_show',
			'MyApp.activity.view.Activity_detail',
			'MyApp.activity.view.Activity_add',
			'MyApp.activity.view.Activity_edit',
			'MyApp.activity.view.Activity_usersShow'],

	stores : [ 'MyApp.activity.store.MyActivityStore',
	           'MyApp.activity.store.ActivityUserStore',
	           'MyApp.activity.store.ActivityStore'],

	refs : [ {
		ref : 'list',
		selector : 'ShowActivity'
	} ],

	init : function() {
		this.control({
			'#btn_activity_delete' : {
				click : this.onDelBtnClick
			},
			'#btn_activity_edit' : {
				click : this.onEditBtnClick
			},
			'#btn_activity_detail' : {
				click : this.onDetailBtnClick
			},
			'#btn_activity_add' : {
				click : this.onAddBtnClick
			}
		});
	},
	
	onDetailBtnClick : function(button) {
		var record = this.getList().getSelectionModel();
		var store = this.getList().getStore();
		if (typeof record.getSelection()[0] == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			var view = Ext.widget('DetailActivity', {
				ActivityRecord : record.getSelection()[0],
				SUCCESS : function() {
					store.reload();
					record.deselect(record.getSelection()[0])
					view.close();
				},
				FAIL : function() {
					view.close();
				}
			});
		}
	},
	onDelBtnClick : function(button) {
		console.log(button.text);
		var record = this.getList().getSelectionModel().getSelection()[0];
		var store = this.getList().getStore();
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			Ext.Ajax.request({
				url : SYSTEM_CONTEXTPATH + "/Activity/selectUsersByActivitiyId",
				method : "Post",
				params : {
					id : record.data.id
				},
				success : function(response) {
					var result = Ext.JSON.decode(response.responseText)
					if (result.success) {
						Ext.Msg.confirm('提示', "活动  " + record.data.theme + "  已有活动参与者,是否继续删除?", function(btnId) {
						if (btnId == "yes") {
							Ext.Ajax.request({
								url : SYSTEM_CONTEXTPATH + "/Activity/DeleteActivitiy",
								method : "Post",
								params : {
									id : record.data.id
								},
								success : function(response) {
									var result = Ext.JSON.decode(response.responseText)
									if (result.success) {
										Ext.Msg.alert('提示', "删除成功");
										store.reload();
									}
								}
							});
						}
					});
					}else
						Ext.Msg.confirm('提示', "活动  " + record.data.theme + "  无活动参与者,是否继续删除?", function(btnId) {
							if (btnId == "yes") {
								Ext.Ajax.request({
									url : SYSTEM_CONTEXTPATH + "/Activity/DeleteActivitiy",
									method : "Post",
									params : {
										id : record.data.id
									},
									success : function(response) {
										var result = Ext.JSON.decode(response.responseText)
										if (result.success) {
											Ext.Msg.alert('提示', "删除成功");
											store.reload();
										}
									}
								});
							}
						});
				}
			});
			
			
//			Ext.Msg.confirm('提示', "确定要取消当前活动", function(btnId) {
//				if (btnId == "yes") {
//					Ext.Ajax.request({
//						url : SYSTEM_CONTEXTPATH + "/Activity/DeleteActivitiy",
//						method : "Post",
//						params : {
//							id : record.data.id
//						},
//						success : function(response) {
//							var result = Ext.JSON.decode(response.responseText)
//							if (result.success) {
//								Ext.Msg.alert('提示', "删除成功");
//								store.reload();
//							}
//						}
//					});
//				}
//			});
		}
	},
	onEditBtnClick : function(button) {
		var record = this.getList().getSelectionModel().getSelection()[0];
		console.log(record);
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			var store = this.getList().getStore();
			console.log(record);
			var view = Ext.widget('EditActivity', {
				ActivityRecord : record,
				SUCCESS : function() {
					store.load();
					view.close();
				},
				FAIL : function() {
					view.close();
				}
			});
		}
	},
	onAddBtnClick : function(button) {
//		var view = Ext.widget('AddActivity');
		var store = this.getList().getStore();
		var view = Ext.widget('AddActivity', {
			SUCCESS : function() {
				store.load();
				view.close();
			},
			FAIL : function() {
				view.close();
			}
		});
		
	}
});