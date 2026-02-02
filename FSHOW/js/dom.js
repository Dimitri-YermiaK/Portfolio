// pegar os elementos da página
const getNomeBanda = document.getElementById("nomeBanda");
console.log(getNomeBanda);

// pegar o primeiro seletor que for compatível com o valor citado
const getFormShow = document.querySelector("#formShow");
console.log(getFormShow);

//pegando pelas classes CSS
const getTheadShows = document.getElementsByClassName("thead-shows");
console.log(getTheadShows);
console.log(getTheadShows[2]);
console.log(getTheadShows[2].textContent);

//QuerySelectorAll pega todas as ocorrências encontradas
const getTheadShows2 = document.querySelectorAll('.thead-shows');
console.log(getTheadShows2);

//pegando pela nome da tag
const getDiv1 = document.getElementsByTagName('div')
console.log(getDiv1);

const getDiv2 = document.querySelectorAll('div');
console.log(getDiv2);
