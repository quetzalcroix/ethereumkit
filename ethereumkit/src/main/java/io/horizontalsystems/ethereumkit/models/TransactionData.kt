package io.horizontalsystems.ethereumkit.models

import io.horizontalsystems.ethereumkit.core.toHexString
import java.math.BigInteger
import java.util.*

data class TransactionData(
    val from: Address? = null,
    val to: Address,
    val value: BigInteger,
    val input: ByteArray,
    val nonce: Long? = null
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other is TransactionData -> to == other.to && from == other.from && value == other.value && input.contentEquals(
                other.input
            ) && nonce == other.nonce
            else -> false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(to, value, input)
    }

    override fun toString(): String {
        return "TransactionData {from: ${from?.hex}, to: ${to.hex}, value: $value, input: ${input.toHexString()}}"
    }

}
