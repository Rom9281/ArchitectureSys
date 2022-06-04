function Connect(){
    
    const target_url = "http://127.0.0.1:8082/getUserInfo"
    // check if user/pw pair exists and opens main menu page if so 

    var jsonString = JSON.stringify(User); //all the User infos
    console.log(jsonString)

    const requestOptions = {
        method: 'GET'
    };

    fetch(target_url, requestOptions)
        .then(response => response.json())
            //.then (response => callback(response))
            .then(response=> response_processing(response))
            .catch(error => err_callback(error));

    function response_processing(response){
        console.log(response.body)
        console.log(typeof(response))
        if (response == "true"){
            sessionStorage.setItem('login', User.login);
            window.location.replace("menu.html");
        } else{
            document.getElementById("validation").innerHTML = "Indentifiants mauvais";
            console.log("/!\\ surname or pw incorrect")
        }
    }

    function err_callback(error){
        console.log(error);
    }

    function reset_password_form(){
        var password = document.getElementById("Password").value="";
    }

}