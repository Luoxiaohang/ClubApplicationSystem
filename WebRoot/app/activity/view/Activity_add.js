Ext.define('MyApp.activity.view.Activity_add', {
	extend : 'Ext.window.Window',
	alias : 'widget.AddActivity',
	requires : [ 'Ext.form.*' ],
	id : 'AddFunction',
	title : '添加活动',
	layout : 'anchor',
	autoShow : true,
	modal : true,
	width : 400,
	height : 500,
	defaults : {
		margins : '5 5 5 5'
	},

	SUCCESS : null,
	FAIL : null,
	
	initComponent : function() {
		console.log(this);
		var user = getUserInfo(-1);
		var date = Ext.Date.format(new Date,'Y年m月d日');
		this.items = [{
			border : false,
			url :SYSTEM_CONTEXTPATH + '/Activity/createActivity',
			xtype : 'form',
			defaults : {
				margin : '10,5,10,5',
				labelAlign : 'right',
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '创建人',
				value : user.nickName,
				name : 'foundUserName',
				readOnly : true
			}, {
				xtype : 'combobox',
				fieldLabel : '选择社团',
				name : 'clubId',
				store : "MyApp.club.store.ClubStore",
				displayField : 'clubName',
				valueField : "clubId",
				emptyText : '请选择(必填)',
				editable : false
			}, {
				xtype : 'textfield',
				fieldLabel : '活动主题',
				name : 'theme',
				emptyText : '必填',
				allowBlank : false
			},{
				xtype : 'textfield',
				fieldLabel : '地点',
				name : 'place',
				emptyText : '必填',
				allowBlank : false
			}, {
				fieldLabel : '创建时间',
				name : 'foundTime',
				xtype : 'textfield',
				value : date,
				readOnly : true
			}, {
				fieldLabel : '开始时间',
				name : 'startTime',
				emptyText : '必填',
				allowBlank : false,
				xtype : 'datefield',
				editable : false
			}, {
				fieldLabel : '结束时间',
				name : 'endTime',
				emptyText : '必填',
				allowBlank : false,
				xtype : 'datefield',
				editable : false
			},{
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
			},{
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
					var win=Ext.getCmp('AddFunction');
					
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							success : function(form, action) {
								console.log(action.result.success);
								if (action.result.success) {
									win.SUCCESS();
									alert("活动创建成功");
								} else {
									win.FAIL();
									alert("活动创建失败");
								}
							},
							failure : function(form, action) {
								win.FAIL("连接失败");
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
		}],
		
		this.callParent(arguments);
	}
});