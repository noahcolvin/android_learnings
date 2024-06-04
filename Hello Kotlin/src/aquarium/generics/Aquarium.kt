package aquarium.generics

fun main() {
    genericExample()
}

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }

        println("adding water from $waterSupply")
    }

}

inline fun <reified R:WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T:WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

inline fun <reified T:WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    println(isWaterClean(aquarium))
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    println(aquarium.waterSupply.isOfType<LakeWater>())

    aquarium.addWater(cleaner)
    aquarium.waterSupply.addChemicalCleaners()
    addItemTo(aquarium)
}