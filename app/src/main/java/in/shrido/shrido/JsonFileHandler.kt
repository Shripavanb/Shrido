package in.shrido.shrido



import android.content.Context
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException

class Helper {
}


class JsonFileHandler(private val context: Context, private val fileName: String) {

    private val json = Json { prettyPrint = true }

    // Get the internal storage file path
    private fun getFile(): File {
        return File(context.filesDir, fileName)
    }

    // Read the JSON file and deserialize it into a UserData object
    fun readUserData(): UserData? {
        val file = getFile()
        if (!file.exists()) {
            return null
        }
        return try {
            val jsonString = file.readText()
            json.decodeFromString<UserData>(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    // Write a UserData object to the JSON file
    private fun writeUserData(userData: UserData) {
        val file = getFile()
        try {
            val jsonString = json.encodeToString(UserData.serializer(), userData)
            file.writeText(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Create the file with initial data if it doesn't exist
    fun createOrInitializeFile() {
        val file = getFile()
        if (!file.exists()) {
            val initialData = UserData(mutableListOf())
            writeUserData(initialData)
        }
    }

    // Add a new user and update the file
    fun addUser(newUser: User) {
        val userData = readUserData() ?: UserData(mutableListOf())
        userData.users.add(newUser)
        writeUserData(userData)
    }

    // Update an existing user and save the changes
    fun updateUser(updatedUser: User) {
        val userData = readUserData() ?: return
        val index = userData.users.indexOfFirst { it.id == updatedUser.id }
        if (index != -1) {
            userData.users[index] = updatedUser
            writeUserData(userData)
        }
    }
}
