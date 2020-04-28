package com.uca.capas.controller;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	private List<Student> lista = new ArrayList<Student>();
	

	@GetMapping(path = "/ejemplo", produces= MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() 
	{
		return "Bienvenidos\n"+"Programación N-Capas";
	}
	
	@GetMapping("/ejemplo2")
	@ResponseBody
	public List<Student> ejemplo2()
	{
		return Arrays.asList(
					new Student("Guillermo", "Morales","10/10/2017","Sistemas",true), 
					new Student("Javier", "Cornejo","10/10/2017","Industrial",true)
				);
	}
	
	@GetMapping("/inicio")
	public String inicio(Student student)
	{
		return "index";
	}
	
	@PostMapping("/parametros1")/*porque en el form pusimos post*/
	public ModelAndView procesar(Student student)/*student es el objeto que enviamos en th:object="${student}"*/
	{
		
		lista.add(student);/*student es el estudiante del formulario*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("student", new Student());/* Si no le pongo a mi model and view un nuevo estudiante
		cuando me devuelva al index mi formulario va a estar con la informacion que le habia pasado antes*/
		return mav;
		
	}
	
	@GetMapping("/listado")
	public ModelAndView listado()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", lista);
		return mav;
	}
	
	
}
