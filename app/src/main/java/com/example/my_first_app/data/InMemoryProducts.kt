package com.example.my_first_app.data

import com.example.my_first_app.model.NutritionFacts
import com.example.my_first_app.model.NutritionFactsItem
import com.example.my_first_app.model.Product
import java.util.concurrent.atomic.AtomicInteger

class InMemoryProducts {

    companion object {
        private val counter: AtomicInteger = AtomicInteger(0)
        private val products: Map<Number, Product> = hashMapOf(
            counter.addAndGet(1) to Product(
                additives = listOfNotNull(
                    "E471 - Mono- and diglycerides of fatty acids",
                    "E472e - Mono- and diacetyltartaric acid esters of mono- and diglycerides of fatty acids",
                    "E282 - Calcium propionate"
                ),
                allergies = listOfNotNull(
                    "Gluten",
                    "Milk",
                    "Sesame seeds",
                    "Sulphur dioxide",
                    "sulphites"
                ),
                brand = "Charal",
                barcode = "3181232138451",
                score = "D",
                ingredients = listOfNotNull(
                    "Pain spécial 38,5% : farine de blé, eau, levure, dextrose, huile de colza, gluten de blé, sucre, graines de sésame, sel, farine de fève, émulsifiants : E471, E472e, conservateur : E282, vinaigre, antioxydant : E300.\n" +
                            "Préparation à base de viande hachée cuite assaisonnée 36,5 % : viande bovine 99 % (soit 36 % sur produit total), sel, arômes, antioxydant : extrait de romarin."
                ),
                quantity = "220g",
                name = "Maxi Cheese Burger",
                nutrientLevels = NutritionFacts(
                    calories = NutritionFactsItem(unit = "kj", quantityPer100g = 1000, quantityPerPortion = 4897),
                    fat = NutritionFactsItem(unit = "g", quantityPer100g = 59),
                    saturatedFat = NutritionFactsItem(unit = "g", quantityPer100g = 12),
                    sugar = NutritionFactsItem(unit = "g", quantityPer100g = 0.2),
                    salt = NutritionFactsItem(unit = "g", quantityPer100g = 32),
                    glucide = NutritionFactsItem(unit = "g", quantityPer100g = 1.1),
                    fibre = NutritionFactsItem(unit = "g", quantityPer100g = 2.6),
                    prot = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sodium = NutritionFactsItem(unit = "g", quantityPer100g = 0.5),
                ),
                sellerCountries = listOfNotNull("France", "Switzerland"),
                urlImg = "http://fr-en.openfoodfacts.org/images/products/318/123/213/8451/front_fr.59.400.jpg",
            ),
            counter.addAndGet(2) to Product(
                additives = listOfNotNull(
                    "E471 - Mono- and diglycerides of fatty acids",
                    "E472e - Mono- and diacetyltartaric acid esters of mono- and diglycerides of fatty acids",
                    "E282 - Calcium propionate"
                ),
                allergies = listOfNotNull(
                    "Gluten",
                    "Milk",
                    "Sesame seeds",
                    "Sulphur dioxide",
                    "sulphites"
                ),
                brand = "Quaker",
                barcode = "3181232138451",
                score = "A",
                ingredients = listOfNotNull(
                    "Pain spécial 38,5% : farine de blé, eau, levure, dextrose" +
                            "Préparation à base de viande hachée cuite assaisonnée 36,5 %"
                ),
                quantity = "220g",
                name = "Pépites de céréales croustillantes avec Mélange de Noix\n" +
                        "\n",
                nutrientLevels = NutritionFacts(
                    calories = NutritionFactsItem(unit = "kj", quantityPer100g = 100, quantityPerPortion = 513),
                    fat = NutritionFactsItem(unit = "g", quantityPer100g = 29),
                    saturatedFat = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sugar = NutritionFactsItem(unit = "g", quantityPer100g = 0.2),
                    salt = NutritionFactsItem(unit = "g", quantityPer100g = 1),
                    glucide = NutritionFactsItem(unit = "g", quantityPer100g = 0.1),
                    fibre = NutritionFactsItem(unit = "g", quantityPer100g = 0.6),
                    prot = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sodium = NutritionFactsItem(unit = "g", quantityPer100g = 1.5),
                ),
                sellerCountries = listOfNotNull("France", "Switzerland"),
                urlImg = "http://fr-en.openfoodfacts.org/images/products/318/123/213/8451/front_fr.59.400.jpg",
            ),
            counter.addAndGet(3) to Product(
                additives = listOfNotNull(
                    "E471 - Mono- and diglycerides of fatty acids",
                    "E472e - Mono- and diacetyltartaric acid esters of mono- and diglycerides of fatty acids",
                    "E282 - Calcium propionate"
                ),
                allergies = listOfNotNull(
                    "Gluten",
                    "Milk",
                    "Sesame seeds",
                    "Sulphur dioxide",
                    "sulphites"
                ),
                brand = "Christaline",
                barcode = "3181232138451",
                score = "D",
                ingredients = listOfNotNull(
                    "Pain spécial 38,5% : farine de blé, eau, levure, dextrose, huile de colza, gluten de blé, sucre, graines de sésame, sel, farine de fève, émulsifiants : E471, E472e, conservateur : E282, vinaigre, antioxydant : E300.\n" +
                            "Préparation à base de viande hachée cuite assaisonnée 36,5 % : viande bovine 99 % (soit 36 % sur produit total), sel, arômes, antioxydant : extrait de romarin."
                ),
                quantity = "220g",
                name = "Eau de source",
                nutrientLevels = NutritionFacts(
                    calories = NutritionFactsItem(unit = "kj", quantityPer100g = 1000, quantityPerPortion = 2310),
                    fat = NutritionFactsItem(unit = "g", quantityPer100g = 59),
                    saturatedFat = NutritionFactsItem(unit = "g", quantityPer100g = 12),
                    sugar = NutritionFactsItem(unit = "g", quantityPer100g = 0.2),
                    salt = NutritionFactsItem(unit = "g", quantityPer100g = 32),
                    glucide = NutritionFactsItem(unit = "g", quantityPer100g = 1.1),
                    fibre = NutritionFactsItem(unit = "g", quantityPer100g = 2.6),
                    prot = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sodium = NutritionFactsItem(unit = "g", quantityPer100g = 0.5),
                ),
                sellerCountries = listOfNotNull("France", "Switzerland"),
                urlImg = "http://fr-en.openfoodfacts.org/images/products/318/123/213/8451/front_fr.59.400.jpg",
            ),
            counter.addAndGet(2) to Product(
                additives = listOfNotNull(
                    "E471 - Mono- and diglycerides of fatty acids",
                    "E472e - Mono- and diacetyltartaric acid esters of mono- and diglycerides of fatty acids",
                    "E282 - Calcium propionate"
                ),
                allergies = listOfNotNull(
                    "Gluten",
                    "Milk",
                    "Sesame seeds",
                    "Sulphur dioxide",
                    "sulphites"
                ),
                brand = "Granola",
                barcode = "3181232138451",
                score = "E",
                ingredients = listOfNotNull(
                    "Pain spécial 38,5% : farine de blé, eau, levure, dextrose" +
                            "Préparation à base de viande hachée cuite assaisonnée 36,5 %"
                ),
                quantity = "220g",
                name = "Biscuits sablés nappés de chocolat au lait",
                nutrientLevels = NutritionFacts(
                    calories = NutritionFactsItem(unit = "kj", quantityPer100g = 100, quantityPerPortion = 458),
                    fat = NutritionFactsItem(unit = "g", quantityPer100g = 29),
                    saturatedFat = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sugar = NutritionFactsItem(unit = "g", quantityPer100g = 0.2),
                    salt = NutritionFactsItem(unit = "g", quantityPer100g = 1),
                    glucide = NutritionFactsItem(unit = "g", quantityPer100g = 0.1),
                    fibre = NutritionFactsItem(unit = "g", quantityPer100g = 0.6),
                    prot = NutritionFactsItem(unit = "g", quantityPer100g = 0),
                    sodium = NutritionFactsItem(unit = "g", quantityPer100g = 1.5),
                ),
                sellerCountries = listOfNotNull("France", "Switzerland"),
                urlImg = "http://fr-en.openfoodfacts.org/images/products/318/123/213/8451/front_fr.59.400.jpg",
            ),
        )

        fun findAll(): Map<Number, Product> {
            return products
        }
    }
}