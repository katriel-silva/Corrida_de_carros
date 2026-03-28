// --- HERANÇA ---
// Classe pai abstrata para representar qualquer veículo.
open class Veiculo(
    val marca: String,
    var tanque: Double, // Litros de combustível
    val consumo: Double // Quanto gasta por volta
) {
    var naCorrida: Boolean = true // Verifica se o carro não quebrou ou ficou sem gás

    // --- POLIMORFISMO ---
    // A palavra 'open' permite que a classe filha (Carro) modifique essa função
    open fun gastarCombustivel() {
        tanque -= consumo
        if (tanque <= 0) {
            naCorrida = false // Pane seca!
        }
    }
}