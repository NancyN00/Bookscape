package com.example.simplebooks.data.repository

import com.example.simplebooks.data.remote.BookListApi
import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.models.BookListItem
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class BookListRepositoryImpl @Inject constructor(
    private val api: BookListApi
) : BookListRepository {
    override fun getBooksList(): Flow<Resource<List<BookListItem>>> =
        flow {
            try {
                emit(Resource.Loading(data = null))
                // Fetch all books from the API
                emit(Resource.Success(data = api.getBookList()))

            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An error has occurred", data = null))

            } catch (e: IOException) {
                emit(Resource.Error("check your internet connection", data = null))

            }

        }

    override fun getFictionBooks(): Flow<Resource<List<BookListItem>>> = flow {
        try {
            emit(Resource.Loading(data = null))
            // Fetch only fiction books from the API
            emit(Resource.Success(data = api.getBookList(type = "fiction")))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An error has occurred", data = null))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection", data = null))
        }
    }

    override fun getNonFictionBooks(): Flow<Resource<List<BookListItem>>> = flow {
        try {
            emit(Resource.Loading(data = null))
            // Fetch only non-fiction books from the API
            emit(Resource.Success(data = api.getBookList(type = "non-fiction")))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An error has occurred", data = null))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection", data = null))
        }
    }

    override fun getBookDetail(bookId: Int): Flow<Resource<List<BookDetailsItem>>> =
        flow {
            try {
//                emit(Resource.Loading(data = null))
//                emit(Resource.Success(data = api.getBookDetails(bookId)))
                /** Fetch book details from API **/
                emit(Resource.Loading())
                val bookDetail = api.getBookDetails(bookId)
                emit(Resource.Success(bookDetail))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An error has occurred", data = null))

            } catch (e: IOException) {
                emit(Resource.Error("check your internet connection", data = null))

            }

        }
}