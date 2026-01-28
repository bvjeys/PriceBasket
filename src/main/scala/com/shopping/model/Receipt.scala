package com.pricebasket.application
package com.shopping.model

case class Receipt(subtotal: BigDecimal, discounts: List[Discount], total: BigDecimal)
