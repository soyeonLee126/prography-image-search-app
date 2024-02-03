import com.example.domain.repository.UnsplashImageRepository

class GetSavedImageUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke(id:String) = unsplashImageRepository.getImageDetailFromDB(id)

}