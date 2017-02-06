Ext.define('MyApp.club.view.ClubUsers_detail', {
	extend : 'Ext.window.Window',
	alias : 'widget.DetailClubUsers',
	requires : [ 'Ext.form.*', 
	             ],

	title : '详细信息',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 340,

	defaults : {
		margins : '5 5 5 5'
	},

	ClubUsersRecord : null,

	initComponent : function() {

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
				value : this.ClubUsersRecord.data.clubId,
				readOnly : true,
			},{
				fieldLabel : '会员名',
				value : this.ClubUsersRecord.data.clubUserName,
				readOnly : true,
			} ,{
				fieldLabel : '社团',
				value : this.ClubUsersRecord.data.clubName,
				readOnly : true,
			} ,{
				fieldLabel : '职位',
				value : this.ClubUsersRecord.data.clubUserPosition,
				readOnly : true,
			} ,{
				fieldLabel : '邮箱',
				value : this.ClubUsersRecord.data.mail,
				readOnly : true,
			} ,{
				fieldLabel : '手机',
				value : this.ClubUsersRecord.data.phone,
				readOnly : true,
			} ,{
				fieldLabel : '加入时间',
				value : this.ClubUsersRecord.data.joinTime,
				readOnly : true,
			}  ],
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