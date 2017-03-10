var div = document.getElementById("div");
var url = "http://localhost:8084/restjson/api/adresses/3/fname,lname,city";

var promise = fetch(url, config);

promise.then(function(response){
    return response.json;
});

document.getElementById("div").innerTEXT = promise;
