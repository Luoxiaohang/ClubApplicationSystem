Ext.define('MyApp.activity.view.MyActivity_detail', {
	extend : 'Ext.window.Window',
	alias : 'widget.DetailMyActivity',
	requires : [ 'Ext.form.*', "MyApp.activity.model.MyActivityModel",
			"MyApp.activity.model.MyActivityModel" ],

	title : '活动信息',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 240,

	defaults : {
		margins : '5 5 5 5'
	},

	FunctionRecord : null,

	initComponent : function() {

		console.log(this.FunctionRecord);

		this.items = [ {

			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'displayfield',

			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 80,
			},

			items : [ {
				fieldLabel : '功能序号',
				value : this.FunctionRecord.data.id
			}, {
				fieldLabel : '所属模块',
				value : this.FunctionRecord.data.moduleName
			}, {
				fieldLabel : '功能名称',
				value : this.FunctionRecord.data.name
			}, {
				fieldLabel : '父节点',
				value : this.FunctionRecord.data.leaf,
				renderer : function(value) {
					if (value)
						return "否";
					else
						return "是";
				}
			}, {
				fieldLabel : '父节点名称',
				value : this.FunctionRecord.data.parentName,
				renderer : function(value) {
					if (value)
						return value;
					else
						return "无";
				}
			}, {
				fieldLabel : '界面名称',
				value : this.FunctionRecord.data.viewName
			} ],
			buttons : [ {
				text : '确定',
				handler : function() {
					this.up("window").close();
				}
			} ]
		} ];
		this.callParent(arguments);
	}
});