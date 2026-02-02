import { shows, capitais, estilos } from "./objetos.js";

// pegando o elemento id que receberá os cards
const proximosShows = document.querySelector("#proximosShows");

//percorrendo o objetos shows - para cada objeto será criado um card do BootStrap
shows.forEach((show) => {
    // criar o html para cada card
    proximosShows.innerHTML += `
    <div class="col-md-4 my-3">
        <div class="card text-center">
            <img src="${show.banner}" class="card-img-top" alt="${show.banda}">
            <div class="card-body">
                <h4 class="card-title my-3">${show.banda}</h4>
                <div class="d-flex justify-content-between">
                    <p>Data: ${show.data}</p>
                    <p>Local: ${show.local}</p>
                </div>
                <a href="#" class="btn btn-danger w-100">Comprar Ingressos</a>
            </div>
        </div>
    </div>
    `;
});
// Fim montagem cards

// Montando select de capitais
const localShow = document.querySelector("#localShow");
capitais.forEach((capital) => {
    localShow.innerHTML += `
        <option class="capital-show" value="${capital}">${capital}</option>`;
});

// Montando select para os estilos
const estiloMusical = document.querySelector('#estiloMusical');
estilos.forEach(estilo => {
    estiloMusical.innerHTML += `
            <option class="estilo-musical" value="${estilo}">${estilo}</option>
        `
});

// gravando os dados na tabela
// passar o formulário para o JS - verificar quando o Submit é disparado - cancelar o envio -
// executar a função que será desenvolvida
document.querySelector("#formShow").addEventListener('submit', function (e) {
    // cancelar o evento padrão - envio - submit
    e.preventDefault();

    // pegar o tbody que receberá as informações digitadas e devem ser exibidas na tabela
    const tbody = document.querySelector('tbody');

    // pegando os campos do formulário
    const campos = [
        document.querySelector("#nomeBanda"),
        document.querySelector("#dataShow"),
        document.querySelector("#localShow"),
        document.querySelector("#estiloMusical")
    ];

    // Criar uma tr para receber as colunas da tabela
    const tr = document.createElement('tr');

    //percorrer o array de campos e PARA CADA criar uma td e colocar nela o valor digitado
    // pelo usuário 
    campos.forEach(campo => {
        // criar uma td 
        const td = document.createElement('td');

        //passar o valor do campo para dentro do conteúdo de texto da td
        td.textContent = campo.value;

        if (campo.type === "date") {
            const [ano, mes, dia] = campo.value.split("-");
            const data = new Date(ano, mes - 1, dia); // mês começa do 0
            td.textContent = data.toLocaleDateString("pt-BR");
        }

        //colocar a td dentro da tr
        tr.append(td);
    })

    // inserindo a tr dentro do tbody
    tbody.append(tr);

    // limpar o formulário
    this.reset();

});