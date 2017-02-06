Ext.define('MyApp.activity.view.Activity_show', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.ShowActivity',
	store : "MyApp.activity.store.ActivityStore",
	title : '活动列表',
	layout : 'fit',
	autoShow : true,
	modal : true,
	width : 480,
	height : 280,
	defaults : {
		margins : '5 5 5 5'
	},

		dockedItems : [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				text : '添加',
				tooltip : '活动',
				id : 'btn_activity_add'
			}, {
				text : '编辑',
				tooltip : '编辑活动',
				id : 'btn_activity_edit'
			}, {
				text : '详细',
				tooltip : '详细信息',
				id : 'btn_activity_detail'
			}, {
				text : '删除',
				tooltip : '删除活动',
				id : 'btn_activity_delete'
			} ]
		} ],

		columns : [ {
			header : '序号',
			dataIndex : 'id',
			width : 80,
			align : 'center'
		}, {
			header : '举办社团',
			dataIndex : 'clubName',
			width : 170,
			align : 'center'
		}, {
			header : '主题',
			dataIndex : 'theme',
			width : 150,
			align : 'center'
		}, {
			header : '创建人',
			dataIndex : 'foundUserName',
			width : 100,
			align : 'center'
		},{
			header : '开始时间',
			dataIndex : 'startTime',
			align : 'center',
			width : 200
		}, {
			header : '地点',
			dataIndex : 'place',
			align : 'center',
			width : 130
		}, {
			header : '描述',
			dataIndex : 'description',
			align : 'center',
			width : 250
		}, {
			header : '状态',
			dataIndex : 'state',
			align : 'center',
			width : 73,
			renderer : function(value) {
				if (value == 1)
					return "已报名";
				else
					return "未报名";
			}
		} ]
		
	

});
