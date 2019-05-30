package com.kailaisi.eshoppriceservice.mapper

import com.kailaisi.eshoppriceservice.model.ProductPrice
import org.apache.ibatis.annotations.*

/**
 *描述：商品价格
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 11:40
 */
@Mapper
interface ProductPriceMapper {
    @Insert("insert into product_price(value,product_id) values(#{value},#{productId})")
    fun add(productPrice: ProductPrice)

    @Delete("delete from product_price where id=#{id}")
    fun delete(id: Long)

    @Update("update product_price set value=#{value} ,product_id=#{productId} where id=#{id}")
    fun update(productPrice: ProductPrice)

    @Select("select * from product_price where id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findById(id: Long): ProductPrice
    @Select("select * from product_price where product_id=#{id} limit 0")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findByProductId(id: Long): ProductPrice
}