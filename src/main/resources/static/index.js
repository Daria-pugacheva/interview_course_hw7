(function () {
    angular
        .module('students-front', ['ngRoute'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'students_list/students_list.html',
                controller: 'studentsListController'
            })
            .when('/update_student/:studentId', {
                templateUrl: 'update_student/update_student.html',
                controller: 'updateStudentsController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http) {
    }
})();

angular.module('students-front').controller('indexController', function ($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/stud';

});