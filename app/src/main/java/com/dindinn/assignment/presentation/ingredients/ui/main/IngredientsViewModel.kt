package com.dindinn.assignment.presentation.ingredients.ui.main

import androidx.lifecycle.*
import com.dindinn.assignment.common.Resource
import com.dindinn.assignment.domain.model.IngredientItem
import com.dindinn.assignment.domain.use_case.ingredient.GetIngredientsUseCase
import javax.inject.Inject

class IngredientsViewModel @Inject constructor(
    private val getIngredientsUseCase: GetIngredientsUseCase
) : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun fetchIngredientsList(categoryId: Int): LiveData<Resource<List<IngredientItem>>> {
        return getIngredientsUseCase.invoke(categoryId).asLiveData()
    }
}