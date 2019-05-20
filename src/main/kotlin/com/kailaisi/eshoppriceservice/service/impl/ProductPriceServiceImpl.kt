package com.kailaisi.eshoppriceservice.service.impl

import com.kailaisi.eshoppriceservice.mapper.ProductPriceMapper
import com.kailaisi.eshoppriceservice.model.ProductPrice
import com.kailaisi.eshoppriceservice.service.ProductPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class ProductPriceServiceImpl : ProductPriceService {
    @Autowired
    lateinit var productPriceMapper: ProductPriceMapper

    override fun delete(id: Long)=
        productPriceMapper.delete(id)


    override fun update(productPrice: ProductPrice) {
        productPriceMapper.update(productPrice)
    }

    override fun findById(id: Long): ProductPrice {
        return productPriceMapper.findById(id)
    }

    override fun add(productPrice: ProductPrice) {
        productPriceMapper.add(productPrice)
    }
}