function SendUser(){
    // create a json from form

    const form = document.getElementById('addUserForm')

    var User = new Object();
    User.name = document.getElementById("Name").value;
    User.surname = document.getElementById("Surname").value;
    User.password = document.getElementById("Password").value;
    User.repassword = document.getElementById("Re-Password").value;
    
    //Check if the two passwords are the same
    if ((User.password.normalize() === User.repassword.normalize())
        && !(User.password === "")){
        console.log("mdp et re-mdp semblables");
    } else{
        console.log("/!\\ mdp et re-mdp différents ou vides");
        reset_password_form();
        return
    }

    var jsonString = JSON.stringify(User); //all the User infos
    console.log(jsonString)


    // Fetch, POST, UrL/Card, headers : Application/json

    const element = jsonString; //what we want to post
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: jsonString
    };

    // TODO change the URL to the User DB
    fetch('', requestOptions)
        .then(response => response.json())
            .then (response => callback(response))
            .catch(error => err_callback(error));

    function callback(response){
        document.getElementById("content").innerHTML = response.value;
    }

    function err_callback(error){
        console.log(error);
    }

    function reset_password_form(){
        var password = document.getElementById("Password").value="";
        var Repassword = document.getElementById("Re-Password").value="";
    }

}