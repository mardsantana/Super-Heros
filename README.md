Esta Aplicação tem como objetivo, a criação de Heróis e seus Poderes. Os Poderes serão relacionados aos heróis! 
Os Heróis devem ser Criados, Obtidos, Atualizados e Deletados. Os Verbos HTTP são: Post, Get, Put e Delete.

CRIAÇÃO DE HERÓIS:

URL: http://localhost:8080/super-heros/api/heros -> Esta URL cria um herói 
JSON: {
    "name":"Batman",
    "powerOfTheHeros":"Rico"
}
URL: http://localhost:8080/super-heros/api/heros/{idHeros} -> Esta URL busca um Herói pelo ID.
JSON: {
    "idHeros": "509e9404-aaff-45c0-97c6-41d1795745e9",
    "name": "Batman",
    "powerOfTheHeros": "Rico",
    "hourOfRegister": "2024-02-28T21:27:03.4001411",
    "powers": []
}
Error:
URL: http://localhost:8080/super-heros/api/heros -> Esta URL busca todos os Heróis.
JSON:  {
        "idHeros": "509e9404-aaff-45c0-97c6-41d1795745e9",
        "name": "Batman",
        "powerOfTheHeros": "Rico",
        "hourOfRegister": "2024-02-28T21:28:34.7905077"
    }
Error: 
URL: http://localhost:8080/super-heros/api/heros/{idHeros} -> Esta URL deleta o Herói pelo ID
JSON: Ele retornará um StatusHttp: 204 No Content.

URL: http://localhost:8080/super-heros/api/heros/a105ab13-c4fa-47c7-a2a0-d61e7112652b -> Esta URL irá Atualizar o Herói.
JSON: {
    "name":"Yin Yun",
    "powerOfTheHeros":"Teletransporte"
}
OBS: Json usado para atualizar. Sendo assim, quando for atualizado o StatusHttp, retornará o Status: 204 No Content.

CRIAÇÃO DE PODERES:__________________________________________________________________________________________________________

URL: http://localhost:8080/super-heros/api/heros/{idHeros}/power -> Esta URL será para criar o Poder, ele só será criado se o ID do Herói for passado.
Do contrário o Poder não será criado e retornará um Status Code 400 Bad Request.
JSON: {
    "descriptionOfPower":"Ele é rico, bonito, inteligente e tem equipamentos legais",
    "weakness":"Mortal"
}

URL: http://localhost:8080/super-heros/api/heros/{idHeros}/power/{idPower} -> Esta URL Busca o Poder pelo ID do poder, mas só irá funcionar caso o ID do Heróia esteja presente na URL.
JSON:{
    "idPower": "506a7f2a-efc7-4ba9-ab14-7ab3a50a85f2",
    "idHeros": "509e9404-aaff-45c0-97c6-41d1795745e9",
    "descriptionOfPower": "Ele é rico, bonito, inteligente e tem equipamentos legais",
    "weakness": "Mortal",
    "hourOfRegister": "2024-02-28T21:47:34.9618265",
    "powerPercentages": {
        "Weakness": 9.523809523809524,
        "Power": 90.47619047619048
    }
}

URL: http://localhost:8080/super-heros/api/heros/{idHeros}/power/{idPower} -> Esta URL deleta o Poder pelo ID. Ele só funcionará caso o ID do Herói esteja Presente na URL.
JSON: Ele retornará um StatusHttp: 204 No Content.

URL: http://localhost:8080/super-heros/api/heros/{idHeros}/power/{idPower} -> Esta URL Atualiza o poder pelo ID. Mas ele só funcionará caso o ID do Herói estiver presente na URL.
JSON: {
    "descriptionOfPower":"Ele pode se Teletransporte para qualquer lugar do Mundo onde ele já esteve!",
    "weakness":"Ele mora na Coreia do Norte"
}

OBS: O resultado final, com o relacionamento entre o Herói e o Poder, retornará o Seguinte JSON.
JSON:"idHeros": "509e9404-aaff-45c0-97c6-41d1795745e9",
    "name": "Batman",
    "powerOfTheHeros": "Rico",
    "hourOfRegister": "2024-02-28T21:53:27.2480943",
    "powers": "idHeros": "509e9404-aaff-45c0-97c6-41d1795745e9",
    "name": "Batman",
    "powerOfTheHeros": "Rico",
    "hourOfRegister": "2024-02-28T21:53:27.2480943",
    "powers": [
        {
            "descriptionOfPower": "Ele é rico, bonito, inteligente e tem equipamentos legais",
            "weakness": "Mortal",
            "hourOfRegister": "2024-02-28T21:53:27.2480943",
            "powerPercentages": {
                "Weakness": 9.523809523809524,
                "Power": 90.47619047619048
            }
        }
    ]



    









