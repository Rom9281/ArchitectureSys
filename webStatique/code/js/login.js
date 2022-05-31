function Connect(){
    console.log("OK");

    const target_url = "http://127.0.0.2:8081/login"
    // check if user/pw pair exists and opens main menu page if so 

    const form = document.getElementById('connectionForm')

    var User = new Object();
    User.name = "";
    User.first_name = "";
    User.email = "";
    User.imgUrl="";
    User.login = document.getElementById("Login").value; // modification de surname a login
    User.password = document.getElementById("Password").value;
    
    //Check if surname or pw is null
    if ((User.surname != "") &&
        (User.password != "")){
    } else{
        console.log("/!\\ surname and/or pw empty");
        reset_password_form();
        return
    }

    var jsonString = JSON.stringify(User); //all the User infos
    console.log(jsonString)

    const requestOptions = {
        //mode: 'no-cors',
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: jsonString
    };

    fetch(target_url, requestOptions)
        .then(response => response.text())
            //.then (response => callback(response))
            .then(response=> response_processing(response))
            .catch(error => err_callback(error));

    function response_processing(response){
        console.log(response.body)
        console.log(typeof(response))
        if (response == "true"){
            window.location.replace("../menu.html");
        } else{
            document.getElementById("content").innerHTML = "Indentifiants mauvais";
            console.log("/!\\ surname or pw incorrect")
        }
    }

    function callback(response){
        document.getElementById("validation").innerHTML = response.value;
    }

    function err_callback(error){
        console.log(error);
    }

    function reset_password_form(){
        var password = document.getElementById("Password").value="";
    }

}