package com.pricebasket.application
package com.shopping

import com.shopping.model.{Basket, Item}
import com.shopping.offers.{AppleDiscountOffer, SoupAndBreadOffer}
import com.shopping.services.CheckoutReceipt
import com.shopping.items.ItemPriceList
import com.shopping.formatOutput.ReceiptFormat

object PriceBasket {

  def main(args: Array[String]): Unit = {

    // Converts the args into two List of valid and invalid items
    val (validItems, invalidItems) = args.toList.partition(arg => ItemPriceList.priceList.contains(arg.capitalize))

    // Warning the user about unavailable items
    invalidItems.foreach(item => println(s"Warning: '$item' is not a valid item and will be ignored."))

    // Getting the Price of all the valid Item and passing it to basket as List[item]
    val items = validItems.map(name => Item(name.capitalize, ItemPriceList.priceList(name.capitalize)))
    val basket = Basket(items)

    //we could extend the offers if we want in future
    val offerLst = List(AppleDiscountOffer, SoupAndBreadOffer)

    // Instantiate the service with the offers we want to apply
    val checkoutService = new CheckoutReceipt(offerLst)
    val receipt = checkoutService.calculatePrice(basket)

    // Formatting and print the final receipt to the console
    val fmt = new ReceiptFormat()
    fmt.formatOutput(receipt)
    
  }
}
