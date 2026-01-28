package com.pricebasket.application
package com.shopping.services

import com.shopping.model.{Basket, Receipt}
import com.shopping.offers.Offer

//This class's only job is to calculate a final receipt

class CheckoutReceipt(offers: List[Offer]) {

  def calculatePrice(basket: Basket): Receipt = {
    
    // Calculating subtotal amount 
    val subtotal = basket.items.map(_.price).sum

    //Getting the discount amount for the products
    val applicableDiscounts = offers.flatMap(offer => offer.apply(basket))

    // Total of all the discounts
    val totalDiscount = applicableDiscounts.map(_.amount).sum
    
    // Calculating the Final total price after discounted price
    val finalTotal = subtotal - totalDiscount

    Receipt(subtotal, applicableDiscounts, finalTotal)
  }
}
