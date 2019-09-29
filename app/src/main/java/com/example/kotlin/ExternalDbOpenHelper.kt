package com.example.kotlin

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ExternalDbOpenHelper(
    var context: Context,
    databaseName: String?
) :
    SQLiteOpenHelper(context, databaseName, null, 1) {
    var db: SQLiteDatabase? = null

    fun createDataBase() {
        if (!isInitialized) {
            this.readableDatabase
            try {
                copyDataBase()
            } catch (e: IOException) {
                Log.e(this.javaClass.toString(), "Copying error")
                throw Error("Error copying database!")
            }
            close()
        }
    }

    @Throws(IOException::class)
    private fun copyDataBase() {
        // Открываем поток для чтения из уже созданной нами БД
        //источник в assets

        try {
            val externalDbStream: InputStream =
                context.assets.open(DB_NAME)
            // Путь к уже созданной пустой базе в андроиде
            // Теперь создадим поток для записи в эту БД побайтно


            val localDbStream: OutputStream =
                FileOutputStream(DB_PATH)
            // Собственно, копирование


            val buffer =
                ByteArray(DB_FILES_COPY_BUFFER_SIZE)
            var bytesRead: Int
            while (externalDbStream.read(buffer).also { bytesRead = it } > 0) {
                localDbStream.write(buffer, 0, bytesRead)
            }
            // Мы будем хорошими мальчиками (девочками) и закроем потоки


            localDbStream.close()
            externalDbStream.close()
        } catch (ex: IOException) {
        } finally {
        }
    }

    @Throws(SQLException::class)
    fun openDataBase(): SQLiteDatabase? {
        if (db == null) {
            createDataBase()
            db = SQLiteDatabase.openDatabase(
                DB_PATH,
                null,
                SQLiteDatabase.OPEN_READWRITE
            )
        }
        return db
    }

    @Synchronized
    override fun close() {
        if (db != null) {
            db!!.close()
        }
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase?) {}
    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
    }

    companion object {
        var DB_PATH: String? = null
        var DB_NAME: String? = null
        var DB_FOLDER: String? = null
        var packageName: String? = null
        var DB_FILES_COPY_BUFFER_SIZE = 0
        private var DB_VERSION = 0
        private val isInitialized: Boolean
            private get() {
                var checkDB: SQLiteDatabase? = null
                var correctVersion = false
                try {
                    checkDB = SQLiteDatabase.openDatabase(
                        DB_PATH,
                        null,
                        SQLiteDatabase.OPEN_READONLY
                    )
                    correctVersion = checkDB.version == DB_VERSION
                } catch (e: SQLiteException) {
                } finally {
                    checkDB?.close()
                }
                return checkDB != null && correctVersion
            }
    }

    init {
        packageName = context.packageName
        DB_FOLDER =
            "/data/data/$packageName/databases/"
        DB_NAME = databaseName
        DB_PATH = DB_FOLDER + DB_NAME
        DB_FILES_COPY_BUFFER_SIZE = 1024
        DB_VERSION = 1
    }
}
