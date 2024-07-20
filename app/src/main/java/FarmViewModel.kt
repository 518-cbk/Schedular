//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class FarmViewModel(private val farmDao: FarmDao) : ViewModel() {
//    private val _farms = MutableLiveData<List<Farm>>()
//    val farms: LiveData<List<Farm>> = _farms
//
//    init {
//        loadFarms()
//    }
//
//    private fun loadFarms() {
//        viewModelScope.launch {
//            _farms.value = farmDao.getAllFarms()
//        }
//    }
//}