package com.kailaisi.eshoppriceservice.control

import com.kailaisi.eshoppriceservice.model.ProductPrice
import com.kailaisi.eshoppriceservice.service.ProductPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 13:09
 */
@Controller
@RequestMapping("product-price")
class ProductPriceControl {
    @Autowired
    lateinit var mService: ProductPriceService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody productPrice: ProductPrice): String {
        mService.add(productPrice)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody productPrice: ProductPrice): String {
        mService.update(productPrice)
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        mService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): ProductPrice {
        return mService.findById(id)
    }
    @RequestMapping("/findByProductId")
    @ResponseBody
    fun findByProductId(id: Long): ProductPrice{
        return mService.findByProductId(id)
    }
}