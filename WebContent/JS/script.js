(function() {
    'use strict';

    angular
        .module('test', [])
        .controller('MainController', MainController);

    MainController.$inject = ['$rootScope', '$http', 'myService'];

    function MainController($rootScope, $http,myService)
    {
        var mainVm = this;
        mainVm.title = 'AngularJS';

        mainVm.employees = [];

        mainVm.addCustomer = function()
        {
            myService.sendObj(mainVm.newEmp,mainVm.employees,$http);
            console.log("After send obj");
            console.log(mainVm.employees);
        };

    }

    //create a service
    angular.module('test').service('myService', myService);

    function myService()
    {
        var self = this;

        //
        self.sendObj = function(input,emps,scope)
        {
            var request = {
                method: "post",
                url: "/TestProj/api/modal/newmodal/",
                data: input
            };
            scope(request).success(function(response,status, headers, config)
            {
                console.log("After send obj then");
                console.dir(response);
                console.dir(response.email);
                emps.push(response);
            });
        };
    }
})();