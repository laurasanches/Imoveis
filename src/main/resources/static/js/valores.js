function validarFormulario() {
  var valorLocacaoInput = document.getElementById("valorLocacao");
  var valorVendaInput = document.getElementById("valorVenda");

  // Verificar se o campo de locação está habilitado e validar se necessário
  if (!valorLocacaoInput.disabled) {
    if (valorLocacaoInput.value === "") {
      alert("O campo de locação deve ser preenchido.");
      return false;
    }
  }

  // Verificar se o campo de venda está habilitado e validar se necessário
  if (!valorVendaInput.disabled) {
    if (valorVendaInput.value === "") {
      alert("O campo de venda deve ser preenchido.");
      return false;
    }
  }

  // Restante do código de validação...

  // Se todas as validações passaram, retorna true para enviar o formulário
  return true;
}

function habilitarCampos() {
  var tipoImovel = document.getElementById("tipo").value;
  var valorLocacaoInput = document.getElementById("valorLocacao");
  var valorVendaInput = document.getElementById("valorVenda");

  if (tipoImovel === "LOCACAO") {
    valorVendaInput.disabled = true;
    valorLocacaoInput.disabled = false;
    valorVendaInput.value = "";
  } else if (tipoImovel === "VENDA") {
    valorLocacaoInput.disabled = true;
    valorVendaInput.disabled = false;
    valorLocacaoInput.value = "";
  } else {
    valorLocacaoInput.disabled = false;
    valorVendaInput.disabled = false;
  }
}


