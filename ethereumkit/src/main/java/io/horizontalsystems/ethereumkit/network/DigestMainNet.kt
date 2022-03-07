package io.horizontalsystems.ethereumkit.network

import io.horizontalsystems.ethereumkit.core.hexStringToByteArray
import io.horizontalsystems.ethereumkit.core.toByteArray
import io.horizontalsystems.ethereumkit.spv.models.BlockHeader
import org.bouncycastle.util.Longs
import java.math.BigInteger

class DigestMainNet : INetwork {
    override val id: Int = 5777

    override val genesisBlockHash: ByteArray =
        "1911ef4ff9aa023382b5012c8610574ae26551ecf110ca637ce6fefa97a31e06".hexStringToByteArray()

    //checkpoint should be updated
    override val checkpointBlock =
        BlockHeader(hashHex = "f7bca29f4f199fddf00d08aa6ade45085844402962123f260374f231191dbdda".hexStringToByteArray(),
            totalDifficulty = BigInteger("1974192024164"),
            parentHash = "3ad1f79758cd0152c55e7bac71b9d572e6f54ac981506daddf9604aefae65db3".hexStringToByteArray(),
            unclesHash = "1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347".hexStringToByteArray(),
            coinbase = "ab9665e3df78667af6304b48a1f068e46c820c24".hexStringToByteArray(),
            stateRoot = "8b7ec14e94ac85bb3b00ffb303fb851794a432ede587ebc4fcd5b872e531f96e".hexStringToByteArray(),
            transactionsRoot = "56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421".hexStringToByteArray(),
            receiptsRoot = "56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421".hexStringToByteArray(),
            logsBloom = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000".hexStringToByteArray(),
            difficulty = Longs.valueOf(946806L).toByteArray(),
            height = 2247175,
            gasLimit = Longs.valueOf(8000000L).toByteArray(),
            gasUsed = 0,
            timestamp = 1646635368,
            extraData = "6469676573742d6e6574776f726b".hexStringToByteArray(),
            mixHash = ("476493887fe1c50f8536a895fbd6b76a8a597186a25e6faffd2d7abd89d7f028").hexStringToByteArray(),
            nonce = "4b18f636944fb358".hexStringToByteArray())

    override val blockTime: Long = 15
}