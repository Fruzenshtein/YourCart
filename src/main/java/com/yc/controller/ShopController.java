package com.yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yc.dto.ShopDTO;
import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;
import com.yc.model.ShopDetails;
import com.yc.service.ShopDetailsService;
import com.yc.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopDetailsService shopDetailsService;
	
	@RequestMapping(value="/shop/add", method=RequestMethod.GET)
	public ModelAndView newShopPage() {
		ModelAndView mav = new ModelAndView("shop/new-shop");
		mav.addObject("shopDTO", new ShopDTO());
		return mav;
	}
	
	@RequestMapping(value="/shop/add", method=RequestMethod.POST)
	public ModelAndView addShop(@ModelAttribute ShopDTO shopDTO,
			final RedirectAttributes redirectAttributes) throws ShopNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:add.html");
		
		Shop shop = new Shop();
		shop.setName(shopDTO.getName());
		
		ShopDetails details = new ShopDetails();
		details.setCategory(shopDTO.getCategory());
		details.setType(shopDTO.getType());

		Shop newShop = shopService.save(shop);
		
		ShopDetails detailsToUpdate = newShop.getShopDetails();
		detailsToUpdate.update(details);
		
		shopDetailsService.update(detailsToUpdate);
		
		redirectAttributes.addFlashAttribute("success_msg", "Магазин "+
		shopDTO.getName()+" успешно добавлен.");
		return mav;
	}

}
