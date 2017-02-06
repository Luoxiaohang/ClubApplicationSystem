Ext.define('MyApp.activity.view.MyActivity_show', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.ShowMyActivity',

	store : "MyApp.activity.store.MyActivityStore",

	title : '我的活动',
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
		items : [ {
			text : '详细',
			tooltip : '查看详细',
			id : 'btn_my_activity_detail'
		}, {
			text : '退出',
			tooltip : '退出活动',
			id : 'btn_my_activity_quit'
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
