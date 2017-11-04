package com.mayer.seckill.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mayer.seckill.dto.Exposer;
import com.mayer.seckill.dto.SeckillExcution;
import com.mayer.seckill.dto.SeckillResult;
import com.mayer.seckill.entity.Seckill;
import com.mayer.seckill.enums.SeckillStateEnum;
import com.mayer.seckill.exception.RepeatKillException;
import com.mayer.seckill.exception.SeckillCloseException;
import com.mayer.seckill.service.SeckillService;

@Controller
/*@RequestMapping("/seckill")*/
public class SeckillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model){
		if(seckillId==null){
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill==null){
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}
	
	@RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId")Long seckillId){
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new SeckillResult<>(false, e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/{seckillId}/{md5}/execution",
			method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExcution> execute(@PathVariable("seckillId")Long seckillId,
			@PathVariable("md5") String md5,@CookieValue(value="killPhone",required=false)Long userPhone){
		if(userPhone==null){
			return new SeckillResult<>(false, "未注册");
		}
		try {
			SeckillExcution excution = seckillService.executeSeckill(seckillId, userPhone, md5);
			return new SeckillResult<SeckillExcution>(true, excution);
		} catch (SeckillCloseException e) {
			SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.END);
			return new SeckillResult<SeckillExcution>(true, excution);
		} catch (RepeatKillException e) {
			SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExcution>(true, excution);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR);
			return new SeckillResult<SeckillExcution>(true, excution);
		}
	}
	
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time(){
		Date now = new Date();
		return new SeckillResult<Long>(true, now.getTime());
		
	}
}
