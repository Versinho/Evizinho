package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Evizinhotest2.model.UniversidadePost;
import Evizinhotest2.service.UniversidadePostService;

@Controller
public class PostController {
	@Autowired
	private UniversidadePostService postService;

	private static final String MSG_SUCESS_ADD = "Post Adicionado com Sucesso!";
	private static final String MSG_SUCESS_UPDATE = "Post Atualizado com Sucesso!";
	private static final String MSG_SUCESS_DELETE = "Excluído com sucesso!.";
	private static final String MSG_ERROR = "Error.";

	@RequestMapping(value = "/posts")
	public List<UniversidadePost> getAllPosts(Model model)
	{
		List<UniversidadePost> posts = postService.getAllPosts();
		model.addAttribute("posts", posts);
		return posts;
	}


	@RequestMapping(value = "/posts/{id}")
	public Optional<UniversidadePost> getPost(@PathVariable Integer id) {
		return postService.getPost(id);
	}

	@RequestMapping(value = "/posts/form", method=RequestMethod.GET)
	public String addPost(Model model, RedirectAttributes redirectAttributes) {
		try {
			UniversidadePost post = new UniversidadePost();
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
	public String addPost(UniversidadePost post, RedirectAttributes redirectAttributes) {
		try {
			postService.addPost(post);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_ADD);
		} catch (Exception e) {
			System.out.println("Erro na inserção de um post");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/{id}/edit", method = RequestMethod.GET)
	public String updatePost(Model model,@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				//postService.updatePost(id, post);
				//redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
				Optional<UniversidadePost> post = postService.getPost(id);
				model.addAttribute("post", post);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "updatePost";
	}

	@RequestMapping(value = "/posts/update", method=RequestMethod.POST)
	public String updatePost(UniversidadePost post, RedirectAttributes redirectAttributes) {
		try {
			postService.addPost(post);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_ADD);
		} catch (Exception e) {
			System.out.println("Erro na inserção de um post");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "redirect:/posts";
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
				UniversidadePost post = postService.getPost(id).get();
				model.addAttribute("post", post);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "showPost";
	}


	@RequestMapping(value="/posts/user/{id}")
	public String getPostersByUserId(Model model, @PathVariable Integer id){
		List<UniversidadePost> posts = postService.getPostsByUser(id);
		model.addAttribute("posts", posts);
		return "postsByUser";
	}

	@RequestMapping(value="/posts/{category}/{subCategory}")
	public String getPostersByFilter(Model model, @PathVariable String category, @PathVariable String subCategory){
		List<UniversidadePost> posts = postService.filter(category, subCategory);
		model.addAttribute("posts", posts);
		return "postsByPlataform";
	}

}