package com.yc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yc.dto.ShopDTO;
import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;
import com.yc.service.ShopDetailsService;
import com.yc.service.ShopService;

@Controller
@RequestMapping(value="/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopDetailsService shopDetailsService;
	
	@RequestMapping(value="/landing", method=RequestMethod.GET)
	public ModelAndView shopLandingPage() {
		return new ModelAndView("shop/shop-landing");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView newShopPage() {
		
		ModelAndView mav = new ModelAndView("shop/shop-create");
		mav.addObject("shopDTO", new ShopDTO());
		return mav;
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addShop(@ModelAttribute ShopDTO shopDTO,
			final RedirectAttributes redirectAttributes) throws ShopNotFoundException {
		
		ModelAndView mav = new ModelAndView("redirect:/shop/list/owner.html");

		shopService.save(shopDTO);
		redirectAttributes.addFlashAttribute("success_msg", "Магазин "+
		shopDTO.getName()+" успешно добавлен.");
		
		return mav;
	}
	
	@RequestMapping(value="/list/owner", method = RequestMethod.GET)
	public ModelAndView ownerShopsPage() {
		
		ModelAndView mav = new ModelAndView("shop/owner-shops");
		
		List<Shop> ownerShops = shopService.findOwnerShops();
		mav.addObject("ownerShops", ownerShops);
		
		return mav;
	}
	
	@RequestMapping(value="/edit/{shopId}", method = RequestMethod.GET)
	public ModelAndView editShopPage(@PathVariable int shopId) {
		
		ModelAndView mav = new ModelAndView("shop/shop-edit");
		
		Shop shop = shopService.get(shopId);
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.buildShopDTO(shop, shop.getShopDetails());
		
		mav.addObject("shopDTO", shopDTO);
		
		return mav;
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.PUT)
	public ModelAndView editShop(@ModelAttribute ShopDTO shopDTO,
			final RedirectAttributes redirectAttributes) throws ShopNotFoundException {
		
		ModelAndView mav = new ModelAndView("redirect:/shop/list/owner.html");
		shopService.update(shopDTO);
		redirectAttributes.addFlashAttribute("success_msg", "Магазин успешно обновлен");
		
		return mav;
	}
	
	@RequestMapping(value="/delete/{shopId}", method = RequestMethod.GET)
	public ModelAndView deleteShop(@PathVariable int shopId,
			final RedirectAttributes redirectAttributes) throws ShopNotFoundException {
		
		ModelAndView mav = new ModelAndView("redirect:/shop/list/owner.html");
		shopService.delete(shopId);
		redirectAttributes.addFlashAttribute("success_msg", "Магазин успешно удален");
		
		return mav;
	}

}
