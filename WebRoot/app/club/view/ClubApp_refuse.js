Ext.define('MyApp.club.view.ClubApp_refuse', {
	extend : 'Ext.window.Window',
	alias : 'widget.ClubAppRefuse',
	id : 'EditClub',
	requires : [ 'Ext.form.*', "MyApp.club.model.ClubModel" ],

	title : '拒绝社团申请',
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
		this.items = [ {
			xtype : 'form',
			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'textfield',
			url : SYSTEM_CONTEXTPATH + '/club/updateClubStateById',
			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 80,
			},

			items : [ {
				name : 'id',
				hidden : true,
				value : this.ClubUserAppsRecord.data.clubId
			}, {
				name : 'state',
				hidden : true,
				value : 2
			},{
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
					var form = this.up('form').getForm();
					var cmp=this.up("window");
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