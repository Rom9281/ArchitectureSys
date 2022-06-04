function getInfo(){

    // create a json from form
    const target_url = "http://127.0.0.1:8082/getUserInfo"


    var user = new Object();
    user.login = sessionStorage.getItem('login');

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
    console.log(response.body)
    console.log(typeof(response))
}
    
function err_callback(error){
    console.log(error);
}


