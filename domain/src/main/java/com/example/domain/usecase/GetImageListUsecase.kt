import com.example.domain.repository.UnsplashImageRepository

class GetImageListUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke() = unsplashImageRepository.getImageList()

}