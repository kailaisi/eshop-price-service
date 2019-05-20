package com.kailaisi.eshoppriceservice.service.impl

import com.kailaisi.eshoppriceservice.mapper.ProductPriceMapper
import com.kailaisi.eshoppriceservice.model.ProductPrice
import com.kailaisi.eshoppriceservice.service.ProductPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import redis.clients.jedis.JedisPool

/**
 *
 */
@Service
class ProductPriceServiceImpl : ProductPriceService {
    @Autowired
    lateinit var productPriceMapper: ProductPriceMapper
    @Autowired
    lateinit var jedisPool: JedisPool

    override fun add(productPrice: ProductPrice) {
        productPriceMapper.add(productPrice)
        val jedis = jedisPool.resource
        jedis.del("product_price_${productPrice.productId}")
    }

    override fun update(productPrice: ProductPrice) {
        productPriceMapper.update(productPrice)
        val jedis = jedisPool.resource
        jedis.del("product_price_${productPrice.productId}")
    }

    override fun delete(id: Long) {
        productPriceMapper.delete(id)
        val jedis = jedisPool.resource
        val price = findById(id)
        jedis.del("product_price_${price.productId}")
    }

    override fun findById(id: Long): ProductPrice {
        return productPriceMapper.findById(id)
    }


}
