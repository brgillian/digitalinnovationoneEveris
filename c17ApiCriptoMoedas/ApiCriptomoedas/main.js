/*
    REQUISITOS:
    - Ter uma conta no site: https://coinmarketcap.com/api/
    - Extensão para chrome:  Moesif Origin & e Cors
*/

// MY API KEY
var myapikey = {
    key: 'XXXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXX' //Chave privada. Insira a sua para testar.
}

//GET FETCH REQUISITION
fetch('https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?CMC_PRO_API_KEY=XXXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXX')
.then((response) => {
    if(!response.ok) throw new Error('Erro ao executar a requisição, status ' + response.status);
        return response.json();
})
.then((api) => {
    var texto = "";
    //Get 10 coins and symbols
    for(let i = 0; i < 10; i++){
        //Show API INFO
        texto = texto + `
        <div class = "media">
            <img src="coin.jpg" class="align-self-center mr-3" alt="coin" width="100" height="60">
            <div class="media-body">
                <h5 class="mt-2">${api.data[i].name}</h5>
                <p>${api.data[i].symbol}</p>
            </div>
        </div>`
        document.getElementById("coins").innerHTML = texto;
    }
})
.catch((error) => {
    console.log(error.message);
});