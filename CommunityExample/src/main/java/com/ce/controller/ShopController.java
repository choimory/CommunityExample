package com.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	private ShopService shopService;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping(value = { "", "/", "/main" })
	public String main(Model model) {
		String view = null;

		// TODO 아이콘과 프로필의 글들 최신순으로 몇개 가져오기

		view = "Shop/main";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/icon")
	public String iconList(Model model) {
		String view = null;

		// TODO 아이콘의 글들을 page를 이용해 가져오기

		view = "Shop/list";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{shop_index}")
	public String content(Model model, @PathVariable("shop_index") int sIndex) {
		String view = null;

		// TODO 해당 idx의 정보와 댓글들 가져오기

		view = "Shop/content";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{shop_index}/comment", method = RequestMethod.POST)
	public String commentList(Model model, @PathVariable("shop_index") int sIndex) {
		String view;

		// TODO 해당 상점글의 댓글창의 페이지네이션을 이용했을때 해당 page의 댓글목록 가져오기

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = null;

		view = "Shop/write";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model) {
		String view = null;

		// TODO 상점테이블에 row 등록

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm(Model model) {
		String view = null;

		view = "Shop/modify";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Model model) {
		String view = null;

		// TODO row 수정

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model) {
		String view = null;

		// TODO row 삭제

		view = ""; // TODO 리다이렉트
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/writeComment", method = RequestMethod.POST)
	public String writeComment(Model model) {
		String view = null;

		// TODO sIndex와 연관짓는 댓글 row 등록

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	public String deleteComment(Model model) {
		String view = null;

		// TODO 해당 row 삭제

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
	public String modifyComment(Model model) {
		String view = null;

		// TODO 해당 row의 컬럼값 수정

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/replyComment", method = RequestMethod.POST)
	public String replyComment(Model model) {
		String view = null;

		// TODO 해당댓글과 연관되는 댓글row 입력

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/search")
	public String search(Model model) {
		String view = null;

		// TODO query와 target 그리고 page를 이용해서 검색한 결과 가져오기

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public String purchaseForm(Model model) {
		String view = null;

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String purchase(Model model) {
		String view = null;

		// TODO 구매테이블에 row입력, 회원정보 중 금액감소, 장바구니 테이블에서 해당아이템 row 제거

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		String view = null;

		view = "Shop/cart";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/addcart")
	public String addCart(Model model) {
		String view = null;

		// TODO cart테이블에 추가

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/report")
	public String report(Model model) {
		String view = null;

		// TODO 해당글 report갯수 추가, 본인의 해당글 report 정보 등록

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpContent")
	public String thumbsUpContent(Model model) {
		String view = null;

		// TODO 해당글 추천수증가, 해당글 추천정보 등록

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownContent")
	public String thumbsDownContent(Model model) {
		String view = null;

		// TODO 해당글 추천수감소, 해당글 추천정보 삭제

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpComment")
	public String thumbsUpComment(Model model) {
		String view = null;

		// TODO 해당댓글 추천수증가, 해당댓글 추천정보 등록

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownComment")
	public String thumbsDownComment(Model model) {
		String view = null;

		// TODO 해당댓글 추천수감소, 해당댓글 추천정보 감소

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/bookmark")
	public String bookmark(Model model) {
		String view = null;

		// TODO 해당아이템 북마크 등록유무 검색후 없으면 등록 있으면 삭제

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}
}
