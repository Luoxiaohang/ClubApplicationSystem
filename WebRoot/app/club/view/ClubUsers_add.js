Ext.define('MyApp.club.view.ClubUsers_add', {
	extend : 'Ext.window.Window',
	alias : 'widget.AddClubUsers',
	requires : [ 'Ext.form.*' ],

	title : '添加社团成员',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 200,
	defaults : {
		margins : '5 5 5 5'
	},

	initComponent : function() {

		this.items = [ {
			xtype : 'form',
			url : SYSTEM_CONTEXTPATH + '/clubUsers/addClubUser',
			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'textfield',
			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 60,
			},

			items : [ 

			{
				fieldLabel : '会员名',
				name : 'clubUserName',
				emptyText : '必填',
				allowBlank : false
			}, {
				fieldLabel : '职位',
				name : 'clubUserPosition',
				emptyText : '必填',
				allowBlank : false
			} ],
			
			buttons : [ {
				text : '提交',
				disabled : true,
				formBind : true,
				handler : function() {
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							success : function(form, action) {
								console.log(action.result.success);
								if (action.result.success!=1) {
									Ext.Msg.alert('成功', "添加成功");
									this.up("window").close();
								} else {
									Ext.Msg.alert('成功', "添加失败");
									this.up("window").close();
								}
							},
							failure : function(form, action) {
								Ext.Msg.alert('失败', "请求失败");
								this.up("window").close();
							}
						});
					}
				}
			}, {
				text : '重置',
				handler : function() {
					this.up('form').getForm().reset();
				}
			} ]
		} ];
		
		this.callParent(arguments);
	}
});