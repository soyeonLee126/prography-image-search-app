import com.example.domain.repository.UnsplashImageRepository

class GetImageListUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    operator fun invoke() = unsplashImageRepository.getImageList()

}