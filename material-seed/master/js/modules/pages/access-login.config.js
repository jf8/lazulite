/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

(function(){
    'use strict';
    angular.module('app.pages').config(shiroConfig);
    shiroConfig.$inject=['$stateProvider', 'angularShiroConfigProvider'];
    function shiroConfig($stateProvider,config){
        config.setFilter('/**/*','authc');
        config.setAuthenticateUrl("api/account/login");
        config.setLoginPath("page/login");
    }
})();