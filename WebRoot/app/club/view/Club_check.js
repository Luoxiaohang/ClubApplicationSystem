Ext.define('MyApp.club.view.Club_check', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.CheckClub',
	

	store : "MyApp.club.store.ClubStore",
	
	title : '社团审核',
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
			text : '通过',
			tooltip : '通过社团申请',
			iconCls : 'myIcon-add',
			id : 'btn_clubApp_allow',
		}, {
			text : '拒绝',
			tooltip : '拒绝社团申请',
			iconCls : 'myIcon-del',
			id : 'btn_clubApp_refuse',
		} ]
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
	},
	 {
		header : '申请人',
		dataIndex : 'founderName',
		width : 150,
		align : 'center'
	},
	{
		header : '学校',
		dataIndex : 'schoolName',
		align : 'center',
		width : 230
	},{
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
	}
	],
	initComponent : function() {

		this.store = Ext.create("MyApp.club.store.ClubStore");
		this.store.proxy.extraParams.state = 1;
		this.store.load();

		this.callParent(arguments);
	}
});
