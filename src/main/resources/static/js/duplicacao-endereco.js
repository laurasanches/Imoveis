function verificarEnderecoExistente() {
    var endereco = $("#endereco").val();
    var numero = $("#numero").val();
    var uf = $("#uf").val();
    var bairro = $("#bairro").val();
    var cep = $("#cep").val();
    var cidade = $("#cidade").val();

    $.ajax({
        type: "GET",
        url: "/imoveis/verificar-endereco",
        data: {
            endereco: endereco,
            numero: numero,
            uf: uf,
            bairro: bairro,
            cep: cep,
            cidade: cidade
        },
        success: function (response) {
            if (response.existeEndereco) {
                exibirMensagemDuplicacao("Endereço já cadastrado! Digite outro.");
                desabilitarBotaoSalvar();
            } else {
                ocultarMensagemDuplicacao();
                habilitarBotaoSalvar();
            }
        },
        error: function () {
            exibirMensagemDuplicacao("Erro ao verificar o endereço, continue preenchendo os campos.");
        }
    });
}

function exibirMensagemDuplicacao(mensagem) {
    $("#mensagem-duplicacao").text(mensagem);
    $("#mensagem-duplicacao").show();
}

function ocultarMensagemDuplicacao() {
    $("#mensagem-duplicacao").hide();
}

function desabilitarBotaoSalvar() {
    $("#btn-salvar").prop("disabled", true);
}

function habilitarBotaoSalvar() {
    $("#btn-salvar").prop("disabled", false);
}
