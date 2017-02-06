Ext
		.define(
				'MyApp.club.controller.ClubController',
				{
					extend : 'Ext.app.Controller',
					views : [ 'MyApp.club.view.Club_show',
							'MyApp.club.view.Club_add',
							'MyApp.club.view.Club_detail',
							'MyApp.club.view.Club_edit',
							'MyApp.club.view.ClubUsers_show',
							'MyApp.club.view.Club_check',
							'MyApp.club.view.ClubApp_refuse',
							'MyApp.club.view.Club_showMyClub' ],

					stores : [ 'MyApp.club.store.ClubStore',
							'MyApp.club.store.ClubSearchStore',
							'MyApp.club.store.ClubUsersStore',
							'MyApp.club.store.MyClubStore' ],

					refs : [ {
						ref : 'list',
						selector : 'ShowClub'
					}, {
						ref : 'myClub',
						selector : 'ShowMyClub'
					}, {
						ref : 'checkClubTable',
						selector : 'CheckClub'
					} ],
					/**
					 * 按钮的响应函数
					 */
					init : function() {
						this.control({
							/**
							 * 社团的增删改查方法定义
							 */
							'#btn_club_add' : {
								click : this.onAddBtnClick
							},
							'#btn_club_delete' : {
								click : this.onDelBtnClick
							},
							'#btn_club_edit' : {
								click : this.onEditBtnClick
							},
							'#btn_club_detail' : {
								click : this.onDetailBtnClick
							},
							/**
							 * 社团申请和通过的方法定义
							 */
							'#btn_clubApp_allow' : {
								click : this.onClubAppAllowBtnClick
							},
							'#btn_clubApp_refuse' : {
								click : this.onClubAppRefuseBtnClick
							},
							/**
							 * 在我的社团里查看某一社团的成员
							 */
							'#btn_clubUsers_view' : {
								click : this.onMyClubBtnClick
							},
							/**
							 * 申请加入社团按钮
							 */
							'#btn_club_app' : {
								click : this.onClubApplBtnClick
							}

						});
					},
					/**
					 * 添加社团
					 * 
					 * @param button
					 */
					onAddBtnClick : function(button) {
						var view = Ext.widget('AddClub');
					},

					onDetailBtnClick : function(button) {
						var record = this.getList().getSelectionModel()
								.getSelection()[0];
						if (typeof record == 'undefined') {
							Ext.MessageBox.show({
								title : '提示',
								msg : '请选择记录!',
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING
							});
						} else {
							var view = Ext.widget('DetailClub', {
								ClubRecord : record
							});
						}
					},

					onDelBtnClick : function(button) {
						// console.log(button.text);
						var store = this.getList().getStore();
						var record = this.getList().getSelectionModel()
								.getSelection()[0];
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
											"确定要删除当前社团",
											function(btnId) {
												if (btnId == "yes") {
													Ext.Ajax
															.request({
																url : SYSTEM_CONTEXTPATH
																		+ "/club/deleteClubById",
																method : "Post",
																params : {
																	clubId : record.data.clubId
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
					},
					/**
					 * 编辑社团信息
					 * 
					 * @param button
					 */
					onEditBtnClick : function(button) {
						var record = this.getList().getSelectionModel()
								.getSelection()[0];

						if (typeof record == 'undefined') {
							Ext.MessageBox.show({
								title : '提示',
								msg : '请选择记录!',
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING
							});
						} else {
							var store = this.getList().getStore();
							var view = Ext.widget('EditClub', {
								ClubRecord : record,
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
					/**
					 * 社团申请通过
					 * 
					 * @param button
					 */

					onClubAppAllowBtnClick : function(button) {
						var record = this.getCheckClubTable()
								.getSelectionModel().getSelection()[0];
						var store = this.getCheckClubTable().getStore();
						console.log(this.getList());
						// var storeClubShow = this.getList().getStore();

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
											"确定要允许社团申请",
											function(btnId) {
												if (btnId == "yes") {
													Ext.Ajax
															.request({
																url : SYSTEM_CONTEXTPATH
																		+ "/club/updateClubStateById",
																method : "Post",
																params : {
																	id : record.data.clubId,
																	state : 0
																},
																success : function(
																		response) {
																	var result = Ext.JSON
																			.decode(response.responseText)
																	if (result.success) {
																		Ext.Msg
																				.alert(
																						'提示',
																						"通过成功");
																		store
																				.load();
																		storeClubShow
																				.load();
																	}
																}
															});
												}
											});
						}
					},

					/**
					 * 社团申请拒绝
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
							var store = this.getCheckClubTable().getStore();
							var view = Ext.widget('ClubAppRefuse', {
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
					},
					/**
					 * 在我的社团里查看某一社团的成员
					 */
					onMyClubBtnClick : function(button) {
						// console.log(clubId);
						var record = this.getMyClub().getSelectionModel()
								.getSelection()[0];
						if (typeof record == 'undefined') {
							Ext.MessageBox.show({
								title : '提示',
								msg : '请选择记录!',
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING
							});
						} else {
							var tabMain = Ext.ComponentQuery
									.query('tabContent')[0];
							var tabId = "tab-"
									+ 'MyApp.club.view.ClubUsers_show';
							var newTab = tabMain.getComponent(tabId);
							if (newTab) {
								tabMain.remove(newTab);
							}
							var panel = Ext
									.create(
											'MyApp.club.view.ClubUsers_show',
											{
												roleName : record.data.clubUserPosition,
												id : tabId,
												clubId : record.data.clubId,
												title : "社团成员",
												closable : true,
											}).show();
							tabMain.add(panel);
							tabMain.setActiveTab(panel);
						}
					},
					/**
					 * 申请加入社团按钮响应
					 */
					onClubApplBtnClick : function(button) {
						// console.log(button.text);
						var store = this.getList().getStore();
						var record = this.getList().getSelectionModel()
								.getSelection()[0];
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
											"确定申请加入当前社团",
											function(btnId) {
												if (btnId == "yes") {
													Ext.Ajax
															.request({
																url : SYSTEM_CONTEXTPATH
																		+ "/clubUsers/UsersAppClub",
																method : "Post",
																params : {
																	userId : getUserInfo(-1).id,
																	clubId : record.data.clubId,
																},
																success : function(
																		response) {
																	var result = Ext.JSON
																			.decode(response.responseText)
																	if (result.success) {
																		Ext.Msg
																				.alert(
																						'提示',
																						"申请成功");
																		store
																				.load();
																	}
																}
															});
												}
											});
						}
					},

				});