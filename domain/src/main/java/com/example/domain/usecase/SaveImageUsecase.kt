import com.example.domain.repository.UnsplashImageRepository
import com.example.domain.usecase.model.ImageModel

class SaveImageUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke(image: ImageModel) = unsplashImageRepository.saveImage(image)
}