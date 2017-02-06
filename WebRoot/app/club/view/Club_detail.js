Ext.define('MyApp.club.view.Club_detail', {
	extend : 'Ext.window.Window',
	alias : 'widget.DetailClub',
	requires : [ 'Ext.form.*', "MyApp.club.model.ClubModel"
	             ],

	title : '详细信息',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 240,

	defaults : {
		margins : '5 5 5 5'
	},

	ClubRecord : null,

	initComponent : function() {

		console.log(this.ClubRecord);

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
				fieldLabel : '社团id',
				value : this.ClubRecord.data.clubId,
				readOnly : true,
			}, {
				fieldLabel : '社团名字',
				value : this.ClubRecord.data.clubName
			}, {
				fieldLabel : '创建时间',
				value : this.ClubRecord.data.foundTime
			}, {
				fieldLabel : '学校',
				value : this.ClubRecord.data.schoolName,
				/*renderer : function(value) {
					if (value)
						return "否";
					else
						return "是";
				}*/
			}, {
				fieldLabel : '简介',
				value : this.ClubRecord.data.description
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