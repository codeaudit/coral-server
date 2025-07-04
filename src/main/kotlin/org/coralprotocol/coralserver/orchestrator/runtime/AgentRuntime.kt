package org.coralprotocol.coralserver.orchestrator.runtime

import com.chrynan.uri.core.Uri
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.coralprotocol.coralserver.orchestrator.ConfigValue
import org.coralprotocol.coralserver.orchestrator.Orchestrate
import org.coralprotocol.coralserver.orchestrator.OrchestratorHandle


data class RuntimeParams(
    val agentName: String,
    val mcpServerPort: UShort,
    val mcpServerRelativeUri: Uri,

    val systemPrompt: String?,
    val options: Map<String, ConfigValue>,
)

@Serializable
sealed class AgentRuntime : Orchestrate {
    @Serializable
    @SerialName("remote")
    data class Remote(
        val host: String,
        val agentType: String,
        val appId: String,
        val privacyKey: String,
    ) : AgentRuntime() {
        override fun spawn(
            params: RuntimeParams,
        ): OrchestratorHandle {
            TODO("request agent from remote server")
        }
    }
}