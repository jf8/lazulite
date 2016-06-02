/**=========================================================
 * Module: access-login.js
 * Demo for login api
 =========================================================*/

(function() {
    'use strict';

    angular
        .module('app.pages')
        .controller('LoginFormController', LoginFormController);

    LoginFormController.$inject = ['$http','$filter', 'usernamePasswordToken', 'subject','$timeout','$rootScope', '$scope', '$state'];


    function LoginFormController($http, $filter,usernamePasswordToken,subject,$timeout,$rootScope,$scope,$state) {
        var vm = this;

        activate();
        ////////////////

        function activate() {

          // bind here all data from the shiro token
          vm.token = usernamePasswordToken;
          // place the message if something goes wrong
          vm.authMsg = '';

          vm.login = function() {

            vm.authMsg = '';


            if(vm.loginForm.$valid) {


                subject.login(vm.token).then(function() {

                    $state.go('app.welcome');

                }, function(response) {
                    console.log(response)
                    vm.authMsg = 'Server Request Error';
                });
            }
            else {
              // set as dirty if the user click directly to login so we show the validation messages
              /*jshint -W106*/
              vm.loginForm.token_username.$dirty = true;
              vm.loginForm.token_password.$dirty = true;
            }
          };
        }
    }
})();
