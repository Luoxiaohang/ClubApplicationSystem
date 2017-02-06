Ext.define('MyApp.mainView.TabContent', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.tabContent',
	itemNo : 0,
	activeTab : 1,
	requires : [ 'Ext.app.Portlet', 'Ext.app.PortalColumn',
			'Ext.app.PortalPanel', 'Ext.app.PortalDropZone',
			'Ext.ux.TabReorderer', 'Ext.ux.TabCloseMenu' ],
	plugins : [ Ext.create('Ext.ux.TabReorderer'),
			Ext.create('Ext.ux.TabCloseMenu', {
				closeTabText : '关闭面板',
				closeOthersTabsText : '关闭其他',
				closeAllTabsText : '关闭所有'
			}) ],
	items : [ {
		title : '系统首页',
		xtype : 'portalpanel',
		itemId : 'platformHomePage',
		autoScroll : true,
		defaults : {
			margin : '5 5 5 5'
		},
		items : [ {
			xtype : 'portalcolumn',
			items : [ {
				title : '社团通知',
				height : 300,
				border : false,
				closable : false,
				collapsible : false,
				items : [ {
					xtype : 'gridpanel',
					header : false,
					border : false,
					store : "MyApp.notify.store.ClubNotifyStore",
					columns : [ {
						text : '社团名称',
						align : 'center',
						flex : 1,
						dataIndex : 'clubName'
					}, {
						text : '用户名',
						align : 'center',
						flex : 1,
						dataIndex : 'userName'
					}, {
						text : '通知内容',
						align : 'center',
						dataIndex : 'state',
						flex : 2,
						renderer : function(value) {
							switch (value) {
							case 0:
								return "社团创建成功";
							case 1:
								return "申请创建社团";
							case 2:
								return "社团创建失败";
							case 3:
								return "社团创建失败";
							}
						}
					} ]
				} ]
			} ]
		}, {
			xtype : 'portalcolumn',
			items : [ {
				title : '活动通知',
				height : 300,
				border : false,
				closable : false,
				collapsible : false,
				items : [ {
					xtype : 'gridpanel',
					header : false,
					border : false,
					store : "MyApp.notify.store.ActivityNotifyStore",
					columns : [ {
						text : '活动主题',
						align : 'center',
						dataIndex : 'theme',
						flex : 1
					}, {
						text : '举办社团',
						align : 'center',
						dataIndex : 'clubName',
						flex : 1
					}, {
						text : '用户名',
						dataIndex : 'userName',
						align : 'center',
						flex : 1
					}, {
						text : '通知类型',
						dataIndex : 'state',
						align : 'center',
						flex : 1,
						renderer : function(value) {
							switch (value) {
							case 0:
								return "退出活动";
							case 1:
								return "参加活动申请通过";
							case 2:
								return "参加活动申请被拒绝";
							case 3:
								return "正在申请参加活动";
							case 4:
								return "活动取消";
							case 5:
								return "创建活动被拒绝";
							case 6:
								return "申请创建活动";
							case 7:
								return "活动创建成功";
							}
						}
					} ]
				} ]
			} ]
		} ]
	} ]
});