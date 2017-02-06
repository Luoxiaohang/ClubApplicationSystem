Ext
		.define(
				'MyApp.club.view.Club_show',
				{
					extend : 'Ext.grid.Panel',
					alias : 'widget.ShowClub',

					store : "MyApp.club.store.ClubStore",

					title : '社团列表',
					layout : 'fit',
					autoShow : true,
					modal : true,
					width : 480,
					height : 280,

					defaults : {
						margins : '5 5 5 5'
					},
					record : null,

					dockedItems : [
							{
								xtype : 'toolbar',
								dock : 'top',
								items : [
										{
											text : '新建',
											tooltip : '新建社团',
											iconCls : 'myIcon-add',
											id : 'btn_club_add',
										},
										{
											text : '编辑',
											tooltip : '编辑社团信息',
											iconCls : 'myIcon-edit',
											id : 'btn_club_edit',
										},
										{
											text : '详细',
											tooltip : '查看详细',
											iconCls : 'myIcon-detail',
											id : 'btn_club_detail',
										},
										{
											text : '删除',
											tooltip : '删除社团',
											iconCls : 'myIcon-del',
											id : 'btn_club_delete',
										},
										{
											text : '申请加入',
											tooltip : '申请加入社团',
											iconCls : 'myIcon-add',
											id : 'btn_club_app',
										},
										'->',
										{
											xtype : 'textfield',
											id : 'KeyWord',
											name : 'clubName',
											fieldLabel : '搜索社团',
										},
										{
											text : '搜索',
											handler : function() {
												this.store = Ext
														.create("MyApp.club.store.ClubSearchStore");
												var url = SYSTEM_CONTEXTPATH
														+ '/club/searchClubByName';
												// 点击搜索按钮将查询条件传递到后台
												var keyWord = Ext.getCmp(
														'KeyWord').getValue();
												if (keyWord.trim().length != 0) {
													this.up('panel').store.proxy.url = url;
													this.up('panel').store.proxy.extraParams.clubName = keyWord;
													this.up('panel').store
															.reload();
												} else {
													Ext.getCmp('KeyWord')
															.setValue("");
													this.up('panel').store.proxy.url = SYSTEM_CONTEXTPATH
															+ '/club/showAllClub';
													this.up('panel').store
															.reload();
												}
											}
										} ]
							}, {
								xtype : 'pagingtoolbar',
								store : "MyApp.club.store.ClubStore",
								emptyMsg : "没有记录",
								dock : 'bottom',
								displayInfo : true
							} ],
					columns : [ {
						header : '社团序号',
						dataIndex : 'clubId',
						width : 70,
						align : 'center'
					}, {
						header : '社团名称',
						dataIndex : 'clubName',
						width : 180,
						align : 'center'
					}, {
						header : '社团创建者',
						dataIndex : 'founderName',
						width : 100,
						align : 'center'
					}, {
						header : '社团创建者Id',
						dataIndex : 'founderId',
						hidden : true,
						width : 200,
						align : 'center'
					}, {
						header : '学校',
						dataIndex : 'schoolName',
						align : 'center',
						width : 180
					}, {
						header : '创建时间',
						dataIndex : 'foundTime',
						align : 'center',
						width : 200
					}, {
						header : '简介',
						dataIndex : 'description',
						width : 320,
						align : 'center'
					}, {
						header : '人数',
						dataIndex : 'peopleNum',
						align : 'center',
						width : 100
					} ],
					initComponent : function() {
						this.store = Ext.create("MyApp.club.store.ClubStore");
						this.store.proxy.extraParams.state = 0;
						this.store.load();
						this.callParent(arguments);
					}
				});
