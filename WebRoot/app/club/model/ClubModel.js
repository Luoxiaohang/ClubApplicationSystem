Ext.define('MyApp.club.model.ClubModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		
		name : 'clubId',
		type : 'int'
	},
	{
		name : 'founderName',
		type : 'string'
	},
	{
		name : 'founderId',
		type : 'int'
	},
	{
		name : 'clubName',
		type : 'string'
	}, {
		name : 'schoolName',
		type : 'string'
	}, {
		name : 'state',
		type : 'int'
	}, {
		name : 'description',
		type : 'string'
	}, {
		name : 'foundTime',
		type : 'string'
	}, {
		name : 'peopleNum',
		type : 'int'
	} ]
});