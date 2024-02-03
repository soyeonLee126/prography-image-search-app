import com.example.domain.repository.UnsplashImageRepository

class GetSavedImgaeListUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    operator fun invoke() = unsplashImageRepository.getSavedImageList()

}