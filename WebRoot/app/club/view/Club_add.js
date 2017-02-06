Ext.define('MyApp.club.view.Club_add', {
	extend : 'Ext.window.Window',
	alias : 'widget.AddClub',
	requires : [ 'Ext.form.*' ],

	title : '添加社团',
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
			url : SYSTEM_CONTEXTPATH + '/club/addClub',
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
				fieldLabel : '社团名称',
				name : 'name',
				emptyText : '必填',
				allowBlank : false
			}, {
				fieldLabel : '社团简介',
				name : 'description',
				emptyText : '必填',
				allowBlank : false
			},/* {
				name : 'foundTime',
				value : Ext.Date.format(new Date(), 'Y-m-d H:i:s'),
				hidden : true
			} */],
			
			buttons : [ {
				text : '提交',
				disabled : true,
				formBind : true,
				handler : function() {
					var win=this.up("window");
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							success : function(form, action) {
								console.log(action.result.success);
								if (action.result.success=1) {
									Ext.Msg.alert('成功', "添加成功");
									win.close();
								} else {
									Ext.Msg.alert('成功', "添加失败");
									win.close();
								}
							},
							failure : function(form, action) {
								Ext.Msg.alert('失败', "请求失败");
								win.close();
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