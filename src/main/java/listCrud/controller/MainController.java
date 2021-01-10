package listCrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import listCrud.dao.InsertDao;
import listCrud.model.Product;

@Controller
public class MainController {

	@Autowired
	private InsertDao id;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> allList = id.getList();
		
		m.addAttribute("allList", allList);
		return "index";
	}
	
	@RequestMapping("/add-list")
	public String addList(Model m)
	{
		m.addAttribute("title", "Add list");
		return "add_list";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public RedirectView handleInsert(@ModelAttribute Product product, HttpServletRequest req)
	{
		
		System.out.println(product);
		
		this.id.insertlist(product);
		RedirectView rv = new RedirectView();
		rv.setUrl(req.getContextPath()+"/");
		return rv;
	}
	
	@RequestMapping("/delete/{lid}")
	public RedirectView handleDelete(@PathVariable("lid") int lid,HttpServletRequest req)
	{
		this.id.deleteList(lid);
		RedirectView rv = new RedirectView();
		rv.setUrl(req.getContextPath()+"/");
		return rv;
	}

	@RequestMapping("/update/{lid}")
	public String handleUpdate(@PathVariable("lid") int id , Model m)
	{
		Product p = this.id.getSingleList(id);
		
		m.addAttribute("product", p);
	
		return "update_list";
	}
}
