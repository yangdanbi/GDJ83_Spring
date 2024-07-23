package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

//객체는 직접 만들지 않음 Autowired
@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET) // , Long page, String kind, String search
	public void getlist(Pager pager, Model model) throws Exception {
		System.out.println("ProductController getList()");
		// List<ProductDTO> ar = productService.getList(page);
		List<ProductDTO> ar = productService.getList(pager);
		// System.out.println("page: " + page);

		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
	}

	// detail.jsp로 보냄
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("ProductController detail()");
		productDTO = productService.getDetail(productDTO);
		String url = "";
		if (productDTO != null) {
			model.addAttribute("dto", productDTO);
			url = "product/list";
		} else {
			model.addAttribute("result", "없는 상품입니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model, MultipartFile[] files, HttpSession session) throws Exception {
		System.out.println("ProductController add()");
		int result = productService.add(productDTO, files, session);

		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ProductDTO productDTO, Model model) throws Exception {

		int result = productService.delete(productDTO);
		String url = "";
		if (result > 0) {

			url = "redirect:./list";
		} else {
			model.addAttribute("result", "삭제에 실패했습니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("ProductController update()");
		productDTO = productService.getDetail(productDTO);
		String url = "";
		if (productDTO != null) {
			model.addAttribute("dto", productDTO);
			url = "product/update";
		} else {
			model.addAttribute("result", "없는 상품입니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		return url;

	}

	// 오버로딩
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);

		return "redirect:list";

	}

}
