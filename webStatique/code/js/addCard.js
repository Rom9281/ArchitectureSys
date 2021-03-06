function SendCard(){

    const target_url = "http://127.0.0.1:8083/card/";
    // const target_url = 'https://asi2-backend-market.herokuapp.com/card'

    // create a json from form
    const form = document.getElementById('addCardForm')

    var Card = new Object();
    Card.name = form.elements[0].value; //it would be better to get the elements via another way (more secure)
    Card.description = form.elements[1].value;
    Card.imgUrl = form.elements[2].value;
    console.log(Card.imgUrl);
    Card.family = form.elements[3].value;
    Card.affinity = form.elements[4].value;
    Card.hp= form.elements[5].value;
    Card.energy = form.elements[6].value;
    Card.attack= form.elements[7].value;
    Card.defence= form.elements[8].value;
    Card.price = form.elements[9].value;

    var jsonString = JSON.stringify(Card); //all the card infos
    console.log(jsonString)


    // Fetch, POST, UrL/Card, headers : Application/json

    const element = jsonString; //what we want to post
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: jsonString
    };
    fetch(target_url, requestOptions)
        .then(response => response.json())
            .then (response => callback(response))
            .catch(error => err_callback(error));
        // .then(data => element.innerHTML = data.id );

    function callback(response){
        document.getElementById("content").innerHTML = response.value;
    }

    function err_callback(error){
        console.log(error);
    }

}

function updatePriceDisplay(val) {
    document.getElementById('priceDisplay').value=val.concat(' $');
  }