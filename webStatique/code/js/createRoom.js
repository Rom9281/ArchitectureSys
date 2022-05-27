function CreateRoom(){
    // create a json from form

    const form = document.getElementById('createRoomForm')

    var Room = new Object();
    Room.name = document.getElementById("Name").value;
    Room.bet = document.getElementById("Bet").value;

    var jsonString = JSON.stringify(Room); //all the room infos
    console.log(jsonString)

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: jsonString
    };

    // TODO change the URL to the User DB
    fetch('insert URL here', requestOptions)
    .then(response => response.json())
        .then (response => callback(response))
        .then (response => response_processing(response))
        .catch(error => err_callback(error));

    function response_processing(response){
        if (response == true){
            window.location.replace("../playRoom.html");
        } else{
            console.log("/!\\ error")
        }
    }

    function callback(response){
        document.getElementById("content").innerHTML = response.value;
    }

    function err_callback(error){
        console.log(error);
    }

}