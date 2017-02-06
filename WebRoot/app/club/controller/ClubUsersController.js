Ext.define('MyApp.club.controller.ClubUsersController', {
	extend : 'Ext.app.Controller',
	views : [ 'MyApp.club.view.ClubUsers_show',
	          'MyApp.club.view.ClubUsers_detail',
	          'MyApp.club.view.ClubUsers_check',
	          'MyApp.club.view.ClubUsersApp_refuse',
	          'MyApp.club.view.ClubUsers_edit'
	          ],

	stores : [ 'MyApp.club.store.ClubUsersStore','MyApp.club.store.MyMngClubUsersStore' ],

	refs : [ {
		ref : 'list',
		selector : 'ShowClubUsers'
	} ],
	
	onClubAppAllowBtnClick : function(button){
		var record = this.getCheckClubTable().getSelectionModel().getSelection()[0];
		var store = this.getCheckClubTable().getStore();
		console.log(this.getList());
		//var storeClubShow = this.getList().getStore();
		
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else{
			Ext.Msg.confirm('提示',"确定要允许加入社团申请",function(btnId) {
				if (btnId == "yes") {
					Ext.Ajax.request({
						url : SYSTEM_CONTEXTPATH + "/club/updateClubStateById",
						method : "Post",
						params : {
							id : record.data.clubId,
							state : 0
						},
						success : function(response) {
							var result = Ext.JSON.decode(response.responseText)
							if (result.success) {
								Ext.Msg.alert('提示',"加入成功");
								store.load();
								storeClubShow.load();
							}
						}
					});
				}
			});
		}
	},
	
	/**
	 * 加入社团申请拒绝
	 */
	onClubAppRefuseBtnClick : function(button) {
		var record = this.getCheckClubTable()
				.getSelectionModel().getSelection()[0];
	
		if (typeof record == 'undefined') {
			Ext.MessageBox.show({
				title : '提示',
				msg : '请选择记录!',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING
			});
		} else {
			
		}
	},



});