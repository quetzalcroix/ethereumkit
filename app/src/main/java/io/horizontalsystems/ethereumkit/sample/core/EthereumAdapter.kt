package io.horizontalsystems.ethereumkit.sample.core

import io.horizontalsystems.ethereumkit.core.EthereumKit
import io.horizontalsystems.ethereumkit.core.signer.Signer
import io.horizontalsystems.ethereumkit.models.Address
import io.horizontalsystems.ethereumkit.models.FullTransaction
import io.horizontalsystems.ethereumkit.models.GasPrice
import io.reactivex.Single
import java.math.BigDecimal

class EthereumAdapter(
    private val ethereumKit: EthereumKit,
    private val signer: Signer
) : EthereumBaseAdapter(ethereumKit) {
    private val decimal = 18

    override fun send(
        address: Address,
        amount: BigDecimal,
        gasPrice: GasPrice,
        gasLimit: Long
    ): Single<FullTransaction> {
        return ethereumKit.let {
            val txData = it.transferTransactionData(address, amount.movePointRight(decimal).toBigInteger())
            val rawTx = it.rawTransaction(txData, gasPrice, gasLimit)
            rawTx.flatMap { rtx ->
                it.send(rtx, signer.signature(rtx))
            }
        }

        /*
        return ethereumKit.rawTransaction(transactionData, gasPrice, gasLimit)
            .flatMap { rawTransaction ->
                val signedTx = signer.signedTransaction(
                    rawTransaction.to,
                    rawTransaction.value,
                    rawTransaction.data,
                    rawTransaction.gasPrice,
                    rawTransaction.gasLimit,
                    rawTransaction.nonce
                )
                ethereumKit.send(rawTransaction, signer.signature(rawTransaction))
            }

        return ethereumKit.run {
            rawTransaction(transferTransactionData(address, amountBigInt), gasPrice, gasLimit)
                .flatMap { rawTx ->
                    send(rawTx, signer.signature(rawTx))
                }
        }

        */
    }

}
