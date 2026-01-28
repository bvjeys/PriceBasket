package com.pricebasket.application
package com.shopping.offers

import com.shopping.model.{Basket, Discount}

object AppleDiscountOffer extends Offer {
  override def apply(basket: Basket): Option[Discount] = {
    val appleCount = basket.items.count(_.name == "Apples")
    if (appleCount > 0) {
      val applePrice = basket.items.find(_.name == "Apples").map(_.price).getOrElse(BigDecimal(0))
      val discountAmount = (applePrice * 0.1 * appleCount)
      Some(Discount("Apples 10% off", discountAmount))
    } else {
      None
    }
  }
}
