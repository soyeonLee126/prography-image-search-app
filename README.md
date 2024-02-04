# prography-image-search-app

unsplash를 사용한 랜덤 이미지 리스트 앱입니다.</br>
Prography의 9기 모바일 과제입니다! 좋은 기회 주셔서 감사합니다 :)</br></br></br></br></br></br></br></br>




### 기본 Stack </br>
<img src="https://img.shields.io/badge/android-34A853?style=for-the-badge&logo=android&logoColor=white"></br>
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"></br>
<img src="https://img.shields.io/badge/jetpackcompose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white"></br></br></br></br>



### 기타 </br>
- 기본적인 구조는 Google Recommendation Architecture를 따르고자 multi-module, clean architecture로 구성했습니다.
- 설계를 할 시간이 부족해, domain모듈을 만들며 설계와 요구명세를 정리하고, 이후 app -> data layer순으로 구현했습니다.
- data에서 사용하는 model을 domain layer -> app layer로 보낼 경우, 반대로 app layer에서 domain -> data layer로 보낼 경우를 고려해 mapper.kt에는 각각의 layer에서 필요한 dater로 mapping하는 확장함수를 구현했습니다.
- DI는 Hilt를 사용했습니다
- Local DB는 Room을 사용했습니다.
- 무한 리스트 로딩은 Paging을 사용했습니다.
- Random Photo Load의 경우, 10개씩 불러와 좌우로 무한으로 붙이게끔 구현했습니다.
- 카드 스와이프는 Compose의 HorizontalPager를 사용했습니다.
- 메인 화면의 엇갈리는 최신 이미지 grid를 표현하기 위해 LazyVerticalStaggeredGrid를 사용했습니다.
- network는 Retrofit을 활용했습니다.</br></br></br></br>


### 피그마와 다르게 구현된 점 </br>
- Unsplash API에서 title 필드를 찾을 수 없어, title은 description, description은 alt_description을 사용했습니다.</br></br></br></br>

### 테스트 안내 </br>
- unSplash Demo API는 시간당 api call이 50회로 재한되어있음을 발견했습니다. 참고 부탁드립니다.
- api_key는 local.properties에 있어 git엔 포함되어있지않습니다. 해당 내용은 메일로 함께 첨부드리니 확인 부탁드립니다!


