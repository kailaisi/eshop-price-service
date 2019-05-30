package com.kailaisi.eshoppriceservice.service.impl

import com.alibaba.fastjson.JSONObject
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
        jedis.set("product_price_" + productPrice.productId, JSONObject.toJSONString(productPrice))
        jedis.close()
    }

    override fun update(productPrice: ProductPrice) {
        productPriceMapper.update(productPrice)
        val jedis = jedisPool.resource
        jedis.set("product_price_" + productPrice.productId, JSONObject.toJSONString(productPrice))
        jedis.close()
    }

    override fun delete(id: Long) {
        val price = findById(id)
        productPriceMapper.delete(id)
        val jedis = jedisPool.resource
        jedis.del("product_price_${price.productId}")
        jedis.close()
    }

    override fun findById(id: Long): ProductPrice {
        return productPriceMapper.findById(id)
    }

    override fun findByProductId(id: Long): ProductPrice {
        var jedis = jedisPool.resource
        var get = jedis.get("product_price_$id")
        return if (!get.isNullOrEmpty()) {
            JSONObject.parseObject(get, ProductPrice::class.java)
        } else {
            var price = productPriceMapper.findByProductId(id)
            price.let {
                jedis.set("product_price_$id", JSONObject.toJSONString(it))
            }
            price
        }
    }
}
