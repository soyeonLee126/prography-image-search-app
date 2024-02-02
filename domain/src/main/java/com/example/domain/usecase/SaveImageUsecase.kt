import com.example.domain.repository.UnsplashImageRepository
import com.example.domain.usecase.model.UnSplashImage

class SaveImageUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke(image: UnSplashImage) = unsplashImageRepository.saveImage(image)

}