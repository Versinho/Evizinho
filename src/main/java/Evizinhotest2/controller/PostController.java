package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Evizinhotest2.model.CondominoPost;
import Evizinhotest2.service.PostService;
import Evizinhotest2.strategy.Post;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	private static final String MSG_SUCESS_ADD = "Post Adicionado com Sucesso!";
	private static final String MSG_SUCESS_UPDATE = "Post Atualizado com Sucesso!";
	private static final String MSG_SUCESS_DELETE = "Excluído com sucesso!.";
	private static final String MSG_ERROR = "Error.";

	 @RequestMapping(value = "/posts")
	  public List<Post> getAllPosts(Model model) 
	  {		
		 List<Post> posts = postService.getAllPosts();
		 model.addAttribute("posts", posts);
		 return posts;
	  }	
	 
	 
	 @RequestMapping(value = "/posts/{id}")
	 public Optional<Post> getPost(@PathVariable Integer id) {
	 	return postService.getPost(id);
	 }
	 
	 @RequestMapping(value = "/posts/form", method=RequestMethod.GET)
	 public String addPost(Model model, RedirectAttributes redirectAttributes) {
		try {
			Post post = new CondominoPost();
			model.addAttribute("post", post);
		}
		catch (Exception e) {
			System.out.println("Exception:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
	 	return "addPost";
	 }

	@RequestMapping(value = "/posts/register", method=RequestMethod.POST)
	public String addPost(CondominoPost post, RedirectAttributes redirectAttributes) {
		try {
			postService.addPost(post);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_ADD);
		} catch (Exception e) {
			System.out.println("Exception:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/posts";
	}
	 
	 /*@RequestMapping(value="/posts/form", method=RequestMethod.GET)
	 public String cadastro() {
		 return "addPost";
		 
	 }
	 @RequestMapping(value="/salvarpost", method=RequestMethod.POST)
	 public String addPost(Post post) {
		 postService.addPost(post);
		 return "home";
	 }*/
	 

	 @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	 public void updatePost(@RequestBody Post post,@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				postService.updatePost(id, post);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}	 
	}
 
	 @RequestMapping(value = "/posts/{id}/delete")
	 public String deletePost(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				postService.deletePost(id);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/posts";
	 }

	@GetMapping("/posts/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Post post = postService.getPost(id).get();
				model.addAttribute("post", post);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}	
		return "showPost";
	}
	
	/*@PostMapping("/pesquisarpost")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) {
		ModelAndView modelAndView = new ModelAndView("/posts");
		modelAndView.addObject("posts", postService.getPostByTitle(nomepesquisa));
		modelAndView("postobj", );
		return modelAndView;
	}*/
	
	@RequestMapping(value="/posts/user/{id}")
	public String getPostersByUserId(Model model, @PathVariable Integer id){
		List<Post> posts = postService.getPostsByUser(id);
		model.addAttribute("posts", posts);
		return "postsByUser";
	}

}
