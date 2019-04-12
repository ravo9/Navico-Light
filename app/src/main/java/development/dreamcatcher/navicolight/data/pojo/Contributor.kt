package development.dreamcatcher.navicolight.data.pojo

import com.google.gson.annotations.SerializedName

data class Contributor(
        @SerializedName("id") val id: Int,
        @SerializedName("login") val username: String,
        @SerializedName("avatar_url") val avatarUrl: String?,
        @SerializedName("contributions") val commitsAmount: Int?)