package lesson5.practice.buildings

fun main() {
    val woodBuilding = Building(Wood())
    woodBuilding.build()

    val brickBuilding = Building(Brick())
    brickBuilding.build()

    isSmallBuilding(Building(Brick()))
}

open class BaseBuildingMaterial {
    open val numberNeeded = 1
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}