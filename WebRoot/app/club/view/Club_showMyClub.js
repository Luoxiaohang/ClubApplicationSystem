Ext.define('MyApp.club.view.Club_showMyClub', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.ShowMyClub',

	title : '我的社团',
	layout : 'fit',
	autoShow : true,
	modal : true,
	width : 480,
	height : 280,

	defaults : {
		margins : '5 5 5 5'
	},
	record : null,

	dockedItems : [ {
		xtype : 'toolbar',
		dock : 'top',
		items : [ 
 
		{
			text : '查看成员',
			tooltip : '查看该社团的成员',
			iconCls : 'myIcon-detail',
			id : 'btn_clubUsers_view',
		}, 
		{
			text : '退出社团',
			tooltip : '查看该社团的成员',
			iconCls : 'myIcon-del',
			id : 'btn_clubUsers_quit',
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
				} else{
					Ext.Msg.confirm('提示', "确定要退出当前社团", function(btnId) {
						if (btnId == "yes") {
							Ext.Ajax.request({
								url : SYSTEM_CONTEXTPATH + "/clubUsers/deleteById",
								//clubUsersRecord : record,
								method : "Post",
								params : {
									clubId : record.data.clubId,
									userId : getUserInfo(-1).id
								},
								success : function(response) {
									var result = Ext.JSON.decode(response.responseText)
									if (result.success) {
										Ext.Msg.alert('提示', "退出成功");
										store.load();
									}
								}
							});
						}
					});
					
				}
					
			}
		}, 
		]
	} ],

	columns : [ {
		header : '社团序号',
		dataIndex : 'clubId',
		width : 100,
		align : 'center'
	}, {
		header : '社团名称',
		dataIndex : 'clubName',
		width : 200,
		align : 'center'
	}, {
		header : '本人职位',
		dataIndex : 'clubUserPosition',
		align : 'center',
		width : 150
	},{
		header : '学校',
		dataIndex : 'schoolName',
		align : 'center',
		width : 230
	}, {
		header : '创建时间',
		dataIndex : 'foundTime',
		align : 'center',
		width : 200
	}, 
	 {
		header : '简介',
		dataIndex : 'description',
		width : 320,
		align : 'center'
	},
	/*{
		header : '人数',
		dataIndex : 'peopleNum',
		align : 'center',
		width : 100
	} */],
	initComponent : function() {

		this.store = Ext.create("MyApp.club.store.MyClubStore");
		this.store.proxy.extraParams.userId  = getUserInfo(-1).id;
		this.store.load();

		this.callParent(arguments);
	}
	
});
