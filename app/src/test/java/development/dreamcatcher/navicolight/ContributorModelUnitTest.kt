package development.dreamcatcher.navicolight

import development.dreamcatcher.navicolight.data.pojo.Contributor
import org.junit.Assert.assertEquals
import org.junit.Test


class ContributorModelUnitTest {

    private var allDataContributor = Contributor(
        0,
        "John Travolta",
        "https://api.adorable.io/avatars/400/abott@adorable.io.png",
        64)

    private var allNecessaryDataContributor = Contributor(
        0,
        "John Travolta",
        null,
        null)

    @Test
    fun createAllDataContributor() {
        val id = 0
        val username = "John Travolta"
        val avatarUrl = "https://api.adorable.io/avatars/400/abott@adorable.io.png"
        val commitsAmount = 64

        val newContributor = Contributor(id, username, avatarUrl, commitsAmount)

        assertEquals(newContributor, allDataContributor)
    }

    @Test
    fun createAllNecessaryDataContributor() {
        val id = 0
        val username = "John Travolta"
        val avatarUrl = null
        val commitsAmount = null

        val newContributor = Contributor(id, username, avatarUrl, commitsAmount)

        assertEquals(newContributor, allNecessaryDataContributor)
    }
}