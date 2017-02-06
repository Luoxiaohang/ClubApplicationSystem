Ext
		.define(
				'MyApp.club.view.ClubUsers_show',
				{
					extend : 'Ext.grid.Panel',
					alias : 'widget.ShowClubUsers',
					store : "MyApp.club.store.ClubUsersStore",
					id : 'ShowClubUsers',
					refs : [ {
						ref : 'list',
						selector : 'ShowClubUsers'
					} ],

					title : '社团成员',
					layout : 'fit',
					autoShow : true,
					modal : true,
					width : 480,
					height : 280,

					roleName:null,
					clubId : null,

					defaults : {
						margins : '5 5 5 5'
					},

					dockedItems : [ {
						xtype : 'toolbar',
						dock : 'top',
						items : [
								/*{
									text : '添加',
									tooltip : '添加会员',
									iconCls : 'myIcon-add',
									id : 'btn_clubUsers_add',
								},*/
								{
									text : '编辑',
									tooltip : '编辑会员信息',
									iconCls : 'myIcon-edit',
									id : 'btn_clubUsers_edit',
									handler : function() {
										var record = this.up('gridpanel')
												.getSelectionModel()
												.getSelection()[0];
										if (typeof record == 'undefined') {
											Ext.MessageBox.show({
												title : '提示',
												msg : '请选择记录!',
												buttons : Ext.MessageBox.OK,
												icon : Ext.MessageBox.WARNING
											});
										} else {
											var widget = Ext.widget(
													"EditClubUsers", {
														SUCCESS : function(
																value) {

														},
														FAIL : function(value) {

														}
													});
										}
									}
								},
								{
									text : '详细',
									tooltip : '查看详细',
									iconCls : 'myIcon-detail',
									id : 'btn_clubUsers_detail',
									handler : function() {
										var record = this.up('gridpanel')
												.getSelectionModel()
												.getSelection()[0];
										if (typeof record == 'undefined') {
											Ext.MessageBox.show({
												title : '提示',
												msg : '请选择记录!',
												buttons : Ext.MessageBox.OK,
												icon : Ext.MessageBox.WARNING
											});
										} else {
											var view = Ext
													.widget(
															'DetailClubUsers',
															{
																ClubUsersRecord : record
															});
										}
									}
								},
								{
									text : '删除',
									tooltip : '删除会员',
									iconCls : 'myIcon-del',
									id : 'btn_clubUsers_delete',
									handler : function() {
										var record = this.up('gridpanel')
												.getSelectionModel()
												.getSelection()[0];
										// var store =
										// this.getList().getStore();
										var store = this.up('gridpanel')
												.getStore();
										if (typeof record == 'undefined') {
											Ext.MessageBox.show({
												title : '提示',
												msg : '请选择记录!',
												buttons : Ext.MessageBox.OK,
												icon : Ext.MessageBox.WARNING
											});
										} else {

											Ext.Msg
													.confirm(
															'提示',
															"确定要删除当前社团成员",
															function(btnId) {
																if (btnId == "yes") {
																	Ext.Ajax
																			.request({
																				url : SYSTEM_CONTEXTPATH
																						+ "/clubUsers/deleteByName",
																				clubUsersRecord : record,
																				method : "Post",
																				params : {
																					clubId : record.data.clubId,
																					clubUserName : record.data.clubUserName
																				},
																				success : function(
																						response) {
																					var result = Ext.JSON
																							.decode(response.responseText)
																					if (result.success) {
																						Ext.Msg
																								.alert(
																										'提示',
																										"删除成功");
																						store
																								.load();
																					}
																				}
																			});
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
						header : '会员',
						dataIndex : 'clubUserName',
						align : 'center',
						width : 200
					}, /*
						 * { header : '会员ID', dataIndex : 'clubUserId',
						 * hidden:true, align : 'center', width : 200 },
						 */{
						header : '职位',
						dataIndex : 'clubUserPosition',
						align : 'center',
						width : 100
					}, {
						header : '手机',
						dataIndex : 'phone',
						align : 'center',
						width : 120
					},

					{
						header : '邮箱',
						dataIndex : 'mail',
						align : 'center',
						width : 200
					}, {
						header : '加入时间',
						dataIndex : 'joinTime',
						align : 'center',
						width : 230
					} ],

					initComponent : function() {
						this.store = Ext
								.create("MyApp.club.store.ClubUsersStore");
						this.store.proxy.extraParams.clubId = this.clubId;
						this.store.load();
						this.callParent(arguments);
						
						if(this.roleName=="社团管理员"){
							Ext.getCmp("btn_clubUsers_edit").setDisabled(false);
						}else{
							Ext.getCmp("btn_clubUsers_edit").setDisabled(true);
						}
					}

				});
