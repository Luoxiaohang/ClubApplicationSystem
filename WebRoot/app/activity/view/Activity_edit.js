Ext.define('MyApp.activity.view.Activity_edit', {
	extend : 'Ext.window.Window',
	alias : 'widget.EditActivity',
	requires : [ 'Ext.form.*', "MyApp.activity.model.MyActivityModel" ],
	id : 'EditActivity',
	title : '编辑活动',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 500,

	defaults : {
		margins : '5 5 5 5'
	},

	ActivityRecord : null,
	SUCCESS : null,
	FAIL : null,
	initComponent : function() {
		this.items = [ {
			xtype : 'form',
			layout : "anchor",
			anchor : "100% 100%",
			bodyPadding : '5 5 5 5',
			defaultType : 'textfield',
			url : SYSTEM_CONTEXTPATH + '/Activity/updateActivity',
			fieldDefaults : {
				labelAlign : 'right',
				anchor : "100%",
				labelWidth : 80,
			},

			items : [ {
				name : 'id',
				xtype : 'textfield',
				fieldLabel : '活动序号',
				hidden:	true,
				value : this.ActivityRecord.data.id
			}, {
				name  : 'clubId',
				xtype : 'textfield',
				fieldLabel : '举办社团id',
				hidden:	true,
				value : this.ActivityRecord.data.clubId
			}, {
				name : 'foundUserId',
				xtype : 'textfield',
				fieldLabel : '创建人Id',
				hidden:	true,
				value : this.ActivityRecord.data.foundUserId
			}, {
				xtype : 'displayfield',
				fieldLabel : '举办社团',
				value : this.ActivityRecord.data.clubName
			}, {
				xtype : 'displayfield',
				fieldLabel : '主题',
				value : this.ActivityRecord.data.theme
			}, {
				xtype : 'displayfield',
				fieldLabel : '时间',
				value : this.ActivityRecord.data.startTime+"---"+this.ActivityRecord.data.endTime
			}, {
				xtype : 'displayfield',
				fieldLabel : '创建人',
				value : this.ActivityRecord.data.foundUserName
			}, {
				xtype : 'displayfield',
				fieldLabel : '地点',
				value : this.ActivityRecord.data.place
			}, {
				fieldLabel : '新主题',
				name : 'theme',
				allowBlank : false,
				emptyText : '必填',
			},
			{
				fieldLabel : '开始时间',
				name : 'startTime',
				allowBlank : false,
				emptyText : '必填',
				xtype : 'datefield'
			}, {
				fieldLabel : '结束时间',
				name : 'endTime',
				allowBlank : false,
				emptyText : '必填',
				xtype : 'datefield'
			}, 
			{
				fieldLabel : '地点',
				name : 'place',
				allowBlank : false,
				emptyText : '必填',
			}, {
				name	   : 'isPublic',
				xtype      : 'fieldcontainer',
		        fieldLabel : '公开',
		        defaultType: 'radiofield',
		        layout	   : 'hbox',
				items : [
				      {
				    	  boxLabel  : '是',  
	                      name      : 'isPublic',  
	                      inputValue: '1',  
	                      id        : 'radio1'
				      },{
				    	  boxLabel  : '否',  
	                      name      : 'isPublic',  
	                      inputValue: '0',  
	                      id        : 'radio0'
				      }]
			}, {
				fieldLabel : '活动描述',
				name : 'description',
				emptyText : '必填',
				allowBlank : false,
				xtype : 'textarea',
				listeners : {
					change : function(){
						maxlength = 5;
						description = this.value;
						if(this.value.length>maxlength){
							alert("超过最大限制字数: "+maxlength+" ,请注意删减!");
							this.setValue(description.substring(0,maxlength));
						}	
					}
				}
			}],
			buttons : [ {
				text : '提交',
				disabled : true,
				formBind : true,
				handler : function() {
					var form = this.up('form').getForm();
					if (form.isValid()) {
						var cmp = Ext.getCmp('EditActivity');
						console.log(cmp);
						form.submit({
							success : function(form, action) {
								Ext.Msg.alert('Success', "修改成功！");
								cmp.SUCCESS();
							},
							failure : function(form, action) {
								Ext.Msg.alert('Failed', "修改失败！");
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