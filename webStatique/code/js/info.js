function getInfo(){

    // create a json from form
    const target_url = "http://127.0.0.1:8082/getUserInfo"

    console.log("ok");
    var user = new Object();
    user.login = sessionStorage.getItem('login');

    if(user.login != null)
    {
        request(user,target_url);
    }
    else{
        document.getElementById("userNameId").innerHTML = "No User";
        document.getElementById("money").innerHTML = "0";
    }

    
}

function request(user,target_url){
    document.getElementById("userNameId").innerHTML = user.login;

    const requestOptions = {
        method: 'GET',
    };

     // TODO change the URL to the User DB
    fetch(target_url+"/"+user.login, requestOptions)
        .then(response => response.json())
        .then (response => response_processing(response))
        .catch(error => err_callback(error));

}

function response_processing(response){
    console.log(response.money)
    console.log(typeof(response))
    document.getElementById("money").innerHTML = response.money;
}
    
function err_callback(error){
    console.log(error);
}


