package br.com.pantufa.testing_20190625

class CoffeeBeanModel (
    val id: Int,
    val producer: String,
    val variety: String,
    val process: String,
    val imageUrl: String,
    val region: RegionModel
)

class RegionModel(
    val city: String,
    val state: String,
    val farm: String
)
//
//"id": 1,
//"producer": "zé",
//"variety": "catuai",
//"process": "natural",
//"imageUrl": "https://www.coffeebeandirect.com/media/catalog/product/cache/1/image/0dc6da5b2fe15547a809e30525508fd7/0/-/0-dark-30-blend-wide.jpg",
//"region": {
//    "city": "itajubá",
//    "state": "MG",
//    "farm": "fazenda do zé"