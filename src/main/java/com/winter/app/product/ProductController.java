package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//객체는 직접 만들지 않음 Autowired
@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getlist(Model model) throws Exception {
		System.out.println("ProductController getList()");
		List<ProductDTO> ar = productService.getList();
		model.addAttribute("list", ar);
	}

	// detail.jsp로 보냄
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, int product_id) throws Exception {
		System.out.println("ProductController detail()");
		ProductDTO productDTO = productService.detail(product_id);
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
	public String add(ProductDTO productDTO, Model model) throws Exception {
		System.out.println("ProductController add()");
		int result = productService.add(productDTO);

		System.out.println(productDTO.getProduct_id());
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}
		return url;
	}

}
