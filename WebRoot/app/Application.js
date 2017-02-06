Ext.define('MyApp.Application', {
	name : 'MyApp',

	views : [ 'MyApp.view.Viewport' ],
	extend : 'Ext.app.Application',

	controllers : [ 'MyApp.system.controller.FunctionController',
			'MyApp.system.controller.RoleController',
			'MyApp.user.controller.UserController',
			'MyApp.club.controller.ClubController',
			'MyApp.club.controller.ClubUsersController',
			'MyApp.notify.controller.NotifyController',
			'MyApp.school.controller.SchoolController',
			'MyApp.activity.controller.MyActivityController',
			'MyApp.activity.controller.ActivityController' ],

	launch : function() {
	}
});
