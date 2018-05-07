package com.paulo.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paulo.cobranca.enums.StatusTitulo;
import com.paulo.cobranca.model.Titulo;
import com.paulo.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("CadastroDeTitulo");
		mv.addObject("todosStatusTitulo", StatusTitulo.values());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {

		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("CadastroDeTitulo");
		mv.addObject("mensagem", "Título salvo com sucesso");
		
		return mv;
	}
	
	@ModelAttribute ("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
