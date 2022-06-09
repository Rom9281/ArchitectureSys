//URLs

let user = new Object();
let get_user_url = "http://localhost:8082/user/";
let get_cards_url = "http://localhost:8083/card/market";
let buy_card_url = "http://localhost:8084/market/buy/";

function getUser(){

    // console.log('getting user info...');
    let requestOptions = {
        method: 'GET',
        mode: 'no-cors'
    }

    fetch(get_user_url+"/"+user.login, requestOptions)
        .then(response => response.json())
        .then (response => callback(response))
        .catch(error => err_callback(error));

    function callback(response){
        console.log(response)
        user.login = localStorage.getItem("login");
        user.money = response.money;
        user.id =response.id;
        display(user);
    }

    function err_callback(error){
        console.log(error);
    }
}

function display(user){
    let clone = document.importNode(template.content, true);

    newContent= clone.firstElementChild.innerHTML
                .replace(/{{userNameId}}/g, user.login)
                .replace(/{{userMoney}}/g, user.money)

    clone.firstElementChild.innerHTML= newContent;
    clone.firstElementChild.addEventListener("click", () => update_user(user));
}

function update_user(user){
//  console.log("updating user".concat(' ', user.login));
    let userNameId = document.querySelector("#userNameId");
    userNameId.textContent = user.login;
    let userMoney = document.querySelector("#userMoney");
    userMoney.textContent = user.money;
}

    
    function create_card_object(response, id){
        var card = new Object();
        card.id = response[id].id //doesn't work properly ?
        card.family_src = "";
        card.family_name = response[id].family
        card.name = response[id].name;
        card.description = response[id].description;
        card.imgUrl = response[id].imgUrl; //"https://media.giphy.com/media/6nWT5GyxsmAoM/giphy.gif"
        card.hp = response[id].hp
        card.energy = response[id].energy
        card.attack = response[id].attack
        card.defence = response[id].defence
    
        cardList.push(card);
        display(card);
    }
    
    let template = document.querySelector("#row");
    
    for(const card of cardList){
        display(card);
    }
    
    function display(card){
        let clone = document.importNode(template.content, true);
    
        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{family_src}}/g, card.family_src)
                    .replace(/{{family_name}}/g, card.family_name)
                    .replace(/{{img_src}}/g, card.img_src)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defence}}/g, card.defence)
                    .replace(/{{price}}/g, card.price);
        clone.firstElementChild.innerHTML= newContent;
        clone.firstElementChild.addEventListener("click", () => update_card(card));
    
        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
    
    function update_card(card){
        console.log("updating card".concat(' ', card.name));
        current_card_id = card.id

        let HP = document.querySelector("#HPId");
        HP.textContent = card.hp;
        let family_name= document.querySelector("#cardFamilyName");
        family_name.textContent = card.family_name;
        let energy = document.querySelector("#energyId");
        energy.textContent = card.energy;
        let name = document.querySelector("#cardName");
        name.textContent = card.name;
        let image = document.querySelector("#cardImgId");
        image.src = card.img_src;
        let description = document.querySelector("#cardDescriptionId");
        description.textContent = card.description;
        let attack = document.querySelector("#cardAttackId");
        attack.textContent = card.attack;
        let defence = document.querySelector("#cardDefenceId");
        defence.textContent = card.defence;
        let card_energy = document.querySelector("#cardEnergyId");
        card_energy.textContent = card.energy;
        let card_HP = document.querySelector("#cardHPId");
        card_HP.textContent = card.hp;
        let card_price = document.querySelector("#cardPriceId");
        card_price.textContent = card.price;
    }
    
    function generate(){
            let requestOptions =   {
                method: 'GET',
                //mode:'no-cors'
            };
            
        fetch(get_cards_url, requestOptions)
            .then(response => response.json())
            .then(response => callback(response))
            .catch(error => err_callback(error));
    }
    
    function callback(response){
         console.log(response);
        // console.log("ajout cartes serveur")
        for (const i in response){
            create_card_object(response, i);
        }
        console.log(cardList);
    }
    
    function err_callback(error){
        console.log(error);
    }
    
    generate();
}

function BuyCard(){
    // console.log("buying card: ".concat(current_card_id));
    let requestOptions = {
        method: 'GET',
        //mode:'no-cors'
    };
    
    fetch(buy_card_url.concat(user.id, "/", current_card_id), requestOptions)
        .catch(error => err_callback(error));

    function err_callback(error){
        console.log(error);
    }
}

getUser();
getCardlist();