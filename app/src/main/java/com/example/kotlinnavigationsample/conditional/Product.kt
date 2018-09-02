package com.example.kotlinnavigationsample.conditional

import com.example.kotlinnavigationsample.R

data class Product(
  var id: Int,
  var name: String,
  var description: String,
  var imageRes: Int,
  var amount: Double = getRandomAmount()
) {
  companion object {
    fun getDefaultList(): List<Product> {
      return listOf(
          Product(1, "Home", "Home, sweet home", R.drawable.ic_home_black_24dp),
          Product(2, "Dash", "A clean dashboard", R.drawable.ic_dashboard_black_24dp),
          Product(3, "Link", "A Unique link", R.drawable.ic_link_black_24dp),
          Product(4, "Camera", "Iconic camera", R.drawable.ic_menu_camera),
          Product(5, "Gallery", "Never run out of images", R.drawable.ic_menu_gallery),
          Product(6, "Font", "A minimal font", R.drawable.ic_text_format_black_24dp),
          Product(7, "Tool", "Awesome tool", R.drawable.ic_menu_manage),
          Product(8, "Notifier", "Your personal notifier", R.drawable.ic_notifications_black_24dp),
          Product(9, "Share", "Custom shares", R.drawable.ic_menu_share),
          Product(10, "Gift", "A random gift", R.drawable.ic_menu_send)
      )
    }

    private fun getRandomAmount(): Double = (100..2000).shuffled().last().toDouble()
  }

  val amountAsCurrency: String = String.format("\u20B9 %,.2f", amount)
  val wareHouseID: String = String.format("Product ID: 2018-CNE-$id")
}