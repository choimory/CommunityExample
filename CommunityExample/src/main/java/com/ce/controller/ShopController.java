package com.ce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopVoteArticleDTO;
import com.ce.dto.ShopVoteCommentDTO;
import com.ce.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ShopService shopService;
	private final int SUCCESS=1;
	private final int FAIL=-1;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping(value = { "", "/", "/main" })
	public String main(Model model) {
		String view = "Shop/main";
		Map<String, List<ShopDTO>> shopDtoListMap = null;

//		shopDtoListMap=shopService.main();
//		if(shopDtoListMap==null) {	
//		}

		model.addAttribute("title", "상점");
		model.addAttribute("shopDtoListMap", shopDtoListMap);
		return view;
	}

	@RequestMapping(value = {"/list","/icon"})
	public String list(Model model, ShopDTO shopDto, PageHelper pageHelper) {
		String view = "Shop/list";
		List<ShopDTO> shopDtoList = null;

//		shopDtoList=shopService.list(shopDto, pageHelper);
//		if(shopDtoList==null) {	
//		}

		model.addAttribute("title", "");
		model.addAttribute("shopDtoList", shopDtoList);
		return view;
	}

	@RequestMapping(value = "/{sIdx}")
	public String content(Model model, @PathVariable("sIdx")String stringShopIdx, PageHelper pageHelper) {
		String view = "Shop/content";
		Map<String, Object> contentMap = null;

//		contentMap=shopService.content(stringShopIdx, pageHelper);
//		if(contentMap==null) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("contentMap", contentMap);
		return view;
	}

	@RequestMapping(value = "/{sIdx}/comment", method = RequestMethod.POST)
	public String comment(Model model, ShopCommentDTO shopCommentDto, PageHelper pageHelper) {
		String view = ""; // TODO ajax
		List<ShopCommentDTO> shopCommentDtoList = null;

//		shopCommentDtoList=shopService.comment(shopCommentDto, pageHelper);
//		if(shopCommentDtoList==null) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("shopCommentDtoList", shopCommentDtoList);
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = "Shop/write";

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, ShopDTO shopDto) {
		String view = "redirect:/shop/"+shopDto.getsIdx();
		int result = 0;

//		result=shopService.write(shopDto);
//		if(result==FAIL) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm(Model model, int sIdx) {
		String view = "Shop/modify";
		ShopDTO shopDto = null;

//		shopDto=shopService.modifyForm(sIdx);
//		if(shopDto==null) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("shopDto", shopDto);
		return view;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Model model, ShopDTO shopDto) {
		String view = "";
		int result = 0;

//		result=shopService.modify(shopDto);		
//		if(result==FAIL) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, int sIdx) {
		String view = ""; // TODO 리다이렉트
		int result = 0;

//		result=shopService.delete(sIdx);
//		if(result==FAIL) {			
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/writeComment", method = RequestMethod.POST)
	public String writeComment(Model model, ShopCommentDTO shopCommentDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.writeComment(shopCommentDto);
//		if(result==FAIL) {
//			
//		}

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	public String deleteComment(Model model, int scIdx) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.deleteComment(scIdx);
//		if(result==FAIL) {
//		
//	}
		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
	public String modifyComment(Model model, ShopCommentDTO shopCommentDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.modifyComment(shopCommentDto);
//		if(result==FAIL) {
//		
//	}
	
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/replyComment", method = RequestMethod.POST)
	public String replyComment(Model model, ShopCommentDTO shopCommentDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.replyComment(shopCommentDto);
//		if(result==FAIL) {
//		
//	}
	
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/search")
	public String search(Model model, PageHelper pageHelper, SearchHelper searchHelper) {
		String view = "";
		List<ShopDTO> shopDtoList = null;

//		shopDtoList=shopService.search(pageHelper, searchHelper);
//		if(shopDtoList==null) {
//			
//		}
		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public String purchaseForm(Model model, String mId) {
		String view = "";

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String purchase(Model model) {
		String view = "";

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		String view = "Shop/cart";

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/addcart")
	public String addCart(Model model) {
		String view = "";

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/report")
	public String report(Model model, ShopDTO shopDto) {
		String view = ""; // TODO ajax
		int result = 0;

		result = shopService.report(shopDto);
		if(result==FAIL) {
		}

		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpContent")
	public String thumbsUpContent(Model model, ShopVoteArticleDTO shopVoteArticleDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.thumbsUpContent(shopVoteArticleDto);
//		if(result==FAIL) {
//			
//		}
//		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownContent")
	public String thumbsDownContent(Model model, ShopVoteArticleDTO shopVoteArticleDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.thumbsDownContent(shopVoteArticleDto);
//		if(result==FAIL) {
//		
//	}
//	
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpComment")
	public String thumbsUpComment(Model model, ShopVoteCommentDTO shopVoteCommentDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.thumbsUpComment(shopVoteCommentDto);
//		if(result==FAIL) {
//		
//	}
//	
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownComment")
	public String thumbsDownComment(Model model, ShopVoteCommentDTO shopVoteCommentDto) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=shopService.thumbsDownComment(shopVoteCommentDto);
//		if(result==FAIL) {
//		
//	}
//	
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/wishlist")
	public String wishList(Model model) {
		String view = ""; // TODO ajax

		model.addAttribute("title", "");
		return view;
	}
}
