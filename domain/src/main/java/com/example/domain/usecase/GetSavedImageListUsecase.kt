import com.example.domain.repository.UnsplashImageRepository

class GetSavedImageListUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    operator fun invoke() = unsplashImageRepository.getSavedImageList()

}