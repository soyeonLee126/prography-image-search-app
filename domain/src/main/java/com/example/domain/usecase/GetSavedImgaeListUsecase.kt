import com.example.domain.repository.UnsplashImageRepository

class GetSavedImgaeListUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke() = unsplashImageRepository.getSavedImageList()

}