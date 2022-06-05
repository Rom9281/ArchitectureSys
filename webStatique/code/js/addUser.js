function SendUser(){
    // create a json from form
    const target_url = "http://127.0.0.1:8082/createUser"

    const form = document.getElementById('addUserForm')

    var User = new Object();
    User.name = document.getElementById("Name").value;
    User.first_name = document.getElementById("Surname").value;
    User.password = document.getElementById("Password").value;
    User.email = document.getElementById("Email").value;
    User.login = document.getElementById("Login").value;
    User.imgUrl="";
    
    //Check if the two passwords are the same
    if ((User.password.normalize() === document.getElementById("Re-Password").value.normalize())
        && !(User.password === "")){
        console.log("mdp et re-mdp semblables");
        document.getElementById('message').value='Account successfully created';
    } else{
        console.log("/!\\ mdp et re-mdp différents ou vides");
        document.getElementById('message').value='Error: passwords are not the same';
        reset_password_form();
        return
    }

    var jsonString = JSON.stringify(User); //all the User infos
    console.log(jsonString)


    // Fetch, POST, UrL/Card, headers : Application/json

    const element = jsonString; //what we want to post
    const requestOptions = {
        method: 'POST',
        mode: 'no-cors',
        headers: { 'Content-Type': 'application/json' },
        body: jsonString
    };

    // TODO change the URL to the User DB
    fetch(target_url, requestOptions)
        .then(response => response.text())
            //.then(response=> response_processing(response))
            .then (response => response_processing(response))
            .catch(error => err_callback(error));


    function response_processing(response){
        console.log(response.body)
        console.log(typeof(response))
        if (response == "true"){
            sessionStorage.setItem('login', User.login);
            window.location.replace("menu.html");
        } else{
            document.getElementById("validation").innerHTML = "Le nom d'utilisateur existe deja.";
            console.log("/!\\ surname or pw incorrect")
        }
    }

    function err_callback(error){
        console.log(error);
    }

    function reset_password_form(){
        var password = document.getElementById("Password").value="";
        var Repassword = document.getElementById("Re-Password").value="";
    }

}