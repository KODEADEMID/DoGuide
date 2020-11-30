package kodeA.doguide

data class InfoAnimal(var check: Boolean) {

    var nickname: String
        set(nickname) {this.nickname = nickname}
        get() = "Nickname: $nickname"

    var breed: String
         set(breed) {this.breed = breed}
    get() = "Breed: $breed"



   // var age:Int
   // var experience: Int
   // var physicalEducation: String
   // var AttitudeFood: String
   // var LifeOnStreet: String
   // var Violence: String

}