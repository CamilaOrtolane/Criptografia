import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun encrypt(text: String, key: String): ByteArray {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    return cipher.doFinal(text.toByteArray())
}

fun decrypt(encryptedData: ByteArray, key: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    return String(cipher.doFinal(encryptedData))
}

fun main() {

    val key = "camilaortolane12"
    val originalText = "Quero bolo"

    val encryptedData = encrypt(originalText, key)
    println("Texto criptografado: ${encryptedData.contentToString()}")

    println("Deseja ver a mensagem descriptografada? s/N")
    val resp = readlnOrNull()

    if (resp == "s"){
        val decryptedText = decrypt(encryptedData, key)
        println("Texto descriptografado: $decryptedText")
    }
    else{

        println("Ok. Fim do programa!")
    }



   /*código para o usuário digitar:

    val key = "camilaortolane29"

    println("Digite o texto que deseja criptografar:")
    val originalText: String? = readLine()


    val encryptedData = originalText?.let { encrypt(it, key) }
    println("Texto criptografado: ${encryptedData.contentToString()}")

    println("Deseja ver a mensagem descriptografada? s/N")
    val resp = readlnOrNull()

    if (resp == "s"){
        val decryptedText = encryptedData?.let { decrypt(it, key) }
        println("Texto descriptografado: $decryptedText")
    }
    else{

        println("Ok. Fim do programa!")
    }*/

}