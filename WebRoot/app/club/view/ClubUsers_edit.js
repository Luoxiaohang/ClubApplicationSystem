Ext.define('MyApp.club.view.ClubUsers_edit', {
	extend : 'Ext.window.Window',
	alias : 'widget.EditClubUsers',
	id : 'EditClub',
	requires : [ 'Ext.form.*' ],

	title : '修改社团成员职位',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 200,

	defaults : {
		margins : '5 5 5 5'
	},

	ClubUsersRecord : null,

	SUCCESS : null,
	FAIL : null,
	items :[ 
	    {
	    xtype:'form',
		layout : "anchor",
		anchor : "100% 100%",
		bodyPadding : '5 5 5 5',
		items:[{
			xtype : 'combobox',
			fieldLabel : '社团职位',
			name : 'clubUserPosition',
			labelAlign:'top',
			store : 'MyApp.system.store.ClubRoleStore',
			displayField : 'name',
			valueField : 'id',
			allowBlank:false
		}],
		buttons : [ {
			text : '提交',
			disabled : true,
			formBind : true,
			handler : function() {
				var form = this.up('form').getForm();
				if (form.isValid()) {
					var cmp = Ext.getCmp('EditClub');
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
		} ]}
		]
});