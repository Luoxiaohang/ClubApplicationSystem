Ext.define('MyApp.club.view.Club_edit', {
	extend : 'Ext.window.Window',
	alias : 'widget.EditClub',
	id : 'EditClub',
	requires : [ 'Ext.form.*', 
			"MyApp.club.model.ClubModel" ],

	title : '修改社团',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 400,

	defaults : {
		margins : '5 5 5 5'
	},

	ClubRecord : null,

	SUCCESS : null,
	FAIL : null,

	initComponent : function() {
		this.items = [ {
			xtype : 'form',
			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'textfield',
			url : SYSTEM_CONTEXTPATH + '/club/updateClubById',
			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 80,
			},

			items : [ {
				xtype : 'textfield',
				fieldLabel : '社团id',
				readOnly:true,
				name:'id',
				value : this.ClubRecord.data.clubId
			}, {
				xtype : 'displayfield',
				fieldLabel : '学校',
				value : this.ClubRecord.data.schoolName
			}, {
				xtype : 'displayfield',
				fieldLabel : '原社团名字',
				value : this.ClubRecord.data.clubName
			}, {
				xtype : 'displayfield',
				fieldLabel : '原简介',
				value : this.ClubRecord.data.description
			}, {
				fieldLabel : '新的社团名字',
				name : 'name',
				allowBlank : false,
				value : this.ClubRecord.data.clubName,
				emptyText : '必填'
			}, {
				fieldLabel : '新的简介',
				name : 'description',
				allowBlank : false,
				emptyText : '必填',
				value : this.ClubRecord.data.description,
			} ],
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
			} ]
		} ];
		this.callParent(arguments);
	}
});