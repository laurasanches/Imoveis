package com.moldsystems.imoveis.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moldsystems.imoveis.filter.ImovelFilter;
import com.moldsystems.imoveis.model.CategoriaImovel;
import com.moldsystems.imoveis.model.Imovel;
import com.moldsystems.imoveis.model.TipoImovel;
import com.moldsystems.imoveis.model.UFImovel;
import com.moldsystems.imoveis.service.CadastroImovelService;


@Controller
@RequestMapping("/imoveis")
public class ImovelController {
	
	private final String CADASTRO_VIEW = "CadastroImovel";
	
	@Autowired
	private CadastroImovelService cadastroImovelService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Imovel());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private String salvar(@Validated Imovel imovel, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}else {
			try {
				cadastroImovelService.save(imovel);
				attributes.addFlashAttribute("mensagem", "Imóvel salvo com sucesso!");
				return "redirect:/imoveis/novo";
			} catch (IllegalArgumentException e) {
				return CADASTRO_VIEW;
			}
		}

	}
	
	@RequestMapping
	private ModelAndView pesquisar(@ModelAttribute("filtro") ImovelFilter filtro) {
		List<Imovel> todosImoveis = cadastroImovelService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaImoveis");
		mv.addObject("imoveis", todosImoveis);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Imovel imovel) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(imovel);
		return mv;
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long codigo, RedirectAttributes attributes) {
		cadastroImovelService.delete(codigo);
		
		attributes.addFlashAttribute("mensagem", "Imóvel excluído com sucesso!");
		return "redirect:/imoveis";
	}
	
    @GetMapping("/verificar-endereco")
    @ResponseBody
    public Map<String, Boolean> verificarEnderecoExistente(@RequestParam String endereco,
                                                           @RequestParam String numero,
                                                           @RequestParam UFImovel uf,
                                                           @RequestParam String bairro,
                                                           @RequestParam String cep,
                                                           @RequestParam String cidade){
        boolean existeEndereco = cadastroImovelService.verificarEnderecoExistente(endereco, numero, uf, bairro, cep, cidade);
        Map<String, Boolean> response = new HashMap<>();
        response.put("existeEndereco", existeEndereco);
        return response;
    }
	
	
	@ModelAttribute("todosEstadosImoveis")
	public List<UFImovel> todosEstadosImoveis(){
		return Arrays.asList(UFImovel.values());
	}
	
	@ModelAttribute("todasCategoriasImoveis")
	public List<CategoriaImovel> todasCategoriasImoveis(){
		return Arrays.asList(CategoriaImovel.values());
	}
	@ModelAttribute("todosTiposImoveis")
	public List<TipoImovel> todosTiposImoveis(){
		return Arrays.asList(TipoImovel.values());
	}
}
