Ext.define('MyApp.club.view.ClubUsersApp_refuse', {
	extend : 'Ext.window.Window',
	alias : 'widget.ClubUsersApplyRefuse',
	requires : [ 'Ext.form.*' ],

	title : '拒绝加入社团申请',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 250,

	defaults : {
		margins : '5 5 5 5'
	},

	ClubUserAppsRecord : null,

	SUCCESS : null,
	FAIL : null,

	initComponent : function() {
		console.log(this);
		console.log(this.ClubUserAppsRecord);

		this.items = [ {
			xtype : 'form',
			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'textfield',
			url : SYSTEM_CONTEXTPATH + "/clubUsers/updateClubUsersState",
			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 80,
			},

			items : [ {
				name : 'clubId',
				hidden : true,
				value : this.ClubUserAppsRecord.data.clubId
			}, {
				name : 'userId',
				hidden : true,
				value : this.ClubUserAppsRecord.data.clubUserId
			}, {
				name : 'state',
				hidden : true,
				value : 2
			}, {
				fieldLabel : '拒绝的理由',
				labelAlign : 'top',
				allowBlank : false,
				emptyText : '必填'
			} ],
			buttons : [ {
				text : '提交',
				disabled : true,
				formBind : true,
				handler : function() {
					var cmp=this.up("window");
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							success : function(form, action) {
								cmp.SUCCESS();
							},
							failure : function(form, action) {
								cmp.FAIL();
							}
						});
					}
				}
			}, {
				text : '重置',
				handler : function() {
					this.up('form').getForm().reset();
				}
			}, {
				text : '取消',
				handler : function() {
					this.up("window").close();
				}
			} ]
		} ];
		this.callParent(arguments);
	}
});