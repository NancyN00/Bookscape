package com.example.simplebooks.data.repository

import com.example.simplebooks.data.remote.BookListApi
import com.example.simplebooks.domain.models.BookListItem
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.util.Resource
import retrofit2.HttpException
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class BookListRepositoryImpl @Inject constructor(
    private val api : BookListApi
) : BookListRepository {
    override fun getCharacterList() = flow<Resource<List<BookListItem>>> {
         try {
             emit(Resource.Loading(data = null))
             emit(Resource.Success(data = api.getBookList()))

         }
         catch (e: HttpException){
             emit(Resource.Error(e.localizedMessage  ?: "An error has occurred", data = null))

         }
         catch (e: IOException){
             emit(Resource.Error("check your internet connection", data = null))

         }

    }
}