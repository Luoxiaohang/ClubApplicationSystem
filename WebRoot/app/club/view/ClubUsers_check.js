Ext.define('MyApp.club.view.ClubUsers_check', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.CheckUsersAppClub',

	store : ["MyApp.club.store.ClubUsersStore",'MyApp.club.store.MyMngClubUsersStore'],
	
	title : '社团成员审核',
	layout : 'fit',
	autoShow : true,
	modal : true,
	width : 480,
	height : 280,

	ClubUserAppsRecord : null,
	SUCCESS : null,
	FAIL : null,
	
	defaults : {
		margins : '5 5 5 5'
	},

	dockedItems : [ {
		xtype : 'toolbar',
		dock : 'top',
		items : [ {
			text : '通过',
			tooltip : '通过加入社团申请',
			iconCls : 'myIcon-add',
			id : 'btn_clubUsersApp_allow',
			handler : function(){
				var record = this.up('gridpanel').getSelectionModel()
				.getSelection()[0];
				var store = this.up('gridpanel').getStore();
				if (typeof record == 'undefined') {
					Ext.MessageBox.show({
						title : '提示',
						msg : '请选择记录!',
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.WARNING
					});
				}else{
					Ext.Msg.confirm('提示',"确定要允许社团成员申请",function(btnId) {
						if (btnId == "yes") {
							Ext.Ajax.request({
								url : SYSTEM_CONTEXTPATH + "/clubUsers/updateClubUsersState",
								method : "Post",
								params : {
									clubId : record.data.clubId,
									userId : record.data.clubUserId,
									state : 0
								},
								success : function(response) {
									var result = Ext.JSON.decode(response.responseText)
									if (result.success) {
										Ext.Msg.alert('提示',"通过成功");
										store.load();
										CheckUsersAppClub.load();
									}
								}
							});
						}
					});
					
				}
			}
		}, {
			text : '拒绝',
			tooltip : '拒绝加入社团申请',
			iconCls : 'myIcon-del',
			id : 'btn_clubUsrsApp_refuse',
			handler : function(){
				var record = this.up('gridpanel').getSelectionModel()
				.getSelection()[0];
				if (typeof record == 'undefined') {
					Ext.MessageBox.show({
						title : '提示',
						msg : '请选择记录!',
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.WARNING
					});
				}else{
					var store = this.up('gridpanel').getStore();
					var view = Ext.widget('ClubUsersApplyRefuse', {
						ClubUserAppsRecord : record,
						SUCCESS : function() {
							store.load();
							view.close();
						},
						FAIL : function() {
							view.close();
						}
					});
					
					
				}
			}
			
		} ]
	} ],

	columns : [ {
		header : '社团序号',
		dataIndex : 'clubId',
		width : 80,
		align : 'center'
	}, {
		header : '社团名称',
		dataIndex : 'clubName',
		width : 200,
		align : 'center'
	}, {
		header : '用户ID',
		dataIndex : 'clubUserId',
		hidden:true,
		align : 'center',
		width : 200
	},{
		header : '申请用户',
		dataIndex : 'clubUserName',
		align : 'center',
		width : 200
	}, {
		header : '手机',
		dataIndex : 'phone',
		align : 'center',
		width : 200
	},
	{
		header : '邮箱',
		dataIndex : 'mail',
		align : 'center',
		width : 200
	}, {
		header : '申请时间',
		dataIndex : 'joinTime',
		align : 'center',
		width : 230
	} ],
	initComponent : function() {

		this.store = Ext.create("MyApp.club.store.MyMngClubUsersStore");
		this.store.proxy.extraParams.state = 1;
		this.store.load();

		this.callParent(arguments);
	}
});
