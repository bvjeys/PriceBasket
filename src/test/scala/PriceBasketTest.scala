package com.pricebasket.application

import com.shopping.model.{Basket, Item}
import com.shopping.offers.{AppleDiscountOffer, SoupAndBreadOffer}
import com.shopping.services.CheckoutReceipt

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PriceBasketTest extends AnyFlatSpec with Matchers  {

  // Define items available for purchase
  val Soup = Item("Soup", BigDecimal("0.65"))
  val Bread = Item("Bread", BigDecimal("0.80"))
  val Milk = Item("Milk", BigDecimal("1.30"))
  val Apples = Item("Apples", BigDecimal("1.00"))

  // The service under test, with all available offers
  val checkoutReceipt = new CheckoutReceipt(List(AppleDiscountOffer, SoupAndBreadOffer))

  behavior of "checkoutReceipt"

  it should "correctly price a basket with one of each item" in {
    val basket = Basket(List(Apples, Milk, Bread))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("3.10"))
    receipt.discounts.head.description should be ("Apples 10% off")
    receipt.discounts.head.amount should be (BigDecimal("0.10"))
    receipt.total should be (BigDecimal("3.00"))
  }

  it should "output a message if no offers are available" in {
    val basket = Basket(List(Milk, Bread))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("2.10"))
    receipt.discounts should be (empty)
    receipt.total should be (BigDecimal("2.10"))
  }

  it should "apply half price bread discount for two tins of soup" in {
    val basket = Basket(List(Soup, Soup, Bread))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("2.10")) // 0.65 + 0.65 + 0.80
    receipt.discounts.head.description should be ("Bread 50% off")
    receipt.discounts.head.amount should be (BigDecimal("0.40"))
    receipt.total should be (BigDecimal("1.70"))
  }

  it should "not apply bread discount if there is only one soup" in {
    val basket = Basket(List(Soup, Bread))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("1.45"))
    receipt.discounts should be (empty)
    receipt.total should be (BigDecimal("1.45"))
  }

  it should "apply both apple and soup offers correctly" in {
    val basket = Basket(List(Apples, Soup, Soup, Bread))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("3.10"))
    receipt.discounts should have size 2
    // The order of discounts is not guaranteed, so we check for presence
    receipt.discounts.map(_.description) should contain ("Apples 10% off")
    receipt.discounts.map(_.description) should contain ("Bread 50% off")
    receipt.discounts.map(_.amount).sum should be (BigDecimal("0.50")) // 0.10 + 0.40
    receipt.total should be (BigDecimal("2.60"))
  }

  it should "handle an empty basket" in {
    val basket = Basket(List.empty)
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("0.00"))
    receipt.discounts should be (empty)
    receipt.total should be (BigDecimal("0.00"))
  }

  it should "handle multiple apples" in {
    val basket = Basket(List(Apples, Apples))
    val receipt = checkoutReceipt.calculatePrice(basket)
    receipt.subtotal should be (BigDecimal("2.00"))
    receipt.discounts.head.description should be ("Apples 10% off")
    receipt.discounts.head.amount should be (BigDecimal("0.20")) // 10% off each bag
    receipt.total should be (BigDecimal("1.80"))
  }
}