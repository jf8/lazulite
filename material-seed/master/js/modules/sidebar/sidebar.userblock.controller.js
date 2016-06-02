(function() {
    'use strict';

    angular
        .module('app.sidebar')
        .controller('UserBlockController', UserBlockController);

    UserBlockController.$inject = ['$rootScope', '$scope','subject'];
    function UserBlockController($rootScope, $scope,subject) {

        activate();

        ////////////////

        function activate() {
          $rootScope.user = {
            name:     subject.authenticationInfo.principal.name,
            job:      subject.authenticationInfo.principal.job,
            picture:  subject.authenticationInfo.principal.picture
          };

          // Hides/show user avatar on sidebar
          $rootScope.toggleUserBlock = function(){
            $rootScope.$broadcast('toggleUserBlock');
          };

          $rootScope.userBlockVisible = true;

          var detach = $rootScope.$on('toggleUserBlock', function(/*event, args*/) {

            $rootScope.userBlockVisible = ! $rootScope.userBlockVisible;

          });

          $scope.$on('$destroy', detach);
        }
    }
})();
