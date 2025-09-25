const API_URL = "http://localhost:8080/api/filmes";

// FILMES
function listarFilmes(callback) {
    $.get(API_URL, callback);
}

function buscarFilme(id, callback) {
    $.get(`${API_URL}/${id}`, callback);
}

function criarFilme(filme, callback) {
    $.ajax({
        url: API_URL,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(filme),
        success: callback
    });
}

function atualizarFilme(id, filme, callback) {
    $.ajax({
        url: `${API_URL}/${id}`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(filme),
        success: callback
    });
}

function deletarFilme(id, callback) {
    $.ajax({
        url: `${API_URL}/${id}`,
        type: "DELETE",
        success: callback
    });
}

// ANÁLISES
function listarAnalises(idFilme, callback) {
    $.get(`${API_URL}/${idFilme}/analises`, callback);
}

function adicionarAnalise(idFilme, analise, callback) {
    $.ajax({
        url: `${API_URL}/${idFilme}/analises`,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(analise),
        success: callback
    });
}

function deletarAnalise(idFilme, idAnalise, callback) {
    $.ajax({
        url: `${API_URL}/${idFilme}/analises/${idAnalise}`,
        type: "DELETE",
        success: callback
    });
}

