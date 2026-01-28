package com.pricebasket.application
package com.shopping.offers

import com.shopping.model.{Basket, Discount}

object SoupAndBreadOffer extends Offer {
  override def apply(basket: Basket): Option[Discount] = {
    val soupTins = basket.items.count(_.name == "Soup")
    val breadLoaves = basket.items.count(_.name == "Bread")

    if (soupTins >= 2 && breadLoaves >= 1) {
      val breadPrice = basket.items.find(_.name == "Bread").map(_.price).getOrElse(BigDecimal(0))
      // Discount applies for each pair of soups, up to the number of loaves available
      val possibleDiscounts = soupTins / 2
      val discountsToApply = Math.min(possibleDiscounts, breadLoaves)
      val discountAmount = (breadPrice * 0.5 * discountsToApply).setScale(2, BigDecimal.RoundingMode.HALF_UP)
      Some(Discount("Bread 50% off", discountAmount))
    } else {
      None
    }
  }
}
