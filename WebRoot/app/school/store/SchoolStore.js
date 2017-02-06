Ext.define("MyApp.school.store.SchoolStore", {
	extend : 'Ext.data.Store',
	model : 'MyApp.school.model.SchoolModel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : SYSTEM_CONTEXTPATH + '/School/getSchoolList',
		reader : {
			type : 'json',
			root : 'list'
		}
	}
});
