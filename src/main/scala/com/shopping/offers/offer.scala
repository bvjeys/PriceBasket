package com.pricebasket.application
package com.shopping.offers

import com.shopping.model.{Basket,Discount}

trait Offer {
  def apply(basket: Basket): Option[Discount]
}
