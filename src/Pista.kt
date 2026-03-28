class Pista(
    val carros: List<Carro>,
    val voltas: Int,
    val clima: String // Ex: "Ensolarado" ou "Chuvoso"
) {

    // Função principal que faz a corrida acontecer
    fun iniciarCorrida() {
        println("=========================================")
        println("🏁 BEM-VINDOS AO GRANDE PRÊMIO KOTLIN 🏁")
        println("Clima: $clima | Total de Voltas: $voltas")
        println("=========================================\n")

        // Loop de voltas
        for (volta in 1..voltas) {
            println("--- Iniciando a Volta $volta ---")
            for (carro in carros) {
                carro.correrVolta(clima)
            }
            println() // Pula linha para ficar bonito no console
        }

        exibirPlacar()
    }

    // --- ENCAPSULAMENTO ---
    // 'private' porque ninguém de fora deve gerar o placar do nada, só a Pista.
    private fun exibirPlacar() {
        println("🏆 === PLACAR FINAL === 🏆")

        // Ordena a lista de carros do maior para o menor com base na distância
        val carrosOrdenados = carros.sortedByDescending { it.distanciaTotal }

        var posicao = 1
        for (carro in carrosOrdenados) {
            val status = if (carro.naCorrida) "🏁 Completou" else "☠️ Fora da corrida"

            println("${posicao}º Lugar: ${carro.piloto.nome} (${carro.marca})")
            println("   Pontos: ${carro.distanciaTotal} | Status: $status")
            println("-----------------------------------------")
            posicao++
        }
    }
}