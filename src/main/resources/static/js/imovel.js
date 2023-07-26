$('#confirmacaoExclusaoModal').on(
		'show.bs.modal',
		function(event) {

			var button = $(event.relatedTarget);

			var codigoImovel = button.data('codigo');
			var enderecoImovel = button.data('endereco');

			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');
			if (!action.endsWith('/')) {
				action += '/';
			}
			form.attr('action', action + codigoImovel);
			console.log(action + enderecoImovel);	
			modal.find('.modal-body span').html(
					'Voce deseja realmente excluir o imóvel com o endereço: <br> <strong>'
							+ enderecoImovel + '</strong>?');

		});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal:',', thousands:'.', allowZero: true});

});

