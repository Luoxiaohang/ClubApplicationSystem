Ext.define('MyApp.activity.view.Activity_detail', {
	extend : 'Ext.window.Window',
	alias : 'widget.DetailActivity',
	requires : [ 'Ext.form.*', "MyApp.activity.model.MyActivityModel" ],
	id : 'detailActivity',
	title : '活动详情',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 240,
	defaults : {
		margins : '5 5 5 5'
	},

	ActivityRecord : null,
	SUCCESS : null,
	FAIL : null,

	initComponent : function() {
		console.log(this);
		console.log(this.ActivityRecord);

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
				fieldLabel : '序号',
				value : this.ActivityRecord.data.id
			}, {
				fieldLabel : '举办社团',
				value : this.ActivityRecord.data.clubName
			}, {
				fieldLabel : '主题',
				value : this.ActivityRecord.data.theme
			},  {
				fieldLabel : '开始时间',
				value : this.ActivityRecord.data.startTime
			},  {
				fieldLabel : '描述',
				value : this.ActivityRecord.data.description
			} ],
			buttons : [ {
				id : 'peopleNum',
				text : '参与人',
				handler : function(){
					var ActivityRecord = this.up("window").ActivityRecord;
					console.log(this.up("window").ActivityRecord);
					Ext.widget('Activity_usersShow',{
						record : ActivityRecord
					});
					
				}
			}, {
				id   : 'applyButton',
				text : '申请加入',
				handler : function() {
					var ActivityRecord = this.up("window").ActivityRecord;
					var joinComfire = Ext.Msg.show({
							title 	: '申请加入活动',
							msg   	: '你确定加入由 '+ActivityRecord.data.clubName+' 举办的 '+
								ActivityRecord.data.theme+' 活动吗?',
							buttons	: Ext.Msg.YESNO,
							icon	: Ext.Msg.QUESTION,
							fn : function callback(btn,text){
								if(btn == 'yes'){
									var users = getUserInfo(-1);
									Ext.Ajax.request({
										url : SYSTEM_CONTEXTPATH + '/Activity/JoinActivity',
										method : 'POST',
										async : false,// 指定为同步方式
										params : {
											userId : users.id,
											state  : '1',
											activityId : ActivityRecord.data.id
										},
										success : function(response) {
											Ext.Msg.alert('成功','加入成功');
											Ext.getCmp('detailActivity').SUCCESS();
										}
									});
								}
							}
					});
				}
			}, {
				text : '取消',
				handler : function() {
					this.up("window").close();
				}
			} ]
		} ];
		if(this.ActivityRecord.data.state == 1){
			console.log(this.items[0].buttons[1].text);
			this.items[0].buttons[1].text = "已加入";
			console.log(this.items[0].buttons[1].text);
			this.items[0].buttons[1].disabled = true;
		}
		this.callParent(arguments);
	}
});