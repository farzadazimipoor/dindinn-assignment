package com.dindinn.assignment.domain.use_case.ingredient

import com.dindinn.assignment.common.Resource
import com.dindinn.assignment.domain.model.IngredientItem
import com.dindinn.assignment.domain.repository.IngredientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetIngredientsUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository
) {
    operator fun invoke(categoryId: Int? = null): Flow<Resource<List<IngredientItem>>> = flow {
        try {
            emit(Resource.loading(data = null))
            var result = ingredientRepository.getIngredients()
            if (categoryId != null) {
                result = result.filter { x -> x.categoryId == categoryId }
            }
            emit(Resource.success(data = result))
        } catch (e: Exception) {
            emit(Resource.error(msg = e.localizedMessage ?: "", data = null))
        }
    }
}