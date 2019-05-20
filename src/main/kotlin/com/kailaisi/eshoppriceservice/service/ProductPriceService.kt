package com.kailaisi.eshoppriceservice.service

import com.kailaisi.eshoppriceservice.model.ProductPrice

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 11:53
 */
interface ProductPriceService {
    fun add(productPrice: ProductPrice)
    fun delete(id: Long)
    fun update(productPrice: ProductPrice)
    fun findById(id: Long): ProductPrice
}
