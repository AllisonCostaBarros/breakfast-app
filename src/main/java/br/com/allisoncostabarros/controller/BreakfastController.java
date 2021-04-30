package br.com.allisoncostabarros.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.allisoncostabarros.model.Breakfast;
import br.com.allisoncostabarros.repository.BreakfastRepository;

@Controller
public class BreakfastController {

	@Autowired
	private BreakfastRepository br;

	@RequestMapping(value = "/cadastrarBreakfast", method = RequestMethod.GET)
	public String form() {
		return "breakfast/formBreakfast";
	}

	@RequestMapping("/deletarBreakfast")
	public String deletarBreakfast(long id) {
		Breakfast breakfast = br.findById(id);
		br.delete(breakfast);
		return "redirect:/breakfasts";
	}

	@RequestMapping("/{id}")
	public ModelAndView alterarBreakfast(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("breakfast/alterarBreakfast");
		Breakfast breakfast = br.findById(id);
		mv.addObject("breakfast", breakfast);
		return mv;
	}

	@RequestMapping(value = "/cadastrarBreakfast", method = RequestMethod.POST)
	public String form(@Valid Breakfast breakfast, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarBreakfast";
		}

		br.save(breakfast);
		attributes.addFlashAttribute("mensagem", "Café da manhã cadastrado com sucesso!");
		return "redirect:/cadastrarBreakfast";
	}

	@RequestMapping("/breakfasts")
	public ModelAndView listaBreakfasts() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Breakfast> breakfasts = br.findAll();
		mv.addObject("breakfasts", breakfasts);
		return mv;
	}

}
