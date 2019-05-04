var baseUrl="http://localhost:8080/apartment";
var fileUrl="http://localhost:8080/file/";

var headers={'authorization':'bearer;'+localStorage.getItem("token")};

function remoteCall(options) {

    var token=localStorage.getItem("token");
    // if(token==null){
    //     location.href='../html/login.html';
    // }
    options['headers']={'authorization':'bearer;'+token}
    console.log("token:"+token);
    console.log("options:"+JSON.stringify(options));
    $.ajax(options);
}

function getUrlVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}