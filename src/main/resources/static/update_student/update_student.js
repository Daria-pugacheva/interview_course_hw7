angular.module('students-front').controller('updateStudentsController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/stud';

    $scope.prepareStudentForUpdate = function () {
        $http.get(contextPath + '/students/' + $routeParams.studentId)
            .then(function (response) {
                console.log(response.data)
                $scope.updated_student = response.data;
            });
    }

    $scope.updateStudent = function () {
        $http.put(contextPath + '/students', $scope.updated_student)
            .then(function (response) {
                $scope.updated_student = null;
                alert('Студент успешно обновлен');
                $location.path('/');
            });
    }

    $scope.prepareStudentForUpdate();
});