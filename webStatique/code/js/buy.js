//URLs

const current_user_id = 0;//TODO get the real current user
const get_user_url = "http://localhost:8082/user/";
const get_cards_url = "http://localhost:8083/card/market";
const buy_card_url = "http://localhost:8084/market/buy/";

function getUser(){

    console.log('getting user info...');
    let requestOptions = {
        method: 'GET',
        mode: 'no-cors'
    }

    fetch(get_user_url.concat(current_user_id), requestOptions)
        .then(response => response.json())
        .then (response => callback(response))
        .catch(error => err_callback(error));

    function callback(response){
        create_user_object(response);
    }

    function err_callback(error){
        console.log(error);
    }
}

function create_user_object(response){
    var user = new Object();
    user.login = response.login
    user.money = response.login

    display(user);
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
    console.log("updating user".concat(' ', user.login));
    
    let userNameId = document.querySelector("#userNameId");
    userNameId.textContent = user.login;
    let userMoney = document.querySelector("#userMoney");
    userMoney.textContent = user.money;
}

function getCardlist(){
    let cardList = [
        // {
        //     family_name:"DC Comic",
        //     img_src:"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif",
        //     name:"SUPERMAN",
        //     description: "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",
        //     hp: 500,
        //     energy:100,
        //     attack:50,
        //     defence: 50,
        //     price:200
        // }
    ];
    
    function create_card_object(response, id){
        var card = new Object();
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
                mode:'no-cors'
            };
            
        fetch(get_cards_url, requestOptions)
            .then(response => response.json())
            .then(response => callback(response))
            .catch(error => err_callback(error));
    }
    
    function callback(response){
        console.log(response);
        console.log("ajout cartes serveur")
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

//TODO: le paramètre card ne marche pas, il faut trouver un moyen de savoir quelle carte a été choisie
function BuyCard(card){
    console.log("buying card: ".concat(card.name))
    let requestOptions = {
        method: 'GET',
        mode:'no-cors'
    };
    
    fetch(buy_card_url.concat(current_user_id, "/", card.id), requestOptions)
        .catch(error => err_callback(error));

    function err_callback(error){
        console.log(error);
    }
}

getUser();
getCardlist();