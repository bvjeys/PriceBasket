package com.pricebasket.application
package com.shopping.formatOutput

import com.shopping.model.Receipt

class ReceiptFormat {
  
  def formatOutput(receipt: Receipt): Unit = {

    println(f"Subtotal: £${receipt.subtotal}%.2f")

    if (receipt.discounts.isEmpty) {
      println("(No offers available)")
    } else {
      receipt.discounts.foreach { discount =>
        println(f"${discount.description}: ${discount.amount * 100}%.0fp")
      }
    }

    println(f"Total price: £${receipt.total}%.2f")
  }

}
